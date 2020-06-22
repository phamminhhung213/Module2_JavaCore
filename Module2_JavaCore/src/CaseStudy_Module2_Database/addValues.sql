drop database if exists furamaresort;
create database furamaresort;
use furamaresort;
CREATE TABLE trinh_do (
  id_trinh_do varchar(10) NOT NULL,
  ten_trinh_do varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_trinh_do)
);
CREATE TABLE vi_tri (
  id_vi_tri varchar(10) NOT NULL,
  ten_vi_tri varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_vi_tri)
);
CREATE TABLE bo_phan (
  id_bo_phan varchar(10) NOT NULL,
  ten_bo_phan varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_bo_phan)
);
CREATE TABLE nhan_vien (
  id_nhan_vien varchar(10) NOT NULL,
  ho_ten varchar(45) DEFAULT NULL,
  id_vi_tri varchar(10) NOT NULL,
  id_trinh_do varchar(10) NOT NULL,
  id_bo_phan varchar(10) NOT NULL,
  ngay_sinh date DEFAULT NULL,
  socmnd varchar(10) DEFAULT NULL,
  luong int DEFAULT NULL,
  sdt varchar(11) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  dia_chi varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_nhan_vien),
  KEY id_vi_tri (id_vi_tri),
  KEY id_trinh_do (id_trinh_do),
  KEY id_bo_phan (id_bo_phan),
  CONSTRAINT nhanvien_fk_1 FOREIGN KEY (id_vi_tri) REFERENCES vi_tri (id_vi_tri),
  CONSTRAINT nhanvien_fk_2 FOREIGN KEY (id_trinh_do) REFERENCES trinh_do (id_trinh_do),
  CONSTRAINT nhanvien_fk_3 FOREIGN KEY (id_bo_phan) REFERENCES bo_phan (id_bo_phan)
);


CREATE TABLE loai_khach (
  id_loai_khach varchar(10) NOT NULL,
  ten_loai_khach varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_loai_khach)
);
CREATE TABLE khach_hang (
  id_khach_hang varchar(10) NOT NULL,
  id_loai_khach varchar(10) NOT NULL,
  ho_ten varchar(45) DEFAULT NULL,
  ngay_sinh date DEFAULT NULL,
  so_cmnd varchar(45) DEFAULT NULL,
  sdt varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  dia_chi varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_khach_hang),
  KEY id_loai_khach (id_loai_khach),
  CONSTRAINT khachhang_fk_1 FOREIGN KEY (id_loai_khach) REFERENCES loai_khach (id_loai_khach)
); 

CREATE TABLE kieu_thue (
  id_kieu_thue varchar(10) NOT NULL,
  ten_kieu_thue varchar(45) DEFAULT NULL,
  gia int DEFAULT NULL,
  PRIMARY KEY (id_kieu_thue)
); 
CREATE TABLE loai_dich_vu (
  id_loai_dich_vu varchar(10) NOT NULL,
  ten_loai_dich_vu varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_loai_dich_vu)
);

CREATE TABLE dich_vu (
  id_dich_vu varchar(10) NOT NULL,
  ten_dich_vu varchar(45) DEFAULT NULL,
  dien_tich int DEFAULT NULL,
  so_tang int DEFAULT NULL,
  so_nguoi_toi_da varchar(45) DEFAULT NULL,
  chi_phi_thue int DEFAULT NULL,
  id_kieu_thue varchar(10) NOT NULL,
  id_loai_dich_vu varchar(10) NOT NULL,
  trang_thai varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_dich_vu),
  KEY id_kieu_thue (id_kieu_thue),
  KEY id_loai_dich_vu (id_loai_dich_vu),
  CONSTRAINT dichvu_fk_1 FOREIGN KEY (id_kieu_thue) REFERENCES kieu_thue (id_kieu_thue),
  CONSTRAINT dichvu_fk_2 FOREIGN KEY (id_loai_dich_vu) REFERENCES loai_dich_vu (id_loai_dich_vu)
);

CREATE TABLE hop_dong (
  id_hop_dong varchar(10) NOT NULL,
  id_nhan_vien varchar(10) NOT NULL,
  id_khach_hang varchar(10) NOT NULL,
  id_dich_vu varchar(10) NOT NULL,
  ngay_lam_hop_dong date DEFAULT NULL,
  ngay_ket_thuc date DEFAULT NULL,
  tien_dat_coc int DEFAULT NULL,
  tong_tien int DEFAULT NULL,
  PRIMARY KEY (id_hop_dong),
  KEY id_nhan_vien (id_nhan_vien),
  KEY id_khach_hang (id_khach_hang),
  KEY id_dich_vu (id_dich_vu),
  CONSTRAINT hopdong_fk_1 FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien (id_nhan_vien),
  CONSTRAINT hopdong_fk_2 FOREIGN KEY (id_khach_hang) REFERENCES khach_hang (id_khach_hang),
  CONSTRAINT hopdong_fk_3 FOREIGN KEY (id_dich_vu) REFERENCES dich_vu (id_dich_vu)
); 

CREATE TABLE dich_vu_di_kem (
  id_dich_vu_di_kem varchar(10) NOT NULL,
  ten_dich_vu_di_kem varchar(45) DEFAULT NULL,
  gia int DEFAULT NULL,
  don_vi int DEFAULT NULL,
  trang_thai_kha_dung varchar(45) DEFAULT NULL,
  PRIMARY KEY (id_dich_vu_di_kem)
); 

CREATE TABLE hop_dong_chi_tiet (
  id_hop_dong_chi_tiet varchar(10) NOT NULL,
  id_hop_dong varchar(10) not null,
  id_dich_vu_di_kem varchar(10) NOT NULL,
  so_luong int NOT NULL,
  PRIMARY KEY (id_hop_dong_chi_tiet),
  KEY id_dich_vu_di_kem (id_dich_vu_di_kem),
  KEY  id_hop_dong (id_hop_dong),
  CONSTRAINT hopdongchitiet_fk_1 FOREIGN KEY (id_dich_vu_di_kem) REFERENCES dich_vu_di_kem (id_dich_vu_di_kem),
  CONSTRAINT hopdongchitiet_fk_2 FOREIGN KEY (id_hop_dong) REFERENCES hop_dong (id_hop_dong)
);


-- nhập liệu bảng trình độ 

INSERT INTO trinh_do (id_trinh_do,ten_trinh_do)
VALUES ("IDTD1","Tên trình độ 1");

INSERT INTO trinh_do (id_trinh_do,ten_trinh_do)
VALUES ("IDTD2","Tên trình độ 2");

INSERT INTO trinh_do (id_trinh_do,ten_trinh_do)
VALUES ("IDTD3","Tên trình độ 3");

INSERT INTO trinh_do (id_trinh_do,ten_trinh_do)
VALUES ("IDTD4","Tên trình độ 4");

INSERT INTO trinh_do (id_trinh_do,ten_trinh_do)
VALUES ("IDTD5","Tên trình độ 5");

-- nhập liệu bảng vị trí

INSERT INTO vi_tri (id_vi_tri,ten_vi_tri)
VALUES ("IDVT1","Tên vị trí 1");

INSERT INTO vi_tri (id_vi_tri,ten_vi_tri)
VALUES ("IDVT2","Tên vị trí 2");

INSERT INTO vi_tri (id_vi_tri,ten_vi_tri)
VALUES ("IDVT3","Tên vị trí 3");

INSERT INTO vi_tri (id_vi_tri,ten_vi_tri)
VALUES ("IDVT4","Tên vị trí 4");

INSERT INTO vi_tri (id_vi_tri,ten_vi_tri)
VALUES ("IDVT5","Tên vị trí 5");

-- nhập liệu bảng bộ phận

INSERT INTO bo_phan (id_bo_phan,ten_bo_phan)
VALUES ("IDBP1","Tên bộ phận 1");

INSERT INTO bo_phan (id_bo_phan,ten_bo_phan)
VALUES ("IDBP2","Tên bộ phận 2");

INSERT INTO bo_phan (id_bo_phan,ten_bo_phan)
VALUES ("IDBP3","Tên bộ phận 3");

INSERT INTO bo_phan (id_bo_phan,ten_bo_phan)
VALUES ("IDBP4","Tên bộ phận 4");

INSERT INTO bo_phan (id_bo_phan,ten_bo_phan)
VALUES ("IDBP5","Tên bộ phận 5");

-- nhập liệu bảng nhân viên
INSERT INTO nhan_vien (
id_nhan_vien,ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,socmnd,luong,sdt,email,dia_chi)
VALUES ("IDNV1","H NV 1","IDVT1","IDTD1","IDBP1","1991-01-01",100000001,10000000,"0906000001","Email NV 1","Địa chỉ NV 1");

INSERT INTO nhan_vien (
id_nhan_vien,ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,socmnd,luong,sdt,email,dia_chi)
VALUES ("IDNV2","K NV 2","IDVT2","IDTD2","IDBP2","1992-02-02",100000002,20000000,"0906000002","Email NV 2","Địa chỉ NV 2");

INSERT INTO nhan_vien (
id_nhan_vien,ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,socmnd,luong,sdt,email,dia_chi)
VALUES ("IDNV3","T NV 3","IDVT3","IDTD3","IDBP3","1993-03-03",100000003,30000000,"0906000003","Email NV 3","Địa chỉ NV 3");

INSERT INTO nhan_vien (
id_nhan_vien,ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,socmnd,luong,sdt,email,dia_chi)
VALUES ("IDNV4","NV 4","IDVT4","IDTD4","IDBP4","1994-04-04",100000004,40000000,"0906000004","Email NV 4","Địa chỉ NV 4");

INSERT INTO nhan_vien (
id_nhan_vien,ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,socmnd,luong,sdt,email,dia_chi)
VALUES ("IDNV5","NV 5","IDVT5","IDTD5","IDBP5","1995-05-05",100000005,50000000,"0906000005","Email NV 5","Địa chỉ NV 5");




-- nhập liệu loại khách

INSERT INTO loai_khach (
id_loai_khach,ten_loai_khach
)
VALUES ("IDLK1","Diamond");

INSERT INTO loai_khach (
id_loai_khach,ten_loai_khach
)
VALUES ("IDLK2","Platinium");


INSERT INTO loai_khach (
id_loai_khach,ten_loai_khach
)
VALUES ("IDLK3","Gold");

INSERT INTO loai_khach (
id_loai_khach,ten_loai_khach
)
VALUES ("IDLK4","Silver");

INSERT INTO loai_khach (
id_loai_khach,ten_loai_khach
)
VALUES ("IDLK5","Member");

-- nhập liệu khách hàng 
INSERT INTO khach_hang (
  id_khach_hang ,id_loai_khach,ho_ten,ngay_sinh,so_cmnd ,sdt ,email ,dia_chi
)
VALUES ("IDKH1","IDLK1","Họ tên KH 1","1996-06-06","1234567891","0123456781","Email KH 1","Vinh");

INSERT INTO khach_hang (
  id_khach_hang ,id_loai_khach,ho_ten,ngay_sinh,so_cmnd ,sdt ,email ,dia_chi
)
VALUES ("IDKH2","IDLK2","Họ tên KH 2","1997-07-07","1234567892","0123456782","Email KH 2","Quãng trị");

INSERT INTO khach_hang (
  id_khach_hang ,id_loai_khach,ho_ten,ngay_sinh,so_cmnd ,sdt ,email ,dia_chi
)
VALUES ("IDKH3","IDLK3","Họ tên KH 3","1998-08-08","1234567893","0123456783","Email KH 3","Đà nẵng");


INSERT INTO khach_hang (
  id_khach_hang ,id_loai_khach,ho_ten,ngay_sinh,so_cmnd ,sdt ,email ,dia_chi
)
VALUES ("IDKH4","IDLK4","Họ tên KH 4","1999-09-09","1234567894","0123456784","Email KH 4","Quãng ngãi");


INSERT INTO khach_hang (
  id_khach_hang ,id_loai_khach,ho_ten,ngay_sinh,so_cmnd ,sdt ,email ,dia_chi
)
VALUES ("IDKH5","IDLK5","Họ tên KH 5","2000-10-10","1234567895","0123456785","Email KH 5","Địa chỉ KH 5");

-- nhập liệu kiểu thuê
INSERT INTO kieu_thue (
  id_kieu_thue ,
  ten_kieu_thue,
  gia 
  )
VALUES ("IDKT1","Tên KT 1",10000);

INSERT INTO kieu_thue (
  id_kieu_thue ,
  ten_kieu_thue,
  gia 
  )
VALUES ("IDKT2","Tên KT 2",20000);

INSERT INTO kieu_thue (
  id_kieu_thue ,
  ten_kieu_thue,
  gia 
  )
VALUES ("IDKT3","Tên KT 3",30000);

INSERT INTO kieu_thue (
  id_kieu_thue ,
  ten_kieu_thue,
  gia 
  )
VALUES ("IDKT4","Tên KT 4",40000);

INSERT INTO kieu_thue (
  id_kieu_thue ,
  ten_kieu_thue,
  gia 
  )
VALUES ("IDKT5","Tên KT 5",50000);

 -- nhập liệu loại dịch vụ 
 INSERT INTO loai_dich_vu (
  id_loai_dich_vu ,
  ten_loai_dich_vu 
  )
VALUES ("IDLDV1","Tên LDV 1");

INSERT INTO loai_dich_vu (
  id_loai_dich_vu ,
  ten_loai_dich_vu 
  )
VALUES ("IDLDV2","Tên LDV 2");

INSERT INTO loai_dich_vu (
  id_loai_dich_vu ,
  ten_loai_dich_vu 
  )
VALUES ("IDLDV3","Tên LDV 3");

INSERT INTO loai_dich_vu (
  id_loai_dich_vu ,
  ten_loai_dich_vu 
  )
VALUES ("IDLDV4","Tên LDV 4");

INSERT INTO loai_dich_vu (
  id_loai_dich_vu ,
  ten_loai_dich_vu 
  )
VALUES ("IDLDV5","Tên LDV 5");

-- nhập liệu dịch vụ 

INSERT INTO dich_vu (
	id_dich_vu ,
  ten_dich_vu ,
  dien_tich ,
  so_tang ,
  so_nguoi_toi_da ,
  chi_phi_thue ,
  id_kieu_thue,
  id_loai_dich_vu,
  trang_thai
  )
VALUES ("IDDV1","Tên DV 1",10,10,"SNTD 1",500,"IDKT1","IDLDV1","Trạng thái DV 1");

INSERT INTO dich_vu (
	id_dich_vu ,
  ten_dich_vu ,
  dien_tich ,
  so_tang ,
  so_nguoi_toi_da ,
  chi_phi_thue ,
  id_kieu_thue,
  id_loai_dich_vu,
  trang_thai
  )
VALUES ("IDDV2","Tên DV 2",20,20,"SNTD 2",600,"IDKT2","IDLDV2","Trạng thái DV 2");

INSERT INTO dich_vu (
	id_dich_vu ,
  ten_dich_vu ,
  dien_tich ,
  so_tang ,
  so_nguoi_toi_da ,
  chi_phi_thue ,
  id_kieu_thue,
  id_loai_dich_vu,
  trang_thai
  )
VALUES ("IDDV3","Tên DV 3",30,30,"SNTD 3",700,"IDKT3","IDLDV3","Trạng thái DV 3");

INSERT INTO dich_vu (
	id_dich_vu ,
  ten_dich_vu ,
  dien_tich ,
  so_tang ,
  so_nguoi_toi_da ,
  chi_phi_thue ,
  id_kieu_thue,
  id_loai_dich_vu,
  trang_thai
  )
VALUES ("IDDV4","Tên DV 4",40,40,"SNTD 4",800,"IDKT4","IDLDV4","Trạng thái DV 4");

INSERT INTO dich_vu (
	id_dich_vu ,
  ten_dich_vu ,
  dien_tich ,
  so_tang ,
  so_nguoi_toi_da ,
  chi_phi_thue ,
  id_kieu_thue,
  id_loai_dich_vu,
  trang_thai
  )
VALUES ("IDDV5","Tên DV 5",50,50,"SNTD 5",900,"IDKT5","IDLDV5","Trạng thái DV 5");

-- nhập liệu hợp đồng 
INSERT INTO hop_dong (
  id_hop_dong,
  id_nhan_vien, 
  id_khach_hang,
  id_dich_vu,
  ngay_lam_hop_dong, 
  ngay_ket_thuc, 
  tien_dat_coc, 
  tong_tien 
  )
VALUES ("IDHD1","IDNV1","IDKH1","IDDV1","2020/01/01","2030/01/01",500000,100000000);

INSERT INTO hop_dong (
  id_hop_dong,
  id_nhan_vien, 
  id_khach_hang,
  id_dich_vu,
  ngay_lam_hop_dong, 
  ngay_ket_thuc, 
  tien_dat_coc, 
  tong_tien 
  )
VALUES ("IDHD2","IDNV2","IDKH2","IDDV2","2020/02/02","2030/02/02",200000,200000000);

INSERT INTO hop_dong (
  id_hop_dong,
  id_nhan_vien, 
  id_khach_hang,
  id_dich_vu,
  ngay_lam_hop_dong, 
  ngay_ket_thuc, 
  tien_dat_coc, 
  tong_tien 
  )
VALUES ("IDHD3","IDNV3","IDKH3","IDDV3","2017/03/03","2030/03/03",300000,300000000);

INSERT INTO hop_dong (
  id_hop_dong,
  id_nhan_vien, 
  id_khach_hang,
  id_dich_vu,
  ngay_lam_hop_dong, 
  ngay_ket_thuc, 
  tien_dat_coc, 
  tong_tien 
  )
VALUES ("IDHD4","IDNV4","IDKH4","IDDV4","2018/04/04","2030/04/04",400000,400000000);

INSERT INTO hop_dong (
  id_hop_dong,
  id_nhan_vien, 
  id_khach_hang,
  id_dich_vu,
  ngay_lam_hop_dong, 
  ngay_ket_thuc, 
  tien_dat_coc, 
  tong_tien 
  )
VALUES ("IDHD5","IDNV5","IDKH5","IDDV5","2019/02/05","2030/05/05",600000,500000000);

-- nhập liệu bảng dịch vụ đi kèm 
INSERT INTO dich_vu_di_kem (
id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung
)
VALUES ("IDDVDK1","Tên DVDK 1",1000,1000,"Trạng thái khả dụng 1");

INSERT INTO dich_vu_di_kem (
id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung
)
VALUES ("IDDVDK2","Tên DVDK 2",2000,2000,"Trạng thái khả dụng 1");

INSERT INTO dich_vu_di_kem (
id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung
)
VALUES ("IDDVDK3","Tên DVDK 3",3000,3000,"Trạng thái khả dụng 3");

INSERT INTO dich_vu_di_kem (
id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung
)
VALUES ("IDDVDK4","Tên DVDK 4",4000,4000,"Trạng thái khả dụng 4");

INSERT INTO dich_vu_di_kem (
id_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung
)
VALUES ("IDDVDK5","Tên DVDK 5",5000,5000,"Trạng thái khả dụng 5");


-- nhập liệu hợp đồng chi tiết

INSERT INTO hop_dong_chi_tiet (
id_hop_dong_chi_tiet,id_hop_dong,id_dich_vu_di_kem,so_luong
)
VALUES ("IDHDCT1","IDHD1","IDDVDK1",1);

INSERT INTO hop_dong_chi_tiet (
id_hop_dong_chi_tiet,id_hop_dong,id_dich_vu_di_kem,so_luong
)
VALUES ("IDHDCT2","IDHD2","IDDVDK2",2);

INSERT INTO hop_dong_chi_tiet (
id_hop_dong_chi_tiet,id_hop_dong,id_dich_vu_di_kem,so_luong
)
VALUES ("IDHDCT3","IDHD3","IDDVDK3",3);

INSERT INTO hop_dong_chi_tiet (
id_hop_dong_chi_tiet,id_hop_dong,id_dich_vu_di_kem,so_luong
)
VALUES ("IDHDCT4","IDHD4","IDDVDK4",4);

INSERT INTO hop_dong_chi_tiet (
id_hop_dong_chi_tiet,id_hop_dong,id_dich_vu_di_kem,so_luong
)
VALUES ("IDHDCT5","IDHD5","IDDVDK5",5);



											-- CASESTUDY MODULE2 DATABASSE




