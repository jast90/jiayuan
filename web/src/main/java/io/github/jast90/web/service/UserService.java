package io.github.jast90.web.service;

import io.github.jast90.user.entity.User;
import io.github.jast90.user.form.LoginForm;
import io.github.jast90.user.form.UserChangePasswordForm;
import io.github.jast90.web.client.user.UserClient;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * Created by jast90 on 2021/3/8
 */
@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserClient userClient;

    private static final String defaultPassword = "123456";

    @Autowired
    private SessionUtil sessionUtil;

    public CommonResult<User> login(LoginForm loginForm) {
        return userClient.login(loginForm);
    }

    public CommonResult<User> add(User entity) {
        entity.setPassword(passwordEncoder.encode(entity.getPassword()!=null?entity.getPassword():defaultPassword));
        return userClient.add(entity);
    }

    public CommonResult<User> updateById(User entity) {
        return userClient.update(entity);
    }

    public CommonResult<User> updatePassword(UserChangePasswordForm form){
        return userClient.changePassword(form);
    }


}
