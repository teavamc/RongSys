package com.ruoyi.api.controller.village;


import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.village.service.IPartyworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pwork")
@CrossOrigin
public class Pwork {

    @Autowired
    private IPartyworkService partyworkService;

    @GetMapping("/five")
    @CrossOrigin
    public RongApiRes searchfive(){
        return RongApiService.get_list(partyworkService.selectPartyworkListlimit5());
    }

}
