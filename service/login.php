<?php
include ("settings.php");

$email = $_POST["email"];
$password = $_POST["password"];

Class User{
    
    public $id;
    public $email;
    public $result;
   
}

$user = new User();
$control= mysqli_fetch_assoc(mysqli_query($connect,"select * from users where email ='$email' and password ='$password' and active = '1'"));

$emailControl = mysqli_query($connect,"select * from users where email ='$email'and password ='$password'");
$count = mysqli_num_rows($emailControl);

$emailVerificationControl = mysqli_query($connect,"select * from users where email ='$email' and password ='$password' and active = '0'");
$count2 = mysqli_num_rows($emailVerificationControl);
if($email == ""){
    $user->result = "email boş bırakılamaz";
    echo(json_encode($user));
}
else if($password ==""){
    $user->result = "Şifre boş bırakılamaz";
    echo(json_encode($user));
}
else if(($count)<1){
    $user->result = "email veya şifre hatalıdır";
    echo(json_encode($user));
}
else if($count2>0){
    $user->result = "Lütfen emailinizi doğrulayın";
    echo(json_encode($user));
}
else{
    $user->id=$control["id"];
    $user->email=$control["email"];
    echo (json_encode($user));
}



?>