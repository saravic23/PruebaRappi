package tasks;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import exceptions.ServiceConsumptionException;
import models.Data;
import models.Requests;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import utils.MakeJsonRequests;
import utils.SetExecutionVariables;
import java.util.ArrayList;
import java.util.List;



public class RegisterUser implements Task {
    public static final String SUCCESSFULRS = "200";
    private Data data;

    public RegisterUser(Data data) {
        this.data = data;
    }

    @Subject("Register User")
    @Override
    public <T extends Actor> void performAs(T actor) {
        MakeJsonRequests jrRegister = new MakeJsonRequests();
        JsonParser parserRegister = new JsonParser();
        String[] responseRegister = new String[3];
        List<String> registerUserRs = new ArrayList<String>();


        try {
            SetExecutionVariables.setParametersRegisterUser(data);
            responseRegister = jrRegister.consumeRestServices("Post", Requests.getGetRegisterEndPoint(),
                    Requests.getRequestHeaders(), Requests.getBodyRequest());
        } catch (Exception | ServiceConsumptionException e) {
            e.printStackTrace();
        }

        if (SUCCESSFULRS.equals(responseRegister[0])) {
            JsonObject jsonObjectregister = parserRegister.parse(responseRegister[2]).getAsJsonObject();
            registerUserRs.add(jsonObjectregister.get("token").getAsString());
            Requests.setMessageResponseRegister(registerUserRs);
            Requests.setCodeRespone(responseRegister);
        }
    }

    public static RegisterUser fromManagementLayer(Data data) {
        return Tasks.instrumented(RegisterUser.class, data);
    }
}
