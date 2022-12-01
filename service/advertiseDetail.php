<?php
include("settings.php");

$advert_id= $_GET["advert_id"];
//$advert_id= "1";

$query = mysqli_query($connect,"select * from adverts where id = '$advert_id'");

$nameQuery = mysqli_query($connect,"SELECT name,surname FROM users INNER JOIN adverts on users.id = adverts.user_id WHERE adverts.id = '$advert_id'");

Class Result{
    
    public $user_id;
    public $advert_title;
    public $explanation;
    public $price;
    public $address;
    
    public $brand;
    public $serial;
    public $model;
    public $year;
    public $fuel;
    
    public $gear;
    public $vehicleStatus;
    public $km;
    public $caseType;
    public $motorPower;
    
    public $motorCapacity;
    public $traction;
    public $color;
    public $guarantee;
    public $swap;
    public $phoneNumber;
    
    public $name;
    public $surname;

}

$result = new Result();

$query2 = mysqli_fetch_assoc($query);
$nameQuery2 = mysqli_fetch_assoc($nameQuery);

$result->user_id = $query2["user_id"];
$result->advert_title = $query2["advert_title"];
$result->explanation = $query2["explanation"];
$result->price = $query2["price"];
$result->address = $query2["address"];

$result->brand = $query2["brand"];
$result->serial = $query2["serial"];
$result->model = $query2["model"];
$result->year = $query2["year"];
$result->fuel = $query2["fuel"];

$result->gear = $query2["gear"];
$result->vehicleStatus = $query2["vehicleStatus"];
$result->km = $query2["km"];
$result->caseType = $query2["caseType"];
$result->motorPower = $query2["motorPower"];

$result->motorCapacity = $query2["motorCapacity"];
$result->traction = $query2["traction"];
$result->color = $query2["color"];
$result->guarantee = $query2["guarantee"];
$result->swap = $query2["swap"];
$result->phoneNumber = $query2["phoneNumber"];

$result->name = $nameQuery2["name"];
$result->surname = $nameQuery2["surname"];



echo(json_encode($result));















