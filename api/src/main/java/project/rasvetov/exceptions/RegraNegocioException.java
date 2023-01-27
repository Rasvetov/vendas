package project.rasvetov.exceptions;


// classe de exception personalizada relacionada a regra de negócios
public class RegraNegocioException extends RuntimeException{
    public RegraNegocioException(String message){
        super(message);
    }
}
