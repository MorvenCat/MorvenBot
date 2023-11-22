package indi.morven.connect2qq;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import indi.morven.config.GlobalConfig;

import java.net.URI;
import java.net.URISyntaxException;

import static indi.morven.config.CheckConfig.config;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        config();

        //请求获取websocket链接
        HttpResponse gateway = HttpRequest.get("https://sandbox.api.sgroup.qq.com/gateway ")
                .header(Header.AUTHORIZATION, GlobalConfig.getAUTHORIZATION())
                .execute();
        String wssUrl = gateway.body();
        JSONObject json = JSONUtil.parseObj(wssUrl);
        String url = json.get("url").toString();

        //启动websocket客户端，建立连接
        webSocket2QQ qqBotEventSocket = new webSocket2QQ(new URI(url));
        qqBotEventSocket.connect();

    }
}
