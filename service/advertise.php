<?php
include("settings.php");

$user_id = $_POST["user_id"];
//$advert_no = $_POST["advert_no"];
//$advert_date = $_POST["advert_date"];
$advert_title = $_POST["advert_title"];
$explanation = $_POST["explanation"];
$price =$_POST["price"];
$address = $_POST["address"];
$brand = $_POST["brand"];
$serial = $_POST["serial"];
$model = $_POST["model"];
$year = $_POST["year"];
$fuel = $_POST["fuel"];
$gear = $_POST["gear"];
$vehicleStatus = $_POST["vehicleStatus"];
$km = $_POST["km"];
$caseType = $_POST["caseType"];
$motorPower = $_POST["motorPower"];
$motorCapacity= $_POST["motorCapacity"];
$traction = $_POST["traction"];
$color = $_POST["color"];
$guarantee = $_POST["guarantee"];
$swap = $_POST["swap"];
$phoneNumber = $_POST["phoneNumber"];

/*
$user_id ="1";// $_POST["user_id"];
$advert_no ="2";// $_POST["advert_no"];
$advert_date ="3";// $_POST["advert_date"];
$advert_title ="4";// $_POST["advert_title"];
$explanation = "5";//$_POST["explanation"];

$price = "6";//$_POST["price"];
$address = "7";//$_POST["address"];
$brand = "8";//$_POST["brand"];
$serial = "9";//$_POST["serial"];
$model = "10";//$_POST["model"];

$year = "11";//$_POST["year"];
$fuel ="12";// $_POST["fuel"];
$gear = "13";//$_POST["gear"];
$vehicleStatus = "14";//$_POST["vehicleStatus"];
$km ="15";// $_POST["km"];

$caseType = "16";//$_POST["caseType"];
$motorPower = "17";//$_POST["motorPower"];
$motorCapacity= "18";//$_POST["motorCapacity"];
$traction = "19";//$_POST["traction"];
$color = "20";//$_POST["color"];
$guarantee ="21";// $_POST["guarantee"];
$swap = "22";//$_POST["swap"];
$phoneNumber = "23";//$_POST["phoneNumber"];
*/


Class Result{
    public $user_id;
    public $advert_id;
    public $success;
    public $result;
}

$result = new Result();

$add = mysqli_query($connect,"insert into adverts(user_id,advert_title,explanation,price,address,brand,serial,model,year,fuel,gear,vehicleStatus,km,caseType,motorPower,motorCapacity,traction,color,guarantee,swap,phoneNumber)
values('$user_id','$advert_title','$explanation','$price','$address','$brand','$serial','$model','$year','$fuel','$gear','$vehicleStatus','$km','$caseType','$motorPower','$motorCapacity','$traction','$color','$guarantee','$swap','$phoneNumber')");

/*
if($advert_title == "" || $explanation == "" || $price == "" || $address == "" || $brand == "" 
|| $serial == "" || $model == "" || $year == "" || $fuel == "" || $gear == "" || $vehicleStatus == "" 
|| $km == "" || $caseType == "" || $motorPower == "" || $motorCapacity == "" || $traction == "" 
|| $color == "" || $guarantee == "" || $swap == "" || $phoneNumber == ""){
    $result->result = "Lütfen tüm alanları doldurun";
    $result->tf=false;
    echo(json_encode($result));
}else if($add){
     $query = mysqli_fetch_assoc(mysqli_query($connect,"select * from adverts where user_id= '$user_id' order by id desc limit 1"));
     
    $result->user_id=$user_id;
    $result->success = true;
    $result->advert_id =$query["id"];
    
    echo(json_encode($result));
}else{
     $result->success = false;
    echo(json_encode($result));
}*/

if($add){
    $query = mysqli_fetch_assoc(mysqli_query($connect,"select * from adverts where user_id= '$user_id' order by id desc limit 1"));
     
    $result->user_id=$user_id;
    $result->success = true;
    $result->advert_id =$query["id"];
    
    echo(json_encode($result));
    
}

else{
    $result->success = false;
    echo(json_encode($result));
}



?>