package com.ruoyi.web.controller.village;

import com.ruoyi.framework.web.base.BaseController;

import com.ruoyi.village.service.IrecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: lyb_RongSys
 * @description: 求职招聘 信息操作处理
 * @author: Mr.Liu
 * @create: 2019-01-15 14:31
 **/
@Controller
@RequestMapping("/village/recruitment")
public class recruitmentController extends BaseController {
    private String prefix = "/village/recruitment";

    @Autowired
    private IrecruitmentService irecruitmentService;

    @GetMapping()
    public String recruitment(){return prefix+"recruitment";}
}
