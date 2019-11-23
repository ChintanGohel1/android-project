<?php
require 'connection.php';

$data = json_decode($_POST["data"]);

$name = $data->name;
$mobile = $data->mobile;
$email = $data->email;
$address = $data->address;
$neck = $data->neck;
$chest = $data->chest;
$waist = $data->waist;
$pant_length = $data->pant_length;
$shirt_length = $data->shirt_length;
$sleave_length = $data->sleave_length;

$query = "INSERT INTO customer(name,mobile, email, address, neck, chest, waist, pant_length,shirt_length,sleave_length)" 
					."values('$name','$mobile', '$email', '$address', '$neck', '$chest', '$waist','$pant_length','$shirt_length','$sleave_length')";


if(mysqli_query($conn, $query)){
		echo "ok";
}else{
	if(mysqli_error($conn)){
		echo "{\"error\":\"".mysqli_error($conn)."\"}";
	}else{
		echo "error";
	}
}

$conn->close();
?>