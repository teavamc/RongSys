package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.village.domain.VillageFamily;
import com.ruoyi.village.mapper.VillageFamilyMapper;
import com.ruoyi.village.service.IVillageFamilyService;
import com.ruoyi.village.util.FilterText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: lyb_RongSys
 * @description: 小村家事 服务层实现
 * @author: Mr.Liu
 * @create: 2019-01-15 15:01
 **/
@Service
public class VillageFamilyServiceImpl implements IVillageFamilyService {

    @Autowired
    private VillageFamilyMapper mapper;

    /**
     * 获取小村家事数据
     * @param  villageFamily 小村家事
     * @return  小村家事集合
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<VillageFamily> selectVillageFamilyList(VillageFamily villageFamily) {
        List<VillageFamily> list = mapper.selectVillageFamilyList(villageFamily);
        for(VillageFamily village : list){
            if(village.getContent().length() > 0)
                village.setContent(FilterText.delHTMLTag(village.getContent())); //过滤html标签
        }
        return list;
    }

    /**
     * 新增小村家事 数据
     * @param villageFamily 新增的小村家事
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int insertVillageFamily(VillageFamily villageFamily) {
        return mapper.insertVillageFamily(villageFamily);
    }

    /**
     * 修改小村家事数据
     * @param jsid 小村家事id号
     * @return 小村家事数据
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public VillageFamily selectByfbid(Integer jsid) {
        return mapper.selectByfbid(jsid);
    }

    /**
     * 保存小村家事修改
     * @param villageFamily 小村家事
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int updateVillageFamily(VillageFamily villageFamily) {
        return mapper.updateVillageFamily(villageFamily);
    }

    /**
     * 根据 jsid 删除
     * @param jsid 小村家事id号
     * @return 结果
     */
    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int deleteVillageFamilyByids(String jsid) {
        return mapper.deleteVillageFamilyByids(Convert.toStrArray(jsid));
    }

}
