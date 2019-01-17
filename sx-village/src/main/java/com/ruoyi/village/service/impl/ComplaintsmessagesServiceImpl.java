package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.village.domain.Complaintsmessages;
import com.ruoyi.village.mapper.ComplaintsmessagesMapper;
import com.ruoyi.village.service.IComplaintsmessagesService;
import com.ruoyi.village.util.FilterText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 投诉咨询
 * @author: Mr.Liu
 * @create: 2019-01-14 15:40
 **/
@Service
public class ComplaintsmessagesServiceImpl implements IComplaintsmessagesService {
    @Resource
    private ComplaintsmessagesMapper mapper;

    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<Complaintsmessages> selectComplaintsList(Complaintsmessages complaintmessages) {
        List<Complaintsmessages> list = mapper.selectComplaintsList(complaintmessages);
        for(Complaintsmessages complaints : list){
            if(complaints.getContent().length()>0)
                complaints.setContent(FilterText.delHTMLTag(complaints.getContent()));
        }
        return list;
    }

    @DataSource(value = DataSourceType.SXVILLAGE)
    public int deleteComplaintsByids(String fbid) {
        return mapper.deleteComplaintsByids(Convert.toStrArray(fbid));
    }

    @DataSource(value = DataSourceType.SXVILLAGE)
    public int insertcomplaintsmessages(Complaintsmessages complaintsmessages) {
        return mapper.insertcomplaintsmessages(complaintsmessages);
    }

    @DataSource(value = DataSourceType.SXVILLAGE)
    public Complaintsmessages selectByfbid(Integer fbid) {
        return mapper.selectByfbid(fbid);
    }



    @DataSource(value = DataSourceType.SXVILLAGE)
    public int updateComplaintsmessages(Complaintsmessages complaintsmessages) {
        return mapper.updateComplaintsmessages(complaintsmessages);
    }
}
