package dev.cfcmagalhaes.exceptions;

public class VendedorNaoExisteException extends RuntimeException
{
        public VendedorNaoExisteException( Integer codigoVendedor )
        {
                super( "Vendedor nº " + codigoVendedor + " não existe." );
        }

}
