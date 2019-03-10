package com.ruoyi.api.controller.rivervis;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.rivervis.service.IEnvDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author 张超 teavamc
 * @Description:山洪预警 - 统计计数类接口
 * @ClassName RivervisCount
 * @date 2019/3/10 13:35
 **/
@RestController
@RequestMapping("/api/rivervis")
@CrossOrigin
@Api(value = "山洪预警 - 统计计数类接口")
public class RivervisCount {

    @Autowired
    private IEnvDataService envDataService;

    /**
        * 按照时间顺序返回前二十条
        * @author 张超 teavamc
        * @date 2019/3/10
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @CrossOrigin
    @GetMapping("/commentCount")
    @ApiOperation(value = "按照时间顺序返回前二十条")
    public RongApiRes commentCount(){
        return RongApiService.get_list(envDataService.selectEnvDataListLimit());
    }


}
