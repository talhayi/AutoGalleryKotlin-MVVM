<?php
include("settings.php");
/*
$user_id = $_POST["user_id"];
$email = $_POST["email"];
$password = $_POST["password"];
$again_password = $_POST["again_password"];
$phoneNumber = $_POST["phoneNumber"];
$city = $_POST["city"];
$district = $_POST["district"];
$neighborhood = $_POST["neighborhood"];
*/

$user_id = 5;
$email = 25;
$password = "252525";
$again_password = "25252";
$phoneNumber = 25;
$city = 25;
$district = 25;
$neighborhood = 25;

//todo:Eğer kullanıcı ilan paylaşmamışsa adres ve telefon numarası?

$query = mysqli_query($connect,"SELECT u.email,a.phoneNumber,a.address FROM users as u INNER JOIN adverts as a ON u.id = a.user_id where user_id =$user_id limit 1");


Class Result{
    
    public $success;
    public $email;
    public $password;
    public $phoneNumber;
    public $address;
}


$result = new Result();

$value = mysqli_fetch_assoc($query);



//E-MAIL
$control = mysqli_query($connect,"select * from users where email = '$email'");
$count = mysqli_num_rows($control);
$email = filter_var($email, FILTER_SANITIZE_EMAIL);

if(($count)>0 && $email !=""){
    $result->result = "Bu email adresi kullanılmaktadır";
    $result->success=false;
    echo(json_encode($result));
}
else if(!filter_var($email, FILTER_VALIDATE_EMAIL)){
    $result->result = "geçerli bir email giriniz";
    $result->success=false;
    echo(json_encode($result));
}else{
    $queryEmail = mysqli_query($connect,"update users set email = $email where id = $user_id");
    $result->email = $value["email"];
    $result->result = "Email adresiniz güncellenmiştir";
    $result->success=true;
    echo(json_encode($result));
}

//PASSWORD
 if(strlen($password)<6){
    $result->result = "En az 6 karekter";
    $result->success=false;
    echo(json_encode($result));
}else if($password!=$again_password){
    
    $result->result = "Şifre eşit değil";
    $result->success=false;
    echo(json_encode($result));
}else{
    
    $queryPassword = mysqli_query($connect,"update users set password = $password where id = $user_id");
    $result->result = "Şifreniz güncellenmiştir";
    $result->success=true;
    echo(json_encode($result));
}

//PHONENUMBER

if($phoneNumber == ""){
    $result->result = "Lütfen cep telefonunu girin";
    $result->success=false;
    echo(json_encode($result));
}else{
    $queryPhoneNumber = mysqli_query($connect,"update adverts set phoneNumber = $phoneNumber where user_id = $user_id");
    $result->phoneNumber = $value["phoneNumber"];
    $result->result = "Telefon numaranız güncellenmiştir";
    $result->success=true;
    echo(json_encode($result));
}

//ADDRESS

if($city == ""){
    $result->result = "Lütfen şehir girin";
    $result->success=false;
    echo(json_encode($result));
}else{
    $queryAddress = mysqli_query($connect,"update adverts set address = $city. ', ' .$district. ', ' .$neighborhood where user_id = $user_id");
    $result->address = $value["address"];
    $result->result = "Adresiniz güncellenmiştir";
    $result->success=true;
    echo(json_encode($result));
}





/*
$result->email = $value["email"];
$result->address = $value["address"];
$result->phoneNumber = $value["phoneNumber"];
$result->success=true;
echo(json_encode($result));

*/




































?>