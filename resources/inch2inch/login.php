<?php
require 'connection.php';

$data = json_decode($_POST["data"]);

$email = $data->email;
$password = $data->password;

$result = mysqli_query($conn, "SELECT * from user WHERE email = '$email' AND password = '$password'");

if(mysqli_error($conn)){
	echo "{\"error\":\"".mysqli_error($conn)."\"}";
}else{
	$user = array();
	if($result->num_rows > 0){
		while($row = mysqli_fetch_assoc($result)){
			$user = array(
				"id" => $row["id"]
			);
		}
	}
	echo json_encode($user);	
}

$conn->close();
?>