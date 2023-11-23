

package indi.morven.connect2qq;

import com.google.gson.Gson;
import indi.morven.Event.EventHandler;
import indi.morven.MorvenBotMain;
import indi.morven.config.GlobalConfig;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class webSocket2QQ extends WebSocketClient {
    private final ScheduledExecutorService heartBeatTask
            = Executors.newSingleThreadScheduledExecutor(); //定时任务
    private String session_id = null;
    private final String token = GlobalConfig.getAUTHORIZATION();
    private final Gson gson = new Gson();
    private int heartBeatInterval = 0;  //心跳周期
    private int s = 0;  //消息序列号
    private boolean isResumeFlag = false;

    public webSocket2QQ(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        MorvenBotMain.LOGGER.info("与服务器建立socket连接！");

        //如果是重新连接
        if (isResumeFlag) {
            //重连鉴权
            Resume();
        } else {
            //登录鉴权
            identifyJson();
        }
    }

    @Override
    public void onMessage(String receiveMessage) {
        MorvenBotMain.LOGGER.debug("收到消息" + receiveMessage);

        //获取opcode值进行判断
        SocketDataBean.BaseMessage baseMessage
                = gson.fromJson(receiveMessage, SocketDataBean.BaseMessage.class);
        int opCode = baseMessage.getOpCode();


        switch (opCode) {
            case 0 -> {
                //服务端消息推送，事件
                SocketDataBean.EventMessage eventMessage = gson.fromJson(receiveMessage, SocketDataBean.EventMessage.class);
                //获取消息序列号，更新心跳
                s = eventMessage.getS();
                //获取事件类型，并进行判断
                String t = eventMessage.getT();
                switch (t) {
                    case "READY" -> {
                        //更新sessionId信息
                        session_id = eventMessage.getD().getSession_id();
                        //启用定时发送心跳包
                        startHeartbeatTask();
                    }
                    case "RESUMED" -> {
                        //重连后消息补发完成
                        MorvenBotMain.LOGGER.info("重连成功~消息已补发");
                        isResumeFlag = false; //重连标记归位
                    }
                    default -> {
                        //其他事件处理
                        EventHandler.handleEvent(t);
                    }
                }
            }
            case 7 -> {
                //服务端通知客户端重新连接
                MorvenBotMain.LOGGER.warn("服务器请求重连！");
                isResumeFlag = true;

            }
            case 9 -> {
                if (isResumeFlag) {
                    MorvenBotMain.LOGGER.warn("重连失败！请检查网络状况！");
                } else {
                    MorvenBotMain.LOGGER.warn("登陆失败！请确认登录信息！");
                }
            }
            case 10 -> {
                //当客户端与网关建立ws连接后，网关发送的第一条消息
                MorvenBotMain.LOGGER.info("登录成功！");
                heartBeatInterval = getHeartBeatInterval(receiveMessage);
            }
            case 11 ->
                //发送心跳成功后收到该消息
                    MorvenBotMain.LOGGER.debug("收到心跳数据包");
            case 12 -> {
                //仅用于http回调。代表机器人收到了平台推送数据
            }
        }
    }

    private void Resume() {
        // 重连
        SocketDataBean.ResumeMessage.d resumeData = new SocketDataBean.ResumeMessage.d();
        resumeData.setSessionId(session_id);//会话id
        resumeData.setToken(token);//token
        resumeData.setS(s);//消息序列号，用于重连补发消息

        SocketDataBean.ResumeMessage resumeMessage = new SocketDataBean.ResumeMessage(6);
        resumeMessage.setD(resumeData);

        String json = gson.toJson(resumeMessage);

        //发送重连信息！
        MorvenBotMain.LOGGER.info("正在请求恢复消息！");
        send(json);

    }

    private void startHeartbeatTask() {
        //心跳任务
        if (heartBeatInterval > 0) {
            heartBeatTask.scheduleAtFixedRate(this::postHeartbeat,
                    0,
                    heartBeatInterval,
                    TimeUnit.MILLISECONDS);
        }
    }

    private void postHeartbeat() {

        //心跳包
        SocketDataBean.HeartbeatMessage heartbeatMessage = new SocketDataBean.HeartbeatMessage(1);
        heartbeatMessage.setD(s);
        String json = gson.toJson(heartbeatMessage);
        //发送
        send(json);
    }

    private int getHeartBeatInterval(String s) {
        SocketDataBean.HelloMessage helloData = gson.fromJson(s, SocketDataBean.HelloMessage.class);
        return helloData.getD().getHeartBeatInterval();
    }

    private void identifyJson() {
        // IdentifyData 对象
        SocketDataBean.IdentifyMessage.IdentifyData identifyData = new SocketDataBean.IdentifyMessage.IdentifyData();
        // 设置字段值
        identifyData.setToken(token);
        identifyData.setIntents((1) | (1 << 1) | (1 << 9) | (1 << 10) | (1 << 12) | (1 << 26) | (1 << 27) | (1 << 28) | (1 << 29));
        identifyData.setShard(new int[]{0, 1});

        Map<String, String> propertiesMap = new HashMap<>();
        propertiesMap.put("$os", "my_library");
        propertiesMap.put("$browser", "my_library");
        propertiesMap.put("$device", "my_library");
        identifyData.setProperties(propertiesMap);

        // IdentifyMessage对象
        SocketDataBean.IdentifyMessage identifyMessage = new SocketDataBean.IdentifyMessage(2);
        identifyMessage.setData(identifyData);


        // 发送鉴权消息
        String identifyJson = gson.toJson(identifyMessage);
        send(identifyJson);


    }


    @Override
    public void onClose(int i, String s, boolean b) {
        if (isResumeFlag) {
            //服务器请求重连
            MorvenBotMain.LOGGER.info("正在重新连接到QQ服务器！");
            reconnect();

        } else {

            heartBeatTask.shutdown();//关闭定时任务
            MorvenBotMain.LOGGER.info("连接断开");
        }

    }

    @Override
    public void onError(Exception e) {
        MorvenBotMain.LOGGER.error("连接出错", e);
        Resume();
    }

}
