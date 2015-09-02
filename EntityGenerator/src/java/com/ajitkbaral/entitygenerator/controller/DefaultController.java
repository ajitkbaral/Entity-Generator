/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.entitygenerator.controller;

import com.ajitkbaral.entitygenerator.util.GenerateClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omg.CORBA.portable.OutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ajit Kumar Baral
 */
@Controller
@RequestMapping("/")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET)
    public String indexPage() {
        return "index/index";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String indexPost(HttpServletRequest request, HttpServletResponse response) {
//        String packageName = request.getParameter("packageName");
//        String className = request.getParameter("className");
//        String variableNames = request.getParameter("variableNames");
//        String variableTypes = request.getParameter("variableTypes");
//
//        String defaultPath = request.getParameter("fullPath");
//        String filePath = packageName.replace(".", "\\");
//
//        String finalFilePath = defaultPath + "\\" + filePath + "\\" + className + ".java";
//        
//        System.out.println("Variables and types "+ variableNames +" "+variableTypes);
//
//        if (!variableNames.equals("") && !variableTypes.equals("")) {
//
//            List<String> variableNameList = new ArrayList<String>();
//            List<String> variableTypeList = new ArrayList<String>();
//
//            StringTokenizer variableNameTokenizer = new StringTokenizer(variableNames, ",");
//            while (variableNameTokenizer.hasMoreTokens()) {
//                variableNameList.add(variableNameTokenizer.nextToken());
//            }
//
//            StringTokenizer variableTypeTokenizer = new StringTokenizer(variableTypes, ",");
//            while (variableTypeTokenizer.hasMoreTokens()) {
//                variableTypeList.add(variableTypeTokenizer.nextToken());
//            }
//                
//                System.out.println(variableNameList.toString() +" "+ variableTypeList.toString());
//
//            try {
//                FileWriter fileWriter = new FileWriter(new File(finalFilePath));
//
//                String content = GenerateClass.packageNameContent(packageName)
//                        + GenerateClass.classNameContent(className)
//                        + GenerateClass.variableDecleration(variableNameList, variableTypeList)
//                        + GenerateClass.defaultConstructor(className)
//                        + GenerateClass.overrideConstructor(className, variableNameList, variableTypeList)
//                        + GenerateClass.getter(variableNameList, variableTypeList)
//                        + GenerateClass.setter(variableNameList, variableTypeList)
//                        + GenerateClass.close();
//                fileWriter.write(content);
//                fileWriter.close();
//                System.out.println("DONE");
//
//            } catch (IOException ioe) {
//                  System.out.println(ioe.getMessage());
//            }
//            
//        }else{
//            System.out.println("Empty fields");
//        }
//        
//            return "index/index";
//    }
    
    
        
}
