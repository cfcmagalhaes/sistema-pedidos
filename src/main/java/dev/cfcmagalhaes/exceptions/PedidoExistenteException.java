package dev.cfcmagalhaes.exceptions;

public class PedidoExistenteException extends RuntimeException
{
    public PedidoExistenteException( String mensagem )
    {
        super( mensagem );
    }
}
