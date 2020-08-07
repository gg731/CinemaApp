<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script>


    </script>


    <title>Hello, world!</title>
</head>
<body>


<div class="container">
    <div class="row pt-3">
        <h3>
            Вы выбрали ряд <%=session.getAttribute("x")%> место <%=session.getAttribute("y")%> , Сумма : 500
            рублей.
        </h3>
    </div>
    <div class="row">

        <form action="buy" method="post">
            <div class="form-group">
                <c:if test="${usernameErr != null}">
                    <h3 style="color: darkred"><%=request.getAttribute("usernameErr")%>
                    </h3>
                </c:if>
                <label>ФИО</label>
                <input type="text" class="form-control" name="username" placeholder="ФИО">
            </div>
            <div class="form-group">
                <label>Номер телефона</label>
                <input type="number" class="form-control" name="phone" placeholder="Номер телефона">
            </div>
            <button type="submit" class="btn btn-success">Оплатить</button>
        </form>
    </div>
</div>
</body>
</html>