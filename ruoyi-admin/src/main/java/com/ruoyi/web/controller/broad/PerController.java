package com.ruoyi.web.controller.broad;

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
import org.springframework.stereotype.Controller;
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
    public AjaxResult addSave(@RequestParam(value = "files") MultipartFile file,
                              @RequestParam(value = "filename", required = false) String fname,
                              @RequestParam(value = "flenth" ,required = false)String flenth, //时长
                              @RequestParam(value = "fsize",required = false) String fsize){//大小

        Program g = new Program();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String year = DateUtil.getYear();
        String maxfileid = iProgramService.getMaxFileidofYear(year); //获取当年文件最大编号
        int fileid = 0;
        if(maxfileid!=null&& Integer.parseInt(maxfileid)>10){
            fileid = Integer.parseInt(maxfileid)+1;
        }else{
            fileid = 1;
        }
        int j=0;
        String filename ="";
        String failfile="";//添加失败的节目
        if(file!=null ){
            filename = fileid+j+"";
            while(filename.length()<5){
                filename = "0"+filename;
            }
            filename = year.substring(2)+filename;
            if (null != file && !file.isEmpty()) {

                filename =filename+"."+bFileUtil.getFileSuffix(file.getOriginalFilename()); //filename字段
                if(flenth!="NaN"&&!flenth.equals("")){
//                    Double lenth = Double.parseDouble(flenth)*1000;
//                    String l = DateUtil.formatLongToTimeStr(lenth.longValue());
//                    g.setFlenth(l);
                        System.out.println("flenth:--"+flenth);
                    g.setFlenth(flenth);
                }else{
                    failfile = fname+"获取时长信息出错，";
                }

                        System.out.println("fname:--"+fname);
                    g.setFname(fname); //fname.substring(0, fname.lastIndexOf("."))
                    //String filePath = bPathUtil.getClasspath() + bConst.FILEPATHPER;			//文件上传路径
                    String path =  bFileUtil.saveImg(file,filename);
                        System.out.println("filename:--"+filename);
                    g.setFilename(filename);
                        System.out.println("Userid:--"+bJurisdiction.getUserid());
                    g.setUserid(bJurisdiction.getUserid());
                        System.out.println("Address:--"+bPathUtil.getClasspath() + bConst.FILEPATHPER+path);
                    g.setAddress(bPathUtil.getClasspath() + bConst.FILEPATHPER+path);
                        System.out.println("Urls:--"+bConst.FILEPATHPER+path);
                    g.setUrls(bConst.FILEPATHPER+path);
                        System.out.println("Createdtime(:--"+df.format(new Date()));
                    g.setCreatedtime(df.format(new Date()));
                    g.setIspublic(false);
                    g.setIslisten(true);
                    if(fsize!=null&&!fsize.equals("")){
                        BigDecimal b   =   new   BigDecimal(fsize);
                        g.setFsize(b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue() );//四舍五入 两位小数
                    }
                    try {
                        //perService.addPer(g);
                        j++;
                    } catch (Exception e) {
                        failfile = fname;
                    }
                }

        }
        //图片上传调用工具类
        try{
            //保存图片
            //String path =  bFileUtil.saveImg(file,filename);

            System.out.println(g.toString());
            //return path;
            return toAjax(1);
        }catch (Exception e){
            //return "上传图片失败";
            System.out.println("失败");
            return toAjax(0);
        }

    }

}
