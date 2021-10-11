package utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import exceptions.ServiceConsumptionException;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
public class MakeJsonRequests {

    private static final Logger LOGGER = LogManager.getLogger(MakeJsonRequests.class.getName());

    public String[] consumeRestServices(String requestType, String requestEndpoint, Map<String, String> headers,
                                        String bodyRequest) throws ServiceConsumptionException {
        String[] responseAux = new String[3];
        HttpResponse<JsonNode> response = null;
        String msg1 = "Consumption of a " + requestType + " request";
        LOGGER.info(msg1);
        try {
            if ("Post".equalsIgnoreCase(requestType)) {
                response = Unirest.post(requestEndpoint)
                        .headers(headers)
                        .body(bodyRequest).asJson();
            } else if ("Get".equalsIgnoreCase(requestType)) {
                response = Unirest.get(requestEndpoint)
                        .headers(headers).asJson();
            } else if ("Delete".equalsIgnoreCase(requestType)) {
                response = Unirest.delete(requestEndpoint)
                        .headers(headers).asJson();
            } else {
                LOGGER.info("Error trying to consume Rest Services: unsupported type of request");
            }
            if(requestType.equals("Delete")){
                assert response.getStatus() != 0;
                responseAux[0] = String.valueOf(response.getStatus());
                responseAux[1] = "";
                responseAux[2] = "";
            }else{
                assert response != null;
                responseAux[0] = String.valueOf(response.getStatus());
                responseAux[1] = response.getStatusText();
                responseAux[2] = IOUtils.toString(response.getRawBody(), StandardCharsets.UTF_8);
            }


        } catch (UnirestException | IOException e) {
            throw new ServiceConsumptionException("Error trying to consume Rest Services(JSONRequests Class)", e);
        }
        String msg2 = "El servicio respondio un código " + response.getStatus() + " " + response.getStatusText();
        LOGGER.info(msg2);
        LOGGER.info(responseAux);
        return responseAux;
    }
}

