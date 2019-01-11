package com.ruoyi.web.controller.broad;

import com.ruoyi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 思信广播短信管理
 *
 * @author 张超
 */
@Controller
@RequestMapping("/broad/sms")
public class SmsController extends BaseController {

    private String prefix = "broad/sms";

    @GetMapping("/send")
    public String sendmessage(){
        return prefix+"/send";
    }

    @GetMapping("/receive")
    public String receivemessage(){
        return prefix+"/receive";
    }

}
