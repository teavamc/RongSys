package com.ruoyi.village.mapper;

import com.ruoyi.village.domain.VillageFamily;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 小村家事数据层
 * @author: Mr.Liu
 * @create: 2019-01-15 14:59
 **/

public interface VillageFamilyMapper {

    List<VillageFamily> selectVillageFamilyList(VillageFamily villageFamily);
}
