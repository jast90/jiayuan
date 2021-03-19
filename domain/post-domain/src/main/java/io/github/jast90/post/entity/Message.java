package io.github.jast90.post.entity;

import io.github.jast90.common.entity.BaseEntity;

/**
 * Created by jast90 on 2021/3/16
 */
public class Message extends BaseEntity {
    private Long parentId;
    private String content;
    private Long createUserId;

    private String userName;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
