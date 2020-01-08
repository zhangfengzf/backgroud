package cn.zf.backgroud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 类描述:
 * 〈启动类〉
 *
 * @author 张锋
 * @date 2019/12/16 13:57
 */
@SpringBootApplication
@MapperScan("cn.zf.backgroud.mapper")
public class BackgroudApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackgroudApplication.class, args);
    }

}
