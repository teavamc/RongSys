package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.Complaintsmessages;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 投诉咨询mapper
 * @author: Mr.Liu
 * @create: 2019-01-14 15:34
 **/

public interface ComplaintsmessagesMapper {
    /**
     * 查询投诉咨询记录列表
     *
     * @return
     */
    List<Complaintsmessages> selectComplaintsList(Complaintsmessages complaintmessages);

    /**
     * 根据fbid删除数据
     * @param id
     */
    int deleteComplaintsByids(String[] id);

    /**
     * 根据类型或者内容进行模糊查询
     * @param other
     * @return
     */
    //List<Complaintsmessages> selectComplaintsListBy_other(String other);
}
