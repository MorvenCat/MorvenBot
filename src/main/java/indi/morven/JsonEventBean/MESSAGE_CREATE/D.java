package indi.morven.JsonEventBean.MESSAGE_CREATE;

import java.util.Date;

public class D {
    private Author author;
    private String channel_id;
    private String content;
    private String guild_id;
    private String id;
    private Member member;
    private int seq;
    private String seq_in_channel;
    private Date timestamp;

    public D() {
    }

    public D(Author author, String channel_id, String content, String guild_id, String id, Member member, int seq, String seq_in_channel, Date timestamp) {
        this.author = author;
        this.channel_id = channel_id;
        this.content = content;
        this.guild_id = guild_id;
        this.id = id;
        this.member = member;
        this.seq = seq;
        this.seq_in_channel = seq_in_channel;
        this.timestamp = timestamp;
    }

    /**
     * 获取
     * @return author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * 获取
     * @return channel_id
     */
    public String getChannel_id() {
        return channel_id;
    }

    /**
     * 设置
     * @param channel_id
     */
    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
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
     * @return guild_id
     */
    public String getGuild_id() {
        return guild_id;
    }

    /**
     * 设置
     * @param guild_id
     */
    public void setGuild_id(String guild_id) {
        this.guild_id = guild_id;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return member
     */
    public Member getMember() {
        return member;
    }

    /**
     * 设置
     * @param member
     */
    public void setMember(Member member) {
        this.member = member;
    }

    /**
     * 获取
     * @return seq
     */
    public int getSeq() {
        return seq;
    }

    /**
     * 设置
     * @param seq
     */
    public void setSeq(int seq) {
        this.seq = seq;
    }

    /**
     * 获取
     * @return seq_in_channel
     */
    public String getSeq_in_channel() {
        return seq_in_channel;
    }

    /**
     * 设置
     * @param seq_in_channel
     */
    public void setSeq_in_channel(String seq_in_channel) {
        this.seq_in_channel = seq_in_channel;
    }

    /**
     * 获取
     * @return timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * 设置
     * @param timestamp
     */
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String toString() {
        return "D{author = " + author + ", channel_id = " + channel_id + ", content = " + content + ", guild_id = " + guild_id + ", id = " + id + ", member = " + member + ", seq = " + seq + ", seq_in_channel = " + seq_in_channel + ", timestamp = " + timestamp + "}";
    }
}
