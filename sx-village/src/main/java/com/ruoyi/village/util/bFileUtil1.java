package com.ruoyi.village.util;

import com.ruoyi.village.domain.Files;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bFileUtil1 {
    private static Logger logger = LoggerFactory.getLogger(bFileUtil1.class);
    /**
     * 图片存储 完整路径（{user.home}/img/coldStone/XXX.jpg）
     * @param file
     * @return 返回相对路径
     */
    public static String saveImg(MultipartFile file,String saveName) {
        //获取文件上传的根目录 C:\Users\fama/upload/img
        String  path = bConstant1.UPLOAD_PATH + bConstant1.IMG_FILE_NAME; //改为bConstant.UPLOAD_PATH
        logger.info(" --- bConstant1.UPLOAD_PATH：{} --- ",bConstant1.UPLOAD_PATH);
        logger.info(" --- bConstant1.IMG_FILE_NAME：{} --- ",bConstant1.IMG_FILE_NAME);
        //拿到文件的后缀名和UUID进行拼接形成新的文件名
        //4ca64e85b1544c96b4a6154bb521476f.jpg
        //String saveName = bCommonUtil.getUuid() + "." + getFileSuffix(file.getOriginalFilename());
        logger.info(" --- 文件保存路径：{}, 文件保存名称：{},文件原名称：{} --- ", path, saveName,file.getOriginalFilename());
        // 保存
        try {
            // 保存文件
            File targetFile = new File(path);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            //file.transferTo(new File(path + "/" + saveName));
            file.transferTo(new File(bPathUtil1.getClasspath() + bConst1.FILEPATHPER2 +saveName));
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("--- 文件保存异常：{} ---" + e.getMessage());
            return null;
        }
        //String filePath =  bConstant1.UPLOAD_PATH;
        //返回相对路径  img/virtual/4ca64e85b1544c96b4a6154bb521476f.jpg
        return saveName; //filePath + "/" + saveName
    }
    /**
     * 返回截取的文件后缀
     * @param path
     * @return
     */
    public static String getFileSuffix(String path) {
        return getFileSuffix(path, "2");
    }

    /**
     * 获取文件名称或后缀(最后一个"."之后内容)
     * @param path
     * @param type 1名称 2后缀
     * @return
     */
    public static String getFileSuffix(String path, String type){
        if(StringUtils.isNotEmpty(path) && path.indexOf(".") > 0) {
            // 名称
            String name = path.substring(0, path.lastIndexOf("."));

            // 后缀
            String suffix = path.substring(path.lastIndexOf(".") + 1);

            return StringUtils.equals("1", type) ? name : suffix;
        } else {
            return null;
        }
    }

    /**
     * 文件上传封装
     * @param maxfileid
     * @param file
     * @param fname
     * @param flenth
     * @param fsize
     * @param year
     * @return Program
     */
    public static com.ruoyi.village.domain.Files uplodeFile(String maxfileid, MultipartFile file, String fname, String flenth, String fsize, String year){
        Files g = new Files();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        int j=0; //上传多个的时候用的
        String filename ="";
        String failfile="";//添加失败的节目
        if(file!=null ){
           /* filename = maxfileid+j+"";*/
            filename = maxfileid+"";
            while(filename.length()<5){
                filename = "0"+filename;
            }
            filename = year.substring(2)+filename;
            if (null != file && !file.isEmpty()) {
                filename =filename+"."+bFileUtil1.getFileSuffix(file.getOriginalFilename()); //filename字段
                if(flenth!="NaN"&&!flenth.equals("")){
                    g.setFlenth(flenth);
                }else{
                    failfile = fname+"获取时长信息出错，";
                }
                //path是返回文件的名字（纯名字）
                String path =  bFileUtil1.saveImg(file,maxfileid+file.getOriginalFilename());
                g.setFilename(filename);
                g.setAddress(bPathUtil1.getClasspath() + bConst1.FILEPATHPER2 + maxfileid+file.getOriginalFilename());
                g.setUrls(bConst1.FILEPATHPER2 + maxfileid+file.getOriginalFilename());
                g.setCreatedtime(df.format(new Date()));
                g.setIspublic(false);
                g.setIslisten(true);
                if(fsize!=null&&!fsize.equals("")){
                    BigDecimal b   =   new   BigDecimal(fsize);
                    g.setFsize(b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue() );//四舍五入 两位小数
                }
                j++;
            }

        }
        return g;
    }
}
