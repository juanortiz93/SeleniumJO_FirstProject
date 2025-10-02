package steps;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ListPage;

public class ListPageSteps {
    ListPage list = new ListPage();

    @Given("^I navigate to the list page$") 
    public void navigateToListPage(){
        list.navigateToListPage();
    }
    @When("^I search the list$")
    public void searchTheList() throws InterruptedException {
        list.enterSearchCriteria();
    }
    @Then("^I can finde the text in the list$")
    public void theTableIsThere(){
        List<String> lista = list.getAllSearchResults();
        boolean textIsThere = lista.contains("Manizales");

        if(textIsThere){
            System.out.println("The text is on the list");
        }else{
            throw new AssertionError("The text is not on the list");
        }
    }
}
