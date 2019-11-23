<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "inch2inchdb";
$port = 3307;

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname,$port);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>