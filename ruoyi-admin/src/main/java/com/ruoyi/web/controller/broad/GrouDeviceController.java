package com.ruoyi.web.controller.broad;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/broad/groupdevice")
public class GrouDeviceController {
    private String prifix = "/broad/groupdevice";

    @GetMapping
    @RequiresPermissions("broad:groupdevice:view")
    public String groupdevice(){
        return prifix + "/groupdevice";
    }
}
