package indi.morven.connect2qq;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class SocketDataBean {
    /**
      *  op 指的是 opcode，全部 opcode 列表参考 opcode
      *  (https://bot.q.qq.com/wiki/develop/api-231017/dev-prepare/interface-framework/event-emit.html#websocket-%E6%96%B9%E5%BC%8F)。
      *  s下行消息都会有一个序列号，标识消息的唯一性，客户端需要再发送心跳的时候，携带客户端收到的最新的s。
      *  t和d 主要是用在op为 0 Dispatch 的时候，
      *  t 代表事件类型，
      *  d 代表事件内容，
      *  不同事件类型的事件内容格式都不同，请注意识别。
      **/

    //消息类
    public static class BaseMessage {
        //op码
        @SerializedName("op")
        private int opCode;

        public BaseMessage(int opCode) {
            this.opCode = opCode;
        }


        public int getOpCode() {
            return opCode;
        }

        public void setOpCode(int opCode) {
            this.opCode = opCode;
        }
    }

    // Hello类
    public static class HelloMessage extends BaseMessage {
        @SerializedName("d")
        private d d;

        public HelloMessage(int opCode) {
            super(opCode);
        }

        public d getD() {
            return d;
        }

        public void setD(d d) {
            this.d = d;
        }

        //d 内部定义
        public static class d {
            @SerializedName("heartbeat_interval")
            private int heartBeatInterval;  //获取心跳周期
            public int getHeartBeatInterval() {
                return heartBeatInterval;
            }
            public void setHeartBeatInterval(int heartBeatInterval) {
                this.heartBeatInterval = heartBeatInterval;
            }
        }
    }

    // 事件消息类型
    public static class EventMessage extends BaseMessage {
        @SerializedName("s")
        private int s;

        @SerializedName("t")
        private String t;

        @SerializedName("id")
        private String id;

        @SerializedName("d")
        private d d;

        public EventMessage(int opCode) {
            super(opCode);
        }

        public static class d {
            @SerializedName("version")
            private String version;

            @SerializedName("user")
            private user user;

            @SerializedName("session_id")
            private String session_id;

            @SerializedName("shard")
            private int[] id;


            public static class user {
                @SerializedName("id")
                private String id;
                @SerializedName("username")
                private String username;
                @SerializedName("bot")
                private String bot;

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

                public String getBot() {
                    return bot;
                }

                public void setBot(String bot) {
                    this.bot = bot;
                }
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public EventMessage.d.user getUser() {
                return user;
            }

            public void setUser(EventMessage.d.user user) {
                this.user = user;
            }

            public String getSession_id() {
                return session_id;
            }

            public void setSession_id(String session_id) {
                this.session_id = session_id;
            }

            public int[] getId() {
                return id;
            }

            public void setId(int[] id) {
                this.id = id;
            }
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

        public d getD() {
            return d;
        }

        public void setD(d d) {
            this.d = d;
        }
    }

    // 鉴权消息类
    public static class IdentifyMessage extends BaseMessage {
        @SerializedName("d")
        private IdentifyData data;

        public IdentifyMessage(int opCode) {
            super(opCode);
        }

        public IdentifyData getData() {
            return data;
        }

        public void setData(IdentifyData data) {
            this.data = data;
        }

        // IdentifyData 内部类定义
        public static class IdentifyData {
            @SerializedName("token")
            private String token;
            @SerializedName("intents")
            private int intents;
            @SerializedName("shard")
            private int[] shard;
            @SerializedName("properties")
            private Map<String, String> properties;

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public int getIntents() {
                return intents;
            }

            public void setIntents(int intents) {
                this.intents = intents;
            }

            public int[] getShard() {
                return shard;
            }

            public void setShard(int[] shard) {
                this.shard = shard;
            }

            public Map<String, String> getProperties() {
                return properties;
            }

            public void setProperties(Map<String, String> properties) {
                this.properties = properties;
            }
        }
    }


    public static class HeartbeatMessage extends BaseMessage {
        @SerializedName("d")
        private int d;

        public HeartbeatMessage(int opCode) {
            super(opCode);
        }

        public int getD() {
            return d;
        }

        public void setD(int d) {
            this.d = d;
        }
    }

    public static class ResumeMessage extends BaseMessage {
        @SerializedName("d")
        private d d;

        public ResumeMessage(int opCode) {
            super(opCode);
        }

        public static class d {
            @SerializedName("token")
            private String token;
            @SerializedName("session_id")
            private String sessionId;
            @SerializedName("seq")
            private int s;

            public String getToken() {
                return token;
            }

            public void setToken(String token) {
                this.token = token;
            }

            public String getSessionId() {
                return sessionId;
            }

            public void setSessionId(String sessionId) {
                this.sessionId = sessionId;
            }

            public int getS() {
                return s;
            }

            public void setS(int s) {
                this.s = s;
            }
        }

        public ResumeMessage.d getD() {
            return d;
        }

        public void setD(ResumeMessage.d d) {
            this.d = d;
        }
    }
}
