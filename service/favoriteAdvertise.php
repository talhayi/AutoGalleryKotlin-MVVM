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
 
//todo: aynı ilanı iki kişi favori olarak ekleyemiyor
if($count>0){
    
    $delete = mysqli_query($connect,"delete from favorite_adverts where user_id= '$user_id' and advert_id = '$advert_id'");
    
    $result->success = false;
    $result->text = "Favoriye Al";
    echo(json_encode($result));
}
else{
    $add = mysqli_query($connect,"insert into favorite_adverts(user_id,advert_id)values('$user_id','$advert_id')");
    
    $result->success = true;
    $result->text = "Favoriden Çıakrt";
    echo(json_encode($result));
}
?>