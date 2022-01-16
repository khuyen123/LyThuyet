<?php 
    include('connect.php');
    $sql="select * from taikhoan";
    $mangtk= array();
    $result= mysqli_query($connect,$sql);
    class taikhoan
    {
        function __construct($id,$tendangnhap,$matkhau,$hoten,$ngaysinh,$diachi,$gioitinh,$email,$sdt,$sodu)
        {
            $this->id=$id;
            $this->tendangnhap=$tendangnhap;
            $this->matkhau=$matkhau;
            $this->hoten=$hoten;
            $this->ngaysinh=$ngaysinh;
            $this->diachi=$diachi;
            $this->gioitinh=$gioitinh;
            $this->email=$email;
            $this->sdt=$sdt;
            $this->sodu=$sodu;
        }
    }
    while(($rows=mysqli_fetch_assoc($result))!=null)
    {
        array_push($mangtk,new taikhoan(
           $rows['id'],
           $rows['tendangnhap'],
           $rows['matkhau'],
           $rows['hoten'],
           $rows['ngaysinh'],
           $rows['diachi'],
           $rows['gioitinh'],
           $rows['email'],
           $rows['sdt'],
           $rows['sodu'],
        ));
    }
    echo json_encode($mangtk);
?>