package springlogin.sevice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springlogin.utils.EncryedPasswordUtils;

import springlogin.Repository.RoleRepository;
import springlogin.Repository.accountRepository;
import springlogin.Repository.appRole;
import springlogin.Repository.appUserRepository;
import springlogin.entities.AppUser;
import springlogin.entities.UserRole;
import springlogin.sercurity.EncrytedPasswordUtils;
import springlogin.entities.AppRole;


@Service
public class TrainerAccountService {
	private accountRepository AccountRepository;
	private appUserRepository AppUserRepository;
	private appRole AppRole;
	
	@Autowired
	public TrainerAccountService(accountRepository AccountRepository,appUserRepository AppUserRepository,
			RoleRepository roleRepository) {
		this.AppUserRepository=AppUserRepository;
		this.AccountRepository=AccountRepository;
		this.AppRole=AppRole;
	}
	
	public AppUser saveTrainerAccount(AppUser appUser) {
		appUser.setEncrytedPassword(EncrytedPasswordUtils.encrytePassword(appUser.getEncrytedPassword()));
		return AppUserRepository.save(appUser);
	}
	

}
