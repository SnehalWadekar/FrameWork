package TestNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	
	@Test(dataProvider = "dataProviderData")
	public void bookTickets(String scr, String des, int NumOfPpl)
	{
		System.out.println("Book ticket from"+scr+"To"+des+" "+NumOfPpl);
	}
	
	@DataProvider
	public Object[][] dataProviderData()
	{
		Object [][] objArr = new Object[2][3];
		objArr[0][0]="Benglore";
		objArr[0][1]="Goa";
		objArr[0][2]=2;
		
		objArr[1][0]="Benglore";
		objArr[1][1]="Mysor";
		objArr[1][2]=3;
		
		return objArr;
	}

}
