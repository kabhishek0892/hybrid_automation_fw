package stepDefinitions;

import com.rr.util.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.logging.Logger;

public class OMDApiSteps {
    private final static Logger logger = Logger.getLogger(OMDApiSteps.class.getName());
    Response response;
    RequestSpecification request;
    JsonPath jsonPath;
    ConfigReader configReader = new ConfigReader();


    @Given("I prepare GET request to OMDB api endpoint")
    public void SetGETRequestToOMDBApiEndpoint() {
        RestAssured.baseURI =configReader.init_prop().getProperty("baseURI");
    }

    @When("I Set query param")
    public void iSetQueryParam() {
        request = RestAssured.given();
        request.queryParam("s", configReader.init_prop().getProperty("searchParam"))
                .queryParam("apikey",configReader.init_prop().getProperty("apikey"));
    }
    @When("Send a GET HTTP request")
    public void send_a_get_http_request() {

        response =request.get();
    }

    @Then("I receive valid Response")
    public void i_receive_valid_response() {
        Assert.assertEquals(response.statusCode(),200);
     logger.info(response.asPrettyString());


    }

    @Then("I list the id of all results")
    public void i_list_the_id_of_all_results() {
        jsonPath = new JsonPath(response.asString());
        List<String> imdblist=jsonPath.getList("Search.imdbID");
        for(String i:imdblist)
        {
            logger.info("List is  ::" + i);

        }

    }

}
