package stepdefinitions;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exceptions.ValidateException;
import models.Data;
import net.serenitybdd.screenplay.Actor;
import questions.DeleteUserResponse;
import questions.GetUsersResponse;
import questions.RegisterUserResponse;
import tasks.DeleteUser;
import tasks.GetUsers;
import tasks.RegisterUser;

import java.util.List;

import static exceptions.ValidateException.*;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ConsumptionServicesStepDefinition {

    Actor sara = Actor.named("sara");

    @When("^the user send the request$")
    public void theUserSendTheRequest() {
        sara.attemptsTo(GetUsers.fromPage(2));
    }

    @Then("^he should see the response code and  message$")
    public void heShouldSeeTheResponseCodeAndMessage() {
        sara.should(seeThat(GetUsersResponse.was()).orComplainWith(ValidateException.class, GET_USER_ERROR));
    }

    @When("^the user send the register request$")
    public void theUserSendTheRegisterRequest(List<Data> datos) {
        sara.attemptsTo(RegisterUser.fromManagementLayer(datos.get(0)));
    }

    @Then("^he should see the register response code and  message$")
    public void heShouldSeeTheRegisterResponseCodeAndMessage() {
       sara.should( seeThat(RegisterUserResponse.was()).
               orComplainWith(ValidateException.class,REGISTER_USER_ERROR));
    }

    @When("^the user send the delete request$")
    public void theUserSendTheDeleteRequest() {
        sara.attemptsTo(DeleteUser.theUser("2"));
    }

    @Then("^he should see the delete response code and  message$")
    public void heShouldSeeTheDeleteResponseCodeAndMessage() {
        sara.should(seeThat(DeleteUserResponse.was()).orComplainWith(ValidateException.class, DELETE_USER));
    }
}
