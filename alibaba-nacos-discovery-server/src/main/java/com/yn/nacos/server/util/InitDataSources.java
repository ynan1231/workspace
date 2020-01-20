package com.yn.nacos.server.util;

//import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
//@Component
public class InitDataSources implements InitializingBean {

	public void afterPropertiesSet() throws Exception {
//		JAXPConfigurator.configure( InitDataSources.class.getClassLoader().getResource("config/proxool.xml").getPath(), false);
		
	}
	public static void main(String[] args) {
		System.out.println(InitDataSources.class.getClassLoader().getResource("config/proxool.xml").getPath());
	}

}
