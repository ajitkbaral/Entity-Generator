/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.entitygenerator.controller;

import com.ajitkbaral.entitygenerator.util.GenerateClass;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ajit Kumar Baral
 */
@RestController
@RequestMapping("api/generate")
public class GenerateController {

    @RequestMapping(method = RequestMethod.POST)
    public String indexPost(HttpServletRequest request, HttpServletResponse response) {
        String result = "";
        String packageName = request.getParameter("packageName");
        String className = request.getParameter("className");
        String variableNames = request.getParameter("variableNames");
        String variableTypes = request.getParameter("variableTypes");

        String defaultPath = request.getParameter("fullPath");
        String filePath = packageName.replace(".", "\\");

        String finalFilePath = defaultPath + "\\" + filePath;
        String finalFilePathWithEntity = finalFilePath + "\\" + className + ".java";

        System.out.println("Variables and types " + variableNames + " " + variableTypes);

        if (!variableNames.equals("") && !variableTypes.equals("")) {

            List<String> variableNameList = new ArrayList<String>();
            List<String> variableTypeList = new ArrayList<String>();

            StringTokenizer variableNameTokenizer = new StringTokenizer(variableNames, ",");
            while (variableNameTokenizer.hasMoreTokens()) {
                variableNameList.add(variableNameTokenizer.nextToken());
            }

            StringTokenizer variableTypeTokenizer = new StringTokenizer(variableTypes, ",");
            while (variableTypeTokenizer.hasMoreTokens()) {
                variableTypeList.add(variableTypeTokenizer.nextToken());
            }

            System.out.println(variableNameList.toString() + " " + variableTypeList.toString());

            try {
                File fileFolder = new File(finalFilePath);
                if (!fileFolder.exists()) {
                    fileFolder.mkdirs();

                }

                FileWriter fileWriter = new FileWriter(finalFilePathWithEntity);

                String content = GenerateClass.packageNameContent(packageName)
                        + GenerateClass.classNameContent(className)
                        + GenerateClass.variableDecleration(variableNameList, variableTypeList)
                        + GenerateClass.defaultConstructor(className)
                        + GenerateClass.overrideConstructor(className, variableNameList, variableTypeList)
                        + GenerateClass.getter(variableNameList, variableTypeList)
                        + GenerateClass.setter(variableNameList, variableTypeList)
                        + GenerateClass.close();
                fileWriter.write(content);
                fileWriter.close();
                System.out.println("DONE");
                result = finalFilePathWithEntity;

            } catch (IOException ioe) {
                result = ioe.getMessage() + ". Please Try again";
            }

        } else {
            result = "Error";
        }
        return result;
    }

}
