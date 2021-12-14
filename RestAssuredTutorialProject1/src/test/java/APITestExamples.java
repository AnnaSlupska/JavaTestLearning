import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APITestExamples {
   @Test
    public void test_get() {
       baseURI="http://localhost:3000/";

     given().
             param("name", "automation").
               get("/users").
               then().statusCode(200).
             log().all();
   }
   @Test
   public void test_post() {
       JSONObject request = new JSONObject();

       request.put("firstName","Jagoda");
       request.put("lastName","Corka");
       request.put("subjectId", "1");
       request.put("id","4");

       baseURI="http://localhost:3000/";

       given().
               contentType(ContentType.JSON).accept(ContentType.JSON).
               header("Content-Type", "application/json").
               body(request.toJSONString()).
       when().
               post("/users").
       then().
               statusCode(201).
               log().all();
   }
//@Test
    public void test_patch() {
        JSONObject request = new JSONObject();

        request.put("firstName","Halina");
        request.put("lastName","Testowska");
        request.put("subjectId", "1");

        baseURI="http://localhost:3000/";

        given().
                contentType(ContentType.JSON).accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(request.toJSONString()).
                when().
                patch("/users/rBxc_Oj").
                then().
                statusCode(200).
                log().all();
    }
//@Test
    public void test_delete() {

        baseURI="http://localhost:3000/";

                when().
                delete("/users/rBxc_Oj").
                then().
                statusCode(200);
    }
}
