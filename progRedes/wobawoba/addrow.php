<?php

session_start();
require_once "database.php";



$columnAssoc =entries("
SHOW COLUMNS FROM userdetail
");
$columnNames = array_map( function($x){return $x["Field"];}, $columnAssoc);  
$idColumnName = "id";


foreach ($columnNames as $colName){
    $_POST[$colName] = (($_POST[$colName] === "" && $columnAssoc[$colName]["Null"]!=="NO")  || $colName === $idColumnName) ? null : sanitize($_POST[$colName]) ;
}


$updatequery="INSERT INTO userdetail VALUES(null, {$_SESSION['userID']}, '{$_POST['Name']}', '{$_POST['Surname']}', '{$_POST['PhoneNumber']}', '{$_POST['Company']}', '{$_POST['Address']}', '{$_POST['Web']}', '{$_POST['Birthdate']}', '{$_POST['Label']}', '{$_POST['Nick']}' ) ";

qq($updatequery);




?>

<script>
    window.location.reload();
</script>