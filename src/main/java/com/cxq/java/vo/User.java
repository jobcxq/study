package com.cxq.java.vo;

import java.io.FileNotFoundException;

/**
 * @author cnxqin
 * @desc
 * @date 2019/09/08 23:23
 */
public class User {

    private Long userId;
    private String account;
    private String userName;
    private String password;
    private String phoneNo;
    private String sex;

    protected String hello;

    protected User sayHello () throws FileNotFoundException {
        return null;
    }

    public User(){

    }

    public User(Long userId, String account, String userName) {
        this.userId = userId;
        this.account = account;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
