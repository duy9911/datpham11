package springlogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springlogin.entities.AppUser;



@Repository
public interface appUserRepository extends JpaRepository<AppUser, Integer>{

}
