package com.ruoyi.broad.mapper;

import com.ruoyi.broad.domain.Program;

import java.util.List;

/**
 * @program: RongSys-lyb
 * @description: 节目上传 数据层
 * @author: Mr.Liu
 * @create: 2019-02-26 19:34
 **/

public interface ProgramMapper {

    /**
     * 查询节目库数据
     * @param program 节目实体类
     * @return 结果
     */
    public List<Program> selectProList(Program program);
}
