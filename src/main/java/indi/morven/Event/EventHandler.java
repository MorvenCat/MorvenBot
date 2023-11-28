package indi.morven.Event;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import indi.morven.Event.MassageEvent.Message;
import indi.morven.MorvenBotMain;

public class EventHandler {
    private static final Gson GSON = new Gson();
    public static void handleEvent(String t, JsonObject eventMessage) {

        switch (t) {
            case "MESSAGE_CREATE" -> {
                //发送消息事件，代表频道内的全部消息，而不只是 at 机器人的消息。内容与 AT_MESSAGE_CREATE 相同
                Message msg = GSON.fromJson(eventMessage,Message.class);
                String user = msg.getMember().getNick();
                String content = msg.getContent();
                String channelid = msg.getChannel_id();

                MorvenBotMain.LOGGER.info("【消息】【"+channelid+"】["+user+"]"+content);


            }
            case "MESSAGE_DELETE" ->{
                //删除（撤回）消息事件

            }
            case "" ->{}
        }
    }
}
