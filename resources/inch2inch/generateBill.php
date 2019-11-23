<?php
require 'connection.php';

$data = json_decode($_POST["data"]);

$amount = $data->amount;
$bill_date = $data->bill_date;
$deliver_date = $data->deliver_date;
$customer_id = $data->customer_id;
$fabric_id = $data->fabric_id;

$query = "INSERT INTO bill_detail(amount,bill_date,deliver_date,customer_id,fabric_id) values()";

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