package stepDefinitions;

import com.rr.Factory.DriverFactory;
import com.rr.pages.mapManipulationPage;
import com.rr.util.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Map;

public class mapManiplationSteps {
    private mapManipulationPage map = new mapManipulationPage(DriverFactory.getDriver());
    ConfigReader configReader = new ConfigReader();


    @Given("user has logged in to application")
    public void user_has_logged_in_to_application(DataTable credTable) {

        List<Map<String, String>> credList = credTable.asMaps();
        String userName = credList.get(0).get("username");
        String password = credList.get(0).get("password");

        DriverFactory.getDriver()
                .get(configReader.init_prop().getProperty("MapURL"));
        map.doLogin(userName, password);

    }

    @Given("user clicks on settings and selects tatsumi from maps and clicks next")
    public void selectMaptoEdit() throws InterruptedException {
        map.selectMaptoEdit();
        map.clickonEditButtoninMap();
    }

    @When("user navigates to select nodes on the map")
    public void userNavigatesToNodesOnTheMap() throws InterruptedException {
        map.selectNodeAndDraginMap();
    }

    @And("user selects edge and joins the selected nodes")
    public void userSelectsEdgeAndJoinsTheSelectedNodes() {
        map.joinNodesUsingEdge();

    }

    @And("user creates region on click of edit")
    public void userCreatesRegionOnClickOfEdit() throws InterruptedException {
        map.createRegioninMap();
    }

    @And("user click in region to Edit and Save the map")
    public void userClickInRegionToEditAndSaveTheMap() {
        map.editAndSaveRegionInMap();

    }

    @And("user edits maps to change X location of map")
    public void userEditsMapsToChangeXLocationOfMap() throws InterruptedException {
        map.editAndChangeNewLocation();
    }
}
