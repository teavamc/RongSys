package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.village.domain.Politics;
import com.ruoyi.village.mapper.PoliticsMapper;
import com.ruoyi.village.service.IPoliticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dyq_RongSys
 * @description: 村务政策
 * @author: 戴誉琪
 * @create: 2019-01-14 15:40
 **/
@Service
public class PoliticsServiceImpl implements IPoliticsService {
        @Autowired
        private PoliticsMapper politicsMapper;

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public List<Politics> selectPoliticsList(Politics politics) {
            return politicsMapper.selectPoliticsList(politics);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int deletePoliticsByids(String id) {
            return politicsMapper.deletePoliticsByids(Convert.toStrArray(id));
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int insertpolitics(Politics politics) {
            return politicsMapper.insertpolitics(politics);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public Politics selectByshiid(Integer shiid) {
            return politicsMapper.selectByshiid(shiid);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int deletePoliticsByIds(String shiid) {
            return politicsMapper.deletePoliticsByIds(shiid);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int updatePolitics(Politics politics) {
            return politicsMapper.updatePolitics(politics);
        }
    }
