package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.BroadTime;
import com.ruoyi.broad.mapper.BroadTimeMapper;
import com.ruoyi.broad.service.IBroadTimeService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 根据时间和地区对广播数目的统计
 * @author 周博
 * @date 2019-01-15
 */
@Service
public class BroadTimeServiceImpl implements IBroadTimeService {
    @Autowired
    private BroadTimeMapper broadTimeMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<BroadTime> selectList() {
        return broadTimeMapper.selectList();
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<BroadTime> selectListByDate() {
        return broadTimeMapper.selectListByDate();
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public  List<BroadTime> selectListByScategory() {
        return broadTimeMapper.selectListByScategory();
    }

}
