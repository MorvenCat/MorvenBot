package indi.morven.QQbotApi.SendMsg;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;

public class channelsMsg {
    private String content;
    private String msg_id;

    public channelsMsg() {
    }

    public channelsMsg(String content, String msg_id) {
        this.content = content;
        this.msg_id = msg_id;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取
     * @return msg_id
     */
    public String getMsg_id() {
        return msg_id;
    }

    /**
     * 设置
     * @param msg_id
     */
    public void setMsg_id(String msg_id) {
        this.msg_id = msg_id;
    }

    public String toString() {
        return "channelsMsg{content = " + content + ", msg_id = " + msg_id + "}";
    }
}
