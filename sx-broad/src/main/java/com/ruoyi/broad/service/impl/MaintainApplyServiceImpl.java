package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.MaintainApply;
import com.ruoyi.broad.mapper.MaintainApplyMapper;
import com.ruoyi.broad.service.IMaintainApplyService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2019/7/12.
 */
@Service
public class MaintainApplyServiceImpl implements IMaintainApplyService {

    @Autowired
    private MaintainApplyMapper maintainApplyMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public MaintainApply selectMaintainApplyById(String maid){
        return maintainApplyMapper.selectMaintainApplyById(maid);
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<MaintainApply> selectMaintainApplyList(MaintainApply maintainApply){
        return maintainApplyMapper.selectMaintainApplyList(maintainApply);
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<MaintainApply> selectAllMaintainApply(){
        return maintainApplyMapper.selectAllMaintainApply();
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int deleteMaintainApplyById(String maid){return maintainApplyMapper.deleteMaintainApplyById(maid);}

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int insertMaintainApply(MaintainApply maintainApply){return maintainApplyMapper.insertMaintainApply(maintainApply);}
}
