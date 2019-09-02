package com.cxq.javaSE.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/02 20:03
 */
public class ChatServer {

//    private final String ip = "127.0.0.1";
    private final static int port = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try{
            serverSocket = new ServerSocket(port);
            while(true) {
                Socket socket = serverSocket.accept();  //连接阻塞

//                new Thread(() -> {}).start(); 使用 线程池，传如 socket 进行处理，BIO

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//阻塞：read/write
                out = new PrintWriter(socket.getOutputStream());
                System.err.println("客户端：\n\t" + in.readLine());

                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                while (!"bye".equals(message)) {
                    out.println(message);
                    out.flush();
                    message = scanner.nextLine();
                }
            }
        }catch ( Exception e){
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
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
