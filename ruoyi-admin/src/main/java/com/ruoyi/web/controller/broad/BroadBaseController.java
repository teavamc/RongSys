package com.ruoyi.web.controller.broad;

import com.ruoyi.common.config.Global;
import com.ruoyi.framework.web.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BroadBaseController extends BaseController {

    @GetMapping("/broad/todo")
    public String todo()
    {
        return "broad/todo";
    }

    @GetMapping("/test")
    public String codetest(){
        return "broad/codetest";
    }
}
