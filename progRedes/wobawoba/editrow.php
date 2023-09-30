<?php
session_start();
require_once "database.php";

$idColumnName = "id";
$id = $_GET["id"];

$columnsData = entries("SHOW columns FROM userdetail");
$colTypes=[];
foreach ($columnsData as $col){
    $colTypes[$col['Field']]=explode('(',$col['Type'])[0];
} 


$row = entries("SELECT * FROM userdetail WHERE id = {$id} AND userID = {$_SESSION['userID']}")[0];

?>

<tr id='e<?=$id?>'>
    
        <input type='hidden' name='idColumn' value='<?=$idColumnName?>'>
<?php foreach ($colTypes as $colName=>$colType){  ?>
    <td class="">
    <?php
    switch ($colType){
        case 'int':
            ?><input name='<?=$colName?>' type='number' value="<?=$row[$colName]?>"  class="includefor<?=$id?> w-3/4 items-center p-1 m-1 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500"><?php
            break;
        case 'varchar':
            ?><input name='<?=$colName?>' type='text' value="<?=$row[$colName]?>" class="includefor<?=$id?> w-3/4 items-center p-1 m-1 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500"><?php
            break;
        case 'datetime':
            ?><input name='<?=$colName?>' type='datetime-local' value="<?=$row[$colName]?>" class="includefor<?=$id?> w-3/4 items-center p-1 m-1 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500"><?php
            break;
        case 'date':
            ?><input name='<?=$colName?>' type='<?=$colType?>' value="<?=$row[$colName]?>" class="includefor<?=$id?> w-3/4 items-center p-1 m-1 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500"><?php
            break;
        default:
            break;
    } ?>
    </td>
    
    <?php
} ?>
    <td class="font-medium py-3.5 px-5 text-gray-700  text-left">
    <button hx-post='/changerow.php?id=<?=reset($row)?>' hx-target='#e<?=$id?>' hx-swap='outerHTML' hx-include='.includefor<?=$id?>' class="rounded-md bg-blue-400 p-2">✔</button>
    </td>
    <td class="font-medium py-3.5 px-5 text-gray-700  text-left ">
    <button onclick="window.location.reload()" class="rounded-md bg-blue-400 p-2">✖</button>
    
    </td>
    
    </tr>