<?php
include("settings.php");

$user_id = $_POST["user_id"];
$email = $_POST["email"];
$password = $_POST["password"];
$againPassword = $_POST["againPassword"];
$phoneNumber = $_POST["phoneNumber"];
$city = $_POST["city"];
$district = $_POST["district"];
$neighborhood = $_POST["neighborhood"];

$address = $city.", ".$district.", ".$neighborhood;

/*
$user_id = 5;
$email = "beseta23@gmail.com";
$password = "252525";
$againPassword = "252525";
$phoneNumber = "0553581831011";
$city = "Elazig";
$district = "Merkez";
$neighborhood = "Cayda cira";
$address = $city.", ".$district.", ".$neighborhood;
*/


//todo:Eğer kullanıcı ilan paylaşmamışsa adres ve telefon numarası?




Class Result{
    
    public $emailSuccess;
    public $passwordSuccess;
    public $phoneNumberSuccess;
    public $addressSuccess;
    public $result;
    public $email;
    public $phoneNumber;
    public $address;
}


$result = new Result();


$query = mysqli_query($connect,"SELECT u.email,a.phoneNumber,a.address FROM users as u INNER JOIN adverts as a ON u.id = a.user_id where user_id = '$user_id' limit 1");
$value = mysqli_fetch_assoc($query);


//E-MAIL
$control = mysqli_query($connect,"select * from users where email = '$email'");
$count = mysqli_num_rows($control);
$email = filter_var($email, FILTER_SANITIZE_EMAIL);

if(($count)>0 && $email !=""){
    $result->result = "Bu email adresi kullanilmaktadir";
    $result->emailSuccess=false;
    echo(json_encode($result));
}
else if(!filter_var($email, FILTER_VALIDATE_EMAIL)){         //1
    $result->result = "gecerli bir email giriniz";
    $result->emailSuccess=false;
    echo(json_encode($result));
}else{
    
     $queryEmail = mysqli_query($connect,"update users set email = '$email' where id = '$user_id'");
    
    if($queryEmail){
        
        $result->email = $value["email"];
        $result->result = "Email adresiniz guncellenmistir";
        $result->emailSuccess=true;
        echo(json_encode($result));
    }
   
   
}


//PASSWORD
 if(strlen($password)<6){               //2
    $result->result = "En az 6 karekter";
    $result->passwordSuccess=false;
    json_encode($result);
}else if($password!=$againPassword){
    
    $result->result = "Sifre esit degil";
    $result->passwordSuccess=false;
    json_encode($result);
}else{
    
     $queryPassword = mysqli_query($connect,"update users set password = '$password' where id = '$user_id'");
    
    if($queryPassword){
        $result->password = $value["password"];
        $result->result = "Sifreniz guncellenmistir";
        $result->passwordSuccess=true;
        json_encode($result);
    }

}


//PHONENUMBER

if($phoneNumber == ""){
    $result->result = "Lütfen cep telefonunu girin";
    $result->phoneNumberSuccess=false;
    json_encode($result);
}else{          //3

    $queryPhoneNumber = mysqli_query($connect,"update adverts set phoneNumber = '$phoneNumber' where user_id = '$user_id'");
    
    if($queryPhoneNumber){
        
        $result->phoneNumber = $value["phoneNumber"];
        $result->result = "Telefon numaraniz guncellenmistir";
        $result->phoneNumberSuccess=true;
        json_encode($result);
    }

}


//ADDRESS


if($city == ""){
    $result->result = "Lutfen sehir girin";
    $result->addressSuccess=false;
    json_encode($result);
}
else{           
    //4
   
    $queryAddress = mysqli_query($connect,"update adverts set address = '$address' where user_id = '$user_id'");
    if($queryAddress){
        
        $result->address = $value["address"];
        $result->result = "Adresiniz guncellenmistir";
        $result->addressSuccess=true;
    
        json_encode($result);
    }

}




/*
$result->email = $value["email"];
$result->address = $value["address"];
$result->phoneNumber = $value["phoneNumber"];
$result->success=true;
echo(json_encode($result));

*/




































?>