package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.ProSpec;

import java.util.List;

/**
 * Created by MI on 2019/3/27.
 */
public interface IProSpecService {

    public ProSpec selectProSpecById(String fid);

    public List<ProSpec> selectProSpecList(ProSpec proSpec);

    public List<ProSpec> selectAllProSpec();
}
