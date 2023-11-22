package indi.morven;


import indi.morven.QQbotApi.GetWssURL;
import indi.morven.connect2qq.webSocket2QQ;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;
import java.net.URISyntaxException;

import static indi.morven.config.CheckConfig.config;

public class MorvenBotMain {
    public static final String version = "1.0.0";
    public static final Logger LOGGER = LogManager.getLogger("MorvenBot");

    public static void main(String[] args) {
        //设置初始化
        config();
        //启动websocket客户端，建立连接
        webSocket2QQ qqBotEventSocket = null;
        try {
            qqBotEventSocket = new webSocket2QQ(new URI(GetWssURL.wssUrl()));
        } catch (URISyntaxException e) {
            LOGGER.error("与QQ服务器建立连接失败，请检查网络连接",e);
        }
        if (qqBotEventSocket != null) {
            qqBotEventSocket.connect();
        }
    }
}
