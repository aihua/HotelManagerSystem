package cn.mafangui.hotelmanagersystem.dao;

import cn.mafangui.hotelmanagersystem.entity.User;

public interface UserDao {
    int insertUser(User user);
    int delUser(User user);
    int updateUser(User user);

}
