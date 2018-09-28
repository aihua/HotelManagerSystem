package cn.mafangui.hotelmanagersystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.mafangui.hotelmanagersystem.dao")
public class HotelmanagersystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelmanagersystemApplication.class, args);
    }
}
