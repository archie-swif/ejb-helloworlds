package com.ryabokon.helloworld;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeanTest {

	private static EJBContainer ejbContainer;
	private static Context ctx;

	private static HelloBean helloBean;

	@BeforeClass
	public static void setUpClass() throws Exception {

		ejbContainer = EJBContainer.createEJBContainer();
		ctx = ejbContainer.getContext();
		helloBean = (HelloBean) ctx.lookup("java:global/classes/HelloBean");
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		ejbContainer.close();
	}

	@Test
	public void testIsExistHelloBean() throws NamingException {
		Assert.assertNotNull(helloBean);
		String hello = helloBean.hello();

		Assert.assertNotNull(hello);
		Assert.assertTrue(hello.contains("Hello"));
	}
}
