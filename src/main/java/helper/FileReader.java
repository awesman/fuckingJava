package helper;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class FileReader {

    private static final Logger LOGGER = LogManager.getLogger();

    public static List<String> pointsInput(String path) {

        List<String> pointsList = new ArrayList<>();

        try {
            pointsList = Files.readAllLines(Paths.get(path),
                    StandardCharsets.UTF_8);
            LOGGER.log(Level.INFO, "Data reading successfull!");
        } catch (IOException e) {
            LOGGER.log(Level.ERROR, "IOException", e);
        }
        return pointsList;
    }
}
