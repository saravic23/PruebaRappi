package tasks;

import exceptions.ServiceConsumptionException;
import models.Requests;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.annotations.Subject;
import utils.MakeJsonRequests;
import utils.SetExecutionVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUser implements Task {

    private final String userid;

    public DeleteUser(String userid) {

        this.userid = userid;
    }

    public static Performable theUser(String user) {
        return instrumented(DeleteUser.class, user);
    }

    @Subject("Delete")
    @Override
    public <T extends Actor> void performAs(T actor) {
        MakeJsonRequests jrDelete = new MakeJsonRequests();
        String[] responseDelete = new String[3];

        try {
            SetExecutionVariables.setParametersDelete(userid);
            responseDelete = jrDelete.consumeRestServices("Delete", Requests.getDeleteEndPoint(),
                    Requests.getRequestHeaders(), Requests.getBodyRequest());

        } catch (Exception | ServiceConsumptionException e) {
            e.printStackTrace();
        }
        Requests.setCodeRespone(responseDelete);
    }
}