package com.es2.login;

public class Registry {
    private String path = null;
    private static volatile Registry instance = null;
    private String connectionString = null;

    private Registry() {
    }

    public static Registry getInstance() {
        if (instance == null)
            synchronized (Registry.class) {
                if (instance == null)
                    instance = new Registry();
            }
        return instance;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public String getPath() {
        return this.path;
    }
}

