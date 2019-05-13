package com.ruoyi.web.controller.broad;


import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ruoyi.framework.web.base.BaseController;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;
import java.util.Set;

import static com.ruoyi.redis.RedisWatchLock.*;

/**
 * 聊天室
 *
 * @author 周博
 * @date 2019-04-27
 */
@Controller
@RequestMapping("/broad/chat")
public class ChatController extends BaseController {
    private String prefix = "broad/chat";

    @GetMapping()
    public String chat(HttpSession session) {
        SysUser user = ShiroUtils.getSysUser(); //从session中获取当前登陆用户的userid
        session.setAttribute("userName", user.getUserName());
        return prefix + "/chat";
    }

    @GetMapping("/msg")
    @ResponseBody
    public Set<String> message() {
        Jedis jedis = new Jedis(redisHost);
        jedis.auth(redisPassword);
        int n = Integer.valueOf(jedis.get(redisNumber));
        Set<String> set = jedis.zrange(redisSocketSet, 0, n+1);
        return set;
    }
}
