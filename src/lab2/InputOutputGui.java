package lab2;

import javax.swing.JOptionPane;

/**
 * This class is responsible for all input and output in the program.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class InputOutputGui {

    private NameService nameService;

    public InputOutputGui() {
        nameService = new NameService();
    }

    public void startConversation() {

        try {
            String fullName = JOptionPane.showInputDialog("Enter full name:");
            String lastName = nameService.extractLastName(fullName);
            String msg = "Your last name is: " + lastName;
            //String firstName = nameService.extractFirstName(fullName);
            //String msg = "Your first name is: " + firstName;
            //String msg = "Your first name is: " + firstName +
            //              ", your last name is: " + lastName;
            JOptionPane.showMessageDialog(null, msg);
        }
        
        catch (IllegalArgumentException e){
            String title = "Invalid Entry";
            //String message1 = "Full Name is missing, please enter full name (issued from gui)";
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), title, JOptionPane.ERROR_MESSAGE);
        }
        
        catch (ArrayIndexOutOfBoundsException e){
            String title = "Invalid Entry";
            String message1 = "oops";
            JOptionPane.showMessageDialog(null,
                    message1, title, JOptionPane.ERROR_MESSAGE);
        }         

        finally{
            System.exit(0);
        }
    }
}
