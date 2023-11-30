package indi.morven.Event;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import indi.morven.Event.MassageEvent.Message;
import indi.morven.MorvenBotMain;
import indi.morven.QQbotApi.QQbotAPI;
import indi.morven.QQbotApi.SendMsg.channelsMsg;
import indi.morven.QQbotApi.Token.TokenRequest;
import indi.morven.QQbotApi.Token.TokenResponse;
import indi.morven.config.GlobalConfig;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class EventHandler {
    private static final Gson GSON = new Gson();
    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.sgroup.qq.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //创建网络请求接口的实例
    private static final QQbotAPI demo = retrofit.create(QQbotAPI.class);

    public static void handleEvent(String t, JsonObject eventMessage) {

        //定时任务，获取token


        switch (t) {
            case "MESSAGE_CREATE" -> {
                //发送消息事件，代表频道内的全部消息，而不只是 at 机器人的消息。内容与 AT_MESSAGE_CREATE 相同
                Message msg = GSON.fromJson(eventMessage, Message.class);
                String user = msg.getMember().getNick();
                String content = msg.getContent();
                String channelid = msg.getChannel_id();
                String msgid = msg.getId();
                MorvenBotMain.LOGGER.info("【频道消息】【" + channelid + "】[" + user + "]" + content);

                channelsMsg fuduji = new channelsMsg(content, msgid);


                //复读
                //封装发送请求
                Call<channelsMsg> call = demo.channelsMsg(fuduji, channelid);
                //发送请求
                try {
                    MorvenBotMain.LOGGER.debug("发送请求\n" + call);
                    Response<channelsMsg> execute = call.execute();
                    MorvenBotMain.LOGGER.debug("返回包\n" + execute);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            case "MESSAGE_DELETE" -> {
                //删除（撤回）消息事件

            }
            case "" -> {
            }

        }
    }

    public static void getToken() {
        TokenRequest TokenRequest = new TokenRequest(GlobalConfig.getAppId(), GlobalConfig.getAppSecret());
        Call<TokenResponse> token = demo.getToken(TokenRequest);

        try {
            MorvenBotMain.LOGGER.debug("发送请求\n" + token);
            Response<TokenResponse> tokenResponse = token.execute();
            MorvenBotMain.LOGGER.debug("返回包\n" + tokenResponse);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
