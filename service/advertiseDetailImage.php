 <?php
include("settings.php");

$advert_id= $_GET["advert_id"];
//$advert_id="13";
$query = mysqli_query($connect,"select * from advert_images where advert_id = '$advert_id'");

Class Result{
    
    public $image;
  
}

$result = new Result();

$count = mysqli_num_rows($query);

    $counter = 0;
    echo("[");
    
    while($value = mysqli_fetch_assoc($query)){
        
        $counter=$counter+1;
        
        $result->image = $value["image_path"];
       
        echo(json_encode($result));
        if(($count)>$counter){
            echo(",");
        }
    }
     echo("]");

?>