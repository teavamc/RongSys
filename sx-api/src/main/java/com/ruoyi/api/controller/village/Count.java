package com.ruoyi.api.controller.village;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.village.service.IMemberService;
import com.ruoyi.village.service.IPartymemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/count")
@CrossOrigin
public class Count {

    @Autowired
    private IPartymemberService partymemberService;
    @Autowired
    private IMemberService memberService;

    @RequestMapping("/pm")
    @CrossOrigin
    public RongApiRes countpm(){
        return RongApiService.get_list(partymemberService.countbygroup());
    }


    @RequestMapping("/m")
    @CrossOrigin
    public RongApiRes countm(){
        return RongApiService.get_list(memberService.countbygroup());
    }


}
