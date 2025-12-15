package Exceptions;

public class ExceptionsClass {
    public void passwordInputException() throws Exception {
        throw new Exception(
                "Entered Password is weak\n Please Enter New Password\nUsing [A-Z] and [0-9] and also [Symbol]");
    }

    public void ArrayIndexException() throws Exception {
        throw new Exception("No enough Space to store more password [DATABASE FULL !!! WARNING !!!]");
    }
}
