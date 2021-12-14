import static io.restassured.RestAssured.*;

import groovyjarjarpicocli.CommandLine;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.ResponseBody;
import java.util.ArrayList;

public class RestAssuredAPITest1 {

    @Test
    void test1(){

        Response response = get("https://api.punkapi.com/v2/beers?brewed_after=12-2015");

        System.out.println("Status Code is "+response.getStatusCode());
        System.out.println("Status time is "+response.getTime());
        System.out.println("Body is "+response.getBody().asString());

        int statusCode = response.statusCode();
        Assert.assertEquals(statusCode,200);

    }
    @Test
    void test2(){

        given().
                get("https://api.punkapi.com/v2/beers?brewed_after=12-2015").
                then().
                statusCode(200);
    }
    @Test
    void test3(){
        baseURI = ("https://api.punkapi.com/v2");

        given().
                get("/beers?brewed_after=12-2015").
                then().
                body("abv[1]", equalTo(4.7F)); //F is float, typy zmiennoprzecinkowe zgoogle'owac (float, decimal) w javie

    }

    @Test
    void test4(){
        baseURI = ("https://api.punkapi.com/v2");

        given().
                get("/beers?brewed_after=12-2015").
                then().
                body("abv[2]", greaterThanOrEqualTo(4F));

    }

    @Test
    void test5(){
        //take out any number in the collection and assert it - for each in java
        baseURI = ("https://api.punkapi.com/v2");

        ArrayList<Number> abv =
//use common type Number, float will result in errors!
                when().get("/beers?brewed_after=12-2015").then().extract().path("abv"); //find out how to assert any element in the collection, not just specified one
            float abvValue = 0;
            //for(var a:abv) {
        for(int i = 0 ; i < abv.size() ; i++){
                var value = abv.get(i);
                float a = value.floatValue();

            //var a =  abv.get(i);
                        System.out.println("Abv value is " +a);

                    abvValue=abvValue+a;
            }
        System.out.println("Abv values are " +abvValue);
    }

    @Test
    void test6(){
        baseURI = ("https://api.punkapi.com/v2");

        given().
                get("/beers?brewed_after=12-2015").
                then().
                body("abv[1]", equalTo(4.7F)); //failed, type float?
    }

}


