package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.BroadCount;
import com.ruoyi.broad.mapper.BcountMapper;
import com.ruoyi.broad.service.IBcountService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公共节目单
 *
 * @author 周博
 * @date 2019-03-22
 */
@Service
public class BcountServiceImpl implements IBcountService {
    @Autowired
    private BcountMapper bcountMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<BroadCount> select() {
        return bcountMapper.select();
    }
}
