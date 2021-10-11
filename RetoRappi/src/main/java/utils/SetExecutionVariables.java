package utils;

import models.Data;
import models.Requests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utils.SetExecutionVariablesFilex.getBodyRQFromFile;

public class SetExecutionVariables {
    private static final String BASE_ENDPOINT = "https://reqres.in/api/";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APP_JSON = "application/json";
    private static final String PATH = "src/main/resources/jsonrequest";
    private static final String EMAIL = "{email}";
    private static final String PASSWORD = "{password}";


    public static void setParametersGetUser(int page) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put("header1", "value1");
        Requests.setRequestHeaders(headers);
        Requests.setGetUserEndPoint(BASE_ENDPOINT + "users?page=" + page);

    }

    public static void setParametersDelete(String user) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, APP_JSON);
        Requests.setRequestHeaders(headers);
        Requests.setDeleteEndPoint(BASE_ENDPOINT + "users/" + user);
    }


    public static void setParametersRegisterUser(Data data) throws IOException {
        Map<String, String> headers = new HashMap<>();
        headers.put(CONTENT_TYPE, APP_JSON);
        Requests.setRequestHeaders(headers);
        Requests.setGetRegisterEndPoint(BASE_ENDPOINT + "register");
        Requests.setBodyRequest(getBodyRQFromFile(PATH + "/register.json")
                .replace(EMAIL, data.getEmail())
                .replace(PASSWORD, data.getPassword()));

    }

}
