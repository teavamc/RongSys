package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.ProSpec;
import com.ruoyi.broad.mapper.ProSpecMapper;
import com.ruoyi.broad.service.IProSpecService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 特种节目管理
 *
 * @author 周博
 * @date 2019-03-27
 */
@Service
public class ProSpecServiceImpl implements IProSpecService {
    @Autowired
    private ProSpecMapper proSpecMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public ProSpec selectProSpecById(String fid) {
        return proSpecMapper.selectProSpecById(fid);
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<ProSpec> selectProSpecList(ProSpec proSpec) {
        return proSpecMapper.selectProSpecList(proSpec);
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<ProSpec> selectAllProSpec() {
        return proSpecMapper.selectAllProSpec();
    }
}
