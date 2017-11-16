package com.dvn.backend.testcases;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dvn.backend.dao.UserDAO;
import com.dvn.backend.model.User;

public class UserTestCases {

	
	@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static User user;
	
	@Autowired  static UserDAO  userDAO;
	
	
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dvn.backend");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
		 
	}
	
	
	
	
	

/*
@Test
public void createUserTestCase(){
	
	user.setId("ADMIN");
	
	user.setPassword("ADMIN");
	boolean flag = userDAO.save(user);
	assertEquals("createUserTestCase",true,flag);
}
	*/
	/*
	@Test
	public void getUserTestCase()
	{
		user =  userDAO.get("sourabh");
		
		assertEquals("getUserTestCase", null, user);
		
		
		
	}
	
	
	@Test
	public void getAllUsersTestCase()
	{
		List<User> users=  userDAO.list();
		
		//select count(*) from c_user_detail
		assertEquals("getAllUsersTestCase", 3, users.size());
		
	}
	
	
	
	
	
	
	
	
@Test	
public void UpdateTestCase(){
	user.setId("niithhhh");
	user.setName("AsP");
	user.setAddress("Bolinj nakad");
	user.setPassword("niit");
	user.setRole("Alumni");
	user.setMobile("444444444");
	
	boolean flag = userDAO.save(user);
	
	
	
	assertEquals("UpdateTestCase",true,flag);
	
	
}*/

	/*@Test
public void AuthenticateTestcase()
{

	
	User flag = userDAO.authenticate("SAI", "SAI");
	
	assertEquals("AuthenticateTestcase",null,flag);
	
	
}

@Test
public void ListTestCase(){
	
	int size = userDAO.list().size();
	
	assertEquals("ListTestCase",9,size);
}
*/
/*@Test
public void getUserTestcase(){
	
	user = userDAO.get("SAI");
	
	assertEquals("getUserTestcase",user);
	
}
*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

}
