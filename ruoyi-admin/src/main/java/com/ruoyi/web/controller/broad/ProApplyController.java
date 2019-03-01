package com.ruoyi.web.controller.broad;

import com.github.pagehelper.Page;
import com.ruoyi.broad.domain.Program;
import com.ruoyi.common.utils.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 张超 teavamc
 * @Description: 节目申请
 * @ClassName ProApplyController
 * @date 2019/2/17 20:37
 **/
@Controller
@RequestMapping(value="/broad/proapply")
public class ProApplyController {
    private String prefix = "broad/proapply";


    //*********节目录制管理--节目申请***********
    /**
     * 节目申请列表
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/listProApply")
    public ModelAndView listProApply(Page page)throws Exception{
        if(!Jurisdiction.hasJurisdiction("proapply/listProApply.do")){return null;} //权限校验
        PageData pd = new PageData();
        pd = this.getPageData();
        ModelAndView mv = this.getModelAndView();
        String userid ="";
        String role = Jurisdiction.getUserRid();
        if(!role.equals("1")&&!Jurisdiction.getRecProApplyRight()){//不是超级管理员且没有接收节目申请权限，则只能查看自己的申请
            userid= Jurisdiction.getUserid();
        }
        pd.put("userid", userid);
        pd.put("role", role);
        String lastStart = pd.getString("lastStart");	//开始时间
        String lastEnd = pd.getString("lastEnd");		//结束时间
        if(lastStart != null && !"".equals(lastStart)){
            pd.put("lastStart", lastStart+" 00:00:00");
        }
        if(lastEnd != null && !"".equals(lastEnd)){
            pd.put("lastEnd", lastEnd+" 23:59:59");
        }
        page.setPd(pd);
        List<PageData> applylist = proApplyService.getProapplyByUser(page);
        mv.addObject("applylist",applylist);
        mv.addObject("curuserid",Jurisdiction.getUserid());
        mv.addObject("pd",pd);
        mv.addObject("editQX", Jurisdiction.getEditRight());
        mv.addObject("recProApplyRight", Jurisdiction.getRecProApplyRight());
        mv.setViewName("program_recording/proapply_list");
        return mv;
    }
    /**
     * 显示申请详情
     * @param
     * @return
     */
    @RequestMapping(value="/showApply")
    public ModelAndView showApply()throws Exception{
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        try{
            PageData pa = proApplyService.getProapplyByPaid(pd.getString("paid"));	//读取此ID的申请信息
            mv.addObject("pd", pd);
            mv.addObject("pa", pa);
            //设置申请已阅读
            pd.put("isread", 1);
            proApplyService.editApplyRead(pd);
            mv.setViewName("program_recording/proapply_show");
        } catch(Exception e){
            logger.error(e.toString(), e);
        }
        return mv;
    }
    /**
     * 去回复申请页面
     * @param
     * @return
     */
    @RequestMapping(value="/toReply")
    public ModelAndView toReply(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        try {
            pd = proApplyService.getProapplyByPaid(pd.getString("paid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("pd", pd);
        mv.addObject("filelimit", Tools.readTxtFile(Const.PROFILELIMIT));
        mv.setViewName("program_recording/proapply_reply");
        return mv;
    }
    /**
     * 回复申请
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/reply")
    public ModelAndView reply(Proapply pa, @RequestParam(value="file",required=false) MultipartFile file, String flenth, String fsize) throws Exception{
        ModelAndView mv = new ModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        PageData applypro = proApplyService.getProapplyByPaid(pa.getPaid());
        String replyprogramid = applypro.get("replyprogramid")!=null && applypro.get("replyprogramid")!=""?applypro.get("replyprogramid").toString():null ;
        if(replyprogramid!=null &&replyprogramid!=""){//修改节目
            String filePath = PathUtil.getClasspath();
            //复制节目文件到节目路径，并修改名称
            String newurls = applypro.getString("urls");
            FileUtil.delFile(filePath+newurls);
            if (null != file && !file.isEmpty()) {
                FileUpload.fileUp(file, filePath+newurls.substring(0, newurls.lastIndexOf("/")+1),newurls.substring(newurls.lastIndexOf("/")+1,newurls.lastIndexOf(".")));	//执行上传
                Program pro = new Program();
                pro.setFid(replyprogramid);
                String l = null;
                if(flenth!=null){
                    Double lenth = Double.parseDouble(flenth)*1000;
                    l = DateUtil.formatLongToTimeStr(lenth.longValue());
                }
                pro.setFlenth(l);
                if(fsize!=null&&fsize!=""){
                    BigDecimal b   =   new   BigDecimal(fsize);
                    pro.setFsize(b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue() );//四舍五入 两位小数
                }
                pro.setPtype(true);
                perService.editPerByFid(pro);
            }
            pa.setReplyprogramid(replyprogramid);
        }else{//添加节目
            String year = DateUtil.getYear();
            String fileid = perService.getMaxFileidofYear(year);//得到当年文件最大编号
            if(fileid!=null){
                fileid = (Integer.parseInt(fileid)+1)+"";
            }else{
                fileid = "1";
            }
            while(fileid.length()<5){
                fileid = "0"+fileid;
            }
            fileid = year.substring(2)+fileid;
            String  saveName = "";
            if (null != file && !file.isEmpty()) {
                String filePath = PathUtil.getClasspath() + Const.FILEPATHPER;			//文件上传路径
                saveName =  FileUpload.fileUp(file, filePath,fileid);	//执行上传
            }
            //添加节目
            Program pro = new Program();
            pro.setFname(pa.getPname());
            pro.setUserid(pa.getUserid());
            pro.setAddress(PathUtil.getClasspath() + Const.FILEPATHPER+saveName);
            pro.setUrls(Const.FILEPATHPER+saveName);
            pro.setCreatedtime(df.format(new Date()));
            pro.setIspublic(false);
            pro.setIslisten(false);
            pro.setFilename(saveName);
            pro.setPtype(true);
            String l = null;
            if(flenth!=null){
                Double lenth = Double.parseDouble(flenth)*1000;
                l = DateUtil.formatLongToTimeStr(lenth.longValue());
            }
            pro.setFlenth(l);
            if(fsize!=null&&fsize!=""){
                BigDecimal   b   =   new   BigDecimal(fsize);
                pro.setFsize(b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue() );//四舍五入 两位小数
            }
            try {
                perService.addPer(pro);
                logService.saveLog(Const.LOGTYPE[1], FUNCTION, "添加", this.getRemortIP(), pro.getFid());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            String programid = pro.getFid();
            pa.setReplyprogramid(programid);
        }
        //修改申请回复
        pa.setReplytime(df.format(new Date()));
        pa.setIslisten(false);
        try {
            proApplyService.replyApplyByPaid(pa);
            logService.saveLog(Const.LOGTYPE[1], FUNCTION, "回复", this.getRemortIP(), pa.getPname());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mv.addObject("pd", pd);
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * 去添加申请页面
     * @param
     * @return
     */
    @RequestMapping(value="/toAddApply")
    public ModelAndView toAddApply(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        mv.addObject("pd", pd);
        mv.addObject("MSG", "addApply");
        mv.setViewName("program_recording/proapply_edit");
        return mv;
    }
    /**
     * 添加申请
     * @param
     * @return
     */
    @RequestMapping(value="/addApply")
    public ModelAndView addApply(Proapply pa,@RequestParam(value="file",required=false) MultipartFile file){
        ModelAndView mv = new ModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        SimpleDateFormat dffile = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String fileName =file.getOriginalFilename();
        String  saveName = "";
        if (null != file && !file.isEmpty()) {
            String filePath = PathUtil.getClasspath() + Const.FILEPATHAPPLY;			//文件上传路径
            String fname = fileName.substring(0, fileName.lastIndexOf("."))+dffile.format(new Date());
            saveName =  FileUpload.fileUp(file, filePath,fname);	//执行上传
        }
        pa.setUserid(Jurisdiction.getUserid());
        pa.setFilename(saveName);
        pa.setFileurl(Const.FILEPATHAPPLY+saveName);
        pa.setSubmittime(df.format(new Date()));
        pa.setIslisten(false);
        try {
            proApplyService.addProApply(pa);
            logService.saveLog(Const.LOGTYPE[1], FUNCTION, "添加", this.getRemortIP(), pa.getPname());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mv.addObject("pd", pd);
        if(pa.getIsemergency()){
            String name = Tools.GetValueByKey(Const.CONFIG, "proapply.name");
            String phone = Tools.GetValueByKey(Const.CONFIG, "proapply.phone");
            String content = Tools.GetValueByKey(Const.CONFIG, "proapply.smscontent");
            List<PageData> pdlist = new ArrayList<PageData>();
            PageData tmpd = new PageData();
            tmpd.put("sendtime", DateUtil.getTime());
            tmpd.put("scontent", content);
            tmpd.put("remark", "紧急节目申请通知");
            tmpd.put("issend", 0);
            tmpd.put("tid",name);
            tmpd.put("smobile", phone);
            pdlist.add(tmpd);
            //添加发送短信表
            try {
                messageService.addSendMessage(pdlist);
                mv.addObject("msg","您的节目申请信息已添加到系统并通过短信通知了节目制作人员，联系电话："+phone+"，联系人："+name+"。");
            } catch (Exception e) {
                logger.error("紧急节目申请短信发送失败", e);
                mv.addObject("msg","您的节目申请信息已添加到系统，节目制作联系人："+name+"，联系电话："+phone+"，短信通知失败！");
                e.printStackTrace();
            }
            mv.addObject("showKnowBtn", true);
            //发短信
        }else{
            mv.addObject("msg","success");
        }
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * 去修改申请页面
     * @param
     * @return
     */
    @RequestMapping(value="/toEditApply")
    public ModelAndView toEditApply(){
        ModelAndView mv = this.getModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        PageData pa = null;
        try {
            pa = proApplyService.getProapplyByPaid(pd.getString("paid"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mv.addObject("pa", pa);
        mv.addObject("pd", pd);
        mv.addObject("MSG", "editApply");
        mv.setViewName("program_recording/proapply_edit");
        return mv;
    }
    /**
     * 修改申请（需要上传文件）
     * @param
     * @return
     */
    @RequestMapping(value="/editApplyWithFile")
    public ModelAndView editApplyWithFile(Proapply pa,@RequestParam(value="file",required=false) MultipartFile file){
        ModelAndView mv = new ModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        SimpleDateFormat dffile = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        String fileName =file.getOriginalFilename();
        String  saveName = "";
        if (null != file && !file.isEmpty()) {
            String filePath = PathUtil.getClasspath() + Const.FILEPATHAPPLY;			//文件上传路径
            String fname = fileName.substring(0, fileName.lastIndexOf("."))+dffile.format(new Date());
            saveName =  FileUpload.fileUp(file, filePath,fname);	//执行上传
            pa.setFilename(saveName);
            pa.setFileurl(Const.FILEPATHAPPLY+saveName);
        }
        try {
            proApplyService.editProApplyByPaid(pa);
            logService.saveLog(Const.LOGTYPE[1], FUNCTION, "修改", this.getRemortIP(), pa.getPname());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("pd", pd);
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * 修改申请
     * @param
     * @return
     */
    @RequestMapping(value="/editApply")
    public ModelAndView editApply(Proapply pa){
        ModelAndView mv = new ModelAndView();
        PageData pd = new PageData();
        pd = this.getPageData();
        try {
            proApplyService.editProApplyByPaid(pa);
            logService.saveLog(Const.LOGTYPE[1], FUNCTION, "修改", this.getRemortIP(), pa.getPname());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mv.addObject("pd", pd);
        mv.addObject("msg","success");
        mv.setViewName("save_result");
        return mv;
    }
    /**
     * 节目申请撤回
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/cancelApply")
    @ResponseBody
    public Object cancelApply()throws Exception{
        Map<String,String> map = new HashMap<String,String>();
        PageData pd = new PageData();
        pd = this.getPageData();
        String errInfo = "";
        try{
            PageData pro = proApplyService.getProapplyByPaid(pd.get("paid").toString());
            if(!Boolean.parseBoolean(pro.get("isread").toString()) &&!Boolean.parseBoolean(pro.get("isreply").toString()) &&!Boolean.parseBoolean(pro.get("islisten").toString())){
                proApplyService.cancelApplyByPaid(pd.get("paid").toString());
                errInfo = "success";
                logService.saveLog(Const.LOGTYPE[1], FUNCTION, "撤回", this.getRemortIP(), pd.get("pname").toString());
            }else{
                errInfo = "error";
            }
        } catch(Exception e){
            logger.error(e.toString(), e);
        }
        map.put("result", errInfo);
        return AppUtil.returnObject(new PageData(), map);
    }
    /**下载文件
     * @param response
     * @throws Exception
     */
    @RequestMapping(value="/downFile")
    public void downFile(HttpServletResponse response){
        PageData pd = new PageData();
        pd = this.getPageData();
        String result="";
        try {
            result = FileDownload.fileDownload(response, PathUtil.getClasspath() + pd.getString("fileurl"), pd.getString("filename"));
        } catch (Exception e) {
            e.printStackTrace();
            result = "error";
        }
        if(result.equals("success")&&pd.get("isread").toString().equals("false")){
            if(pd.getString("paid")!=null ||!pd.getString("paid").equals("")){
                //修改节目申请的阅读情况
                PageData editpd = new PageData();
                editpd.put("isread", 1);
                editpd.put("paid", pd.getString("paid"));
                try {
                    proApplyService.editApplyRead(editpd);
//					logService.saveLog(Const.LOGTYPE[1], "节目申请", "阅读", this.getRemortIP(), "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
