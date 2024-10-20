package com.donate.donate_app.config;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvironmentManager {
    private static EnvironmentManager instance;
    private Dotenv dotenv;

    private EnvironmentManager() {
        dotenv = Dotenv.load();
    }
    public static EnvironmentManager getInstance() {
        if (instance == null) {
            instance = new EnvironmentManager();
        }
        return instance;
    }

    public String getEnv(String key) {
        return dotenv.get(key);
    }
}
