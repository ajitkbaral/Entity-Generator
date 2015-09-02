/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ajitkbaral.entitygenerator.entities;

/**
 *
 * @author Ajit Kumar Baral
 */
public class ClassGenerate {
    private int id;
    private String packageName;
    private String className;
    private String variableName;
    private String variableType;
    
    public ClassGenerate(){
        
    }
    
    public ClassGenerate(int id, String packageName, String className, String variableName, String variableType) {
        this.id = id;
        this.packageName = packageName;
        this.className = className;
        this.variableName = variableName;
        this.variableType = variableType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    @Override
    public String toString() {
        return "ClassGenerate{" + "id=" + id + ", packageName=" + packageName + ", className=" + className + ", variableName=" + variableName + ", variableType=" + variableType + '}';
    }
    
    
    
}
