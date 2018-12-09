package com.lu.pro.mybatisplus.service.impl;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.lu.pro.mybatisplus.service.PlusGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @autor 10758
 * @system lu-pro-arch
 * @Time 2018/12/6
 */
@Service
@Slf4j
public class PlusGeneratorImpl implements PlusGenerator {
    @Value("${modelName}")
    private String modelName;
    @Value("${packageName}")
    private String packageName;
    @Value("${tableNames}")
    private String tableNames;
    @Value("${excludedFields}")
    private String excludedFields;
    @Value("${outputDir}")
    private String outputDir;



    @Value("${spring.datasource.driver-class-name}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.username}")
    private String userName;
    @Value("${spring.datasource.password}")
    private String pwd;
    @Value("${dbType}")
    private String dbType;

    @Override
    public void generator() {
        String baseDir = System.getProperty("user.dir");
        log.info(baseDir);
        GlobalConfig config = new GlobalConfig();

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.getDbType(dbType))
                .setUrl(dbUrl)
                .setUsername(userName)
                .setPassword(pwd)
                .setDriverName(driver);
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setSuperEntityColumns(excludedFields.split(","))
                .setEntityLombokModel(true)
                // .setDbColumnUnderline(true) 改为如下 2 个配置
                .setNaming(NamingStrategy.underline_to_camel)
                .setControllerMappingHyphenStyle(true)
                .setColumnNaming(NamingStrategy.underline_to_camel);

                /*.entityTableFieldAnnotationEnable(enableTableFieldAnnotation)
                .setFieldPrefix(fieldPrefix)//test_id -> id, test_type -> type*/
                if(null != tableNames && tableNames.trim().length()>0){
                    strategyConfig.setInclude(tableNames.split(","));
                }
              //  .setInclude();//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(true)
                .setEnableCache(false)
                .setBaseColumnList(true)
                .setBaseResultMap(true)

                .setDateType(DateType.ONLY_DATE)
                //.setIdType(tableIdType)
                .setAuthor(System.getProperty("user.name"))
                .setOutputDir(outputDir+"/java")
                               .setFileOverride(true);
        config.setServiceName("%sService")
        ;
        new AutoGenerator().setGlobalConfig(config)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                                .setMapper("mapper")
                                //.setXml("src/main/resources/mapper")
                                .setModuleName(modelName)
                                .setService("service")
                                .setServiceImpl("service.impl")
                ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        map.put("packageName", packageName + "."+modelName);
                        this.setMap(map);
                    }
                }.setFileOutConfigList(initFileOutConfig()

                )
        )
                .setTemplate(
                // 关闭默认 xml 生成，调整生成 至 根目录
                new TemplateConfig()
                        .setXml(null)
                // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
                // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
                .setController("/template/controller.java")
                .setEntity("/template/entity.java")
                .setMapper("/template/mapper.java")
               // .setXml("/template/mapper.xml")
                .setService("/template/service.java")
                .setServiceImpl("/template/serviceImpl.java")
        ).execute();
    }

    private List<FileOutConfig> initFileOutConfig() {
        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
        String baseDir = System.getProperty("user.dir");
        //xml
        fileOutConfigs.add( new FileOutConfig(
                "/template/mapper.xml" +  ".ftl" ) {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return  outputDir+"/resources/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        // entitybase
        fileOutConfigs.add( new FileOutConfig(
                "/template/entityBase.java" +  ".ftl" ) {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outputDir + "/java/"+packageName.replace(".","/") +"/"+modelName+"/entity/base/"+tableInfo.getEntityName() + "BaseEntity.java";
            }
        });

        // dto
        fileOutConfigs.add( new FileOutConfig(
                "/template/dto.java" +  ".ftl" ) {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outputDir + "/java/"+packageName.replace(".","/") +"/"+modelName+"/dto/"+tableInfo.getEntityName() + "Dto.java";
            }
        });

        // dtobase
        fileOutConfigs.add( new FileOutConfig(
                "/template/dtoBase.java" +  ".ftl" ) {
            // 自定义输出文件目录
            @Override
            public String outputFile(TableInfo tableInfo) {
                return outputDir + "/java/"+packageName.replace(".","/")+"/"+modelName+"/dto/base/" +tableInfo.getEntityName() + "BaseDto.java";
            }
        });

        return fileOutConfigs;
    }

}
