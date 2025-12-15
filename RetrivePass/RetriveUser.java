package RetrivePass;

import java.io.*;
import java.util.*;


public class RetriveUser {

    public static String getPassword(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader("Total_Users_Details.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(username + ":")) {
                    return line.substring(line.indexOf(':') + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
