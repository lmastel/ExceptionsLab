package lab1;

public class ParseDemo {

    public static void main(String[] args) {

        String fullName = "Pamela Caldwell";
        fullName = fullName.trim();
        int indexOfSpace = fullName.indexOf(" ");
        String firstName = fullName.substring(0, indexOfSpace);
        String lastName = fullName.substring (indexOfSpace);
        
        System.out.println("firstName= " + firstName);
        System.out.println("lastName= " + lastName);
    }
}
