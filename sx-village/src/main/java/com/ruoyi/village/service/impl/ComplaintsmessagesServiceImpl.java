package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.village.domain.Complaintsmessages;
import com.ruoyi.village.mapper.ComplaintsmessagesMapper;
import com.ruoyi.village.service.IComplaintsmessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 投诉咨询
 * @author: Mr.Liu
 * @create: 2019-01-14 15:40
 **/
@Service
public class ComplaintsmessagesServiceImpl implements IComplaintsmessagesService {
    @Autowired
    private ComplaintsmessagesMapper mapper;

    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<Complaintsmessages> selectComplaintsList(Complaintsmessages complaintmessages) {
        return mapper.selectComplaintsList(complaintmessages);
    }

    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<Complaintsmessages> selectComplaintsList_first(){
        return mapper.selectComplaintsList_first();
    }
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int deleteComplaintsByids(String id) {
        return mapper.deleteComplaintsByids(Convert.toStrArray(id));
    }
}
