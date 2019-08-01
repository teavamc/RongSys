package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.Tempgroup;
import com.ruoyi.broad.mapper.TempgroupMapper;
import com.ruoyi.broad.service.ITempgroupService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2019/7/29.
 */
@Service
public class TempgroupServiceImpl implements ITempgroupService{

    @Autowired
    private TempgroupMapper tempgroupMapper;
    /**
     * 查询终端临时列表
     *
     * @return 终端临时列表
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Tempgroup> selectAllTempgroup()
    {
        return tempgroupMapper.selectAllTempgroup();
    }

    /**
     * 更新终端临时列表
     *
     * @return 终端临时列表
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int updateTempgroup(Tempgroup tempgroup)
    {
        return tempgroupMapper.updateTempgroup(tempgroup);
    }

    /**
     * 删除终端临时列表
     *
     * @return 终端临时列表
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int deleteTempgroup(int tgid)
    {
        return tempgroupMapper.deleteTempgroup(tgid);
    }

    /**
     * 插入终端临时列表
     *
     * @return 终端临时列表
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public int insertTempgroup(Tempgroup tempgroup)
    {
        return tempgroupMapper.insertTempgroup(tempgroup);
    }
}
