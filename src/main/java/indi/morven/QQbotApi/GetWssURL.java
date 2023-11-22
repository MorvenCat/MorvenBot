package indi.morven.QQbotApi;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import indi.morven.MorvenBotMain;
import indi.morven.config.GlobalConfig;

public class GetWssURL {
    public static String wssUrl() {
        //请求获取websocket链接
        HttpResponse gateway = null;
        try {
            gateway = HttpRequest.get("https://sandbox.api.sgroup.qq.com/gateway ")
                    .header(Header.AUTHORIZATION, GlobalConfig.getAUTHORIZATION())
                    .execute();
        } catch (Exception e) {
            MorvenBotMain.LOGGER.error("获取WSS失败！请检查网络连接\n",e);
        }
        String wssUrl = gateway.body();
        JSONObject json = JSONUtil.parseObj(wssUrl);
        return json.get("url").toString();
    }
}
