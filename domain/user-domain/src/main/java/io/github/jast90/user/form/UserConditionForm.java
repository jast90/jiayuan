package io.github.jast90.user.form;

import io.github.jast90.user.entity.User;

import java.util.List;

/**
 * Created by jast90 on 2021/3/17
 */
public class UserConditionForm extends User {
    private List<Long> userIds;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}
