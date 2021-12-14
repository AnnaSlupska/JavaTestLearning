import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Tests_GET {
    @Test
    public void test_1() {

        given().
                header("Content-Type","application-json");
                get("https://api.punkapi.com/v2/beers?brewed_after=12-2015").
                then().
                statusCode(200).
                body("abv[0]", equalTo(6.3F)).
                log().all();


    }
}
