<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 11/22/2021
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Settings</h1>
<div class="container-fluid">
    <form:form action="" method="post" modelAttribute="">
        <div class="row m-3">
            <div class="col-1 m-2">
                <h6>Language: </h6>
            </div>
            <div class="col-5">
                <form:select class="form-select" aria-label="Default select example" path="language">
                    <form:option value="English" >English</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                </form:select>
            </div>
        </div>
        <div class="row m-3">
            <div class="col-1 m-2">
                <h6>Page Size: </h6>
            </div>
            <div class="col-5">
                <p class="d-inline">Show</p>
                <form:select cssStyle="width: 70px; height:35px" class="form-select d-inline" aria-label="Default select example" path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                <p class="d-inline">emails per page</p>
            </div>
            <div class="row m-3">
                <div class="col-1 m-2">
                    <h6>Spams filter: </h6>
                </div>
                <div class="col-5">
                    <div class="form-check form-switch">
                        <form:checkbox class="form-check-input" role="switch" id="flexSwitchCheckDefault" path="spamsFilter"/>
                            <%--                    <form:input class="form-check-input" type="checkbox" role="switch" id="flexSwitchCheckDefault" path="spamsFilter"/>--%>
                        <label class="form-check-label" for="flexSwitchCheckDefault">Enable spams filter</label>
                    </div>
                </div>
            </div>
            <div class="row m-3">
                <div class="col-1 m-2">
                    <h6>Signature: </h6>
                </div>
                <div class="col-5">
                    <div class="mb-3">
                        <form:textarea class="form-control" id="exampleFormControlTextarea1" rows="3" path="signature"></form:textarea>
                    </div>
                </div>
            </div>
            <div class="row m-3 ">
                <div class="col-3"  style="padding-left: 150px">
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
                <div class="col-3" style="padding-left: 150px">
                    <a href="/"><button type="button" class="btn btn-light">Cancel</button></a>
                </div>
            </div>
    </form:form>
</div>
</body>
</html>
