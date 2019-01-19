package com.ruoyi.web.controller.village;

import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.village.domain.SocialCircle;
import com.ruoyi.village.domain.SocialCircleComment;
import com.ruoyi.village.service.SocialCircleCommentService;
import com.ruoyi.village.service.SocialCircleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: lyb_RongSys
 * @description: 暮云圈 信息操作处理
 * @author: Mr.Liu
 * @create: 2019-01-17 13:00
 **/
@Controller
@RequestMapping("/village/SocialCircle")
public class SocialCircleController extends BaseController {

    private String prefix = "village/socialCircle";

    @Autowired
    private SocialCircleService socialCircleService;
    @Autowired
    private SocialCircleCommentService socialCircleCommentService;

    @RequiresPermissions("village:socialCircle:view")
    @RequestMapping()
    public String list(ModelMap mmap){
            int index = 4;
            List<SocialCircle> list = socialCircleService.selectSocialCircleList(index);
            for (int i =0 ;i<socialCircleService.selectSocialCircleList(index).size();i++){
                list.get(i).setChild(socialCircleCommentService.selectAllByPcid(list.get(i).getPcid()));
            }
            mmap.put("socialCircleOne",list);
            mmap.put("index",index);
            mmap.put("socialCircleTwo",socialCircleService.selectSocialCircleList(0));
        return prefix+"/socialCircle";
    }

    @RequestMapping("/addpc")
    public void Ajax_list(ModelMap mmap,int index){


    }

    //@RequiresPermissions("village:socialCircle:list")
    @PostMapping("/list")
    @ResponseBody
    public Map<String, Object> List(String pcid){
        Map<String,Object> map = new HashMap<String, Object>();
        String[] list = pcid.split(",");
        for(int i=0;i<list.length;i++){
            List<SocialCircleComment> scc = socialCircleCommentService.selectAllByPcid(Integer.valueOf(list[i]));
            map.put(list[i],scc);
        }


        return map;
    }
}
