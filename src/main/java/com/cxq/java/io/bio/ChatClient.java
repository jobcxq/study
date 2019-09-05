package com.cxq.java.io.bio;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/02 20:28
 */
public class ChatClient {

    private final static String ip = "127.0.0.1";
    private final static int port = 8080;

    public static void main(String[] args){
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket(ip, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            while(!"bye".equals(message)){
                out.println(message);
                System.err.println("服务器：\n\t" + in.readLine());
                message = scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                out.close();
            }
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
