/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.entitygenerator.util;

import java.util.List;

/**
 *
 * @author Ajit Kumar Baral
 */
public class GenerateClass {
    
    public static String space = "    ";

    public static String packageNameContent(String packageName) {
        return "package " + packageName + ";\n\n";
    }

    public static String classNameContent(String className) {
        return "public class " + className + " {\n\n";
    }

    public static String variableDecleration(List<String> variableNameList, List<String> variableTypeList) {
        String content = "";
        
        for(int i = 0; i<variableNameList.size(); i++){
            content += space+"private " + variableTypeList.get(i) + " " + variableNameList.get(i) + ";\n";
        

        }
        return content;
    }

    public static String defaultConstructor(String className) {
        return "\n"+space+"public " + className + "(){\n\n"+space+"}\n\n";
    }

    public static String overrideConstructor(String className, 
            List<String> variableNameList, List<String> variableTypeList) {
        
        String methodContent = "";
        String bodyContent = "";
        
        for(int i = 0; i<variableNameList.size(); i++){
            if(i==variableNameList.size()-1){
                methodContent += variableTypeList.get(i) + " " + variableNameList.get(i);
            }else{
            methodContent += variableTypeList.get(i) + " " + variableNameList.get(i)+", ";
            }
            bodyContent += space+space+"this." + variableNameList.get(i) + " = " + variableNameList.get(i) + ";\n";
        }
        return space+"public " + className + "(" + methodContent + "){\n"
                + bodyContent
                + space+"}\n\n";
    }

    public static String getter(List<String> variableNameList, List<String> variableTypeList) {
        String content = "";
        
        for(int i = 0; i<variableNameList.size(); i++){
            content += space+"public " + variableTypeList.get(i) + " get" + 
                    variableNameList.get(i).substring(0, 1).toUpperCase() + 
                    variableNameList.get(i).substring(1) + "(){\n"
                        + space+space+"return " + variableNameList.get(i) + ";" + "\n"
                        + space+"}\n\n";
        

        }
        return content;
    }

    public static String setter(List<String> variableNameList, List<String> variableTypeList) {
        String content = "";
        
        for(int i = 0; i<variableNameList.size(); i++){
            content += space+"public void set" + variableNameList.get(i).substring(0, 1).toUpperCase() 
                    + variableNameList.get(i).substring(1) + "(" + variableTypeList.get(i) + " " + 
                    variableNameList.get(i) + "){\n"
                        + space+space+"this." + variableNameList.get(i) + " = " + 
                    variableNameList.get(i) + ";\n"
                        + space+"}\n\n";
        

        }
        return content;
    }

    public static String close() {
        return "}";
    }
}
