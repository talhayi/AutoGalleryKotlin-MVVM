<?php
include("settings.php");

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require "PHPMailer/src/Exception.php";
require "PHPMailer/src/PHPMailer.php";
require "PHPMailer/src/SMTP.php";

$email= $_POST["email"];
$code = rand(100000,1000000);
$active = 0;

class Result{
    public $success;
    public $code;
}

$result=new Result();

$control = mysqli_query($connect,"select * from users where email = '$email'");
$count = mysqli_num_rows($control);



if(($count)>0){
    
        $add = mysqli_query($connect,"insert into reset_passwords(users_email, active, code) values('$email','$active','$code')");
        
        //$result->result = "E mail gönderildi";
        $result->success=true;
        $result->code=$code;
        $result->email=$email;
        echo(json_encode($result));
        
                    
        $mail = new PHPMailer();
        
        $mail -> isSMTP();
        $mail -> Host = "ni-tidy.guzelhosting.com";
        $mail -> SMTPAuth = true;
        $mail -> Username = "otogaleri@yazilimgunlukleri.com";
        $mail -> Password = "VaasMontenegro71?";
        $mail -> Port = 587;//tls or ssl-> 465
        $mail -> SMTPSecure = "tls";
     
        $mail -> smtpConnect([
            'ssl' =>[
                'verify_peer' => false,
                'verify_peer_name' => false,
                'allow_self_signed' => true
                ]
            ]);
       
        $mail -> isHTML(true);
        $mail -> setFrom("otogaleri@yazilimgunlukleri.com","Oto Galeri");
        $mail -> addAddress($email);
        $mail -> CharSet = 'UTF-8';
        $mail -> Subject = "Şifre Yenileme";
     	$mail -> Body = ("Şifrenizi yenilemek için <br> Doğrulama kodu = $code");

	    if($mail->send()) {
	         $result->result = "E mail gönderildi";
             json_encode("Mail gönderildi");
        }
        else {
             json_encode("Mail gönderilirken bir hata oluştu: " . $mail->ErrorInfo);
        }
    
}
else if($email==""){
    $result->success=false;
    $result->result = "Lütfen e mail adresinizi giriniz";
    echo(json_encode($result));
}
else{
    $result->success=false;
    $result->result = "Lütfen kayıtlı e mail adresinizi giriniz";
    echo(json_encode($result));
}
























?>