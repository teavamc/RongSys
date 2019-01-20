package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.village.domain.Villagefamily;
import com.ruoyi.village.mapper.VillagefamilyMapper;
import com.ruoyi.village.service.IVillagefamilyService;
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
public class VillagefamilyServiceImpl implements IVillagefamilyService {
    @Autowired
    private VillagefamilyMapper villagefamilyMapper;

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public List<Villagefamily> selectvillagefamilylist(Villagefamily villagefamily) {
        List<Villagefamily> list = villagefamilyMapper.selectVillageFamilyList(villagefamily);
        for(Villagefamily village : list){
            if(village.getContent().length() > 0)
                village.setContent(FilterText.delHTMLTag(village.getContent())); //过滤html标签
        }
        return list;
    }

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int insertvillagefamily(Villagefamily villagefamily) {
        return villagefamilyMapper.insertVillageFamily(villagefamily);
    }

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public Villagefamily selectByfbid(Integer jsid) {
        return villagefamilyMapper.selectByfbid(jsid);
    }

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int updatevillagefamily(Villagefamily villagefamily) {
        return villagefamilyMapper.updateVillageFamily(villagefamily);
    }

    @Override
    @DataSource(value = DataSourceType.SXVILLAGE)
    public int deletevillagefamilybyids(String jsid) {
        return villagefamilyMapper.deleteVillageFamilyByids(Convert.toStrArray(jsid));
    }

}
