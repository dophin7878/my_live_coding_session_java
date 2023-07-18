package stepDefinition;
 
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import com.fasterxml.jackson.annotation.JsonFormat;



import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.springframework.http.HttpHeaders;
import java.util.*;

public class Smoke { 


   private String addURI;
   private ResponseEntity response;
   private ResponseEntity<String> responseCreateEmployee;
   
   @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
   private Date dateOfBirth=null;
private String responseGetEmployee;
   
   

   
   /**
    * get employees
    */
   @Given("^I Set GETemployees endpoint$")
   public void setGetEmployeesEndpoint(){
       addURI = "http://localhost:8080/employees";
 
   }   
   
   @When("^I want to retrieve a list of employees$")
   public void listEmployees() throws Throwable {
	   RestTemplate restTemplate = new RestTemplate ();
	   response = restTemplate.getForEntity("http://localhost:8080/employees", String.class, String.class);
   }
   
   @Then("^the server should handle it and return a list of employees$")
   public void verifyGetEmployees() throws Throwable {
	   int statusCode = response.getStatusCodeValue();
	   
	    Assert.assertEquals(statusCode,200);
	     
   }

   /**
    * get employee.
    */
   @Given("^I Set GETemployee endpoint$")
   public void setGetEmployeeEndpoint(){
       addURI = "http://localhost:8080/employee";
 
   }
   
   @When("^I want to retrieve a defined '(.+)' employee$")
   public void getEmployee(String arg1) throws Throwable {
	  
	   Map<String, String> vars = new HashMap<>();
	   vars.put("id", arg1);
	   RestTemplate restTemplate = new RestTemplate ();

	   responseGetEmployee = restTemplate.getForObject("http://localhost:8080/employee/{id}", 
	       String.class, vars);

   }

   @Then("^the server should handle it and return an employee$")
   public void verifyGetEmployee() throws Throwable {
	   Assert.assertNotNull(responseGetEmployee);
   }
   
   
  
   @When("^I want to create an employee$")
   public void createEmployee() throws Throwable {
	 HttpHeaders headers = new HttpHeaders();
	 String nameEmployee = "Test2";
     int idEmployee = 1110;
     
	 headers.setContentType(MediaType.APPLICATION_JSON);
     
     String jsonBody="{\"nameEmployee\":\""+nameEmployee+"\",\"idEmployee\":\""+idEmployee+"\",\"birthDate\":\""+dateOfBirth+"\"}";
    
     HttpEntity<String> request = new HttpEntity<String>(jsonBody, headers);
     RestTemplate restTemplate = new RestTemplate ();
     responseCreateEmployee =     
     restTemplate.exchange("http://localhost:8080/employee/", HttpMethod.POST, request, String.class);
    
   }
   
 
   
 
   
   
   
   
  
}