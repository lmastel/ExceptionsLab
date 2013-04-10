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
    public String extractLastName(String fullName)  {
        
        if (fullName == null || fullName.length() == 0) {
            throw new InvalidNameException(
                    "Full Name is missing", new NullPointerException());            
        }
        
        for (int i = 0; i < fullName.length(); i++) {
            
            if (Character.isDigit(fullName.charAt(i))) {
                throw new InvalidNameException(
                      "Full Name cannot contain digits", new IllegalArgumentException());                
            }
        }
        
        for (int i = 0; i < fullName.length(); i++) {
            
            if (!Character.isLetter(fullName.charAt(i)) && 
                    fullName.charAt(i) != ' ') {
                throw new InvalidNameException(
                      "Full Name cannot contain special characters", new IllegalArgumentException());                
            }
        }

        fullName = fullName.trim();        
        int numberOfSpaces = 0;        
        for (int i = 0; i < fullName.length(); i++) {
            if (fullName.charAt(i) == ' ') {
                numberOfSpaces++;
                if (numberOfSpaces > 1) {
                    throw new InvalidNameException(
                            "Full Name cannot contain more than 1 space", new IllegalArgumentException());
                }
            }
        }        

        fullName = fullName.trim();
        int indexOfSpace = fullName.indexOf(" ");
        if (indexOfSpace < 0) {
            throw new InvalidNameException(
                    "Enter First Name, Last Name separated by a space", new IllegalArgumentException());
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
