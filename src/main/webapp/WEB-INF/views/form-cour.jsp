<%--
  Created by IntelliJ IDEA.
  User: Abdeslam Rehaimi
  Date: 06/04/2020
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Form|Cours</title>
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
        <div class="col-md-8 offset-2">
            <div >
                <a style="float: left;" class="btn btn-danger" href="list" >Returne</a>
            </div>
            <br><br>
            <div class="card">
                    <div class="card-header">Nouveau/Update Cours</div>
                <form:form action="saveCour"  method="post" modelAttribute="cour">
                    <div class="card-body row">
                        <form:hidden path="ID_C" />
                        <div class="form-group col-md-6 required ">
                            <label>Titre</label>
                            <form:input path="titre" type="text" name="nom" placeholder="Titre*" class="form-control "></form:input>
                            <form:errors path="titre" class="invalid-feedback"  cssStyle="color: red" />
                        </div>

                        <div class="form-group col-md-6 required ">
                            <label>Auteur</label>
                            <form:input path="auteur" type="text" name="auteur" placeholder="Auteur*"  class="form-control"></form:input>
                            <form:errors path="auteur"  class="invalid-feedback"  cssStyle="color: red"  />
                        </div>


                        <div class="form-group col-sm-12 required ">
                            <label>Module</label>
                            <form:select path="module" name="module" class="form-control"  >
                                <form:option value="Unkown">------</form:option>
                                <form:option value="JEE-Spring">JEE-Spring</form:option>
                                <form:option value="Web">Web</form:option>
                                <form:option value="Python">Python</form:option>
                                <form:option value="Base De Donner">Base De Donner</form:option>
                                <form:option value="Developement Mobile">Developement Mobile</form:option>
                            </form:select>
                            <form:errors path="module"  class="invalid-feedback"  cssStyle="color: red" />
                        </div>


                        <div class="form-group col-sm-12 required ">
                            <label>Owner</label>

                            <form:select path="utilisateurList"  class="form-control"  >
                                     <form:options items="${utilisateur}" id="ID_U" itemValue="ID_U"  itemLabel="email" />
                             </form:select>
                            <form:errors path="utilisateurList"  class="invalid-feedback"  cssStyle="color: red" />

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
