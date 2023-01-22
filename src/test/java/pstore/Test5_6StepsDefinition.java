package pstore;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pstore.steps.Test5_6;

public class Test5_6StepsDefinition {

    @Steps
    Test5_6 myTest;

    @Given("I have an item in my cart that i want to remove")
    public void iHaveAnItemInMyCartThatIWantToRemove() {
        myTest.i_have_an_item_in_cart();
    }

    @When("I remove a samsung mobile")
    public void iRemoveASamsungMobile() {
        myTest.remove_s6_from_cart();
    }

    @Then("I should have an empty cart without that mobile")
    public void iShouldHaveAnEmptyCartWithoutThatMobile() {
        myTest.cart_should_be_empty();
    }
}
