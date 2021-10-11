package questions;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import models.Requests;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import java.util.ArrayList;
import java.util.List;


public class GetUsersResponse implements Question<Boolean> {
    public static final String SUCCESSFULRS = "200";
    JsonParser parserCode = new JsonParser();
    private List<String> originalResponseInfo = new ArrayList<>();
    private List<String> capaResponse = new ArrayList<>();


    @Subject("consult response")
    @Override
    public Boolean answeredBy(Actor actor) {
        String[] responseCode = Requests.getCodeRespone();
        Boolean validation = true;
        Boolean result = false;
        if (SUCCESSFULRS.equals(responseCode[0])) {
            JsonObject jsonOjectCode = parserCode.parse(responseCode[2]).getAsJsonObject();
            JsonObject data = jsonOjectCode.get("data").getAsJsonArray().get(0).getAsJsonObject();
            capaResponse.add(data.get("email").getAsString());
            capaResponse.add(data.get("id").getAsString());
            originalResponseInfo.add("michael.lawson@reqres.in");
            originalResponseInfo.add("7");

            result = capaResponse.get(0).equals(originalResponseInfo.get(0));

            if(result.equals(validation)){
                validation = true;
            }else{
                validation = false;
            }
        }
        return validation;
    }

    public static GetUsersResponse was() {
        return new GetUsersResponse();
    }
}
