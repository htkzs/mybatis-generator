package com.atguigu.test;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class MyBatis_Generator {
    /*
     * @Author GhostGalaxy
     * @Description 简单的代码生成
     * @Date 15:58:07 2022/11/20
     * @Param []
     * @return void
     **/
    public static void mybatisSimpleGenerator() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        File f = new File("src/config/simple-mybatis-generator.xml");
        List<String> warnings = new ArrayList<String>();
        ConfigurationParser cp
                = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(f);
        DefaultShellCallback callBack = new DefaultShellCallback(true);
        MyBatisGenerator generator = new MyBatisGenerator(config, callBack, warnings);
        generator.generate(null);
    }
    /*
     * @Author GhostGalaxy
     * @Description 复杂的代码生成器
     * @Date 15:58:40 2022/11/20
     * @Param []
     * @return void
     **/
    public static void mybatisGenerator() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        File f = new File("src/config/mybatis-generator.xml");
        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp
                = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(f);
        DefaultShellCallback callBack = new DefaultShellCallback(true);
        MyBatisGenerator generator = new MyBatisGenerator(config, callBack, warnings);
        generator.generate(null);
    }


    public static void main(String[] args) throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {
        //MyBatis_Generator.mybatisSimpleGenerator();
        MyBatis_Generator.mybatisGenerator();
    }
}
