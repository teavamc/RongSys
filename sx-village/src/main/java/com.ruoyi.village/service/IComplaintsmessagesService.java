package com.ruoyi.village.service;

import com.ruoyi.village.domain.Complaintsmessages;


import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 投诉咨询Service
 * @author: Mr.Liu
 * @create: 2019-01-14 15:37
 **/

public interface IComplaintsmessagesService {
    /**
     * 查询投诉咨询记录列表
     *
     * @return
     */
    public List<Complaintsmessages> selectComplaintsList(Complaintsmessages complaintmessages);

    /**
     * 根据fbid删除数据
     * @param id
     */
    public int deleteComplaintsByids(String id);
}
