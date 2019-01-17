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
 * @author: Mr.Dai
 * @create: 2019-01-14 15:40
 **/
@Service
public class PoliticsServiceImpl implements IPoliticsService {
        @Autowired
        private PoliticsMapper mapper;

        @DataSource(value = DataSourceType.SXVILLAGE)
        public List<Politics> selectPoliticsList(Politics politics) {
            return mapper.selectPoliticsList(politics);
        }

        @DataSource(value = DataSourceType.SXVILLAGE)
        public int deletePoliticsByids(String id) {
            return mapper.deletePoliticsByids(Convert.toStrArray(id));
        }

        @DataSource(value = DataSourceType.SXVILLAGE)
        public int insertpolitics(Politics politics) {
            return mapper.insertpolitics(politics);
        }

        @DataSource(value = DataSourceType.SXVILLAGE)
        public Politics selectByshiid(Integer shiid) {
            return mapper.selectByshiid(shiid);
        }

        @DataSource(value = DataSourceType.SXVILLAGE)
        public int deletePoliticsByIds(String shiid) {
            return mapper.deletePoliticsByIds(shiid);
        }

        @DataSource(value = DataSourceType.SXVILLAGE)
        public int updatePolitics(Politics politics) {
            return mapper.updatePolitics(politics);
        }
    }
