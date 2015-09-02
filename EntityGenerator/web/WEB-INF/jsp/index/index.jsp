<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Class Generator</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/angular.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/angular-route.min.js"></script>
        <!-- Font Awesome Icons -->
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
    <nav class="navbar navbar-default navbar-static-top">
        <div class="container">
            <a class="navbar-brand" href="#">Java Class Generator</a>
            <p class="navbar-text navbar-right">
                Prepared By <a href="#" class="navbar-link">
                    Ajit Kumar Baral</a></p>
        </div>
    </nav>
    <!--<div ng-app="classgenerator">
        <div ng-controller="DefaultController">
            <nav class="navbar navbar-default navbar-static-top">
                <div class="container">
                    <a class="navbar-brand" href="#">Java Class Generator</a><p class="navbar-text navbar-right">Prepared By <a href="#" class="navbar-link">Ajit Kumar Baral</a></p>
                </div>
            </nav>
            <div class="col-xs-4">
                <div class="form-group">
                    <label>Class Path</label>
                    <input type="text" class="form-control" name="fullPath"
                           placeholder="E:\repository\SampleApp\EntityGenerator\src\java">
                </div>
                <div class="form-group">
                    <label>Package Name</label>
                    <input type="text" class="form-control" name="packageName"
                           placeholder="com.example.project">
                </div>
                <div class="form-group">
                        <div class="input-group input-group">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-warning dropdown-toggle" 
                                        data-toggle="dropdown" >{{dataTypeSelector}} <span 
                                        class="fa fa-caret-down"></span></button>
                                <ul class="dropdown-menu">
                                    <li ng-repeat="dataType in dataTypes" 
                                        ng-click="dataTypeSelected(dataType)">
                                        <a href="#">{{dataType}}</a>
                                    </li>
                                </ul>
                            </div>
                            <input type="text" class="form-control" name="variableName">
                        </div>
                    </div>
                <button class="btn btn-info fa fa-plus pull-right" id="btnAdd">
                </button>
                <button class="btn btn-info fa fa-minus pull-right" id="btnMinus">
                </button>
            </div>-->

    <div class="col-xs-4">
        <form id="generateForm" method="POST">
            <div class="form-group">
                <label>Full File Path </label>
                <input type="text" placeholder = "Eg: E:\Repository\Project Name\src\java" 
                       name="fullPath" size="100" id="fullPath" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Package Name</label>
                <input type="text" placeholder = "Eg: com.package.project.entity" 
                       name="packageName" size="100" id="package" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Class Name</label>
                <input type="text" placeholder = "Eg: Employee" name="className" size="100" 
                       id="class" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Variable Names with commas</label>
                <input type="text" placeholder = "id,firstName,lastName,email,phone,status" 
                       name="variableNames" size="100" id="variable" class="form-control"/>
            </div>
            <div class="form-group">
                <label>Variable Data Types with commas</label>
                <input type="text" placeholder = "int,String,String,String,String,Boolean" 
                       name="variableTypes" size="100" id="dataType" class="form-control"/>
            </div>
        </form>
            <div class="form-group">
                <button class="btn btn-info pull-right" id="btnGenerate">Generate Entity</button><br/><br/>
            </div>
    </div>
    
        <div class="form-group col-xs-12" id="pathDiv">
            <label>File Path</label>
            <input disabled="true" id="path" class="form-control"/>
            
        </div>
    <script>
        $(document).on('ready', function () {
            $("#pathDiv").hide();

            $("#btnGenerate").on('click', function () {
               var fullPath = $("#fullPath").val();
               var package = $("#package").val();
               var classes = $("#class").val();
               var variable = $("#variable").val();
               var dataType = $("#dataType").val();
                
                if(fullPath !== "" && package !=="" && classes!=="" 
                        && variable!=="" && dataType !=="" ){
                    
                $.post("http://localhost:8080/EntityGenerator/api/generate", $("#generateForm").serialize(), 
                function (data) {
                    $("#pathDiv").show();
                    $("#path").val(data);
                });
                }else{
                    $("#pathDiv").show();
                    $("#path").val("Please fill all the fields");
                }
            });
        });
        //Angular
        /*var app = angular.module("classgenerator", []);
         app.controller("DefaultController", function ($scope) {
         $scope.dataTypeSelector = "Data Type";
         $scope.dataTypes = ["Integer", "String", "Boolean", "Double", "Long", "Float"];
         $scope.dataTypeSelected = function (dataType) {
         $scope.dataTypeSelector = dataType;
         };
         });*/




    </script>
</body>
</html>
