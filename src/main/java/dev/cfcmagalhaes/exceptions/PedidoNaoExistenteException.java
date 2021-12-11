package dev.cfcmagalhaes.exceptions;

public class PedidoNaoExistenteException extends RuntimeException
{
    public PedidoNaoExistenteException( Integer numero )
    {
        super( "Pedido nº " + numero + " não está na lista" );
    }
}
