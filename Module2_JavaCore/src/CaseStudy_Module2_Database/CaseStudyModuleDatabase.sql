use furamaresort;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select * 
from nhan_vien 
where  length(nhan_vien.ho_ten) <=15 and
(
  nhan_vien.ho_ten Like "H%" or nhan_vien.ho_ten Like "K%" or nhan_vien.ho_ten Like "T%"
);

-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.

select * from khach_hang
where timestampdiff(year,ngay_sinh,curdate()) >=18 And
			timestampdiff(year,ngay_sinh,curdate()) <= 50
            and ( khach_hang.dia_chi like "Đà nẵng" or khach_hang.dia_chi like "Quảng trị");
            
-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.

select khach_hang.id_khach_hang, khach_hang.ho_ten,loai_khach.ten_loai_khach, count(hop_dong.id_khach_hang) as "SLDP"
from khach_hang , loai_khach, hop_dong
where (khach_hang.id_loai_khach = loai_khach.id_loai_khach and 
hop_dong.id_khach_hang = khach_hang.id_khach_hang and
loai_khach.ten_loai_khach = 'Diamond');

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).

select khach_hang.id_khach_hang,
khach_hang.ho_ten,
loai_khach.ten_loai_khach,
hop_dong.id_hop_dong,
dich_vu.ten_dich_vu,
hop_dong.ngay_lam_hop_dong,
hop_dong.ngay_ket_thuc,dich_vu.chi_phi_thue,dich_vu_di_kem.gia,hop_dong_chi_tiet.so_luong,
(dich_vu.chi_phi_thue + (dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong)) as "tong_tien"

from loai_khach
left join khach_hang on khach_hang.id_loai_khach = loai_khach.id_loai_khach
left join hop_dong on  hop_dong.id_khach_hang = khach_hang.id_khach_hang 
left join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
left join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem ;

-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

SELECT  dv.id_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv 
INNER JOIN loai_dich_vu ldv ON dv.id_loai_dich_vu = ldv.id_loai_dich_vu
WHERE NOT EXISTS
(SELECT hd.id_dich_vu FROM hop_dong hd
WHERE (hd.ngay_lam_hop_dong between "2020-01-01" and "2020-03-31")
AND hd.id_dich_vu = dv.id_dich_vu);

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
select hd.id_hop_dong,nv.ho_ten as ten_nhan_vien,kh.ho_ten as ten_khach_hang,kh.sdt as SoDienThoaiKhachHang,ten_dich_vu,tien_dat_coc,so_luong as SoLuongDichVuDiKem
from (((hop_dong hd join dich_vu dv on hd.id_dich_vu=dv.id_dich_vu) join khach_hang kh on hd.id_khach_hang=kh.id_khach_hang) join nhan_vien nv on hd.id_nhan_vien=nv.id_nhan_vien)join hop_dong_chi_tiet hdct on hdct.id_hop_dong=hd.id_hop_dong
where
    (hd.id_dich_vu in(select id_dich_vu
                from hop_dong
                where month(ngay_lam_hop_dong) in(1,2,3) and year(ngay_lam_hop_dong)=2019))
    and
    (hd.id_dich_vu not in(select id_dich_vu 
                       from hop_dong
					   where month(ngay_lam_hop_dong) in (1,2,3,4,5,6) and year(ngay_lam_hop_dong)=2019)) ;
-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên
 
-- c1:
select distinct  khach_hang.ho_ten
from khach_hang;

-- c2
select distinctrow  khach_hang.ho_ten
from khach_hang;

-- c3 
select khach_hang.ho_ten
from khach_hang
group by ho_ten;
-- 4 
SELECT  khach_hang.ho_ten
FROM khach_hang
UNION
SELECT khach_hang.ho_ten
FROM khach_hang;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
DROP temporary TABLE TEMP;
CREATE TEMPORARY TABLE TEMP
SELECT 1 AS MONTH
UNION
SELECT 2 AS MONTH
UNION
SELECT 3 AS MONTH
UNION
SELECT 4 AS MONTH
UNION
SELECT 5 AS MONTH
UNION
SELECT 6 AS MONTH
UNION
SELECT 7 AS MONTH
UNION
SELECT 8 AS MONTH
UNION
SELECT 9 AS MONTH
UNION
SELECT 10 AS MONTH
UNION
SELECT 11 AS MONTH
UNION
SELECT 12 AS MONTH;
SELECT MONTH, COUNT(hd.id_hop_dong) AS 'Số Khách Hàng Thực Hiện Đặt Phòng', SUM(hd.tong_tien) FROM TEMP
LEFT JOIN  hop_dong hd on month(hd.ngay_lam_hop_dong)= month
AND YEAR(hd.ngay_lam_hop_dong) = 2020
GROUP BY MONTH
ORDER BY MONTH;


-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
SELECT hd.id_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc, COUNT(hdct.id_hop_dong_chi_tiet) AS SoLuongDichVuDiKem
FROM hop_dong hd
LEFT JOIN hop_dong_chi_tiet hdct ON hd.id_hop_dong = hdct.id_hop_dong
GROUP BY hd.id_hop_dong;

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
SELECT dvdk.*
FROM dich_vu_di_kem dvdk
INNER JOIN hop_dong_chi_tiet hdct ON dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
INNER JOIN hop_dong hd ON hd.id_hop_dong = hdct.id_hop_dong
INNER JOIN khach_hang kh ON kh.id_khach_hang = hd.id_khach_hang
INNER JOIN loai_khach lkh ON lkh.id_loai_khach = kh.id_loai_khach
WHERE lkh.ten_loai_khach = 'Diamond'
AND kh.dia_chi in ('Vinh','Quảng ngãi');
-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.


select HD.id_hop_dong, NV.ho_ten 'họ tên nhân viên', KH.ho_ten 'họ tên khách hàng',
 KH.sdt, ten_dich_vu, count(HDCT.id_hop_dong)   as 'số lượng dịch vụ đi kèm',tien_dat_coc
from hop_dong HD
inner join nhan_vien  NV on HD.id_nhan_vien = NV.id_nhan_vien
inner join khach_hang KH on HD.id_khach_hang = KH.id_khach_hang
inner join dich_vu DV on HD.id_dich_vu = DV.id_dich_vu
left join hop_dong_chi_tiet HDCT on HD.id_hop_dong = HDCT.id_hop_dong
where 
year(ngay_lam_hop_dong) =2019
and month(ngay_lam_hop_dong)>9
not in (
select HD.id_hop_dong from hop_dong HD where year(ngay_lam_hop_dong) = 2019 and month(ngay_lam_hop_dong)<7);


-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

CREATE temporary TABLE TEMP2
SELECT dvdk.*, COUNT(hdct.id_dich_vu_di_kem) AS TONG
FROM dich_vu_di_kem dvdk
LEFT JOIN hop_dong_chi_tiet hdct ON hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
OR hdct.id_dich_vu_di_kem IS NULL
GROUP BY dvdk.id_dich_vu_di_kem;

SELECT dvdk.*, COUNT(hdct.id_dich_vu_di_kem) AS TONG
FROM dich_vu_di_kem dvdk
LEFT JOIN hop_dong_chi_tiet hdct ON hdct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
OR hdct.id_dich_vu_di_kem IS NULL
GROUP BY dvdk.id_dich_vu_di_kem
HAVING TONG IN (SELECT MAX(t.TONG) FROM TEMP2 t);



-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.

SELECT hd.id_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, COUNT(hdct.id_dich_vu_di_kem) AS SoLanSuDung
FROM dich_vu_di_kem dvdk
INNER JOIN hop_dong_chi_tiet hdct ON dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
INNER JOIN hop_dong hd ON hd.id_hop_dong = hdct.id_hop_dong
INNER JOIN dich_vu dv ON dv.id_dich_vu  = hd.id_dich_vu 
INNER JOIN loai_dich_vu ldv ON ldv.id_loai_dich_vu = dv.id_loai_dich_vu
GROUP BY dvdk.ten_dich_vu_di_kem
HAVING SoLanSuDung = 1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.


SELECT nv.id_nhan_vien, nv.ho_ten, td.ten_Trinh_do, bp.ten_bo_phan, nv.sdt, nv.dia_chi, COUNT(hd.id_nhan_vien) AS 'Số Hợp Đồng Đã Lập'
FROM nhan_vien nv
INNER JOIN trinh_do td ON nv.id_trinh_do = td.id_trinh_do
INNER JOIN bo_phan bp ON nv.id_bo_phan = bp.id_bo_phan
LEFT JOIN hop_dong hd ON nv.id_nhan_vien = hd.id_nhan_vien
WHERE YEAR(hd.ngay_lam_hop_dong) IN (2018,2019)
OR hd.id_nhan_vien IS NULL
GROUP BY nv.id_nhan_vien
HAVING COUNT(hd.id_nhan_vien) <=3
ORDER BY nv.id_nhan_vien;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.

CREATE TEMPORARY TABLE TEMP3
SELECT nv.id_nhan_vien FROM nhan_vien nv
LEFT JOIN hop_dong hd ON nv.id_nhan_vien = hd.id_nhan_vien
WHERE YEAR(hd.ngay_lam_hop_dong) NOT IN (2017,2018,2019)
OR hd.id_nhan_vien IS NULL
GROUP BY nv.id_nhan_vien;

 DELETE hop_dong_chi_tiet FROM hop_dong_chi_tiet hdct
 WHERE hdct.id_hop_dong NOT IN (SELECT hd.id_hop_dong FROM hop_dong hd WHERE YEAR(hd.ngay_lam_hop_dong) IN (2017,2018,2019));

DELETE FROM hop_dong
WHERE id_nhan_vien IN (SELECT * FROM TEMP3);

DELETE FROM nhan_vien 
WHERE id_nhan_vien IN (SELECT * FROM TEMP3);

-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
SET SQL_SAFE_UPDATES = 0;
UPDATE khach_hang kh
SET kh.id_loai_khach = (SELECT lk.id_loai_khach FROM loai_khach lk WHERE lk.ten_loai_khach = 'Diamond')
WHERE kh.id_loai_khach IN (SELECT hd.id_khach_hang
FROM hop_dong hd
WHERE YEAR(hd.ngay_lam_hop_dong) = 2017
GROUP BY (hd.id_khach_hang)
HAVING SUM(hd.tong_tien) > 1000000);




select * from khach_hang;
select * from hop_dong;

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).

CREATE TEMPORARY TABLE TEMP4
SELECT kh.id_khach_hang FROM khach_hang kh
INNER JOIN hop_dong hd ON kh.id_khach_hang = hd.id_khach_hang
WHERE YEAR(hd.ngay_lam_hop_dong) < 2016
GROUP BY kh.id_khach_hang;

-- lổi tùm lum
-- DELETE hop_dong_chi_tiet FROM hop_dong_chi_tiet hdct
-- WHERE hdct.id_hop_dong IN (SELECT hd.id_hop_dong FROM hop_dong hd WHERE YEAR(hd.ngay_lam_hop_dong) < 2016);


DELETE FROM hop_dong
WHERE id_khach_hang IN (SELECT * FROM TEMP4);

DELETE FROM khach_hang 
WHERE id_khach_hang IN (SELECT * FROM TEMP4);


-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.

SET SQL_SAFE_UPDATES = 0;
UPDATE dich_vu_di_kem dvdk
SET dvdk.gia = dvdk.gia * 2
WHERE dvdk.id_dich_vu_di_kem IN (SELECT hdct.id_dich_vu_di_kem
FROM hop_dong hd
INNER JOIN hop_dong_chi_tiet hdct ON hd.id_hop_dong = hdct.id_hop_dong
WHERE YEAR(hd.ngay_lam_hop_dong) = 2020
GROUP BY hdct.id_dich_vu_di_kem
HAVING COUNT(hdct.id_dich_vu_di_kem) >= 1);

select * from dich_vu_di_kem;


-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.

SELECT id_nhan_vien AS ID, ho_ten, email, sdt, ngay_sinh, dia_chi
FROM nhan_vien
UNION
SELECT id_khach_hang , ho_ten, email, sdt, ngay_sinh, dia_chi
FROM khach_hang;
