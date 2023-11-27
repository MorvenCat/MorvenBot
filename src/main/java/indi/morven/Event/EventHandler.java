package indi.morven.Event;

import com.google.gson.JsonObject;

public class EventHandler {
    public static void handleEvent(String t, JsonObject eventMessage) {
        switch (t) {
            case "MESSAGE_CREATE" -> {
                //发送消息事件，代表频道内的全部消息，而不只是 at 机器人的消息。内容与 AT_MESSAGE_CREATE 相同

            }
            case "MESSAGE_DELETE" ->{
                //删除（撤回）消息事件

            }
            case "" ->{}
        }
    }
}
