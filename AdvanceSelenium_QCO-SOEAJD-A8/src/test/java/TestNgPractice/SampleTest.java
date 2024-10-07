package TestNgPractice;

import org.testng.annotations.Test;

public class SampleTest {
	
	@Test(priority=-1)
	public void createContact()
	{
		System.out.println("contact created");
	}
	
	@Test(priority=1)
	public void modifyContact()
	{
		System.out.println("contact modified");
	}
	
	@Test(priority=0)
	public void deletedContact()
	{
		System.out.println("contact delated");
	}

}
