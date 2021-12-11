package dev.cfcmagalhaes;

import dev.cfcmagalhaes.domain.ListaDePedidos;
import dev.cfcmagalhaes.domain.Pedido;

public class Main
{
    public static void main( String[] args )
    {
		ListaDePedidos lp = new ListaDePedidos( 5 );

		lp.cadastrar( new Pedido( 121, 1, 10, 150.00 ) );
		lp.cadastrar( new Pedido( 122, 1, 11, 10.00  ) );
		lp.cadastrar( new Pedido( 123, 2, 10, 50.00  ) );
		lp.cadastrar( new Pedido( 124, 2, 11, 1150.00 ) );
		lp.cadastrar( new Pedido( 125, 1, 10, 110.00 ) );

		lp.atenderPedido( 125 );

		lp.pagarVendedor( 10, 5.0 );

		lp.relatorioCliente( 1, false, false );
    }
}
