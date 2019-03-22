package com.ruoyi.broad.service.impl;

import com.ruoyi.broad.domain.TerminalCount;
import com.ruoyi.broad.mapper.TerminalCountMapper;
import com.ruoyi.broad.service.TerminalCountService;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2019/3/20.
 */
@Service
public class TerminalCountImpl implements TerminalCountService {
    @Autowired
    private TerminalCountMapper terminalCountMapper;
    /*统计终端维护量
    * */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<TerminalCount> getAllTerminal(){
        return terminalCountMapper.getAllTerminal();

    }
}
