package RestAssuredAPITesting.com.RestAssuredApiTesting;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AccessToken {
    @Test
    public void get_AccessToken() {
    	
        String url = "http://travoapimanagementloadbalancer-801977752.ap-south-1.elb.amazonaws.com/v1/verify";
        RequestSpecification http_req = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("User-Agent", "PostmanRuntime/7.39.0")
                .header("Accept", "*/*")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Connection", "keep-alive");

        JSONObject payload = new JSONObject();
        payload.put("username", "travobuddyapi");
        payload.put("password", "travobuddyapi@129476");

        http_req.body(payload.toJSONString()); // Set the request body

        Response response = http_req.post(url);
        System.out.println(response);

        int status_code = response.getStatusCode();
        String response_body = response.asString();

        System.out.println("....status code...." + status_code);
        System.out.println("....response body...." + response_body);
    }
}
	  
			  
			  
	