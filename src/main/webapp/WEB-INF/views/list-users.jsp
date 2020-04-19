<%--
  Created by IntelliJ IDEA.
  User: Abdeslam Rehaimi
  Date: 06/04/2020
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>List|User</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
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
        h4{
            color: aliceblue;
            margin-bottom: 50px;
        }
    </style>
</head>
<body style="background-color: #4a4747;">
<div class="container">
    <fieldset >
        <div style="text-align: center;">
            <h1> <span style="color: #ffffff;">SpringMVC</span> CONF JAVA </h1>
        </div>
        <div style="text-align: center;">
        <h4>${bnvnu} <em style="color: #1a909c">${nomcomplet} </em></h4>
            <hr />
        </div>
    </fieldset>
     <div class="col-md-offset-1 col-md-10">


        <input type="button" style="float: left;" value="Nouveau Utilisateur"
               onclick="window.location.href='new'; return false;"
               class="btn btn-primary" />

        <input type="button" style="float: right;" value="Consultation Cours"
               onclick="window.location.href='../cours/list'; return false;"
               class="btn btn-primary" />

        <br/><br/>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">Lists of Utilisateur</div>
            </div>
            <div class="panel-body">
                <table class="table  table-dark table-striped table-bordered">
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>Email</th>
                        <th>Identiter</th>
                        <th>Image</th>
                        <th>Action</th>
                    </tr>

                     <c:forEach var="temp" items="${utilisateur}">
                         <c:url var="updateLink" value="/user/update">
                            <c:param name="ID_U" value="${temp.ID_U}" />
                        </c:url>

                         <c:url var="deleteLink" value="/user/delete">
                            <c:param name="ID_U" value="${temp.ID_U}" />
                        </c:url>

                        <tr>
                            <td>${temp.ID_U}</td>
                            <td>${temp.nom}</td>
                            <td>${temp.prenom}</td>
                            <td>${temp.email}</td>
                            <td>${temp.identiter}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${temp.image.length()>20}">
                                        <img width="80px" height="30px" src="${temp.image}" alt="image">
                                    </c:when>
                                    <c:otherwise>
                                        ${temp.image}
                                    </c:otherwise>
                                </c:choose>
                            </td>

                            <td>
                                 <a href="${updateLink}">Update</a>
                                |
                                <a href="${deleteLink}"
                                     onclick="if (!(confirm('Voulez vous vraiment me supprimer?'))) return false">Delete
                                </a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>
        </div>
    </div>

</div>
</body>
</html>
