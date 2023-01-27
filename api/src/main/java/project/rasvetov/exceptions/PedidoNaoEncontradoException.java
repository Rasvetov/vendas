package project.rasvetov.exceptions;

//classe de exception personalizada para caso o pedido não for encontrado no banco de dados
public class PedidoNaoEncontradoException extends RuntimeException{
    public PedidoNaoEncontradoException(){
        super("Pedido não encontrado.");
    }
}
