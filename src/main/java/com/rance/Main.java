package com.rance;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;

import java.util.Collections;

public class Main {
    private static final String url =  "jdbc:sqlserver://localhost:1433;databaseName=HEP20231220;user=sa;password=qwertyuiop;Encrypt=false;trustServerCertificate=true";
    private static final String projectPath = "D:\\MySpace\\IdeaProjects\\jlzk-mes-crop";
    private static final String username = "sa";
    private static final String password = "qwertyuiop";
    private static final String parentPackageName = "com.rance";
    private static final String moduleName = "";
    private static final String writer = "Rance";
    private static final String outPath = projectPath + "\\src\\main\\java";
    private static final String mapperPath = projectPath + "\\src\\main\\java\\com\\rance\\jlzk-mes-crop\\mapper\\xml\\";

    public static void main(String[] args) {
        String[] tableNames = {"SaleOrderList_ZK"};
        Main.execute(tableNames);
        System.out.println("pimp success");
    }

    public static void execute(String[] tableNames){
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(writer)
                            // .enableSwagger()
                            .outputDir(outPath)
                            .disableOpenDir();
                })
                .packageConfig(builder -> {
                    builder.parent(parentPackageName)
                            // .moduleName(moduleName)
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperPath));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tableNames)
                            // .addTablePrefix("t_")
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .enableFileOverride()
                            .entityBuilder()
                            .disableSerialVersionUID()
                            .enableLombok()
                            .enableTableFieldAnnotation()
                            .addTableFills(new Column("create_time", FieldFill.INSERT))
                            .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                            .enableFileOverride()
                            .mapperBuilder()
                            .enableMapperAnnotation()
                            .enableFileOverride()
                            .controllerBuilder()
                            .enableRestStyle()
                            .enableFileOverride();
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}