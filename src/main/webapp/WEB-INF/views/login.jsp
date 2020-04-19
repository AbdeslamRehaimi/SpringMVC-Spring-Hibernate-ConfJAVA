<%--
  Created by IntelliJ IDEA.
  User: Abdeslam Rehaimi
  Date: 17/04/2020
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/cards.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <style>
        h1 {
            color: #fff70a;
        }

        h2 {
            color: chocolate;
        }
        hr {
            width: 150px;
            border: 5px solid #48ff0c;
        }
        input{
            border-radius: 50px;
        }
    </style>
</head>
<body style="background-color: #4a4747;">
<div class="container">
    <fieldset >
        <div style="text-align: center;">
            <h1> <span style="color: #ffffff;">SpringMVC</span> CONF XML </h1>
        </div>
        <hr />
    </fieldset>
    <div class="row">
        <div class="col-md-8 offset-2">
        <div >
            <br><br><br><br><br>
            <div class="card">
                <div class="card-header">Votre Identifiant</div>
                <form:form action="authentification"  method="post" modelAttribute="user">
                    <div class="card-body row">
                        <div class="form-group col-md-6 col-sm-12 required ">
                            <label>Nom</label>
                            <form:input path="nom" type="text" name="nom" placeholder="Nom*" class="form-control"></form:input>
                            <form:errors path="nom"  class="invalid-feedback"  cssStyle="color: red" />
                        </div>
                        <div class="form-group col-md-6 col-sm-12 required ">
                            <label>Prenom</label>
                            <form:input path="prenom" type="text" name="prenom" placeholder="Prenom*" class="form-control"></form:input>
                            <form:errors path="prenom"  class="invalid-feedback"  cssStyle="color: red" />
                        </div>

                        <div class="form-group col-md-12">
                            <form:button class="btn btn-primary btn-block">Submit</form:button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        </div>
    </div>
</div>
</body>
</html>
