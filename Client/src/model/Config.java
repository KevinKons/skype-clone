/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dougl
 */
public class Config {

    private static Config instance;
    private String address;
    private final int port = 56000;

    private Config() {
    }

    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }

        return instance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

}
