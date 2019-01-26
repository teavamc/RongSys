package com.ruoyi.api.controller.village;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.village.service.IMemberService;
import com.ruoyi.village.service.IPartymemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
        * 党员统计数据api
        * @author 张超 teavamc
        * @date 2019/1/25
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping("/pm")
    @CrossOrigin
    public RongApiRes countpm(){
        return RongApiService.get_list(partymemberService.countbygroup());
    }


    /**
        * 村民统计数据接api
        * @author 张超 teavamc
        * @date 2019/1/25
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping("/m")
    @CrossOrigin
    public RongApiRes countm(){
        return RongApiService.get_list(memberService.countbygroup());
    }


}
