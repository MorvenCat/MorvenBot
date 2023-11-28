package indi.morven.Event.MassageEvent;

import java.util.Date;

public class Message {

    private Author author;
    private String channel_id;
    private String content;
    private String guild_id;
    private String id;
    private Member member;
    private int seq;
    private String seq_in_channel;
    private Date timestamp;
    public void setAuthor(Author author) {
         this.author = author;
     }
     public Author getAuthor() {
         return author;
     }

    public void setChannel_id(String channel_id) {
         this.channel_id = channel_id;
     }
     public String getChannel_id() {
         return channel_id;
     }

    public void setContent(String content) {
         this.content = content;
     }
     public String getContent() {
         return content;
     }

    public void setGuild_id(String guild_id) {
         this.guild_id = guild_id;
     }
     public String getGuild_id() {
         return guild_id;
     }

    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setMember(Member member) {
         this.member = member;
     }
     public Member getMember() {
         return member;
     }

    public void setSeq(int seq) {
         this.seq = seq;
     }
     public int getSeq() {
         return seq;
     }

    public void setSeq_in_channel(String seq_in_channel) {
         this.seq_in_channel = seq_in_channel;
     }
     public String getSeq_in_channel() {
         return seq_in_channel;
     }

    public void setTimestamp(Date timestamp) {
         this.timestamp = timestamp;
     }
     public Date getTimestamp() {
         return timestamp;
     }
}