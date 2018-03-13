package com.ciker.laohuier.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/12/26 0026.
 */

public class User extends DataSupport{
    private String account;
    private String password;
    private String imageId;
    private String name;
    private String sex;
    public void setAccount(String account){
        this.account = account;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getAccount(){
        return account;
    }
    public String getPassword(){
        return password;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public String getSex(){
        return sex;
    }
}
