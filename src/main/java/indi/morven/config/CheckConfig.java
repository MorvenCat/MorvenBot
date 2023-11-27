package indi.morven.config;

import indi.morven.MorvenBotMain;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.nodes.Tag;

import java.io.*;

public class CheckConfig {
    private static final Yaml yaml = new Yaml();
    private static final String FILEPATH = "config.yml";
    private static final String COMMENT = """
            ########################################################################
            #          __  __                              ____        _  \s
            #         |  \\/  | ___  _ ____   _____ _ __   | __ )  ___ | |_\s
            #         | |\\/| |/ _ \\| '__\\ \\ / / _ \\ '_ \\  |  _ \\ / _ \\| __|
            #         | |  | | (_) | |   \\ V /  __/ | | | | |_) | (_) | |_\s
            #         |_|  |_|\\___/|_|    \\_/ \\___|_| |_| |____/ \\___/ \\__|
            #"`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'"`-0-0-'
            #   Github: https://github.com/MorvenCat/MorvenBot
            #   Author: MorvenCat
            ########################################################################
            """;

    public static void config() {
        File configFile = new File(FILEPATH);

        if (!configFile.exists()) {
            MorvenBotMain.LOGGER.info("找不到配置文件，会是第一次启动吗？");
            buildConfig(configFile);
        } else {
            MorvenBotMain.LOGGER.info("读取配置文件中");
            readConfig(configFile);
        }
    }

    private static void buildConfig(File configFile) {
        MorvenBotMain.LOGGER.info("配置文件生成中~");
        RootConfigBean rootConfig = new RootConfigBean();
        String configYml = serialize2Yaml(rootConfig);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(configFile))) {
            writer.write(COMMENT + "\n");
            writer.write(configYml);
        } catch (IOException e) {
            MorvenBotMain.LOGGER.error("啊，生成配置文件失败了，快看看是怎么个事\n", e);
        }
    }

    private static void readConfig(File configFile) {
        try (FileReader reader = new FileReader(configFile)) {
            MorvenBotMain.LOGGER.info("配置初始化");

            RootConfigBean config = yaml.loadAs(reader,RootConfigBean.class);

            GlobalConfig.setAppSecret(config.getAuthConfig().getAppSecret());
            GlobalConfig.setAppId(config.getAuthConfig().getAppId());
            GlobalConfig.setBotQQ(config.getAuthConfig().getBotQQ());
            GlobalConfig.setToken(config.getAuthConfig().getToken());
            GlobalConfig.setIsShard(config.getBaseConfigBean().isIsShard());
            GlobalConfig.setDebug_mode(config.getBaseConfigBean().isDebug_mode());
            GlobalConfig.setAutoReconnect(config.getBaseConfigBean().isAutoReconnect());

        } catch (YAMLException e) {
            MorvenBotMain.LOGGER.error("配置文件里好像有什么奇怪的东西呢，快看看是怎么个事\n" + e.getMessage());
        } catch (IOException | ClassCastException e) {
            MorvenBotMain.LOGGER.error("配置文件读取失败了XoX~\n" + e);
        }
    }

    public static String serialize2Yaml(Object object) {

        return yaml.dumpAs(object, Tag.MAP, DumperOptions.FlowStyle.BLOCK);
    }
}