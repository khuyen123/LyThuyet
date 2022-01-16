<?php 
    include('connect.php');
    $sql="select * from giohang";
    $mangtk= array();
    $result= mysqli_query($connect,$sql);
    class giohang
    {
        function __construct($id,$tensanpham,$mota,$soluong,$dongia)
        {
            $this->tensanpham=$tensanpham;
            $this->mota=$mota;
            $this->soluong=$soluong;
            $this->dongia=$dongia;
            $this->id=$id;
        }
    }
    while(($rows=mysqli_fetch_assoc($result))!=null)
    {
        array_push($mangtk,new giohang(
            $rows['id'],
            $rows['tensanpham'],
           $rows['mota'],
           $rows['soluong'],
           $rows['dongia']
           
        ));
    }
    echo json_encode($mangtk);
?>