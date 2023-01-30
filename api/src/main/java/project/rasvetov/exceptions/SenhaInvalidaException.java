package project.rasvetov.exceptions;

public class SenhaInvalidaException extends RuntimeException{
    public SenhaInvalidaException(){
        super("Senha inválida.");
    }
}
