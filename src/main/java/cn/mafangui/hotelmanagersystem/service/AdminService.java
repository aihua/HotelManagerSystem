package cn.mafangui.hotelmanagersystem.service;


import cn.mafangui.hotelmanagersystem.entity.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    int register(String adminName, String adminPassword);
    int login(String adminName, String adminPassword);
    Admin queryAdminByName(String adminName);
    List<Admin> showAllAdmin();
}
