package springlogin.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springlogin.entities.AppUser;



@Repository
public interface appUserRepository extends JpaRepository<AppUser, Integer>{
	 @Transactional
	@Modifying(clearAutomatically = true)
	@Query(value ="select * from AppUser where username=:username", nativeQuery = true)
	List<AppUser> findByUsername(@Param("username") String username);
}
