package InsurancePOSService.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.IDToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
//Mora @Component anotacija inace nece ucitati askept klasu
@Component
@Configurable
public class PermissionAspect {
	
	/*@Autowired
	private AccessToken token;
	*/
	@Around("execution(* InsurancePOSService.demo.controllers.*.*(..)) && "
			+ "@annotation(InsurancePOSService.demo.annotations.PermissionType)")
	public Object validator(ProceedingJoinPoint jp){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		//Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		System.out.println("Username je " + SecurityContextHolder.getContext().getAuthentication().getName());
		Object retVal = null;
		try {
			retVal = jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retVal;
		 //ArrayList<String> r = new ArrayList<String>();
		// r.addAll(roles);
		/*if(u != null){
			MethodSignature signature = (MethodSignature) jp.getSignature();
		    Method method = signature.getMethod();
		    PermissionType myAnnotation = method.getAnnotation(PermissionType.class);
			boolean weGood = false;
		    for(Role r : u.getRoles()){
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
		}*/
	}  

}
