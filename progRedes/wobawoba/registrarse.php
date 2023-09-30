<?php
require_once "./database.php";
session_start();
if (isset( $_SESSION['userID'])){
    header('Location: ./index.php');
}

if (isset( $_POST['email']) && isset( $_POST['pwd']) && isset( $_POST['pwd2']) && $_POST['pwd'] === $_POST['pwd2']){
    $sanitized_email = sanitize($_POST['email']);
    $userlist=qq("SELECT * FROM user WHERE email = '{$sanitized_email}'");
    if (mysqli_num_rows($userlist) >= 1){
        echo "tremendos zapallos";
    } else {
        $hash = password_hash( sanitize($_POST['pwd']),  PASSWORD_DEFAULT  );
        /*
        if (password_verify($user["password"], $_POST['pwd'] )){
            //$_SESSION['userID'] = $user["id"];
            //header('Location: ./index.php');
            //FINISH REGISTER
        } else {
            echo "contra incorrcta";
        }
        */
        qq("INSERT INTO user VALUES (null, '$sanitized_email', '$hash', null, NOW(), NOW(), null)");
        header("Location: ./index.php");
        ?>
        <script>
            window.location.href="./index.php";
        </script>
        <?php
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
        <h1>Página de rehistrarse</h1>
        <br>
        
        <form method="post">
            <label for="email">Mail</label><br>
            <input name="email" type="email"> <br>
            <label for="pwd">Contraseña</label><br>
            <input name="pwd"  type="password"> <br>
            <label for="pwd2">Contraseña (repetir)</label><br>
            <input name="pwd2"  type="password"> <br>
            <input type="submit" name="" id="">
        </form>
    </div>
</body>
</html>