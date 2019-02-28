package com.ruoyi.web.controller.broad;

import com.ruoyi.broad.domain.Program;
import com.ruoyi.broad.service.IProgramService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.page.TableDataInfo;
import com.ruoyi.common.base.AjaxResult;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.web.base.BaseController;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.broad.utils.bFileUtil;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

/**
 * @author 刘衍斌
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
    @Log(title = "节目单新增", businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam(value = "files", required = false) MultipartFile files,
                              @RequestParam(value = "filename", required = false) String filename,
                              @RequestParam(value = "type", required = false) String type)
    {

        System.out.println(filename+">>>"+type+">>>"+files);
        //图片上传调用工具类
        try{
            //保存图片
            String path =  bFileUtil.saveImg(files);
            System.out.println("成功"+path);
            //return path;
            return toAjax(1);
        }catch (Exception e){
            //return "上传图片失败";
            System.out.println("失败");
            return toAjax(0);
        }

    }

}
