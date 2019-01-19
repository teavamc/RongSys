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
     * @return
     */
    public List<VillageFamily> selectvillagefamilylist(VillageFamily villagefamily);


    /**
     * 新增小村家事 数据
     * @param villagefamily
     * @return
     */
    public int insertvillagefamily(VillageFamily villagefamily);
    /**
     * 修改小村家事数据
     * @param jsid
     * @return
     */
    public VillageFamily selectByfbid(Integer jsid);
    /**
     * 保存小村家事修改
     * @param villagefamily
     * @return
     */
    public int updatevillagefamily(VillageFamily villagefamily);
    /**
     * 根据 jsid 删除
     * @param jsid
     * @return
     */
    public int deletevillagefamilybyids(String jsid);

}
