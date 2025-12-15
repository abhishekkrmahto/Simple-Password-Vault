package DeleteUser;
import java.io.*;
import java.util.*;

public class DeleteUserData {

    public static void deleteUser() throws Exception {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the username you want to delete: ");
        String userToDelete = scanner.nextLine().trim();

        String usernameFile = "usersHistory.txt";
        String passwordFile = "passwordHistory.txt";
        String userPassFile = "Total_Users_Details.txt";

        List<String> usernameList = readFile(usernameFile);
        List<String> passwordList = readFile(passwordFile);
        List<String> userPassList = readFile(userPassFile);

        int index = usernameList.indexOf(userToDelete);

        if (index == -1) {
            System.out.println("The username you entered does not exist.");
            return;
        }

        String passwordToDelete = passwordList.get(index);

        usernameList.remove(index);
        passwordList.remove(index);

        userPassList.remove(userToDelete + ":" + passwordToDelete);

        writeFile(usernameFile, usernameList);
        writeFile(passwordFile, passwordList);
        writeFile(userPassFile, userPassList);

        System.out.println("User" + userToDelete + " and its password were deleted successfully.");
    }

    private static List<String> readFile(String fileName) throws IOException {
        File file = new File(fileName);

        if (!file.exists()) return new ArrayList<>();

        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            if (!line.trim().isEmpty()) {
                lines.add(line.trim());
            }
        }

        reader.close();
        return lines;
    }

    private static void writeFile(String fileName, List<String> lines) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }

        writer.close();
    }
}
