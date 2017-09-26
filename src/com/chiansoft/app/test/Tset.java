package com.chiansoft.app.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chiansoft.app.domain.User;
import com.chinasoft.app.util.HibernateUtil;

public class Tset {
	Session session=null;
	
	@Before
	public void setUp() throws Exception {
		session=HibernateUtil.openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void test() {
		Transaction tran = session.beginTransaction();
//		User user = (User) session.get(User.class, 1);
		 User user = (User) session.load(User.class, 1);
		System.out.println(user.getUsername());
		tran.commit();
	}

}
