<?php
require 'connection.php';
$customerId = $_GET["customerId"];
$result = mysqli_query($conn, "SELECT * from customer where id = ".$customerId);
$customer =  null;
if(mysqli_error($conn)){
	echo "{\"error\":\"".mysqli_error($conn)."\"}";
}else{
	if($result->num_rows > 0){
		while($row = mysqli_fetch_assoc($result)){
			$customer = array(
				"id" => $row["id"],
				"name" => $row["name"],
				"mobile" => $row["mobile"],
				"email" => $row["email"],
				"address" => $row["address"],
				"chest" => $row["chest"],
				"neck" => $row["neck"],
				"waist" => $row["waist"],
				"pant_length" => $row["pant_length"],
				"sleave_length" => $row["sleave_length"],
				"shirt_length" => $row["shirt_length"],
				
			);

		}
	}
	echo json_encode($customer);	
}

$conn->close();
?>