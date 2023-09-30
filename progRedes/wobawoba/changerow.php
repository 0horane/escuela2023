<?php

session_start();
require_once "database.php";

$id = sanitize($_GET["id"]);

$columnAssoc =entries("
SHOW COLUMNS FROM userdetail
");
$columnAssoc = array_slice($columnAssoc, 2);

$columnNames = array_map( function($x){return $x["Field"];}, $columnAssoc);  
$idColumnName = "id";


foreach ($columnNames as $colName){
    $_POST[$colName] = (($_POST[$colName] === "" && $columnAssoc[$colName]["Null"]!=="NO")  || $colName === $idColumnName) ? null : sanitize($_POST[$colName]) ;
}


$updatequery="UPDATE userdetail SET Name='{$_POST['Name']}', 
                                    Surname='{$_POST['Surname']}', 
                                    PhoneNumber= '{$_POST['PhoneNumber']}', 
                                    Company='{$_POST['Company']}', 
                                    Address='{$_POST['Address']}', 
                                    Web='{$_POST['Web']}', 
                                    Birthdate='{$_POST['Birthdate']}', 
                                    Label='{$_POST['Label']}', 
                                    Nick='{$_POST['Nick']}'  
                                    WHERE id=$id AND userID = {$_SESSION['userID']}";

qq($updatequery);




?>

<script>
    window.location.reload();
</script>