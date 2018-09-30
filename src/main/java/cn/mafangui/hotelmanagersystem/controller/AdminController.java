package cn.mafangui.hotelmanagersystem.controller;


import cn.mafangui.hotelmanagersystem.entity.Admin;
import cn.mafangui.hotelmanagersystem.service.AdminService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;



    @PostMapping(value = "/register")
    public Map adminRegister(String adminName, String adminPassword){
        Map response = new HashMap();
        int resultCode = -2;
        String result = "";
        if (adminService.queryAdminByName(adminName) != null){
            result = "用户名已存在";
        } else{
            resultCode = adminService.register(adminName, adminPassword);
            if (resultCode == 1){
                result = "注册成功";
            }else {
                result = "注册失败";
            }
        }
        response.put("resultCode", resultCode);
        response.put("result", result);
        return response;
    }

    /**
     * 登录
     * @param adminName
     * @param adminPassword
     * @return
     */
    @PostMapping(value = "/login")
    public Map login(String adminName, String adminPassword){
        Map response = new HashMap();
        int resultCode = adminService.login(adminName, adminPassword);
        String result = "";
        response.put("resultCode", resultCode);
        if (resultCode == -1){
            result = "找不到用户名";
        }
        else if (resultCode == -2){
            result = "密码错误";
        }else {
            result = "登录成功";
        }
        response.put("result", result);
        return response;
    }


    /**
     * 显示所有管理员
     * @return
     */
    @RequestMapping(value = "/allAdmin")
    public Map showAllAdmin(){
        Map response = new HashMap();
        response.put("resultCode",0);
        response.put("result",adminService.showAllAdmin());
        return response;
    }
}
