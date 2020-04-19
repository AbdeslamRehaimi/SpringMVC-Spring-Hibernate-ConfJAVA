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
    <title>Form|Users</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/cards.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body style="background-color: #4a4747;">
<div class="container">


    <div class="row">
        <div class="col-md-8 col-md-offset-2 ">
            <div >
                <a style="float: left;" class="btn btn-danger" href="list" >Returne</a>
            </div>
            <br><br>
            <div class="card">
                     <div class="card-header">Nouveau/Modifier Utilisateur</div>
                 <form:form action="saveUser"  method="post" modelAttribute="user">
                    <div class="card-body row">
                        <form:hidden path="ID_U" />
                        <div class="form-group col-md-6 required ">
                            <label>Nom</label>
                            <form:input path="nom" type="text" name="nom" placeholder="Nom*" class="form-control "></form:input>
                            <form:errors path="nom" class="invalid-feedback"  cssStyle="color: red" />
                        </div>

                        <div class="form-group col-md-6 required ">
                            <label>Prenom</label>
                            <form:input path="prenom" type="text" name="prenom" placeholder="Prenom*"  class="form-control"></form:input>
                            <form:errors path="prenom"  class="invalid-feedback"  cssStyle="color: red"  />
                        </div>


                        <div class="form-group col-sm-12 required ">
                            <label>Email</label>
                            <form:input path="email" type="text" name="email" placeholder="Email*" class="form-control"></form:input>
                            <form:errors path="email"  class="invalid-feedback"  cssStyle="color: red"  />
                        </div>


                        <div class="form-group col-md-6 required ">
                            <label>Mot de pass</label>
                            <form:input path="password" type="password" name="motdepasse" placeholder="Password*" autocomplete="off" class="form-control"></form:input>
                            <form:errors path="password"  class="invalid-feedback"  cssStyle="color: red"  />
                        </div>


                        <div class="form-group col-md-6 required ">
                            <label>Retaper Password</label>
                            <form:input path="confirmpassword" type="password" name="repetermotdepasse" placeholder="Confirme Password*" autocomplete="off" class="form-control is-invalid"></form:input>
                            <form:errors path="confirmpassword"  class="invalid-feedback"  cssStyle="color: red"  />
                        </div>

                        <div class="form-group col-sm-12">
                            <label>Role</label>
                            <form:select path="identiter" name="admin" class="form-control"  >
                                <form:option value="Unkown">------</form:option>
                                <form:option value="Etudiant">Etudiant</form:option>
                                <form:option value="Professeur">Professeur</form:option>
                            </form:select>
                            <form:errors path="identiter"  class="invalid-feedback"  cssStyle="color: red" />
                        </div>


                        <div class="form-group col-sm-12 required text-danger">
                            <label>Image</label>
                            <form:input path="image" type="text" name="text" placeholder="Path image" class="form-control is-invalid"></form:input>
                        </div>

                        <div class="form-group col-md-12">
                            <form:button class="btn btn-success btn-block">Valider</form:button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
