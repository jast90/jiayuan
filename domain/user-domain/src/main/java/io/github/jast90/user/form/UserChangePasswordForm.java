package io.github.jast90.user.form;


import io.github.jast90.user.entity.User;

/**
 * Created by jast90 on 2021/3/13
 */
public class UserChangePasswordForm extends User {
    private String newPassword;
    private String oldPassword;

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
}
