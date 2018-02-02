package com.PaymentHandler.PaymentHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentHandlerApplication.class, args);
		
		    //for localhost testing only
		    javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
		    new javax.net.ssl.HostnameVerifier(){

		        public boolean verify(String hostname,
		                javax.net.ssl.SSLSession sslSession) {
		            if (hostname.equals("192.168.1.16")) {
		                return true;
		            }
		            return false;
		        }
		    });
		

	}
}
