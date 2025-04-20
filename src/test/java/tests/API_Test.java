package tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.annotations.Step;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.*;
import io.restassured.response.Response;

public class API_Test {

    private Map<String, String> endPoint = new HashMap<String, String>();

    private String baseUrl = null;
    private Map messagesData = null;

    @Step
    public void dog_api(String url) {
        //setup endpoint
        endPoint.put("listallDogbreeds", "breeds/list/all");
        endPoint.put("listofsubbreeds", "breed/retriever/list");
        endPoint.put("goldenDog", "breed/retriever/golden/images/random");
        baseUrl = url;
    }


    public void dog_breeds_list() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(endPoint.get("listallDogbreeds"));
        int statuscode = response.getStatusCode();

        System.err.println("******** Scenario 1 *******");
        System.out.println("Status Code: " + statuscode);
        if (statuscode == 200) {
            System.out.println("Response message: " + response.asString());

            try {
                Object obj = new JSONParser().parse(response.asString());

                JSONObject jo = (JSONObject) obj;
                messagesData = ((Map) jo.get("message"));
            } catch (Exception ex) {
                System.out.println("Message: " + ex.getMessage());
            }
        } else {
            System.err.println("Error message: " + response.asString());
        }

    }

    public void retrieve_breed_in_list() {
        System.err.println("****** Scenario 2 *******");

        //verify item exists
        boolean state = messagesData.containsKey("retriever");
        if (state) {
            System.out.println("retriever: Exists");
        }
    }

    public void list_of_sub_breeds_for_retriever() {

        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(endPoint.get("listofsubbreeds"));
        int statuscode = response.getStatusCode();
        System.err.println("****** Scenario 3 *******");

        System.out.println("Status Code  message  : " + statuscode);
        if (statuscode == 200) {
            System.out.println("Response: " + response.asString());

        }
    }

    public void random_image_for_subbreed_golden() {

        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(endPoint.get("goldenDog"));
        int statuscode = response.getStatusCode();
        System.err.println("****** Scenario 4 *******");


        System.out.println("Status Code: " + statuscode);
        if (statuscode == 200) {
            System.out.println("Response: " + response.asString());

        } else {
            System.err.println("Error message: " + response.asString());
        }
    }


}
