package cn.mafangui.hotelmanagersystem.dao;


import cn.mafangui.hotelmanagersystem.entity.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AdminDao {

    @Insert("insert into t_admin(admin_name,admin_password) values(#{adminName},#{adminPassword})")
    int addAdmin(@Param("adminName") String adminName,@Param("adminPassword") String adminPassword);

    @Delete("delete from t_admin where admin_name=#{adminName} and admin_password=#{adminPassword}")
    int delAdmin(@Param("adminName") String adminName,@Param("adminPassword") String adminPassword);


    int updateAdmin(@Param("adminName") String adminName,@Param("adminPassword") String adminPassword);

    @Select("SELECT * FROM t_admin where admin_name = #{adminName}")
    Admin findByAdminName(String adminName);

    @Select("SELECT * from t_admin where admin_name = #{adminName} AND admin_password = #{adminPassword}")
    Admin findByAdminNameAndPassword(@Param("adminName") String adminName,@Param("adminPassword") String adminPassword);

    @Select("SELECT * from t_admin")
    List<Admin> findAllAdmin();
}
