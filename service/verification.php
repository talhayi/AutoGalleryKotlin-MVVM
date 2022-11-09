<?php
include("settings.php");

$email = $_POST["email"];
$code = $_POST["code"];

Class Result{
    public $result;
    public $tf;
    public $id;
    public $email;
}
$result = new Result();

$control = mysqli_query($connect,"select* from users where email = '$email' and code = '$code' and active = '0'");

if(mysqli_num_rows($control)>0){
    
    $update = mysqli_query($connect,"update users set active = '1' where email = '$email' and code = '$code'");
    $a = mysqli_fetch_assoc($control);
    if($update){
        $result->result = "Emailiniz Adresiniz Dogrulandi";
        $result->tf=true;
        $result->id =$a["id"];
        $result->email =$a["email"];
        
        echo(json_encode($result));
    }
}else{
    
        $result->result = "Emailiniz Adresiniz Dogrulanmadi";
        $result->tf=false;
        $result->id =null;
        $result->email =null;
        echo(json_encode($result));
}

?>