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
   private String responseGetUser;
   private ResponseEntity<String> responseCreateUser;
   
   @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
   private Date dateOfBirth=null;
   
   

   
   /**
    * get users
    */
   @Given("^I Set GET employees service api endpoint$")
   public void setGetUsersEndpoint(){
       addURI = "http://localhost:8080/employees/";
 
   }   
   
   @When("^you want to retrieve a list of users$")
   public void listUsers() throws Throwable {
      //llamada get
	   RestTemplate restTemplate = new RestTemplate ();
	   response = restTemplate.getForEntity("http://localhost:8080/employees/", String.class, String.class);
   }
   
   @Then("^the server should handle it and return a list of users$")
   public void verifyGetUsers() throws Throwable {
	   int statusCode = response.getStatusCodeValue();
	   
	    Assert.assertEquals(statusCode,200);
	     
   }

   /**
    * get user.
    */
   @Given("^I Set GET employee service api endpoint$")
   public void setGetUserEndpoint(){
       addURI = "http://localhost:8080/employee";
 
   }
   
   @When("^you want to retrieve a defined '(.+)' user$")
   public void getUser(String arg1) throws Throwable {
	  
	   Map<String, String> vars = new HashMap<>();
	   vars.put("id", arg1);
	   RestTemplate restTemplate = new RestTemplate ();

	   responseGetUser = restTemplate.getForObject("http://localhost:8080/employee/{id}", 
	       String.class, vars);
//	   System.out.println(responseGetUser);
   }

   @Then("^the server should handle it and return a user$")
   public void verifyGetUser() throws Throwable {
	   Assert.assertNotNull(responseGetUser);
   }
   
   
   @Given("^I Set POST employee service api endpoint$")
   public void setCreateUserEndpoint(){
       addURI = "http://localhost:8080/employee";
   }
   
   @When("^you want to create an user$")
   public void createUser() throws Throwable {
	 HttpHeaders headers = new HttpHeaders();
	 String nameEmployee = "Test2";
     int idEmployee = 1110;
     
	 headers.setContentType(MediaType.APPLICATION_JSON);
     
     String jsonBody="{\"nameEmployee\":\""+nameEmployee+"\",\"idEmployee\":\""+idEmployee+"\",\"birthDate\":\""+dateOfBirth+"\"}";
    
     HttpEntity<String> request = new HttpEntity<String>(jsonBody, headers);
     RestTemplate restTemplate = new RestTemplate ();
     responseCreateUser =     
     restTemplate.exchange("http://localhost:8080/employee", HttpMethod.POST, request, String.class);
    
   }
   
   @Then("^the user is created in the database$")
   public void assertCreateUser() throws Throwable {
	   Assert.assertNotNull(responseCreateUser);
   }
   
   
 
   
   
   
   
  
}