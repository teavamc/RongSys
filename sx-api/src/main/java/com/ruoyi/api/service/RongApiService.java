package com.ruoyi.api.service;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.broad.domain.Managementgps;
import com.ruoyi.broad.service.IManagementService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *  接口业务处理封装
 *
 * @author 张超
 */
public class RongApiService {

    /**
        * 将其他业务中的List<HashMap(JavaBean)>进行统一封装成API-JSON数据
        * @author 张超 teavamc
        * @date 2019/1/25
        * @param [list]
        * @return com.ruoyi.api.domain.RongApiRes
        */
    public static RongApiRes get_list(List list){
        RongApiRes res = new RongApiRes();
        if(list!=null&&!list.isEmpty()){
            res = res.success("已查询到"+list.size()+"条数据");
            res.put("data",list);
            res.put("data_size",list.size());
        }else {
            res = res.error("数据获取失败");
        }
        return res;
    }

    /**
        * 将其他业务中的HashMap(JavaBean)进行统一封装成API-JSON数据
        * @author 张超 teavamc
        * @date 2019/2/4
        * @param [obj]
        * @return com.ruoyi.api.domain.RongApiRes
        */
    public static RongApiRes get_bean(Object obj){
        RongApiRes res = new RongApiRes();
        if(obj!=null){
            res = res.success("已查询到1条数据");
            res.put("data",obj);
        }else {
            res = res.error("数据获取失败");
        }
        return res;
    }

    public static List<HashMap<String,Object>> list_quickSort(List<HashMap<String,Object>> list){
        List<HashMap<String,Object>> pre = list;
        //1.取list[0]的数据，找到value最大的key
        Object[] keys = ((list.get(0)).keySet()).toArray();
        //2.遍历这个数组 拿到值最大的key
        //3.list就按照这个Key的Value进行快排


        return list;
    }


}
