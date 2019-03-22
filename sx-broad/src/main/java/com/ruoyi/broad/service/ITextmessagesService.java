package com.ruoyi.broad.service;

import com.ruoyi.broad.domain.typenum;

import java.util.List;

public interface ITextmessagesService {
    /**
     * 获取所有类型及数量
     * @return
     */
    public List<typenum> selectTypeNum();
}
