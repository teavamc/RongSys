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
     * @param  villageFamily 小村家事
     * @return  小村家事集合
     */
    public List<VillageFamily> selectVillageFamilyList(VillageFamily villageFamily);


    /**
     * 新增小村家事 数据
     * @param villageFamily 新增的小村家事
     * @return 结果
     */
    public int insertVillageFamily(VillageFamily villageFamily);
    /**
     * 修改小村家事数据
     * @param jsid 小村家事id号
     * @return 小村家事数据
     */
    public VillageFamily selectByfbid(Integer jsid);
    /**
     * 保存小村家事修改
     * @param villageFamily 小村家事
     * @return 结果
     */
    public int updateVillageFamily(VillageFamily villageFamily);
    /**
     * 根据 jsid 删除
     * @param jsid 小村家事id号
     * @return 结果
     */
    public int deleteVillageFamilyByids(String jsid);

}
