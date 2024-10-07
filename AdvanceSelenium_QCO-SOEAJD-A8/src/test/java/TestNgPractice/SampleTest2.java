package TestNgPractice;

import org.testng.annotations.Test;

public class SampleTest2 {
	
	@Test(invocationCount =2)
	public void createContact()
	{
		System.out.println("contact created");
	}
	
	@Test(enabled= false)
	public void modifyContact()
	{
		System.out.println("contact modified");
	}
	
	@Test(dependsOnMethods = "createContact")
	public void deletedContact()
	{
		System.out.println("contact delated");
	}

}
