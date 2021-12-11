package dev.cfcmagalhaes;

import dev.cfcmagalhaes.domain.GerenciadorPedidos;
import dev.cfcmagalhaes.domain.Pedido;

public class Main
{
    public static void main( String[] args )
    {
		GerenciadorPedidos gp = new GerenciadorPedidos( 5 );

		gp.cadastrar( new Pedido( 121, 1, 10, 150.00 ) );
		gp.cadastrar( new Pedido( 122, 1, 11, 10.00  ) );
		gp.cadastrar( new Pedido( 123, 2, 10, 50.00  ) );
		gp.cadastrar( new Pedido( 124, 2, 11, 1150.00 ) );
		gp.cadastrar( new Pedido( 125, 1, 10, 110.00 ) );

		System.out.println( gp.buscarPorNumero( 120 ) );

//		lp.atenderPedido( 125 );

//		lp.pagarVendedor( 10, 5.0 );

//		lp.relatorioCliente( 1, false, false );
    }
}
