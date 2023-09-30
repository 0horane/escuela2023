<?php
session_start();
require_once "database.php";



$columnsData = entries("SHOW columns FROM userdetail");
$colTypes=[];
foreach ($columnsData as $col){
    $colTypes[$col['Field']]=explode('(',$col['Type'])[0];
} 

?>

<tr id='einsert'>
    
<?php foreach ($colTypes as $colName=>$colType){ ?>
    <td class="">
    <?php
    switch ($colType){
        case 'int':
            ?><input name='<?=$colName?>' type='number'   class="includefor<?=$id?> w-3/4 items-center p-1 m-1 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500"><?php
            break;
        case 'varchar':
            ?><input name='<?=$colName?>' type='text'  class="includefor<?=$id?> w-3/4 items-center p-1 m-1 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500"><?php
            break;
        case 'datetime':
            ?><input name='<?=$colName?>' type='datetime-local'  class="includefor<?=$id?> w-3/4 items-center p-1 m-1 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500"><?php
            break;
        case 'date':
            ?><input name='<?=$colName?>' type='<?=$colType?>'  class="includefor<?=$id?> w-3/4 items-center p-1 m-1 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500"><?php
            break;
        default:
            break;
    } ?>
    </td>
    
    <?php
} ?>
<td class="font-medium py-3.5 px-5 text-gray-700  text-left">
<button hx-post='/addrow.php' hx-target='#einsert' hx-swap='outerHTML' hx-include='.includeforinsert' class="rounded-md bg-blue-400 p-2">✔</button>
</td>
<td class="font-medium py-3.5 px-5 text-gray-700  text-left ">
<button hx-post='/empty.php' hx-target='#einsert' hx-swap='outerHTML' class="rounded-md bg-blue-400 p-2">✖</button>

</td>

</tr>