<?php
include("settings.php");

$advert_id = $_GET["advert_id"];
//$advert_id = "1";

$delete_advert = mysqli_query($connect,"delete from adverts where id = '$advert_id'");
$delete_image = mysqli_query($connect,"delete from advert_images where advert_id = '$advert_id'");

Class Result{
    
    public $success;
    public $result;
}

$result = new Result();

if($delete_advert || $delete_image){
    
    $result->success = true;
    $result->result = "Silindi";
    echo(json_encode($result));
    
}else{
    
    $result->success = false;
    $result->result = "Silinmedi";
    echo(json_encode($result));
    
}
?>