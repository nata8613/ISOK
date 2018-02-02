package com.PM.PMService;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PM.PMService.models.Policy;

@Service
public class KIEService {

	private final KieContainer kieContainer;

	@Autowired
	public KIEService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Policy getProductDiscount(Policy polisa) {
		//get the stateful session
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(polisa);
		//ako nam treba vise objekata ubacujemo kao kieSession.insert(objekat);
		kieSession.fireAllRules();
		kieSession.dispose();
		return polisa;
	}
}
