<?php

include("settings.php");

$user_id = $_POST["user_id"];
$advert_id = $_POST["advert_id"];
$image = $_POST["image"];

Class Result{
        
     public $user_id;
     public $advert_id;
     public $success;
     public $result;

}

$random = str_split('ABCDEFGHIJKLMNOPQRSTUVWXYZ'.'0123456789'.'abcdefghijklmnoqrstuvwxyz');
shuffle($random);


$imageTitle = '';
foreach(array_rand($random, 30) as $k) $imageTitle.= $random[$k];

$imagePath = "advertiseImage/$imageTitle.png";

$add = mysqli_query($connect,"insert into advert_images(user_id,advert_id,image_title,image_path)values('$user_id','$advert_id','$imageTitle','$imagePath')");

//$count = mysqli_num_rows($add);

$result = new Result();


if($add){
   
    
    $query =  mysqli_query($connect,"select * from adverts where user_id= '$user_id' order by id desc limit 1");
    
    $query2 = mysqli_fetch_assoc($query);
    
   
    file_put_contents($imagePath,base64_decode($image));
    
    $result->user_id = $user_id;
    $result->advert_id = $query2["id"];
    $result->success = true;
    $result->result = "Resim Yuklendi";
   
    echo(json_encode($result));
 
}else{
    
    $result->result = "Resim Yuklenmedi";
    $result->success = false;
    echo(json_encode($result));
}



/*
if($count<1){
    $result->result = "Lütfen önce resim seçin";
    $result->tf=false;
    echo(json_encode($result));
    
}else if($add){
      
    $query =  mysqli_query($connect,"select * from adverts where user_id= '$user_id' order by id desc limit 1");
    
    $query2 = mysqli_fetch_assoc($query);
    
   
    file_put_contents($imagePath,base64_decode($image));
    
    $result->user_id = $user_id;
    $result->advert_id = $query2["id"];
    $result->success = true;
    $result->result = "Resim Yuklendi";
   
    echo(json_encode($result));
 
}
else{
    
    $result->result = "Resim Yuklenmedi";
    $result->success = false;
    echo(json_encode($result));
}
*/





?>