package InsurancePOSService.demo;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import InsurancePOSService.demo.annotations.PermissionType;
import InsurancePOSService.demo.models.Permission;
import InsurancePOSService.demo.models.Role;
import InsurancePOSService.demo.models.User;

@Aspect
//Mora @Component anotacija inace nece ucitati askept klasu
@Component
@Configurable
public class PermissionAspect {
	

	@Around("execution(* InsurancePOSService.demo.controllers.*.*(..)) && "
			+ "@annotation(InsurancePOSService.demo.annotations.PermissionType)")
	public Object validator(ProceedingJoinPoint jp){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		//Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		System.out.println("Username je " + SecurityContextHolder.getContext().getAuthentication().getName());
		RestTemplate template = new RestTemplate();
		User u = template.postForObject("http://localhost:8080/dc/user/UserByUsername/", username, User.class);

		if(u != null){
			MethodSignature signature = (MethodSignature) jp.getSignature();
		    Method method = signature.getMethod();
		    PermissionType myAnnotation = method.getAnnotation(PermissionType.class);
			boolean weGood = false;
		    for(Role r : u.getAllowed()){
		    	for(Permission p : r.getPermissions()){
		    		if(myAnnotation.value().equals(p.getNaziv())){
		    			weGood = true;
		    			break;
		    		}
		    	}
		    }
		    Object retVal = null;
		    if(weGood){
				try {
					retVal = jp.proceed();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } else {
		    }
		    return retVal;
		} else {
			return null;
		}
	}  

}
