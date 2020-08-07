<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

    <script>
        setTimeout(function () {
            location.reload();
        }, 15000);

        $(document).ready(function createTable() {
            $.ajax({
                type: 'POST',
                data_type: 'JSON',
                url: 'http://localhost:8081/CinemaWeb/hall',
            }).done(function (responseText) {
                var places = JSON.parse(responseText);

                for (var i = 0; i < places.length; i++) {
                    if (places[i].free == 1) {
                        $('#' + places[i].x).after(' <td style="font-size: 1.2rem; color: whitesmoke; background: lightcoral" >' +
                            ' Место занято ' + places[i].username + '</td>');
                    } else {
                        $('#' + places[i].x).after(' <td><input type="radio" name="place" ' +
                            'value="' + places[i].id + ' ' + places[i].x + ' ' + places[i].y +
                            '" required> Ряд ' + places[i].x + ', Место ' + places[i].y + '</td>');
                    }
                }
            }).fail(function () {
                alert('Ajax ERROR.')
            })
        })

    </script>
    <title>Cinema</title>
</head>
<body>


<div class="container">
    <form action="buy" method="get">
        <div class="row pt-3">
            <h4>
                Бронирование месте на сеанс
            </h4>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th style="width: 120px;">Ряд / Место</th>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th id="1">1</th>

                </tr>
                <tr>
                    <th id="2">2</th>

                </tr>
                <tr>
                    <th id="3">3</th>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="row float-right">
            <button type="submit" class="btn btn-success">Оплатить</button>
        </div>
    </form>
</div>
</body>
</html>