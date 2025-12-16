package Add_Password;

import java.util.Scanner;

import Data.UserChecker;
import Data.UsersStorage;
import Encyption.EncyptDecypt;
import Exceptions.ExceptionsClass;

public class AddPasswordClass {
    ExceptionsClass exceptionObj = new ExceptionsClass();
    UsersStorage usersStorage = new UsersStorage();
    EncyptDecypt encyptDecypt = new EncyptDecypt();
    UserChecker userChecker = new UserChecker();

    Scanner sc = new Scanner(System.in);
    int numberOfPasswords = 0;

    public void addPasswordMethod() throws Exception {
        System.out.print("Enter New User = ");
        String userName = sc.nextLine();
        System.out.print("Enter New Password = ");
        String newPassword = sc.nextLine();

        if (!newPassword.matches(".*[^a-zA-Z0-9].*")) {
            exceptionObj.passwordInputException();
            return;
        } else if (userChecker.userExists(userName)) {
            System.out.println("----------------------------");
            System.out.println("|| User Already Exists ..... ||");
            System.out.println("----------------------------");
            return;
        } else {
            usersStorage.addUser(userName, encyptDecypt.encryptPassword(newPassword));
            usersStorage.addPass(userName, encyptDecypt.encryptPassword(newPassword));
            System.out.println("SuccessFully Password Stored !!");
            return;
        }
    }
}
