<?php

include("settings.php");
$user_id = $_GET["user_id"];
$advert_id = $_GET["advert_id"];

//$user_id = "2";
//$advert_id = "13";

$query = mysqli_query($connect,"select * from favorite_adverts where user_id= '$user_id' and advert_id = '$advert_id'");

$count = mysqli_num_rows($query);


Class Result{
    public $success;
    public $text;
}

$result = new Result();
 

if($count>0){
    
    $result->success = true;
    $result->text = "Favoriden Çıkart";
    echo(json_encode($result));
}
else{
  
    $result->success = false;
    $result->text = "Favoriye Al";
    echo(json_encode($result));
}
?>