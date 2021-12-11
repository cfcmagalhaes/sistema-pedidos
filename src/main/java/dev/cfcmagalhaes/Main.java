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
//
		ListaDePedidos lp1 = new ListaDePedidos( 4 );

		lp1.cadastrar( ped1 );
		lp1.cadastrar( ped2 );
		lp1.cadastrar( ped3 );
		lp1.cadastrar( ped4 );

		System.out.println( lp1 );
		lp1.atenderPedido( 121 );
		System.out.println( lp1 );

//		lp1.buscar( 125 );

//		System.out.println( "A lista tá vazia: " + lp1.ehVazia( ) );
//		System.out.println( "A lista tá cheia: " + lp1.taCheia( ) );

//		lp1.buscar( 121 );

//		String[] lista = new String[5];
//
//		lista[0] = "Item 1";
//		lista[1] = "Item 2";
//		lista[2] = "Item 3";
//
//		for (String item: lista)
//		{
//			System.out.println(item);
//
//		}


    }
}
