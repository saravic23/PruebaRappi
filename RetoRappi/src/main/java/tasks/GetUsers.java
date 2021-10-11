package tasks;

import exceptions.ServiceConsumptionException;
import models.Requests;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import utils.MakeJsonRequests;
import utils.SetExecutionVariables;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsers implements Task {
    private final int page;

    public GetUsers(int page) {
        this.page = page;
    }

    public static Performable fromPage(int page) {
        return instrumented(GetUsers.class, page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        MakeJsonRequests jrCosnult = new MakeJsonRequests();
        String[] responseCosnult = new String[3];

        try {
            SetExecutionVariables.setParametersGetUser(page);
            responseCosnult = jrCosnult.consumeRestServices("Get", Requests.getGetUserEndPoint(),
                    Requests.getRequestHeaders(), Requests.getBodyRequest());
        } catch (Exception | ServiceConsumptionException e) {
            e.printStackTrace();
        }

        Requests.setCodeRespone(responseCosnult);
    }
}