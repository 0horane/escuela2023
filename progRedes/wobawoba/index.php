<?php
session_start();
if (!isset($_SESSION['userID'])){
    header('Location: ./html.php');
}

require_once "./database.php";

$rows=entries("
Select * FROM userdetail WHERE userID =  {$_SESSION['userID']}
");





$columnNames = array_map( function($x){return $x["Field"];},  entries("
SHOW COLUMNS FROM userdetail
"));

?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <script src="https://unpkg.com/htmx.org@1.9.5"></script>
    <link rel="icon" href="/img/azul.png">


</head>

<a href="./logout.php" class="bg-blue-400 inline-block text-sm px-4 py-2 leading-none border rounded text-white border-white hover:border-transparent hover:text-teal-500 hover:bg-blue-500 mt-4 mt-0 ml-20">Desloguearse</a>
<div class="">
    <div class="bg-slate-50 rounded-xl mt-5 mx-5 p-3 border-blue-500 border overflow-auto">
        <table class="table-fixed">
        <thead>
            <tr id="tablenames">
	        <?php foreach ( $columnNames as $column ){ 
                if ($column!=="contrasenia"){?>
            <th class="border-b font-bold py-3.5 pl-3 text-gray-800 text-center "><?= $column ?></th>
		    <?php }} ?>
            </tr>
        </thead>
        <tbody id="rowsbody">
            <?php foreach($rows as $row){ ?>
            <tr id="r<?=reset($row)?>">
		        <?php foreach ($columnNames as $column){?>
                <td class="font-medium py-3.5 px-5 text-gray-700  text-left">
                    <?=$row[$column]?>
                </td>
		        <?php } ?>
                <td class="font-medium py-3.5 px-5 text-gray-700  text-left">
                <button hx-get='/editrow.php?id=<?=reset($row)?>' hx-target='#r<?=reset($row)?>' hx-swap='outerHTML' class="rounded-md bg-blue-400 p-2">✏️</button>
                </td>
                <td class="font-medium py-3.5 px-5 text-gray-700  text-left ">
                <button hx-get='/deleterow.php?id=<?=reset($row)?>' hx-target='#r<?=reset($row)?>' hx-swap='outerHTML' class="rounded-md bg-blue-400 p-2">❌</button>
                </td>

            </tr>
            <?php } ?>
            
            
        </tbody>
        </table>
    </div>
</div>

<div>
    <a hx-get='/newrow.php' hx-target="#rowsbody" hx-swap="beforeend" class="bg-blue-400 inline-block text-sm px-4 py-2 leading-none border rounded text-white border-white hover:border-transparent hover:text-teal-500 hover:bg-blue-500 mt-4 mt-0 ml-20">Agregar</a>
</div>