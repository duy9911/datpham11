package springlogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springlogin.entities.UserRole;



@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
	@Query(value ="select * from UserRole where userID=?1", nativeQuery = true)
	UserRole findByUserId(Integer id);
}
