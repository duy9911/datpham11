package springlogin.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springlogin.entities.account;

@Repository
public interface accountRepository extends JpaRepository<account, Integer>{
	 @Transactional
	@Modifying(clearAutomatically = true)
	@Query(value ="select * from app_user where user_name=:user_name", nativeQuery = true)
	List<account> findByUsername(@Param("user_name") String user_name);
}
