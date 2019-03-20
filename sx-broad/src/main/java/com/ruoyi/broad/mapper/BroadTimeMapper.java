package com.ruoyi.broad.mapper;

import com.ruoyi.broad.domain.BroadTime;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 根据时间和地区对广播数目的统计
 * @author 周博
 * @date 2019-01-15
 */
@Mapper
public interface BroadTimeMapper {

    public List<BroadTime> selectList();

    public List<BroadTime> selectListByDate();

    public  List<BroadTime> selectListByScategory();
}
