package sda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BanksReader {

    public List<Rules> read (String filePath) throws IOException {

        List<Rules> result = new ArrayList<>();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader reader = new BufferedReader(fileReader);

        String line = reader.readLine();
        String[] headers = line.split(";");

        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            Rules rule = new Rules();
            String[] values = line.split(";");
            for (int i = 0; i < headers.length; i++) {
                if ("Wystawca".equals(headers[i])) {
                    rule.setIssuer(values[i]);
                } else if ("Prefiks".equals(headers[i])) {
                    rule.setPrefix(values[i]);
                } else if ("Liczba znakow".equals(headers[i])) {
                    rule.setLength(Integer.parseInt(values[i]));
                }
            }
            result.add(rule);
        }
        return result;
    }
}
