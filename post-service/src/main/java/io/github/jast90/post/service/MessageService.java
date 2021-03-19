package io.github.jast90.post.service;

import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.post.client.user.UserClient;
import io.github.jast90.post.entity.Announcement;
import io.github.jast90.post.entity.Message;
import io.github.jast90.post.mapper.MessageMapper;
import io.github.jast90.user.entity.User;
import io.github.jast90.user.form.UserConditionForm;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jast90 on 2021/3/16
 */
@Service
public class MessageService extends BaseService<MessageMapper, Message> {
    @Autowired
    private UserClient userClient;

    @Override
    public CommonResult<Page<Message>> queryPage(PageRequest pageRequest, Message entity) {
        CommonResult<Page<Message>> pageCommonResult = super.queryPage(pageRequest, entity);
        if(pageCommonResult.getData()!=null&&pageCommonResult.getData().getContent()!=null){
            List<Long> userIds = new ArrayList<>();
            for (Message message : pageCommonResult.getData().getContent()) {
                userIds.add(message.getCreateUserId());
            }
            UserConditionForm userConditionForm = new UserConditionForm();
            userConditionForm.setUserIds(userIds);
            CommonResult<List<User>> listCommonResult = userClient.queryListByCondition(userConditionForm);
            Map<Long,String> userIdUserNameMap = new HashMap<>();
            if(listCommonResult.getData()!=null){
                for (User user : listCommonResult.getData()) {
                    userIdUserNameMap.put(user.getId(),user.getRealName());
                }
            }
            for (Message message : pageCommonResult.getData().getContent()) {
                message.setUserName(userIdUserNameMap.get(message.getCreateUserId()));
            }
        }

        return pageCommonResult;
    }
}
