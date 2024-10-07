package Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertMethod {
	@Test
	public void m1()
	{
		int act=10;
		int exp=20;
		Assert.assertEquals(act, exp);
		System.out.println("Assertion Excetuted");
	}
	@Test
	public void m2()
	{
		int act=10;
		int exp=10;
		Assert.assertEquals(act, exp, "Execution Fail");
		System.out.println("Assertion Excetuted");
	}
	
	@Test
	public void m3()
	{
		int act=10;
		int exp=20;
		Assert.assertNotSame(act, exp, "It is equal");
		System.out.println("Not equal");
	}
	

	@Test
	public void m4()
	{
		String s = "Hello";
		Assert.assertTrue(s.contains("is"),"false=");
		System.out.println("True");
	}
	
	@Test
	public void m5()
	{
		String s="Hello";
		String SS="Hell";
		Assert.assertTrue(s.equalsIgnoreCase(SS), "False==");
		System.out.println("AssertPass");
	}
	
	@Test
	public void m6()
	{
		int act = 10;
		int exp = 0;
		Assert.assertSame(act,exp,"Not Same");
		System.out.println("Same");
		}
	
	@Test
	public void m7()
	{
		String s="Hi";
//		Assert.assertNull(s, "not null");
//		System.out.println("it is null");
		Assert.fail("i am failing");
		
		}

}
