<?php


session_start();
require_once "database.php";
$id=sanitize($_GET["id"]);

qq("DELETE FROM userdetail WHERE id=$id AND userID={$_SESSION['userID']}");
