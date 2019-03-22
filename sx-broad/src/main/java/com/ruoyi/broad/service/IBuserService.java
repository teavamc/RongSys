package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.Buser;

import java.util.List;

/**
 * 根据用户对广播数目的统计
 * @author 周博
 * @date 2019-03-21
 */

public interface IBuserService {

    public List<Buser> selectProgramsByUser();

    public List<Buser> selectProgramsByLenth();

    public List<Buser> selectProgramsIfPublic();

    public List<Buser> selectProgramsPtp();
}
