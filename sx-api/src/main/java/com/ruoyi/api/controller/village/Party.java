package com.ruoyi.api.controller.village;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.village.domain.Education;
import com.ruoyi.village.domain.Huodong;
import com.ruoyi.village.domain.Partyaffairs;
import com.ruoyi.village.domain.Shishi;
import com.ruoyi.village.service.IEducationService;
import com.ruoyi.village.service.IHuodongService;
import com.ruoyi.village.service.IPartyaffairsService;
import com.ruoyi.village.service.IShishiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/party")
@CrossOrigin
@Api(value = "党建模块 - 党员活动API类")
public class Party {
    @Autowired
    private IHuodongService huodongService;
    @Autowired
    private IEducationService educationService;
    @Autowired
    private IPartyaffairsService partyaffairsService;
    @Autowired
    private IShishiService shishiService;
    /**
     * 返回所有党员活动信息
     * @author 施景程 teavamc
     * @date 2019/6/8
     * @param []
     * @return com.ruoyi.api.domain.RongApiRes
     */
    @GetMapping("/hdAll")
    @CrossOrigin
    @ApiOperation(value = "返回所有党员活动信息")
    public RongApiRes searchAll(Huodong huodong)
    {
        return RongApiService.get_list(huodongService.selectHuodongList(huodong));
    }
    @PostMapping("/insertHd")
    @CrossOrigin
    @ApiOperation(value = "返回所有党员活动信息")
    public RongApiRes insertHd(Huodong huodong)
    {
        return RongApiService.get_bean(huodongService.inserthuodong(huodong));
    }

    @GetMapping("/eduAll")
    @CrossOrigin
    @ApiOperation(value = "返回所有党员学习信息")
    public RongApiRes searchEduAll(Education education)
    {
        return RongApiService.get_list(educationService.selectEducationList(education));
    }

    @GetMapping("/affairAll")
    @CrossOrigin
    @ApiOperation(value = "返回所有党务公开信息")
    public RongApiRes searchAffairAll(Partyaffairs partyaffairs)
    {
        return RongApiService.get_list(partyaffairsService.selectPartyaffairsList(partyaffairs));
    }

    @GetMapping("/shishiAll")
    @CrossOrigin
    @ApiOperation(value = "返回所有党务公开信息")
    public RongApiRes selectShishiList(Shishi shishi)
    {
        return RongApiService.get_list(shishiService.selectShishiList(shishi));
    }
}
