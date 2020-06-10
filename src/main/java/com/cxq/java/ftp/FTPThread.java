package com.cxq.java.ftp;

import com.jcraft.jsch.*;

import java.beans.ExceptionListener;
import java.util.Properties;

/**
 * @author cnxqin
 * @desc
 * @date 2020/06/10 19:44
 */
public class FTPThread implements Runnable {

    static Session session = null;
    static ChannelSftp channel = null;

    @Override
    public void run() {
        this.open();
        for(int i = 0 ; i < 20; i ++) {
            //上传文件
            if(channel == null){
                System.out.println(getInfo() + "b.channel 为 null，停止上传");
                break;
            }
            try {
                System.out.println(getInfo() + "10.开始上传第 " + i + " 个文件...");
                channel.put("D:\\Download\\电子保单.pdf", Thread.currentThread().getName() + "-" + i + ".pdf");
                System.out.println(getInfo() + "11.开始上传第 " + i + " 个文件上传成功");
            } catch (SftpException e) {
                System.out.println(getInfo() + "c.上传第 " + i + " 个文件上传失败");
                e.printStackTrace();
            }
        }
//        this.close();
        System.out.println(getInfo() + "=======================================================" + "线程执行完成");
    }

    public void open() {
        try {
            System.out.println(getInfo() + "1.开始连接 SFTP 服务......");
            JSch jSch = new JSch();
            System.out.println(getInfo() + "2.开始创建 session 信息...");
            session = jSch.getSession("root", "CentOS_01", 22);
            System.out.println(getInfo() + "3.创建 session 信息完成，session = " + session);
            session.setPassword("1234");
            Properties sshConfig = new Properties();
            //严格主机密钥检查
            sshConfig.put("StrictHostKeyChecking", "no");
            session.setConfig(sshConfig);
            session.setTimeout(1000);
            //开启sshSession链接
            System.out.println(getInfo() + "4.开始连接 SFTP 服务器...");
            session.connect();
            System.out.println(getInfo() + "5.连接 SFTP 服务器成功，sessionsession.isConnected = " + session.isConnected());

            System.out.println(getInfo() + "6.开始获取 SFTP 通道...");
            channel = (ChannelSftp) session.openChannel("sftp");
            System.out.println(getInfo() + "7.获取 SFTP 通道成功，channel = " + channel);
            System.out.println(getInfo() + "8.开始连接 SFTP 通道...");
            channel.connect();
            System.out.println(getInfo() + "9.连接 SFTP 通道成功，channel = " + channel.isConnected());
            channel.cd("/root/ftp");
        }catch (Exception e){
            System.out.println(getInfo() + "a.连接 SFTP 服务失败");
            e.printStackTrace();
        }
    }

    //关闭
    public void close() {
        try {
            System.out.println(getInfo() + "12.开始关闭 SFTP 服务...");
            channel.disconnect();
            System.out.println(getInfo() + "13.关闭 SFTP 通道成功，channel = " + channel);
        } catch (Exception e) {
            System.out.println(getInfo() + "d.关闭 SFTP 通道失败，channel = " + channel);
            e.printStackTrace();
        }
        channel = null;

        try {
            System.out.println(getInfo() + "14.开始关闭 SFTP 服务器，session = " + session);
            session.disconnect();
            session = null;
            System.out.println(getInfo() + "15.关闭 SFTP 服务器成功，session = " + session);
        } catch (Exception e) {
            System.out.println(getInfo() + "e.关闭 SFTP 服务器失败，session = " + session);
            e.printStackTrace();
        }
        session = null;
    }
    
    public String getInfo(){
        
        StringBuilder sb = new StringBuilder(Thread.currentThread().getName())
                .append(" ")
                .append(System.currentTimeMillis())
                .append(" session = ").append(session)
                .append(" session.isConnected = ").append(session != null ? session.isConnected() : null)
                .append(" channel = ").append(channel)
                .append(" channel.isConnected = ").append(channel != null ? channel.isConnected() : channel)
                .append("\n==========");
        return sb.toString();
        
    }
}
