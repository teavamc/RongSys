package com.ruoyi.api.controller.village;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.village.domain.Mcount;
import com.ruoyi.village.domain.Pmcount;
import com.ruoyi.village.service.IMemberService;
import com.ruoyi.village.service.IPartymemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

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
        * （快排）按照地区统计党员数据：地区、总数、男性、女性
        * @author 张超 teavamc
        * @date 2019/2/13
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping("/pmSort")
    @CrossOrigin
    @ApiOperation(value = "（快排）按照地区统计党员数据：地区、总数、男性、女性")
    public RongApiRes pmSort(){
        List<Pmcount> pre = partymemberService.countbygroup();
        pmQuickSort(pre,0,pre.size()-1);
        return RongApiService.get_list(pre);
    }

    /**
        * 对List<Pmcount>数据，比较psum属性进行快排
        * @author 张超 teavamc
        * @date 2019/2/13
        * @param [list, start, end]
        * @return void
        */
    public void pmQuickSort(List<Pmcount> list,int start,int end){
        if (start < end){
            int left = start;
            int right = end;
            while (left != right){
                while (list.get(right).getPsum() >= list.get(start).getPsum() && right > left){
                    right--;
                }
                while (list.get(left).getPsum() <= list.get(start).getPsum() && right > left){
                    left++;
                }
                if (right > left){
                    Collections.swap(list,left,right);
                }
            }
            Collections.swap(list,left,start);
            pmQuickSort(list,start,left-1);
            pmQuickSort(list,right+1,end);
        }
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
        * （快排）按照地区统计村民数据：地区、总数、男性、女性
        * @author 张超 teavamc
        * @date 2019/2/13
        * @param []
        * @return com.ruoyi.api.domain.RongApiRes
        */
    @GetMapping("/mSort")
    @CrossOrigin
    @ApiOperation(value = "（快排）按照地区统计村民数据：地区、总数、男性、女性")
    public RongApiRes mSort(){
        List<Mcount> pre = memberService.countbygroup();
        mQuickSort(pre,0,pre.size()-1);
        return RongApiService.get_list(pre);
    }

    /**
        * 对List<Mcount>数据中的msum属性进行快排
        * @author 张超 teavamc
        * @date 2019/2/13
        * @param [list, start, end]
        * @return void
        */
    public void mQuickSort(List<Mcount> list,int start,int end){
        if (start < end){
            int left = start;
            int right = end;
            while (left != right){
                while (list.get(right).getMsum() >= list.get(start).getMsum() && right > left){
                    right--;
                }
                while (list.get(left).getMsum() <= list.get(start).getMsum() && right > left){
                    left++;
                }
                if (right > left){
                    Collections.swap(list,left,right);
                }
            }
            Collections.swap(list,left,start);
            mQuickSort(list,start,left-1);
            mQuickSort(list,right+1,end);
        }
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
