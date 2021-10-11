package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SetExecutionVariablesFilex {
    private SetExecutionVariablesFilex() {
    }
    public static String getBodyRQFromFile(String fileroute) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileroute)));
    }
}