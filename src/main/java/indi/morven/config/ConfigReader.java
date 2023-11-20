package indi.morven.config;

import indi.morven.MorvenBotMain;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigReader {
    static final String FILEPATH = "config.yml";
    static final String COMMENT = "" +
            "#          __  __                              ____        _   \n" +
            "#         |  \\/  | ___  _ ____   _____ _ __   | __ )  ___ | |_ \n" +
            "#         | |\\/| |/ _ \\| '__\\ \\ / / _ \\ '_ \\  |  _ \\ / _ \\| __|\n" +
            "#         | |  | | (_) | |   \\ V /  __/ | | | | |_) | (_) | |_ \n" +
            "#         |_|  |_|\\___/|_|    \\_/ \\___|_| |_| |____/ \\___/ \\__|\n" +
            "#\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\"`-0-0-'\n" +
            "#   Github:  https://github.com/MorvenCat/MorvenBot";

    public static void config() {
        File configFile = new File(FILEPATH);

        if (!configFile.exists()) {
            MorvenBotMain.LOGGER.info("找不到配置文件，会是第一次启动吗？");
            buildConfig(configFile);
        } else {
            readConfig(configFile);
        }
    }

    private static void buildConfig(File configFile) {
        MorvenBotMain.LOGGER.info("配置文件生成中~");
        BaseConfigBean base = new BaseConfigBean();
        AuthConfigBean auth = new AuthConfigBean();

        Map<String, Object> config = new LinkedHashMap<>();
        config.put("BaseConfig", base);
        config.put("AuthConfig", auth);

        String configYml = serialize2Yaml(config);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configFile))) {
            writer.write(COMMENT + "\n");
            writer.write(configYml);
        } catch (IOException e) {
            MorvenBotMain.LOGGER.error("啊，生成配置文件失败了，快看看是怎么个事\n", e);
        }
    }

    private static void readConfig(File configFile) {
        try (FileReader reader = new FileReader(configFile)) {
            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(reader);

            System.out.println(config);


        } catch (YAMLException e) {
            MorvenBotMain.LOGGER.error("配置文件里好像有什么奇怪的东西呢，快看看是怎么个事\n" + e.getMessage());
            // 可以进一步处理错误，如记录日志等
        } catch (IOException e) {
            MorvenBotMain.LOGGER.error("配置文件读取失败了XoX~\n" + e);
        }
    }

    public static String serialize2Yaml(Object object) {
    Representer representer = new Representer(new DumperOptions()) {
        @Override
        protected Tag getTag(Class<?> type, Tag defaultTag) {
            // 对于所有类型，都返回 Map 的标签，而不是类标签
            return Tag.MAP;
        }
    };

    DumperOptions options = new DumperOptions();
    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);

    Yaml yaml = new Yaml(representer, options);
    return yaml.dump(object);
    }
}
