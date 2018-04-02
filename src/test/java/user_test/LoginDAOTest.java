package user_test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soa.dao.LoginDAO;


public class LoginDAOTest{
	private LoginDAO ld;
	@Before
	public void init() {
		String conf="conf/spring-mybatis.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		ld=ac.getBean("loginDAO",LoginDAO.class);
	}
	
	@Test
	public void findUserPassWordByName() {
	
	}
}
