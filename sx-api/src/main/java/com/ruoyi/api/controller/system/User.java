package com.ruoyi.api.controller.system;



import com.ruoyi.api.domain.RongApiRes;
import com.ruoyi.api.service.RongApiService;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.village.domain.Policyinfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
@Api(value = "用户信息")
public class User {
    @Autowired
    private ISysUserService sysUserService;

    @PostMapping("/resetPwd")
    @CrossOrigin
    @ApiOperation(value = "修改用户密码信息")
    public RongApiRes resetUserPwd(SysUser user)
    {
        return RongApiService.get_bean(sysUserService.resetUserPwd(user));
    }

    @PostMapping("/upUser")
    @CrossOrigin
    @ApiOperation(value = "修改用户详细信息")
    public RongApiRes updateUser(SysUser user)
    {
        return RongApiService.get_bean(sysUserService.updateUser(user));
    }

    @GetMapping("/selectById")
    @CrossOrigin
    @ApiOperation(value = "通过用户ID查询用户")
    public RongApiRes selectUserById(Long userId)
    {
        return RongApiService.get_bean(sysUserService.selectUserById(userId));
    }
    @GetMapping("/selectByName")
    @CrossOrigin
    @ApiOperation(value = "通过用户名查询用户")
    public RongApiRes selectUserByLoginName(String userName)
    {
        return RongApiService.get_bean(sysUserService.selectUserByLoginName(userName));
    }
}
