/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

/**
 *
 * @author Kevin
 */
public class CloseConnection {

    private CloseConnection() {
    }

    private static CloseConnection instance;

    public static CloseConnection getInstance() {
        if (instance == null) {
            instance = new CloseConnection();
        }

        return instance;
    }

    public void close(Reader in, Writer out, Socket conn) {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (IOException e) {
            System.out.println("Error on closing input stream, output stream or socket");
            e.printStackTrace();
        }
    }

    public void closeInAndConn(Reader in, Socket conn) {
        try {
            if (in != null) {
                in.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (IOException e) {
            System.out.println("Error on closing input stream or socket");
            e.printStackTrace();
        }
    }

    public void closeOutAndConn(Writer out, Socket conn) {
        try {
            if (out != null) {
                out.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (IOException e) {
            System.out.println("Error on closing output stream or socket");
            e.printStackTrace();
        }
    }
}
