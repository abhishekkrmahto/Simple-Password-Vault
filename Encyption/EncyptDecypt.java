package Encyption;

public class EncyptDecypt {
    public String encryptPassword(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append((char) (c + 3)); // shift +3
        }
        return sb.toString();
    }

    public String decryptPassword(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append((char) (c - 3)); // shift -3
        }
        return sb.toString();
    }

}
