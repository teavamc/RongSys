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

    /**
     * 获取小村家事数据
     * @param villageFamily
     * @return
     */
    List<VillageFamily> selectVillageFamilyList(VillageFamily villageFamily);

    /**
     * 根据 id 批量删除
     * @param id
     * @return
     */
    int deleteVillageFamilyByids(String[] id);
}
