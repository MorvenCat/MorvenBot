package indi.morven;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static indi.morven.config.ConfigReader.config;

public class MorvenBotMain {
    public static final String version = "1.0.0";
    public static final Logger LOGGER = LogManager.getLogger("MorvenBot");

    public static void main(String[] args) {
        config();
    }
}
