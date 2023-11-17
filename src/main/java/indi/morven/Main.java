    package indi.morven;

    import cn.hutool.json.JSONObject;
    import cn.hutool.json.JSONUtil;

    public class Main {
        public static void main(String[] args) throws Exception {

            //apiHttpDemo.getAccessToken();

            //Cli cli = new Cli();
            //cli.botCli();

            String json ="{\n" +
                    "  \"op\": 2,\n" +
                    "  \"d\": {\n" +
                    "    \"token\": \"token string\",\n" +
                    "    \"intents\": 513,\n" +
                    "    \"shard\": [0, 4],\n" +
                    "    \"properties\": {\n" +
                    "      \"$os\": \"linux\",\n" +
                    "      \"$browser\": \"my_library\",\n" +
                    "      \"$device\": \"my_library\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
            JSONObject jsonObject = JSONUtil.parseObj(json);
            System.out.println(jsonObject.get("d"));
        }
    }