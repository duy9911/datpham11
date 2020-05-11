package springlogin.Repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springlogin.entities.lienhe;

@Repository
public interface lienheRepository extends JpaRepository<lienhe, Integer>{
	 @Transactional
	@Modifying(clearAutomatically = true)
	@Query(value ="INSERT INTO contact (hoten ,diachi, dienthoai, email, mucdichgui, ngay, noidung, tieudegui) VALUES (:hoten, :diachi, :dienthoai, :email, :mucdichgui, :ngay, :noidung, :tieudegui)", nativeQuery = true)
	void savelienhe(@Param("hoten") String hoten, @Param("diachi") String diachi, @Param("dienthoai") String dienthoai, @Param("email") String email, @Param("mucdichgui") String mucdichgui, @Param("ngay") String ngay, @Param("noidung") String noidung, @Param("tieudegui") String tieudegui);

	@Query(value = "select * from contact where ngay = :ngay", nativeQuery = true)
	List<lienhe> searchLienHe(@Param("ngay") String ngay);
}
