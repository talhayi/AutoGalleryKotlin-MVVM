<?php
include("settings.php");

$user_id = $_GET["user_id"];
//$user_id = "3";


$query = mysqli_query($connect,"SELECT u.name,u.surname, u.email,a.address,a.phoneNumber FROM users as u INNER JOIN adverts as a ON u.id = a.user_id WHERE u.id = '$user_id' LIMIT 1");

Class Result{
    
    public $name;
    public $surname;
    public $email;
    public $phoneNumber;
    public $address;
    
}

$result = new Result();
$value = mysqli_fetch_assoc($query);

$result->name = $value["name"];
$result->surname = $value["surname"];
$result->email = $value["email"];
$result->phoneNumber = $value["phoneNumber"];
$result->address = $value["address"];

echo(json_encode($result));


?>