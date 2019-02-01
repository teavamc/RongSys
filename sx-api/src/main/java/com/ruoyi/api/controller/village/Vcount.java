package com.ruoyi.api.controller.village;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.village.service.IMemberService;
import com.ruoyi.village.service.IPartymemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 村务模块的数据统计接口
 *
 * @author 张超
 */

@RestController
@RequestMapping("/api/count")
@CrossOrigin
@Api(value = "村务模块 - 数据统计API类")
public class Vcount {

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
    @ApiOperation(value = "按照地区统计党员数据：地区、总数、男性、女性")
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
    @ApiOperation(value = "按照地区统计村民数据：地区、总数、男性、女性")
    public RongApiRes countm(){
        return RongApiService.get_list(memberService.countbygroup());
    }

    /**
        * 统计村民和党员总数/男/女
        * @author 张超 teavamc
        * @date 2019/1/30
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping("/p_m")
    @CrossOrigin
    @ApiOperation(value = "统计村民和党员总数/男/女")
    public RongApiRes countp_m(){
        return RongApiService.get_list(memberService.countpm());
    }

    @GetMapping("/g_cPM")
    @CrossOrigin
    @ApiOperation(value = "按照地区类型返回村民和党员的总数/男性/女性")
    public RongApiRes groupByAreaCountPM(){
        return RongApiService.get_list(memberService.groupAreaCountPM());
    }

}
