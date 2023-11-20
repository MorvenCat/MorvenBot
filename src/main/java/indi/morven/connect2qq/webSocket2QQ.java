

package indi.morven.connect2qq;

import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class webSocket2QQ extends WebSocketClient {
    private static final Logger logger = LogManager.getLogger(webSocket2QQ.class); //日志
    private final ScheduledExecutorService heartBeatTask
            = Executors.newSingleThreadScheduledExecutor(); //定时任务
    private String session_id = null;
    private final String token = "Bot 102073158.0wE108Lwimm5pIy1krGpAJ6XOd72u75E";
    private final Gson gson = new Gson();
    private int heartBeatInterval = 0;  //心跳周期
    private int s = 0;  //消息序列号
    private boolean isResumeFlag = false;

    public webSocket2QQ(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        //登录鉴权
        identifyJson();
    }

    @Override
    public void onMessage(String receiveMessage) {
        logger.debug("收到消息"+receiveMessage);

        //获取opcode值进行判断
        SocketDataBean.BaseMessage baseMessage
                = gson.fromJson(receiveMessage, SocketDataBean.BaseMessage.class);
        int opCode = baseMessage.getOpCode();


        switch (opCode) {
            case 0:
                //服务端消息推送，事件
                SocketDataBean.EventMessage eventMessage = gson.fromJson(receiveMessage, SocketDataBean.EventMessage.class);
                //获取消息序列号，更新心跳
                s = eventMessage.getS();
                //获取事件类型，并进行判断
                String t = eventMessage.getT();
                switch (t) {
                    case "READY":
                        //更新sessionId信息
                        session_id = eventMessage.getD().getSession_id();
                        //启用定时发送心跳包
                        startHeartbeatTask();
                        break;
                    case "RESUMED":
                        //重连后消息补发完成
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                }
                break;
            case 7:
                //服务端通知客户端重新连接
                logger.warn("服务器请求重连！");
                Resume();
                break;
            case 9:
                if (isResumeFlag){
                    logger.warn("重连失败！请检查网络状况！");
                }else {
                    logger.warn("登陆失败！请确认登录信息！");
                }

                break;
            case 10:
                //当客户端与网关建立ws连接后，网关发送的第一条消息
                heartBeatInterval = getHeartBeatInterval(receiveMessage);
                break;
            case 11:
                //发送心跳成功后收到该消息
                logger.debug("收到心跳数据包");
                break;
            case 12:
                //仅用于http回调。代表机器人收到了平台推送数据
                break;

        }
    }

    private void Resume() {
        // 重连
        logger.warn("正在重连至QQ服务器！");
        isResumeFlag = true;    //标记为断线重连

        SocketDataBean.ResumeMessage.d resumeData = new SocketDataBean.ResumeMessage.d();
        resumeData.setSessionId(session_id);
        resumeData.setToken(token);
        resumeData.setS(s);

        SocketDataBean.ResumeMessage resumeMessage = new SocketDataBean.ResumeMessage(6);
        resumeMessage.setD(resumeData);

        String json = gson.toJson(resumeMessage);
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
        heartBeatTask.shutdown();//关闭定时任务
        logger.info("连接断开");
    }

    @Override
    public void onError(Exception e) {
        logger.error("连接出错", e);
        Resume();
    }

}
