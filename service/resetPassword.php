<?php
include("settings.php");

$email = $_POST["email"];
$newPassword = $_POST["password"];

class Result{

    public $success;
    public $result;

}

$result=new Result();

$control = mysqli_query($connect,"select * from users where email = '$email'");
$count = mysqli_num_rows($control);


if($count>0 && strlen($newPassword)>5){
    
    
    $control2 = mysqli_query($connect,"update users set password = '$newPassword' where email = '$email'");
    $result->success=true;
    echo(json_encode($result));   
    
}
else if(strlen($newPassword)<6){
    
    $result->result = "En az 6 karekter";
    $result->success=false;
    echo(json_encode($result));   
     
}
else{
    
    $result->success=false;
    echo(json_encode($result));   
     
}





?>