<?php
include("settings.php");


$code = $_POST["code"];

Class Result{
    
    public $result;
    public $success;
    public $code;

}
$result = new Result();

$control = mysqli_query($connect, "select* from reset_passwords where code = '$code' and active = '0'");
   

if(mysqli_num_rows($control)>0){
    
    $update = mysqli_query($connect,"update reset_passwords set active = '1' where code = '$code'");
   
    if($update){
        
        $result->result = "basarili";
        $result->success=true;
        $result->code = $code;
        
        echo(json_encode($result));
    }
    else{
        
        $result->result = "Doğrulama kodu hatalıdır";
        $result->success=false;
        echo(json_encode($result));
    }
   
}
else if($code ==""){
    $result->result = "Lütfen doğrulama kodunu giriniz";
    $result->success=false;
    echo(json_encode($result));
}
else{
    
    $result->result = "Hatalı kod girdiniz";
    $result->success=false;
    echo(json_encode($result));
}

?>