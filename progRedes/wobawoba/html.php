<?php
require_once "./database.php";
session_start();
if (isset( $_SESSION['melones'])){
    header('Location: ./index.php');
}

if (isset( $_POST['email']) && isset( $_POST['pwd'])){
    $sanitized_email = sanitize($email);
    $userlst=qq("SELECT * FROM user WHERE email = {$sanitized_email}");
    if (mysqli_num_rows($userlist) != 1){
        echo "tremendos zapallos";
    } else {
        $user = $qq->fetch_assoc();
        if (password_verify($user["password"], sanitize($_POST['pwd'] ))){
            $_SESSION['melones'] = $user["id"];
            header('Location: ./index.php');
        } else {
            echo "contra incorrcta";
        }
    }

    
}

?>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        p, label, span, h1 {
            color: white;
        }
        body {
            background-image: url(https://static.vecteezy.com/system/resources/previews/001/841/347/original/dark-orange-background-with-curved-lines-vector.jpg);
            text-align: center;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }
        .brungus{
            text-align: center;
            width: 60%;
        }
    </style>
</head>
<body>
    <br><br><br>
    <div class="brungus">
        <h1>Página de logueo</h1>
        <br>
        
        <form>
            <label for="email">Mail</label><br>
            <input name="email" type="email"> <br>
            <label for="pwd">Contraseña</label><br>
            <input name="pwd"  type="password"> <br>
            <input type="submit" name="" id="">
        </form>
    </div>
</body>
</html>