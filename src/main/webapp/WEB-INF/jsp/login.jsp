
<!DOCTYPE html>
<%@ taglib uri="https://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <title>Welcome Students</title>
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Welcome!</h1>
        <h2></h2>
    </div>

    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
<form action="/processUserLogin" method="post">
    <label for="username">UserName</label>
    <input type="text" id="username" minlength="8" name="username"><br>
    <label for="password">Password</label>
    <input type="password" id="password" minlength="8" name="password" >
    <br>
    <input type="submit" value="submit">
</form>
        </div>
        <div class="col-sm-4"></div>
    </div>
</div>
</body>
</html>