package mp;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;

import java.util.Collections;

public class CodeGenerator {

    public static void main(String[] args) {

        String url = "";
        String username = "root";
        String password = "";
        DataSourceConfig.Builder wordsHandler = new DataSourceConfig.Builder(url, username, password)
                .dbQuery(new MySqlQuery())
                .schema("mybatis-plus")
                .typeConvert(new MySqlTypeConvert())
                .keyWordsHandler(new MySqlKeyWordsHandler());


        FastAutoGenerator.create(wordsHandler)
                         .globalConfig(builder -> {
                             builder.author("milo") // 设置作者
                                    .enableSwagger() // 开启 swagger 模式
                                    .outputDir("/Users/xpj/workSpace/studyAction/src/main/java/mp"); // 指定输出目录
                         })
                         .packageConfig(builder -> {
                             builder.parent("com.one.meinai") // 设置父包名
                                    .moduleName("common") // 设置父包模块名
                                    .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/xpj/workSpace/studyAction/src/main/java/mp/mapper")); // 设置mapperXml生成路径
                         })
                         .strategyConfig(builder -> {
                             builder.addInclude("sub_order_info")
                                    .mapperBuilder().enableBaseResultMap().enableBaseColumnList().enableMapperAnnotation().enableMapperAnnotation().entityBuilder().enableLombok(); // 设置需要生成的表名
                             //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                         })
                         .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                         .execute();
    }

}