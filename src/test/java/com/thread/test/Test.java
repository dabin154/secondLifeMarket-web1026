package com.thread.test;
import com.secondLifeMarket.general.admin.manage.impl.DataServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class Test {

    @Autowired
    private DataServiceImpl dataService;
    
	public static void main(String[] args) {
//		String a = "121212";
//		if(true){
//			String b=a;
//			System.out.println(b);
//		}
	}
	
	@org.junit.Test
	public void testDataService() {
	    String a = "121212";
	    if(true){
          String b=a;
          System.out.println(b);
      }
	}

}
