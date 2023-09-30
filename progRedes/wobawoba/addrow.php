<?php

session_start();
require_once "database.php";




$columnNames = array_map( function($x){return $x["Field"];},  entries("
SHOW COLUMNS FROM userdetail
"));
$idColumnName = "id";

$postVars = [];
foreach ($columnNames as $colName){
    $postVars[] = ($_POST[$colName] === "" || $colName === $idColumnName) ? null : $_POST[$colName] ;
}

$postVars = array_map("trim", $postVars);

$updatequery="INSERT INTO userdetail VALUES( ";
foreach ($columnNames as $colName){
    $updatequery.=" {$_POST[$colName]} , ";
}
$updatequery=substr($updatequery, 0,  strlen($updatequery)-2). ') ';
qq($updatequery);




?>

<script>
    window.location.reload();
</script>