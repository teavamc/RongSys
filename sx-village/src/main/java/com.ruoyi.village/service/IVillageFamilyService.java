package com.ruoyi.village.service;

import com.ruoyi.village.domain.VillageFamily;

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 小村家事 服务层
 * @author: Mr.Liu
 * @create: 2019-01-15 15:00
 **/

public interface IVillageFamilyService {

    /**
     * 获取小村家事数据
     * @param villageFamily
     * @return
     */
    List<VillageFamily> selectVillageFamilyList(VillageFamily villageFamily);

    /**
     * 根据id 批量删除
     * @param id
     * @return
     */
    int deleteVillageFamilyByids(String id);
}
