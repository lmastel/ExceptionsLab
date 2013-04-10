package lab4;

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
            JOptionPane.showMessageDialog(null, msg);
        } 
        catch (NullPointerException e) {
            String title = "Invalid Name";
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), title, JOptionPane.ERROR_MESSAGE);
            System.out.println("e1" + e.getCause().toString());
            System.err.println("e2" + e.getMessage() + "\n");
            System.err.println("e3" + e.toString() + "\n");
        } 
        catch (IllegalArgumentException e) {
            String title = "Invalid Name";
            JOptionPane.showMessageDialog(null,
                    e.getMessage(), title, JOptionPane.ERROR_MESSAGE);
            System.out.println("e1" + e.getCause().toString());
            System.err.println("e2" + e.getMessage() + "\n");
            System.err.println("e3" + e.toString() + "\n");
        } 
        finally {
            System.exit(0);
        }
    }
}
