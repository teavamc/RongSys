package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.village.domain.Huodong;
import com.ruoyi.village.mapper.HuodongMapper;
import com.ruoyi.village.service.IHuodongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dyq_RongSys
 * @description: 村务党员活动
 * @author: 戴誉琪
 * @create: 2019-01-14 15:40
 **/
@Service
public class HuodongServiceImpl implements IHuodongService {
        @Autowired
        private HuodongMapper huodongmapper;

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public List<Huodong> selectHuodongList(Huodong huodong) {
            return huodongmapper.selectHuodongList(huodong);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int deleteHuodongByids(String id) {
            return huodongmapper.deleteHuodongByids(Convert.toStrArray(id));
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int inserthuodong(Huodong huodong) {
            return huodongmapper.inserthuodong(huodong);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public Huodong selectByhdid(Integer hdid) {
            return huodongmapper.selectByhdid(hdid);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int deleteHuodongByIds(String hdid) {
            return huodongmapper.deleteHuodongByIds(hdid);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int updateHuodong(Huodong huodong) {
            return huodongmapper.updateHuodong(huodong);
        }
    }
