package dev.cfcmagalhaes.domain;

import dev.cfcmagalhaes.enums.StatusEnum;
import dev.cfcmagalhaes.exceptions.*;

public class GerenciadorPedidos
{
    Pedido[] lista;
    Integer tamanho = 0;

    public GerenciadorPedidos(Integer tamanho )
    {
        this.lista = new Pedido[tamanho];
        this.tamanho = tamanho;
    }

    public Pedido buscarPorNumero( Integer numero )
    {
        if( !this.taVazia( ) )
        {
            for( int i = 0; i < this.tamanho; i++ )
            {
                if( this.lista[i] != null && this.lista[i].getNumero( ) == numero ) {
                    return this.lista[i];
                }
            }
            return null;
        }

        return null;
    }

    private Integer buscarPorPedido(Pedido p )
    {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getNumero() == p.getNumero())
                return i;
        }
        return -1;
    }

    public void cadastrar( Pedido p ) throws PedidoExistenteException, ListaPedidosCheiaException
    {
        // Testa se o pedido já existe
        if( this.buscarPorNumero( p.getNumero( ) ) != null )
            throw new PedidoExistenteException( "Pedido nº " + p.getNumero( ) + " já existe na lista!" );

        // Testa se a lista está cheia
        if( this.taCheia( ) )
            throw new ListaPedidosCheiaException( );

        for( int i = 0; i < lista.length; i++ )
        {
            if (lista[i] == null)
            {
                lista[i] = p;
                System.out.println( "Pedido nº " + p.getNumero( ) + " adicionado com sucesso!" );
                return;
            }
        }
    }

    public void atenderPedido( Integer numero ) throws ListaPedidosVaziaException, PedidoNaoExistenteException
    {
        if( this.taVazia( ) )
            throw new ListaPedidosVaziaException( );

        Pedido p = this.buscarPorNumero( numero );

        if( p == null )
            throw new PedidoNaoExistenteException( numero );

        int i = this.buscarPorPedido( p );

        if( i != -1 )
            lista[i].setAtendido( StatusEnum.ATENDIDO );
    }

    public void relatorioCliente( Integer codigoCliente, Boolean todos, Boolean atendidos )
    {
        Pedido[] lista =  listaPedidosPorCliente( codigoCliente );
        Pedido[] relatorio = new Pedido[lista.length];

        if( !todos )
        {
            int i = 0;
            if( atendidos )
                for( int j = 0; j < lista.length; j++ )
                {
                    if( lista[j] != null && lista[j].getAtendido() == StatusEnum.ATENDIDO )
                    {
                        relatorio[i] = lista[j];
                        i++;
                    }

                }
            else
            {
                for( int j = 0; j < lista.length; j++ )
                    if (lista[j] != null && lista[j].getAtendido() == StatusEnum.PENDENTE)
                    {
                        relatorio[i] = lista[j];
                        i++;
                    }
            }
        }
        else
            relatorio = lista;

        this.imprimirRelatorio( relatorio, calculaTotal( relatorio ), false, 0.0 );
    }

    public void pagarVendedor( Integer codigoVendedor, Double porcent )
    {
        Pedido[] lista = this.listaPedidosPorVendedor( codigoVendedor );
        Pedido[] relatorioPagamento = new Pedido[tamanho];

        int j = 0;

        for( int i = 0; i < lista.length; i++)
        {
            if( lista[i] != null && lista[i].getAtendido( ) == StatusEnum.ATENDIDO && !lista[i].getComissaoPaga( ) )
            {
                relatorioPagamento[j] = lista[i];
                lista[i].setComissaoPaga( true );
                j++;
            }
        }

        Double total = calculaTotal( relatorioPagamento );
        Double comissao = calculaComissao( total, porcent );

        this.imprimirRelatorio( relatorioPagamento, total, true, comissao );

    }

    private boolean vendedorExiste( Integer codigoVendedor )
    {
        if( !this.taVazia( ) )
        {
            for( int i = 0; i < this.lista.length; i++)
            {
                if( this.lista[i].getCodigoVendedor( ) == codigoVendedor )
                    return true;
            }
            return false;
        }
        throw new ListaPedidosVaziaException( );
    }

    private Double calculaComissao( Double total, Double porcent)
    {
        return total * porcent / 100;
    }

    private Double calculaTotal( Pedido[] relatorio )
    {
        Double total = 0.0;
        int i = 0;

        while( relatorio[i] != null )
        {
            total += relatorio[i].getValor( );
            i++;
        }

        return total;
    }

    private Pedido[] listaPedidosPorCliente( Integer codigoCliente )
    {
        Pedido[] listaPedidosPorCliente = new Pedido[this.tamanho];

        int j = 0;

        for( int i = 0; i < this.tamanho; i++ )
        {
            if( this.lista[i].getCodigoCliente( ) == codigoCliente )
            {
                listaPedidosPorCliente[j] = this.lista[i];
                j++;
            }
        }

        return listaPedidosPorCliente;
    }

    private Pedido[] listaPedidosPorVendedor( Integer codigoVendedor )
    {
        if( vendedorExiste( codigoVendedor ) )
        {
            Pedido[] listaPedidosPorVendedor = new Pedido[tamanho];

            int j = 0;

            for( int i = 0; i < this.tamanho; i++ )
            {
                if( this.lista[i].getCodigoVendedor( ) == codigoVendedor )
                {
                    listaPedidosPorVendedor[j] = this.lista[i];
                    j++;
                }
            }
            return listaPedidosPorVendedor;
        }
        else {
            throw new VendedorNaoExisteException( codigoVendedor );
        }
    }

    private boolean taVazia( )
    {
        if( this.lista[0] == null )
                return true;

        return false;
    }

    private boolean taCheia( )
    {
        if( lista[lista.length - 1] == null )
            return false;

        return true;
    }

    private void imprimirRelatorio( Pedido[] lista, Double total, Boolean exibeComissao, Double valorComissao )
    {
        String saida = "ListaDePedidos[ \n";

        for( Pedido pedido: lista )
        {
            if (pedido == null)
                break;

            saida += pedido.toString() + "\n";
        }
        saida += "] \n " +
                "Valor Total dos Pedidos R$ " + total;

        if( exibeComissao )
            saida += "\n" +
                "Valor Total da Comissão R$ " + valorComissao;

        System.out.println( saida );
    }

}
