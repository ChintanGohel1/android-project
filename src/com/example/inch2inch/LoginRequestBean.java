package com.example.inch2inch;

import java.io.Serializable;

public class LoginRequestBean implements Serializable{

    private static final long serialVersionUID = 2536939376235107174L; 

    private String userName;
    
    private String password;

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

    @Override
    public String toString() {
	return "LoginRequestBean [userName=" + userName + ", password="
		+ password + "]";
    }
    
    
}
