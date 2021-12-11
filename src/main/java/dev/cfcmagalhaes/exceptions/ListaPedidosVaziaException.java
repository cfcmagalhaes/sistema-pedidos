package dev.cfcmagalhaes.exceptions;

public class ListaPedidosVaziaException extends RuntimeException
{
    public ListaPedidosVaziaException( )
    {
        super( "Lista de pedidos vazia" );
    }
}
