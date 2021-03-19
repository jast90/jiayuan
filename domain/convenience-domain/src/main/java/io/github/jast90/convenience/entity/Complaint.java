package io.github.jast90.convenience.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.github.jast90.common.entity.BaseEntity;

import java.time.LocalDate;

/**
 * Created by jast90 on 2021/3/16
 */
public class Complaint extends BaseEntity {
    private String content;
    private Long createUserId;
    private String phone;
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate postDate;

    private String userName;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
