package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using Java
 * Exception handling techniques. <p> Your challenge is to consider all the
 * possible things that can go wrong with this program and use exception
 * handling where appropriate to prevent the program from crashing. In addition
 * you must display a friendly error message in a JOptionPane and ask the user
 * to try again.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {

    private static final int LAST_NAME_IDX = 1;
    private static String message1;

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();

        try {
            String fullName = JOptionPane.showInputDialog("Enter full name:");
            String lastName = app.extractLastName(fullName);
            String msg = "Your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
        } catch (IllegalArgumentException e) {
            String title = "Invalid Entry";
            //message1 = "Full Name is missing, please enter full name";
            JOptionPane.showMessageDialog(null,
                    message1, title, JOptionPane.ERROR_MESSAGE);
        } catch (StringIndexOutOfBoundsException e) {
            String title = "Invalid Entry";
            //message1 = "Enter First Name and Last Name seperated by a space";
            JOptionPane.showMessageDialog(null,
                    message1, title, JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            String title = "Invalid Entry";
            //message1 = "Full Name is missing, please enter full name";
            JOptionPane.showMessageDialog(null,
                    message1, title, JOptionPane.ERROR_MESSAGE);
        }
    }

    public String extractLastName(String fullName) {
        if (fullName == null || fullName.length() == 0) {
            message1 = "Full Name is missing, please re-enter full name";
            throw new NullPointerException();
        }

        for (int i = 0; i < fullName.length(); i++) {
            if (fullName.charAt(i) == '0'
                    || fullName.charAt(i) == '1'
                    || fullName.charAt(i) == '2'
                    || fullName.charAt(i) == '3'
                    || fullName.charAt(i) == '4'
                    || fullName.charAt(i) == '5'
                    || fullName.charAt(i) == '6'
                    || fullName.charAt(i) == '7'
                    || fullName.charAt(i) == '8'
                    || fullName.charAt(i) == '9') {
                message1 = "Full Name cannot contain numbers";
                throw new IllegalArgumentException();
            }
        }

        int numberOfSpaces = 0;
        for (int i = 0; i < fullName.length(); i++) {
            if (fullName.charAt(i) == ' ') {
                numberOfSpaces++;
                if (numberOfSpaces > 1) {
                    message1 = "Full Name cannot contain more than 1 space";
                    throw new IllegalArgumentException();
                }
            }
        }

        for (int i = 0; i < fullName.length(); i++) {
            if ((fullName.charAt(i) >= 'a'
                    && fullName.charAt(i) <= 'z')
                    || (fullName.charAt(i) >= 'A'
                    && fullName.charAt(i) <= 'Z')) {
                message1 = "Full Name cannot contain special characters";
                throw new IllegalArgumentException();

            }
        }


        fullName = fullName.trim();
        int indexOfSpace = fullName.indexOf(" ");
        if (indexOfSpace < 0) {
            message1 = "Enter First Name, Last Name separated by a space";
        }



        String[] nameParts = fullName.split(" ");
        return nameParts[LAST_NAME_IDX];
    }
}
