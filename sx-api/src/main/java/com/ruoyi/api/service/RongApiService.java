package com.ruoyi.api.service;

import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.broad.domain.Managementgps;
import com.ruoyi.broad.service.IManagementService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *  接口业务处理封装
 *
 * @author 张超
 */
public class RongApiService {

    public static RongApiRes get_list(List list){
        RongApiRes res = new RongApiRes();
        if(list!=null&&!list.isEmpty()){
            res = res.success("已查询到"+list.size()+"数据");
            res.put("data",list);
            res.put("data_size",list.size());
        }else {
            res = res.error("数据获取失败");
        }
        return res;
    }

}
