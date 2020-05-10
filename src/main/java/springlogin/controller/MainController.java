package springlogin.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springlogin.entities.UserRole;

import springlogin.utils.EncryedPasswordUtils;
import springlogin.sevice.TrainerAccountService;

import javassist.expr.NewArray;
import springlogin.Repository.UserRoleRepository;
import springlogin.Repository.accountRepository;
import springlogin.Repository.appRole;
import springlogin.Repository.appUserRepository;
import springlogin.Repository.duantrienkhaiRepository;
import springlogin.Repository.lienheRepository;
import springlogin.entities.AppRole;
import springlogin.entities.AppUser;
import springlogin.entities.account;
import springlogin.entities.duantrienkhai;
import springlogin.entities.lienhe;
import springlogin.sercurity.EncrytedPasswordUtils;
import springlogin.utils.WebUtils;



 
@Controller
public class MainController {
	@Autowired
	private duantrienkhaiRepository duantrienkhaiRepository;
	@Autowired
	private lienheRepository LienheRepository;
	@Autowired
	private appUserRepository AppUserRepository;
	@Autowired
	private accountRepository AccountRepository;
	@Autowired
	private UserRoleRepository userRoleRepository;
	

	

	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String welcomePage() {
        return "index";
    }
 
 // da fix
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "login";
    }
    
	@RequestMapping("/dichvu/{dichvu}")
	public String dichvu(@PathVariable String dichvu, Model model)
	{
		model.addAttribute("dichvu", dichvu);
		return "dichvu";
	}
	@RequestMapping("duantrienkhai")
	public String duantrienkhai(Model model) {
		List<duantrienkhai> duantrienkhai = duantrienkhaiRepository.findAll();
		model.addAttribute("Duantrienkhai", duantrienkhai);
		return "duantrienkhai";
	}
	@RequestMapping("vechungtoi")
	public String vechungtoi(Model model) {
		return "vechungtoi";
	}
    @RequestMapping("thungo")
    public String thungo(Model model) {
    	return "thungo";
    }
    @RequestMapping("gioithieu")
    public String gioithieu(Model model) {
    	return "gioithieu";
    }
    @RequestMapping("sodocongty")
    public String sodocongty(Model model) {
    	return "sodocongty";
    }
    @RequestMapping("tamnhinsumenh")
    public String tamnhinsumenh(Model model) {
    	return "tamnhinsumenh";
    }
    @RequestMapping("lienhe")
    public String lienhe(Model model){
    	model.addAttribute("lienhe", new springlogin.entities.lienhe());

    	return "lienhe";
    }
    @RequestMapping("addLienhe")
    public String addLienhe(@ModelAttribute("lienhe") springlogin.entities.lienhe Lienhe, Model model){
    	LienheRepository.save(Lienhe);
    	return "lienhe";
    	
    }
    //admin
    @RequestMapping("manageDuantrienkhai")
    public String manageDuantrienkhai(Model model) {
		List<duantrienkhai> duantrienkhai = duantrienkhaiRepository.findAll();
		model.addAttribute("Duantrienkhai", duantrienkhai);
		return "admin/duantrienkhai";
		
	}
    @RequestMapping("/viewUpdateDuan/{id}")
	public String viewUpdateDuan(@PathVariable int id, Model model) {
		Optional<duantrienkhai> duantrienkhai = duantrienkhaiRepository.findById(id);
		if (duantrienkhai.isPresent()) {
			model.addAttribute("Duantrienkhai",  duantrienkhai.get());
		}
		return "admin/updateduantrienkhai";
	}
    @RequestMapping("updateDuan")
    public String updateDuan(@ModelAttribute("duantrienkhai") duantrienkhai Duantrienkhai, Model model) {
    	duantrienkhaiRepository.save(Duantrienkhai);
		List<duantrienkhai> duantrienkhai = duantrienkhaiRepository.findAll();
		model.addAttribute("Duantrienkhai", duantrienkhai);
		return "admin/duantrienkhai";
    	
    }
    @RequestMapping("/viewAddDuAn")
    public String addDuAn(Model model) {
    	model.addAttribute("Duantrienkhai", new duantrienkhai());
    	return "admin/addduan";
    }
    @RequestMapping("addDuAn")
    public String addDuAn(@ModelAttribute("duantrienkhai") duantrienkhai Duantrienkhai, Model model) {
    	duantrienkhaiRepository.save(Duantrienkhai);
		List<duantrienkhai> duantrienkhai = duantrienkhaiRepository.findAll();
		model.addAttribute("Duantrienkhai", duantrienkhai);
		return "admin/duantrienkhai";
    	
    }
    @RequestMapping("/deleteDuAn/{id}")
    public String deleteDuAn(@PathVariable int id, Model model) {
    	duantrienkhaiRepository.deleteById(id);
		List<duantrienkhai> duantrienkhai = duantrienkhaiRepository.findAll();
		model.addAttribute("Duantrienkhai", duantrienkhai);
		return "admin/duantrienkhai";
    	
    }
    @RequestMapping("manageLienHe", produces=" application/x-www-form-urlencoded;charset-UTF-8")
    public String manageLienHe(Model model){
		List<lienhe> lienhe = LienheRepository.findAll();
		model.addAttribute("Lienhe", lienhe);
		return "admin/lienhe";
    }
    @RequestMapping("manageAccount")
    public String manageAccount(Model model) {
		List<account> account = AccountRepository.findAll();
		model.addAttribute("Account", account);
		return "admin/selectaccount";
    }
    @RequestMapping("viewAddAccount")
    public String viewAddAccount(Model model) {
    	model.addAttribute("Account", new account());
    	return "admin/addaccount";
    }
    // add cần phải sửa
    @RequestMapping("/addAccount")
    public ModelAndView addAccount(@ModelAttribute("account") account Account, Model model) {
    	ModelAndView modelAndView=new ModelAndView();
   		Account.setEncryted_Password(EncrytedPasswordUtils.encrytePassword(Account.getEncryted_Password()));
   		Account = AccountRepository.save(Account);
   		AppUser appUser= new AppUser();
   		appUser.setUserId((long) Account.getUser_id());
   		
   		AppRole appRole = new AppRole();
   		appRole.setRoleId((long) 1);
 
		UserRole userRole=new UserRole();
		userRole.setAppUser(appUser);
		userRole.setAppRole(appRole);
		userRoleRepository.save(userRole);
		
		
   		
		  modelAndView.addObject("Account",AccountRepository.findAll());
          modelAndView.setViewName("admin/selectaccount");
          return modelAndView;
    }
    @RequestMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable int id, Model model) {
    	AccountRepository.deleteById(id);
   		List<account> account = AccountRepository.findAll();
		model.addAttribute("Account", account);
		return "admin/selectaccount";
    	
    }
    @RequestMapping("/viewUpdateAccount/{id}")
    public String viewUpdateAccount(@PathVariable int id, Model model) {
		Optional<account> account = AccountRepository.findById(id);
		if (account.isPresent()) {
			model.addAttribute("Account",  account.get());
		}
		return "admin/updateaccount";
    }
    @RequestMapping("/updateAccount")
    public String updateAccount(@ModelAttribute("account") account Account, Model model, AppUser appUser) {
   		Account.setEncryted_Password(EncrytedPasswordUtils.encrytePassword(Account.getEncryted_Password()));
   		AccountRepository.save(Account);
   		List<account> account = AccountRepository.findAll();
		model.addAttribute("Account", account);
		return "admin/selectaccount";
    }
    
    
    
    
    @RequestMapping("admin")
    public String admin() {
    	return "admin/admin";
    }
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "index";
    }
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
 
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
 
            String userInfo = WebUtils.toString(loginedUser);
 
            model.addAttribute("userInfo", userInfo);
 
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
 
        }
 
        return "403Page";
    }
 
}