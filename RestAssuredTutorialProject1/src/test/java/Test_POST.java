import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import static io.restassured.RestAssured.*;

public class Test_POST {

    @Test
    public void test1_post() {

        //Map<String, Object> map = new HashMap<String, Object>();

        //map.put("name","Anna");
        //map.put("job","Tester");

        //System.out.println(map);

        JSONObject request = new JSONObject ();

        request.put("name","Anna");
        request.put("job","Tester");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().post("https://reqres.in/api/users").
                then().statusCode(201);

    }
@Test
    public void test2_put() {


        JSONObject request = new JSONObject ();

        request.put("name","Anna");
        request.put("job","Tester");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().put("https://reqres.in/api/users/2").
                then().statusCode(200).
                log().all();

    }

    @Test
    public void test3_patch() {


        JSONObject request = new JSONObject ();

        request.put("name","Elwira");
        request.put("job","Student");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given().
                header("Content-Type", "application/json").
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().patch("https://reqres.in/api/users/2").
        then().statusCode(200).
                log().all();

    }

    @Test
    public void test4_delete() {


        given().
                when().delete("https://reqres.in/api/users/2").
                then().statusCode(204). //success status code for delete is 204
                log().all();

    }
}
