package indi.morven.connect2qq;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class message {

    //消息类
    public class BaseMessage {
        //op码
        @SerializedName("op")
        private int opCode;
    }

    // Hello类
    public class HelloMessage extends BaseMessage{
        @SerializedName("d")
        private HelloData data;

        public HelloData getData() {
            return data;
        }

        public void setData(HelloData data) {
            this.data = data;
        }

        //HelloData 内部定义
        public class HelloData {
            @SerializedName("heartbeat_interval")
            private int heartBeatInterval;

            public int getHeartBeatInterval() {
                return heartBeatInterval;
            }

            public void setHeartBeatInterval(int heartBeatInterval) {
                this.heartBeatInterval = heartBeatInterval;
            }
        }
    }

    // 鉴权消息类
    public class IdentifyMessage extends BaseMessage {
        @SerializedName("d")
        private IdentifyData data;

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


    public class HeartbeatMessage extends BaseMessage {

        // 心跳特有的字段
        // ... 心跳消息的字段和方法
    }

    // 事件消息类型
    public class EventMessage extends BaseMessage {
        @SerializedName("event_data")
        private String eventData;

        // ... 事件消息的字段和方法
    }
}
