package com.ruoyi.village.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.support.Convert;
import com.ruoyi.village.domain.Policyinfo;
import com.ruoyi.village.mapper.PolicyinfoMapper;
import com.ruoyi.village.service.IPolicyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dyq_RongSys
 * @description: 村务公告
 * @author: Mr.Dai
 * @create: 2019-01-14 15:40
 **/
@Service
public class PolicyinfoServiceImpl implements IPolicyinfoService {
        @Autowired
        private PolicyinfoMapper policyinfomapper;

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public List<Policyinfo> selectPolicyinfoList(Policyinfo policyinfo) {
            return policyinfomapper.selectPolicyinfoList(policyinfo);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int deletePolicyinfoByids(String id) {
            return policyinfomapper.deletePolicyinfoByids(Convert.toStrArray(id));
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int insertpolicyinfo(Policyinfo policyinfo) {
            return policyinfomapper.insertpolicyinfo(policyinfo);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public Policyinfo selectBypoinid(Integer shiid) {
            return policyinfomapper.selectBypoinid(shiid);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int deletePolicyinfoByIds(String shiid) {
            return policyinfomapper.deletePolicyinfoByIds(shiid);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public int updatePolicyinfo(Policyinfo politics) {
            return policyinfomapper.updatePolicyinfo(politics);
        }

        @Override
        @DataSource(value = DataSourceType.SXVILLAGE)
        public List<Policyinfo> selectpoliclimitten(){
            return policyinfomapper.selectpoliclimitten();
        }
    }
