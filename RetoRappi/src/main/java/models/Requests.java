package models;

import java.util.List;
import java.util.Map;

public class Requests {

    private static Map<String, String> requestHeaders;
    private static String userEndPoint;
    private static String registerEndPoint;
    private static String deleteEndPoint;
    private static String bodyRequest;
    private static String[] getCodeRespone;
    private static List<String> messageResponseRegister;

    public static String getDeleteEndPoint() {
        return deleteEndPoint;
    }

    public static void setDeleteEndPoint(String deleteEndPoint) {
        Requests.deleteEndPoint = deleteEndPoint;
    }

    public static List<String> getMessageResponseRegister() {
        return messageResponseRegister;
    }

    public static void setMessageResponseRegister(List<String> messageResponseRegister) {
        Requests.messageResponseRegister = messageResponseRegister;
    }

    public static String getGetRegisterEndPoint() {
        return registerEndPoint;
    }

    public static void setGetRegisterEndPoint(String registerEndPoint) {
        Requests.registerEndPoint = registerEndPoint;
    }

    public static String[] getCodeRespone() {
        return getCodeRespone;
    }

    public static void setCodeRespone(String[] getCodeRespone) {
        Requests.getCodeRespone = getCodeRespone;
    }


    public static String getBodyRequest() {
        return bodyRequest;
    }

    public static void setBodyRequest(String bodyRequest) {
        Requests.bodyRequest = bodyRequest;
    }


    public static String getGetUserEndPoint() {
        return userEndPoint;
    }

    public static void setGetUserEndPoint(String userEndPoint) {
        Requests.userEndPoint = userEndPoint;
    }

    public static Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }


    public static void setRequestHeaders(Map<String, String> requestHeaders) {
        Requests.requestHeaders = requestHeaders;
    }

}
