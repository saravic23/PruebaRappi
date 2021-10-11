package questions;

import models.Requests;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;


public class RegisterUserResponse implements Question<Boolean> {
    private static final String CODE = "200";
    private static final String TOKEN = "QpwL5tke4Pnpja7X4";


    @Subject("register response")
    @Override
    public Boolean answeredBy(Actor actor) {

        String[] responseCode = Requests.getCodeRespone();

        boolean result = false;
        result = responseCode[0].equals(CODE) && Requests.getMessageResponseRegister().get(0).equals(TOKEN);

        return result;
    }

    public static RegisterUserResponse was() {
        return new RegisterUserResponse();
    }
}
