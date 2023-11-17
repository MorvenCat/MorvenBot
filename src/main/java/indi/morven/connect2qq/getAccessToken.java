package indi.morven.connect2qq;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class getAccessToken {
    public String[] getAccessToken(){
        JSONObject json = JSONUtil.createObj()
                .putOnce("appId","102073158")
                .putOnce("clientSecret","Z2IagYCdqqb9TYkj");

        String accessInfo = json.toString();
        HttpResponse response = HttpRequest.post("https://bots.qq.com/app/getAppAccessToken")
                .header(Header.CONTENT_TYPE,"application/json")
                .body(accessInfo)
                .execute();
        String responseJson = response.body();
        JSONObject json2 = JSONUtil.parseObj(responseJson);
        String accessToken = json2.get("access_token").toString();
        String expires_in = json2.get("expires_in").toString();

        return new String[]{accessToken,expires_in};
    }
}
