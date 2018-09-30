package cn.mafangui.hotelmanagersystem.service.impl;


import cn.mafangui.hotelmanagersystem.dao.AdminDao;
import cn.mafangui.hotelmanagersystem.entity.Admin;
import cn.mafangui.hotelmanagersystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;


    /**
     * 注册
     * @param adminName
     * @param adminPassword
     * @return
     */
    @Override
    public int register(String adminName, String adminPassword) {
        return adminDao.addAdmin(adminName, adminPassword);
    }

    /**
     * 登录
     * @param adminName
     * @param adminPassword
     * @return
     */
    @Override
    public int login(String adminName, String adminPassword) {
        if (adminDao.findByAdminName(adminName) == null){
            return -1;
        }
        if (adminDao.findByAdminNameAndPassword(adminName,adminPassword) == null){
            return -2;
        }
        return 0;
    }

    @Override
    public Admin queryAdminByName(String adminName) {
        return adminDao.findByAdminName(adminName);
    }

    @Override
    public List<Admin> showAllAdmin() {
        return adminDao.findAllAdmin();
    }
}
