package RetrivePass;

import java.io.*;
import java.util.*;

import Encyption.EncyptDecypt;

public class RetriveUser {

    public static String getPassword(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader("Total_Users_Details.txt"))) {
            String line;
            EncyptDecypt decypt = new EncyptDecypt();
            while ((line = br.readLine()) != null) {
                if (line.startsWith(username + ":")) {
                    String encryptedPass = line.substring(line.indexOf(':') + 1);
                    String password = decypt.decryptPassword(encryptedPass);
                    return password;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
