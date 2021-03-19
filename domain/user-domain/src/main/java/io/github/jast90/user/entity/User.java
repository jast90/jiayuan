package io.github.jast90.user.entity;

import io.github.jast90.common.entity.BaseEntity;

/**
 * Created by jast90 on 2021/3/15
 */
public class User extends BaseEntity {
    private String username;
    private String password;
    private byte userType;
    private String realName;
    private int age;

    //未入住的用户
    private boolean unJoin;

    public String getUserTypeDesc(){
        String desc = null;
        switch (getUserType()){
            case 1: desc = "管理员"; break;
            default: desc = "业主";break;
        }
        return desc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getUserType() {
        return userType;
    }

    public void setUserType(byte userType) {
        this.userType = userType;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isUnJoin() {
        return unJoin;
    }

    public void setUnJoin(boolean unJoin) {
        this.unJoin = unJoin;
    }
}
