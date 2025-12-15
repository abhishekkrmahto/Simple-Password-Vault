package Data;

import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class UsersStorage {
    public void addUser(String uname,String pass) throws IOException{
        File f = new File("usersHistory.txt");
        File f2 = new File("passwordHistory.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        if(!f2.exists()){
            f2.createNewFile();
        }

        

        BufferedOutputStream userWrite = new BufferedOutputStream(new FileOutputStream(f,true));
        BufferedOutputStream passwordWrite = new BufferedOutputStream(new FileOutputStream(f2,true));


        try{
            String userName = uname+"\n";
            String password = pass+"\n";
            userWrite.write(userName.getBytes());
            passwordWrite.write(password.getBytes());

            
        }catch(Exception e){
            System.out.println("Error happended adding user !!");
        }
        finally{
            userWrite.close();
            passwordWrite.close();
        }
    }

    public void addPass(String uname,String pass) throws IOException{
        File file = new File("Total_Users_Details.txt");

        if(!file.exists()){
            file.createNewFile();
        }

        BufferedOutputStream details = new BufferedOutputStream(new FileOutputStream(file,true));

        try{
            String user = uname+":"+pass+"\n";
            details.write(user.getBytes());
        }catch(Exception e){
            System.out.println(e);
        }
        finally{
            details.close();
        }


        

    }
}
