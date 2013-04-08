package lab3;

/**
 * This class provides various services relating to name manipulation.
 * No output should be performed here.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int FIRST_NAME_IDX = 0;
    private static final int LAST_NAME_IDX = 1;
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
    public String extractLastName(String fullName) throws InvalidNameException {
        
        if (fullName == null || fullName.length() == 0) {
            throw new InvalidNameException();
        }
        
        int numberOfSpaces = 0;
        for (int i = 0; i < fullName.length(); i++) {
            if (fullName.charAt(i) == ' ') {
                numberOfSpaces++;
                if (numberOfSpaces > 1) {
                    //message1 = "Full Name cannot contain more than 1 space";
                    throw new InvalidNameException(
                            "Full Name cannot contain more than 1 space");
                }
            }
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
                //message1 = "Full Name cannot contain numbers";
                throw new InvalidNameException(
                        "Full Name cannot contain numbers");
            }
        }
        
        fullName = fullName.trim();
        int indexOfSpace = fullName.indexOf(" ");
        if (indexOfSpace < 0) {
            //message1 = "Enter First Name, Last Name separated by a space";
            throw new InvalidNameException(
                        "Enter First Name, Last Name separated by a space");
        }
        
        for (int i = 0; i < fullName.length(); i++) {
            if ((fullName.charAt(i) >= 'a'
                    && fullName.charAt(i) <= 'z')
                    || (fullName.charAt(i) >= 'A'
                    && fullName.charAt(i) <= 'Z')) {
                //message1 = "Full Name cannot contain special characters";
                throw new InvalidNameException(
                        "Full Name cannot contain special characters");

            }
        }
        
        String[] nameParts = fullName.split(" ");
        return nameParts[LAST_NAME_IDX];
    }
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) throws InvalidNameException {
        
        if (fullName == null || fullName.length() == 0) {
            throw new InvalidNameException();
        }
        
        String[] nameParts = fullName.split(" ");
        return nameParts[FIRST_NAME_IDX];
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) {
        return name.length();
    }
    
}
