package io.github.jast90.user.service;

import io.github.jast90.user.entity.User;
import io.github.jast90.user.form.UserChangePasswordForm;
import io.github.jast90.user.mapper.UserMapper;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.result.MyResult;
import io.github.jast90.web.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by jast90 on 2021/3/15
 */
@Service
public class UserService extends BaseService<UserMapper, User> {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public CommonResult<User> login(String loginName, String password) {
        User user = mapper.selectByUsername(loginName);
        if(user==null){
            return new CommonResult<>(MyResult.FAIL);
        }
        if(passwordEncoder.matches(password,user.getPassword())){
            return new CommonResult<>(MyResult.SUCCESS,user);
        }else {
            return new CommonResult<>(MyResult.FAIL);
        }
    }

    public CommonResult<User> changePassword(UserChangePasswordForm form) {
        User user = mapper.selectByPrimaryKey(form.getId());
        if(user == null || !passwordEncoder.matches(form.getOldPassword(),user.getPassword())){
            return new CommonResult<>(MyResult.FAIL);
        }
        if(form.getNewPassword() != null){
            form.setPassword(passwordEncoder.encode(form.getNewPassword()));
            if(mapper.updatePassword(form)>0){
                return new CommonResult<>(MyResult.SUCCESS);
            }
        }
        return new CommonResult<>(MyResult.FAIL);
    }
}
