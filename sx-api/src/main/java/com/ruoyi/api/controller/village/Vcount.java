package com.ruoyi.api.controller.village;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.common.utils.PageData;
import com.ruoyi.village.domain.*;

import com.ruoyi.village.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Set;

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
    @Autowired
    private IForestlandInfoService forestlandInfoService;
    @Autowired
    private IPlowlandInfoService plowlandInfoService;
    @Autowired
    private IAssetAssessmentService assetAssessmentService;
    @Autowired
    private IVillagegroupStatisticsInfoService villagegroupStatisticsInfoService;
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


    @GetMapping("/g_fLand")
    @CrossOrigin
    @ApiOperation(value = "按照地区类型返回林地列表")
    public RongApiRes selectForestlandInfoList(ForestlandInfo forestlandInfo){
        return RongApiService.get_list(forestlandInfoService.selectForestlandInfoList(forestlandInfo));
    }

    @GetMapping("/g_pLand")
    @CrossOrigin
    @ApiOperation(value = "按照地区类型返回耕地列表")
    public RongApiRes selectPlowlandInfoList(PlowlandInfo plowlandInfo){
        return RongApiService.get_list(plowlandInfoService.selectPlowlandInfoList(plowlandInfo));
    }

    @GetMapping("/g_asset")
    @CrossOrigin
    @ApiOperation(value = "按照地区类型返回资产清查")
    public RongApiRes selectAssetAssessmentList(AssetAssessment assetAssessment){
        return RongApiService.get_list(assetAssessmentService.selectAssetAssessmentList(assetAssessment));
    }

    @GetMapping("/g_viiGroup")
    @CrossOrigin
    @ApiOperation(value = "按照地区类型返回村组列表")
    public RongApiRes selectVillagegroupStatisticsInfoList(VillagegroupStatisticsInfo villagegroupStatisticsInfo){
        return RongApiService.get_list(villagegroupStatisticsInfoService.selectVillagegroupStatisticsInfoList(villagegroupStatisticsInfo));
    }

    @GetMapping("/g_edulevel")
    @CrossOrigin
    @ApiOperation(value = "统计村民和党员总数/男/女")
    public RongApiRes countbyedulevel(){
        return RongApiService.get_list(partymemberService.countbyedulevel());
    }
//    报错：类转换错误
//    java.lang.ClassCastException: java.util.HashMap cannot be cast to com.ruoyi.common.utils.PageData
//    不知为何PageData实现了Map接口，却无法使用override的get(Object key)和getString(Object key)方法
//    本功能的排序暂搁置


//    @GetMapping("/g_cPMSort")
//    @CrossOrigin
//    @ApiOperation(value = "（排序后）按照地区类型返回村民和党员的总数/男性/女性")
//    public RongApiRes groupByAreaCountPMSort(){
//        List<PageData> pre = memberService.groupAreaCountPM();
//        //PageData中的基准key
//        Object key = "msum";
////        gcQuickSort(pre,key,0,pre.size()-1);
//        return RongApiService.get_list(pre);
//    }
//
//    public void gcQuickSort(List<PageData> list,String key,int start,int end){
//        if (start < end){
//            int left = start;
//            int right = end;
//            while (left != right){
//                while (Integer.valueOf((list.get(right)).getString(key)) >= Integer.valueOf((list.get(start)).getString(key)) && left < right){
//                    right--;
//                }
//                while (Integer.valueOf((list.get(left)).getString(key)) <= Integer.valueOf((list.get(start)).getString(key)) && left < right){
//                    left++;
//                }
//                Collections.swap(list,left,right);
//            }
//            Collections.swap(list,left,start);
//            gcQuickSort(list,key,start,left-1);
//            gcQuickSort(list,key,right+1,end);
//        }
//    }

}
