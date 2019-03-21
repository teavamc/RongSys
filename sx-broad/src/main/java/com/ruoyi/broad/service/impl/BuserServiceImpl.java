package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.Buser;
import com.ruoyi.broad.mapper.BuserMapper;
import com.ruoyi.broad.service.IBuserService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 根据用户对广播数目的统计
 *
 * @author 周博
 * @date 2019-03-21
 */

@Service
public class BuserServiceImpl implements IBuserService {
    @Autowired
    private BuserMapper buserMapper;

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Buser> selectProgramsByUser() {
        return buserMapper.selectProgramsByUser();
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Buser> selectProgramsByLenth() {
        return buserMapper.selectProgramsByLenth();
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Buser> selectProgramsIfPublic() {
        List<Buser> res = buserMapper.selectProgramsIfPublic();
        for (Buser buser : res) {
            switch (buser.getIsPublic()) {
                case "0":
                    buser.setIsPublic("非公共");
                    break;
                case "1":
                    buser.setIsPublic("公共");
                    break;
                case "2":
                    buser.setIsPublic("总数");
                    break;
            }
        }
        return res;
    }

    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<Buser> selectProgramsPtp() {
        return buserMapper.selectProgramsPtp();
    }
}
