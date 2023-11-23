package indi.morven.connect2qq;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import indi.morven.MorvenBotMain;
import indi.morven.config.GlobalConfig;

public class GetWssURL {
    public static String wssUrl(String AUTHORIZATION) {
        //请求获取websocket链接
        HttpResponse gateway = null;
        try {
            gateway = HttpRequest.get("https://sandbox.api.sgroup.qq.com/gateway ")
                    .header(Header.AUTHORIZATION, AUTHORIZATION)
                    .execute();
        } catch (Exception e) {
            MorvenBotMain.LOGGER.error("获取WSS失败！请检查网络连接\n", e);
        }
        String wssUrl = null;
        if (gateway != null) {
            wssUrl = gateway.body();
        } else {
            MorvenBotMain.LOGGER.error("获取WSS失败！请检查配置文件验证信息是否正确！");
        }
        JSONObject json = JSONUtil.parseObj(wssUrl);
        return json.get("url").toString();
    }
}
