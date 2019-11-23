<?php
require 'connection.php';
$fabricId = $_GET["fabricId"];
$result = mysqli_query($conn, "SELECT * from fabric where id = $fabricId");
$fabric = null;
if(mysqli_error($conn)){
	echo "{\"error\":\"".mysqli_error($conn)."\"}";
}else{
	if($result->num_rows > 0){
		while($row = mysqli_fetch_assoc($result)){
			$fabric = array(
				"id" => $row["id"],
				"image_path" => $row["image_path"],
				"fabric_type" => $row["fabric_type"],
				"price" => $row["price"]
			);

		}
	}
	echo json_encode($fabric);	
}

$conn->close();
?>