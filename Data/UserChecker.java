package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class UserChecker {
    public boolean userExists(String username) {
        File f = new File("usersHistory.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().equalsIgnoreCase(username.trim())) {
                    return true; // user mil gaya
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return false; // user nahi mila
    }
}
