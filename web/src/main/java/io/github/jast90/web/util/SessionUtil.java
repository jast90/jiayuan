package io.github.jast90.web.util;

import io.github.jast90.user.entity.User;
import io.github.jast90.user.entity.UserHouse;
import io.github.jast90.web.client.user.UserHouseClient;
import io.github.jast90.web.common.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jast90 on 2021/3/12
 */
@Service
public class SessionUtil {

    @Autowired
    private HttpSession session;

    @Autowired
    private UserHouseClient userHouseClient;

    public long getUid(){
        User user = (User) session.getAttribute("s_sysUser");
        return user.getId();
    }

    public boolean admin(){
        User user = (User) session.getAttribute("s_sysUser");
        return user.getUserType()==1;
    }

    public boolean user(){
        User user = (User) session.getAttribute("s_sysUser");
        return user.getUserType()==2;
    }

    public Long getUserHouseId(){
        if(user()){
            UserHouse userHouse = new UserHouse();
            userHouse.setUserId(getUid());
            CommonResult<List<UserHouse>> listCommonResult = userHouseClient.queryListByCondition(userHouse);
            if(listCommonResult.getData()!=null && listCommonResult.getData().size()==1){
                return listCommonResult.getData().get(0).getHouseId();
            }
        }
        return 0L;
    }
}
