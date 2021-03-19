package io.github.jast90.convenience.service;

import com.google.common.collect.Lists;
import com.netflix.discovery.converters.Auto;
import io.github.jast90.convenience.client.user.UserClient;
import io.github.jast90.convenience.entity.Complaint;
import io.github.jast90.convenience.entity.Repair;
import io.github.jast90.convenience.mapper.ComplaintMapper;
import io.github.jast90.mybatis.pagination.domain.Page;
import io.github.jast90.mybatis.pagination.domain.PageRequest;
import io.github.jast90.user.entity.User;
import io.github.jast90.user.form.UserConditionForm;
import io.github.jast90.web.common.result.CommonResult;
import io.github.jast90.web.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jast90 on 2021/3/16
 */
@Service
public class ComplaintService extends BaseService<ComplaintMapper, Complaint> {

    @Autowired
    private UserClient userClient;

    @Override
    public CommonResult<Page<Complaint>> queryPage(PageRequest pageRequest, Complaint entity) {
        CommonResult<Page<Complaint>> pageCommonResult = super.queryPage(pageRequest, entity);
        List<Long> userIds = Lists.newArrayList();
        if(pageCommonResult.getData()!=null && pageCommonResult.getData().getContent()!=null){
            for (Complaint complaint : pageCommonResult.getData().getContent()) {
                userIds.add(complaint.getCreateUserId());
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
            for (Complaint complaint : pageCommonResult.getData().getContent()) {
                complaint.setUserName(userIdUserNameMap.get(complaint.getCreateUserId()));
            }
        }


        return pageCommonResult;
    }
}
