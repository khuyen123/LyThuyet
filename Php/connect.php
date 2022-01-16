<?php
   $username = "root"; // Khai báo username
   $password = "";      // Khai báo password
   $server   = "localhost";   // Khai báo server
   $dbname   = "ltdd";      // Khai báo database
   
   // Kết nối database 
   $connect = new mysqli($server, $username, $password, $dbname);
   
   //Nếu kết nối bị lỗi thì xuất báo lỗi và thoát.
   if ($connect->connect_error) {
	   die("Không kết nối :" . $conn->connect_error);
	   exit();
   }
?> 