package com.ruoyi.web.controller.broad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ruoyi.broad.domain.Program;
import com.ruoyi.broad.service.IProgramService;
import com.ruoyi.broad.utils.bConst;
import com.ruoyi.broad.utils.bJurisdiction;
import com.ruoyi.broad.utils.bPathUtil;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.DateUtil;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.web.base.BaseController;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.broad.utils.bFileUtil;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @author 张超 teavamc
 * @Description: 节目库管理
 * @ClassName PerController
 * @date 2019/2/17 20:37
 **/
@Controller
@RequestMapping(value="/broad/per")
public class PerController extends BaseController{
    private String prefix = "broad/program/per";

    @Autowired
    private IProgramService iProgramService;

    @RequiresPermissions("broad:per:view")
    @GetMapping()
    public String per()
    {
        return prefix + "/per";
    }

    /**
     * 查询节目库列表
     */
    @RequiresPermissions("broad:per:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Program program)
    {
        startPage() ;
        List<Program> list = iProgramService.selectProList(program);
        return getDataTable(list);
    }

    /**
     * 返回新增页面
     * @return
     */
    @GetMapping("/add")
    public String addper()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存节目单
     */
    //@RequiresPermissions("broad:per:add")
    @Log(title = "新增节目单", businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam(value = "files") MultipartFile file,
                              @RequestParam(value = "filename", required = false) String fname,
                              @RequestParam(value = "flenth" ,required = false)String flenth, //时长
                              @RequestParam(value = "fsize",required = false) String fsize){//大小

        String year = DateUtil.getYear();
        String maxfileid = iProgramService.getMaxFileidofYear(year); //获取当年文件最大编号
        //图片上传调用工具类
        try{
            //保存图片
            //String path =  bFileUtil.saveImg(file,filename);
            Program g = bFileUtil.uplodeFile(maxfileid,file,fname,flenth,fsize,year);
            System.out.println(g.toString());
//            try{
//                System.out.println("用户id:>>>"+bJurisdiction.getUserid());
//            }catch (Exception e){
//                e.printStackTrace();
//                System.out.println("此处错误");
//            }
            //return path;
            return toAjax(1);
        }catch (Exception e){
            //return "上传图片失败";
            System.out.println("失败");
            return toAjax(0);
        }

    }
}
