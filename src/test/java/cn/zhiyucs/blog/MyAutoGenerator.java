package cn.zhiyucs.blog;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyAutoGenerator {

    @Test
    void contextLoads() {
        String projectPath = System.getProperty("user.dir");//获取当前目录

        FastAutoGenerator.create("jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("zhiyu1998")
                            .enableSwagger()
                            .fileOverride()
                            .outputDir(projectPath + "/src/main/java")
                            .commentDate("yyyy-MM-dd")
                            .build();
                })
                .packageConfig(builder -> {
                    builder.parent("cn.zhiyucs")
//                            .moduleName("assd")
                            .entity("db.pojo")
                            .mapper("db.mapper")
                            .service("service")
                            .service("service.impl")
                            .controller("controller")
                            .build();
                })
                .strategyConfig(builder -> {
                    builder.addInclude("blog", "comment", "tag", "user") // 设置需要生成的表名
                            .addTablePrefix("t_")
                            .build();
                })
                .execute();
    }

}
