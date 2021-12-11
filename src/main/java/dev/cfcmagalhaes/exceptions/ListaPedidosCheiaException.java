package dev.cfcmagalhaes.exceptions;

public class ListaPedidosCheiaException extends RuntimeException
{
    public ListaPedidosCheiaException( )
    {
        super( "Lista Cheia!" );
    }
}
