package dev.cfcmagalhaes;

import dev.cfcmagalhaes.domain.ListaDePedidos;
import dev.cfcmagalhaes.domain.Pedido;

public class Main
{
    public static void main( String[] args )
    {
	Pedido ped1 = new Pedido( 121, 1, 10, 150.00 );
	Pedido ped2 = new Pedido( 122, 1, 11, 10.00 );
	Pedido ped3 = new Pedido( 123, 2, 10, 50.00 );
	Pedido ped4 = new Pedido( 124, 2, 11, 1150.00 );

	ListaDePedidos lp1 = new ListaDePedidos( 2 );
	ListaDePedidos lp2 = new ListaDePedidos( 2 );

	lp1.cadastrar( ped1 );
	lp1.cadastrar( ped2 );

//	lp1.toString( );


    }
}
