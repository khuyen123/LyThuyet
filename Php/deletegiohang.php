<?php 
    include('connect.php');
    $sql="delete  from giohang";
    $mangtk= array();
    $result= mysqli_query($connect,$sql);
    if($result)
    echo "sucsess"; else
    echo "fail";
?>