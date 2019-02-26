package com.ruoyi.broad.mapper;

import com.github.pagehelper.Page;
import com.ruoyi.broad.domain.Program;
import com.ruoyi.broad.utils.bPageData;

import java.util.List;

/**
 * @author 张超 teavamc
 * @Description:TODO
 * @ClassName PerMapper
 * @date 2019/2/25 18:36
 **/
public interface PerMapper {
    /**
     * 查询节目列表(分页)
     * @param page
     * @return
     * @throws Exception
     */
    public List<bPageData> getPerByUser(Page page) throws Exception;
    /**
     * 查询公共节目列表(分页)
     * @param page
     * @return
     * @throws Exception
     */
    public List<bPageData> getPublicPerByUser(Page page) throws Exception;
    /**
     * 节目单导出
     * @param pd
     * @return
     * @throws Exception
     */
    public List<bPageData> getPerByFidlist(bPageData pd) throws Exception;
    /**
     * 根据编号获取编号信息
     * @param paid
     * @return
     * @throws Exception
     */
    public bPageData getPerByFid(String fid) throws Exception;


    /**
     * 添加节目
     * @param pa
     * @throws Exception
     */
    public void addPer(Program g) throws Exception;
    /**
     * 修改节目
     * @param pa
     * @throws Exception
     */
    public void editPerByFid(Program g) throws Exception;
    /**
     * 修改节目文件名
     * @param g
     * @throws Exception
     */
    public void updateFilename(Program g) throws Exception;
    /**
     * 删除节目
     * @param fid
     * @throws Exception
     */
    public void deleteP(String fid) throws Exception;
    /**
     * 设置节目公共属性
     * @param PageData pd
     * @throws Exception
     */
    public void setpublic(bPageData pd) throws Exception;
    /**
     * 修改节目审听通过状态
     * @param pd
     * @throws Exception
     */
    public void setIsListen(bPageData pd) throws Exception;
    /**
     * 得到当年文件最大编号
     * @param year
     * @return
     */
    public String getMaxFileidofYear(String year) throws Exception;
    /**
     * 修改节目为特种节目，修改节目时长，节目文件编号
     * @param pd
     * @throws Exception
     */
    public void setSpePer(bPageData pd) throws Exception;
}
