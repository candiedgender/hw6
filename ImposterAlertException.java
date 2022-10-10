/**
* Class that creates the imposter alert exception
*
* @author cproenza3
* @version 1
*/
public class ImposterAlertException extends Exception {
    private String message;

    /**
    * Does a supercall of the line being thrown
    * @param message is the message that gets thrown in Hogwarts.java
    */
    public ImposterAlertException(String message) {
        super(message);
    }


}