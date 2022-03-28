
package exception;


    public class InvalidInputException extends RuntimeException {
    public String errorMessage;
    
    public InvalidInputException(){
        this.errorMessage = "InvaliInput";
    } 
         
    
}
