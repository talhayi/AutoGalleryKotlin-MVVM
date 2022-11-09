
<?php


include("settings.php");

use PHPMailer\PHPMailer\PHPMailer;
use PHPMailer\PHPMailer\Exception;

require "PHPMailer/src/Exception.php";
require "PHPMailer/src/PHPMailer.php";
require "PHPMailer/src/SMTP.php";


$name = $_POST["name"];
$surname = $_POST["surname"];
$email = $_POST["email"];
$password = $_POST["password"];
$code = rand(100000,1000000);
$active = 0;

//$mpassword = md5($password);

Class Result{
    public $result;
    public $tf;
    public $code;
    public $name;
    public $surname;
    public $email;
    public $password;
}

$result = new Result();

$control = mysqli_query($connect,"select * from users where email = '$email'");
$count = mysqli_num_rows($control);

$email = filter_var($email, FILTER_SANITIZE_EMAIL);


if(($count)>0 && $email !=""){
    $result->result = "Boyle Bir Kayit Var";
    $result->tf=false;
    echo(json_encode($result));
}
else if($name == ""){
    $result->result = "isim boş bırakılamaz";
    $result->tf=false;
    echo(json_encode($result));
}
else if($surname == ""){
    $result->result = "Soyisim boş bırakılamaz";
    $result->tf=false;
    echo(json_encode($result));
}
else if(!filter_var($email, FILTER_VALIDATE_EMAIL)){
    $result->result = "geçerli bir email giriniz";
    $result->tf=false;
    echo(json_encode($result));
}
else if(strlen($password)<6){
    $result->result = "En az 6 karekter";
    $result->tf=false;
    echo(json_encode($result));
}


else{
    $add = mysqli_query($connect,"insert into users(name, surname, email, password, active, code) values('$name','$surname','$email','$password','$active','$code')");
    
    if($add){
        
        $result->result = "Kayit Basarili";
        $result->tf=true;
        $result->code=$code;
        $result->name=$name;
        $result->surname=$surname;
        $result->email=$email;
        $result->password=$password;
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
        $mail -> Subject = "Emaili doğrulamanız gerekiyor";
     	$mail -> Body = ("Merhaba aşağıdaki doğrulama kodu ile uygulamaya giriş yapabilirsiniz. <br> Doğrulama kodu = $code");

	    if($mail->send()) {
             json_encode("Mail gönderildi");
        }
        else {
             json_encode("Mail gönderilirken bir hata oluştu: " . $mail->ErrorInfo);
        }

    }


}

?>


