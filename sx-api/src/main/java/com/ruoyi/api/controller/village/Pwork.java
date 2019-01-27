package com.ruoyi.api.controller.village;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.village.service.IPartyworkService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 村务模块中党员值班功能的接口
 *
 * @author 张超
 */
@RestController
@RequestMapping("/api/pwork")
@CrossOrigin
@Api(value = "村务模块 - 党员值班API类")
public class Pwork {

    @Autowired
    private IPartyworkService partyworkService;

    /**
        * 返回最近五条党员值班信息
        * @author 张超 teavamc
        * @date 2019/1/25
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping("/five")
    @CrossOrigin
    @ApiOperation(value = "返回最近五条党员值班信息")
    public RongApiRes searchfive(){
        return RongApiService.get_list(partyworkService.selectPartyworkListlimit5());
    }

}
