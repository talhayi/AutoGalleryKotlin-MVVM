<?php
include("settings.php");

$user_id = $_GET["user_id"];
//$user_id = 3;
//todo: resim yüklenmediğinde ilanlarım listesinde gözükmüyor
$query = mysqli_query($connect,"SELECT fa.*,ai.image_path,a.advert_title,a.price,a.address from adverts as a inner join favorite_adverts as fa
ON a.user_id = fa.user_id and a.id = fa.advert_id INNER JOIN advert_images as ai ON ai.id = ( select ai1.id from advert_images as ai1 where 
fa.advert_id = ai1.advert_id limit 1 ) where fa.user_id ='$user_id'");

Class Result{
    
    public $advert_id;
    public $user_id;
    public $price;
    public $image;
    public $advert_title;
    public $address;
    public $success;
    public $result;
    public $count;
}

$result = new Result();

$count = mysqli_num_rows($query);

if($count>0){
    $counter = 0;
    echo("[");
    
    while($value = mysqli_fetch_assoc($query)){
        
        $counter=$counter+1;
        
        //$result->advert_id = $value["advert_id"]; bi ara bunu dene
        
        $result->advert_id = $value["advert_id"];
        $result->user_id = $user_id;
        $result->price = $value["price"];
        $result->image = $value["image_path"];
        $result->address = $value["address"];
        $result->advert_title = $value["advert_title"];
        $result->success = true;
        $result->result ="Ilan Var";
        $result->count = $count;
        echo(json_encode($result));
        if(($count)>$counter){
            echo(",");
        }
    }
     echo("]");
}

else{
    
    echo("[");
    
    $result->success = false;
    $result->result = "Ilan Yok";
    echo(json_encode($result));
    
     echo("]");
}

?>