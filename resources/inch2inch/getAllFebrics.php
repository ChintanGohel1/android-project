<?php
require 'connection.php';

$result = mysqli_query($conn, "SELECT * from fabric");

if(mysqli_error($conn)){
	echo "{\"error\":\"".mysqli_error($conn)."\"}";
}else{
	$fabrics["fabrics"] = array();
	if($result->num_rows > 0){
		while($row = mysqli_fetch_assoc($result)){
			$fabric = array(
				"id" => $row["id"],
				"image_path" => $row["image_path"],
				"fabric_type" => $row["fabric_type"],
				"price" => $row["price"]
			);

			array_push($fabrics["fabrics"], $fabric);
		}
	}
	echo json_encode($fabrics);	
}

$conn->close();
?>