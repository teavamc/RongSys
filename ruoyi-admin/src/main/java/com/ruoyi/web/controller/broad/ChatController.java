package com.ruoyi.web.controller.broad;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ruoyi.framework.web.base.BaseController;

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
    public String chat() {
        return prefix + "/chat";
    }
}
