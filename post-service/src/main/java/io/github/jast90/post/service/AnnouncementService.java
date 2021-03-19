package io.github.jast90.post.service;

import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.post.client.user.UserClient;
import io.github.jast90.post.entity.Announcement;
import io.github.jast90.post.mapper.AnnouncementMapper;
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
public class AnnouncementService extends BaseService<AnnouncementMapper, Announcement> {

    @Autowired
    private UserClient userClient;

    @Override
    public CommonResult<Page<Announcement>> queryPage(PageRequest pageRequest, Announcement entity) {
        CommonResult<Page<Announcement>> pageCommonResult = super.queryPage(pageRequest, entity);
        if(pageCommonResult.getData()!=null&&pageCommonResult.getData().getContent()!=null){
            List<Long> userIds = new ArrayList<>();
            for (Announcement announcement : pageCommonResult.getData().getContent()) {
                userIds.add(announcement.getCreateUserId());
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
            for (Announcement announcement : pageCommonResult.getData().getContent()) {
                announcement.setUserName(userIdUserNameMap.get(announcement.getCreateUserId()));
            }
        }
        return pageCommonResult;
    }
}
