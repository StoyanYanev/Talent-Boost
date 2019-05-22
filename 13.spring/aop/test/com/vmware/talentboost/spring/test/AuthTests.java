package com.vmware.talentboost.spring.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vmware.talentboost.spring.data.UnauthorizedException;
import com.vmware.talentboost.spring.data.UserAccount;
import com.vmware.talentboost.spring.impl.AccountManager;

public class AuthTests {
	
	@Autowired
	private AccountManager accountManager;

	@Before
	public void setUp(){
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/vmware/talentboost/spring/test/test-config.xml");
		accountManager = (AccountManager) context.getBean("accountManagerTestBean");
	}
	
	@Test
	public void testAuthenticatePositive() {
		try {
			String username = "tanya";
			UserAccount user = accountManager.authenticate(username);
			assertNotNull(user);
			assertNotNull(user.username);
			assertEquals("tanya", user.username);
			assertNotNull(user.role);
			assertEquals("player", user.role);
			
		} catch (UnauthorizedException e) {
			fail("Exception should have been thrown!");
		}
	}

	// Task 0: Add the new required jars to the project build path // if not already added
	//
	// Task 1(optional): Add a negative test.
	//			- Add a test for a negative scenario (eg. someone else tries to play)
	//			- Re-run the tests.
	//			tip: Find a way to assure if the correct exception is thrown.
	// Task 2: Use spring instead of manual set up.
	//			- Add appropriate annotations to the test class.
	//			- Remove the manual set up.
	//			- Re-run the tests.
}
