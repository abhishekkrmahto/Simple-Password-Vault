import java.util.Scanner;
import Add_Password.AddPasswordClass;
import RetrivePass.RetriveUser;
public class Main {
    public static void main(String[] args) throws Exception {

        AddPasswordClass addPass = new AddPasswordClass();
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while (n != 4) {
            System.out.print(
                    "(1)---->ADD PASSWORD\n(2)---->RETRIEVE PASSWORD\n(3)---->DELETE PASSWORD\n(4)---->EXIT\n");
            n = sc.nextInt();
            switch (n) {
                case 1: {
                    addPass.addPasswordMethod();
                    break;
                }
                case 2: {
                    sc.nextLine();// this covers /n when we press enter 
                    System.out.print("Enter username: ");
                    String userName = sc.nextLine();
                    String pass = RetriveUser.getPassword(userName);
                    if (pass != null) {
                        System.out.println("Password: " + pass);
                    } else {
                        System.out.println("----------------------------");
                        System.out.println("||  Username not found!  ||");
                        System.out.println("----------------------------");
                    }
                    break;
                }
                case 3: {
                    sc.nextLine();
                    try {
                        DeleteUser.DeleteUserData.deleteUser();
                    } catch (Exception e) {
                        System.out.println("An error occurred while deleting the user: " + e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("---------EXITED FROM PROGRAM--------");
                    break;
                }
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        sc.close();
    }
}
