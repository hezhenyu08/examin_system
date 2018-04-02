package user_test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.soa.dao.IndexDAO;


public class IndexDAOTest{
	private IndexDAO id;
	@Before
	public void init() {
		String conf="conf/spring-mybatis.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		id=ac.getBean("indexDAO",IndexDAO.class);
	}
	
	@Test
	public void findUserModule() {
		List<Map<String, Object>> modules = id.findUserModule("4d74e918-a9de-43bf-bd41-d896a1d536af");
		for (Map<String, Object> map : modules) {
			System.out.println(map);
		}
	}
}
