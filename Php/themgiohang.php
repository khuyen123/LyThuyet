<?php 
    include('connect.php');
    $tensanpham=$_POST['tensanpham'];
    $mota=$_POST['mota'];
    $dongia=$_POST['dongia'];
    $soluong=1;
    $sql="insert into giohang (id,tensanpham,mota,soluong,dongia) values('','{$tensanpham}','{$mota}','{$soluong}','{$dongia}')";
    $mangtk= array();
    $result= mysqli_query($connect,$sql);
    if($result)
    echo "sucsess"; else
    echo "fail";
?>