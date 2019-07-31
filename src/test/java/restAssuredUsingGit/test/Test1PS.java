package restAssuredUsingGit.test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test1PS {
	
	
    //GETCall   //To get all employees detail
	@Test(priority=3)
	public void  testAllEmployees()
	{
		RequestSpecification resp = RestAssured.given();
	    Response getData=resp.get("http://localhost:7200/topics");
		
		String AllEmployeedata =getData.asString();
		System.out.println("Data is"+AllEmployeedata);
		
		int statuscode=getData.statusCode();
		System.out.println("Status code is "+statuscode);
	
	}
	
	//GetCall //To get specific employee detail
	@Test(priority=4) 
	public void testSpecificEmployee()
	{
		RequestSpecification resp =RestAssured.given();
        Response getData=resp.get("http://localhost:7200/topics/01");
		
		String SpecificEmployeedata =getData.asString();
		System.out.println("Data is"+SpecificEmployeedata);
		
		int statuscode=getData.statusCode();
		System.out.println("Status code is "+statuscode); 
	}
	
	//PostCall   //Creating an employee
	@Test(priority=1)
	public void testCreatingNewEmployee()
	{
		RequestSpecification resp =RestAssured.given();
        resp.header("Content-Type","application/json");
        
        JSONObject json = new JSONObject();
        json.put("id", "04");
        json.put("name", "venkatesh04");
        
        resp.body(json.toJSONString());
        Response getData=resp.post("http://localhost:7200/topic");
        int statusCode =getData.statusCode();
        System.out.println("Status code is "+statusCode); 
	}
	
	//PutCall   //Updating an employee
	@Test(priority=2)
	public void testUpdatingAnEmployee()
	{
		RequestSpecification resp =RestAssured.given();
        resp.header("Content-Type","application/json");
        
        JSONObject json = new JSONObject();
        json.put("id", "03");
        json.put("name", "venkatesh03modified");
        
        resp.body(json.toJSONString());
        Response getData=resp.put("http://localhost:7200/topic/03");
        int statusCode =getData.statusCode();
        System.out.println("Status code is "+statusCode);  
	}
	
//	    //DeleteCall   //Deleting an employee
//		@Test(priority=5)
//		public void testDeletingAnEmployee()
//		{
//			RequestSpecification resp =RestAssured.given();
//	        Response getData=resp.delete("http://localhost:7000/topic/01");
//	        int statusCode =getData.statusCode();
//	        System.out.println("Status code is "+statusCode);  
//		}
	
	
	

}
