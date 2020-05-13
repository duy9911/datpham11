package springlogin.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springlogin.entities.UserRole1;
@Repository
public interface UserRoleRepository1 extends JpaRepository<UserRole1, Integer>{
	 @Transactional
	@Modifying(clearAutomatically = true)
	@Query(value ="delete from user_role WHERE user_id = :user_id", nativeQuery = true)
	public void deleteByUserId(@Param("user_id") Integer user_id);
}
