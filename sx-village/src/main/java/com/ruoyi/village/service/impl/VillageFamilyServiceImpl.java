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

import java.util.List;

/**
 * @program: lyb_RongSys
 * @description: 小村家事 服务层实现
 * @author: Mr.Liu
 * @create: 2019-01-15 15:01
 **/
@Service
public class VillageFamilyServiceImpl implements IVillageFamilyService {
    @Autowired
    private VillageFamilyMapper villageFamilyMapper;

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<VillageFamily> selectvillagefamilylist(VillageFamily villagefamily) {
        List<VillageFamily> list = villageFamilyMapper.selectVillageFamilyList(villagefamily);
        for(VillageFamily village : list){
            if(village.getContent().length() > 0)
                village.setContent(FilterText.delHTMLTag(village.getContent())); //过滤html标签
        }
        return list;
    }

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int insertvillagefamily(VillageFamily villagefamily) {
        return villageFamilyMapper.insertVillageFamily(villagefamily);
    }

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public VillageFamily selectByfbid(Integer jsid) {
        return villageFamilyMapper.selectByfbid(jsid);
    }

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int updatevillagefamily(VillageFamily villagefamily) {
        return villageFamilyMapper.updateVillageFamily(villagefamily);
    }

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int deletevillagefamilybyids(String jsid) {
        return villageFamilyMapper.deleteVillageFamilyByids(Convert.toStrArray(jsid));
    }

}
