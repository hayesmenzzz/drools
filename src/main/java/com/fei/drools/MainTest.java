package com.fei.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.fei.drools.bean.Message;
import com.fei.drools.bean.PointDomain;

public class MainTest {

	public static void main(String[] args) {
		hello();
//		point();
	}
	
	public static void hello(){
		
		// load up the knowledge base
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		
		Message message = new Message();
		message.setMsg("Hello World");
		message.setStatus(Message.HELLO);
		
		kSession.insert(message);
        kSession.fireAllRules();
        kSession.dispose();
	}
	
	public static void point(){
		// load up the knowledge base
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession kSession = kContainer.newKieSession("ksession-rules");
		
		PointDomain pointDomain = new PointDomain();
		pointDomain.setUserName("ko");
		pointDomain.setBillThisMonth(3);
		pointDomain.setBackMondy(100d);
		pointDomain.setBuyMoney(500d);
		pointDomain.setBackNums(1);
		pointDomain.setBuyNums(5);
		pointDomain.setBirthDay(true);
		pointDomain.setPoint(0l);

		// go !
		kSession.insert(pointDomain);
		kSession.fireAllRules();
		System.out.println("积分 ："+pointDomain.getPoint());
	}
}
