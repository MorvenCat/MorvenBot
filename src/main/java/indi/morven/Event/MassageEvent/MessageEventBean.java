package indi.morven.Event.MassageEvent;

import java.util.List;

public class MessageEventBean {
    private int op;
    private int s;
    private String t;
    private String id;
    private Message Message;

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MessageEventBean.Message getMessage() {
        return Message;
    }

    public void setMessage(MessageEventBean.Message message) {
        Message = message;
    }

    private class Message {
        private User author;
        private String channelId;
        private String content;
        private String guildId;
        private String id;
        private Member member;
        private int seq;
        private String seqInChannel;
        private String timestamp;

        public User getAuthor() {
            return author;
        }

        public void setAuthor(User author) {
            this.author = author;
        }

        public String getChannelId() {
            return channelId;
        }

        public void setChannelId(String channelId) {
            this.channelId = channelId;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getGuildId() {
            return guildId;
        }

        public void setGuildId(String guildId) {
            this.guildId = guildId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Member getMember() {
            return member;
        }

        public void setMember(Member member) {
            this.member = member;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }

        public String getSeqInChannel() {
            return seqInChannel;
        }

        public void setSeqInChannel(String seqInChannel) {
            this.seqInChannel = seqInChannel;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        private class Member {
            private User user;
            private String nick;
            private List<String> roles;

            public User getUser() {
                return user;
            }

            public void setUser(User user) {
                this.user = user;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public List<String> getRoles() {
                return roles;
            }

            public void setRoles(List<String> roles) {
                this.roles = roles;
            }

            public String getJoinedAt() {
                return joinedAt;
            }

            public void setJoinedAt(String joinedAt) {
                this.joinedAt = joinedAt;
            }

            private String joinedAt;
        }

        private class User {
            private String id;
            private String username;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public boolean isBot() {
                return bot;
            }

            public void setBot(boolean bot) {
                this.bot = bot;
            }

            private String avatar;
            private boolean bot;
        }
    }
}

