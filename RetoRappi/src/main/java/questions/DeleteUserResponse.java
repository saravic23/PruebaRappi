package questions;

import models.Requests;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

public class DeleteUserResponse implements Question<Boolean> {
    private static final String CODE = "204";


    @Subject("delete response")
    @Override
    public Boolean answeredBy(Actor actor) {
        String[] responseCode = Requests.getCodeRespone();
        boolean result = false;

        result = responseCode[0].equals(CODE);

        return result;
    }

    public static DeleteUserResponse was() {
        return new DeleteUserResponse();
    }
}
