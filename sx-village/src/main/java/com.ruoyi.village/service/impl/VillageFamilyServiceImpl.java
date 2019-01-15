package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.village.domain.VillageFamily;
import com.ruoyi.village.mapper.VillageFamilyMapper;
import com.ruoyi.village.service.IVillageFamilyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 小村家事 服务层实现
 * @author: Mr.Liu
 * @create: 2019-01-15 15:01
 **/
public class VillageFamilyServiceImpl implements IVillageFamilyService {
    @Autowired
    private VillageFamilyMapper mapper;

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<VillageFamily> selectVillageFamilyList(VillageFamily villageFamily) {
        return mapper.selectVillageFamilyList(villageFamily);
    }
}
