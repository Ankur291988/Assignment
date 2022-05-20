package org.cigniti;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;



public class E2ETest {
	static Random random = new Random();
    public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
    	 
       RestAssured.baseURI = "https://api.thecatapi.com/v1";
       RequestSpecification request = RestAssured.given().log().all();
       
       request.header("x-api-key", "DEMO-API-KEY");     

       Response response = request.get("/votes");
              
        //Verify 200 response status code
        Assert.assertEquals(response.getStatusCode(), 200);
        
        String jsonString = response.asString();
        List<Map<String, String>> id = JsonPath.from(jsonString).get("id");
        
        //length of the response result is more than 0.
        Assert.assertTrue(id.size() > 0);     
        
      
       
        
        //proper object to unmarshal the result in it.
        Gson gson = new GsonBuilder().create();
        
        Type ResTest = new TypeToken<ArrayList<ResponsePayload>>(){}.getType();
        //ResponseTest[] obj = gson.fromJson(response.asString(), ResponseTest[].class);
        List<ResponsePayload> obj = gson.fromJson(response.asString(), ResTest);
        
        System.out.println(obj.get(0).getId());   
        
        for (ResponsePayload itr : obj) {
            System.out.println("Val of id is: " + itr.getId());
            }
        
        
      //From the object stored at previous point get a random element using it to GET /votes/{​​​id}​​​.       
        int x = random.nextInt(15);   
        System.out.println(x); 
        int newID = obj.get(x).getId(); 
        //response = request.get("/votes/31098");
        
        response = request.get("/votes/"+newID);
        
                
       // Verify 200 response status code
        Assert.assertEquals(response.getStatusCode(), 200);
        
        JsonPath eve = response.jsonPath();
        int fetchid = eve.get("id");
        
        //Verifying fetched ID against the response ID
        Assert.assertEquals(fetchid,newID);
        
        
        
        //Calling Java Objects
        RequestPayload req = new RequestPayload("asf2","my-user-1234",1);
        ObjectMapper objMap = new ObjectMapper();
        String data = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(req);
     
       
      //POST
       request = RestAssured.given();
       request.header("Content-Type", "application/json");
       request.header("x-api-key", "DEMO-API-KEY");
       response = request.body("{\n" +
               "  \"image_id\": \"asf2\",\n" +
               "  \"sub_id\": \"my-user-1234\",\n" +
               "  \"value\": 1\n" +
               "}").post("/votes");

        
       //Verify 200 response status code       
       Assert.assertEquals(response.getStatusCode(), 200);
       
      // body response match expected value "message": "SUCCESS", 
       JsonPath neweve= response.jsonPath();
       String msg = neweve.get("message");
       Assert.assertEquals(msg, "SUCCESS");
        
        
        String idnew1 = neweve.get("id").toString();
       
        RestAssured.baseURI = "https://api.thecatapi.com/v1";
        request = RestAssured.given().log().all();
        
        request.header("x-api-key","DEMO-API-KEY");
        response = request.get("/votes/"+idnew1);
        jsonString = response.asString();
         
        //Verify 200 response status code,
        Assert.assertEquals(response.getStatusCode(), 200);
        
         JsonPath neweve1= response.jsonPath();
         String idnew2 = neweve1.get("id").toString();
         
         //{​​​id}​​​ response match {​​​id}​​​ request.
         Assert.assertEquals(idnew2, idnew1);
         
         
         //DELETE /votes/{​​​vote_id}​​​ specifying the same {​​​id}​​​ at previous point. 
         RestAssured.baseURI = "https://api.thecatapi.com/v1";
         request = RestAssured.given().log().all();
         request.header("x-api-key","DEMO-API-KEY");
         response = request.delete("/votes/"+idnew1);
         //Verify 200 response status code
         Assert.assertEquals(response.getStatusCode(), 200);
         
         //Verify body response match expected value "message": "SUCCESS"
         JsonPath jpath= response.jsonPath();
         String successmsg = jpath.get("message");
         Assert.assertEquals(successmsg, "SUCCESS");
         
         
         //GET /votes/{​​​id}​​​ using the {​​​id}​​​ deleted at previous point.
         RestAssured.baseURI = "https://api.thecatapi.com/v1";
         request = RestAssured.given().log().all();
         request.header("x-api-key","DEMO-API-KEY");
         response = request.get("/votes/"+idnew1);
         
       //Verify 404 status code
         Assert.assertEquals(response.getStatusCode(), 404);
         
       //Verify body response match expected value "message": "NOT_FOUND" and "status": 404
         JsonPath jpath1= response.jsonPath();
         String message = jpath1.get("message").toString();
         Assert.assertEquals(message, "NOT_FOUND");
    }
    
     
}
        
        
       
       

       
    



