

package indi.morven.connect2qq;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class webSocket extends WebSocketClient {
    Gson gson = new Gson();

    public webSocket(URI serverUri) {
        super(serverUri);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("正在连接");
    }

    @Override
    public void onMessage(String s) {
        System.out.println("收到信息");
        JSONObject json = JSONUtil.parseObj(s);
        String opCode = json.get("op").toString();
        switch (opCode) {
            case "0":
                //服务端进行消息推送
            case "1":
                //客户端或服务端发送心跳
            case "7":
                //服务端通知客户端重新连接
            case "9":
                //当2或6报错时回复该消息
            case "10":
                //当客户端与网关建立ws连接后，网关发送的第一条消息
            case "11":
                //发送心跳成功后收到该消息
                message.HelloMessage message = gson.fromJson(s, indi.morven.connect2qq.message.HelloMessage.class);
                int heartBeatInterval = message.getData().getHeartBeatInterval();
            case "12":
                //仅用于http回调。代表机器人收到了平台推送数据

        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {
        System.out.println("关闭连接");
    }

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }
}
