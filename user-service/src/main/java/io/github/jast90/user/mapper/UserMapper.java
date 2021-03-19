package io.github.jast90.user.mapper;

import io.github.jast90.user.entity.User;
import io.github.jast90.user.form.UserChangePasswordForm;
import io.github.jast90.web.common.mapper.BaseMapper;

import java.util.List;

/**
 * Created by jast90 on 2021/3/15
 */
public interface UserMapper extends BaseMapper<User> {
    User selectByUsername(String loginName);

    int updatePassword(UserChangePasswordForm form);
}
