package dev.cfcmagalhaes.domain;

import dev.cfcmagalhaes.enums.StatusEnum;
import dev.cfcmagalhaes.exceptions.ListaPedidosCheiaException;
import dev.cfcmagalhaes.exceptions.ListaPedidosVaziaException;
import dev.cfcmagalhaes.exceptions.PedidoExistenteException;
import dev.cfcmagalhaes.exceptions.PedidoNaoExistenteException;

public class ListaDePedidos
{
    Pedido[] lista;

    /*
    Construtor da Classe
     */
    public ListaDePedidos( Integer tamanho )
    {
        this.lista = new Pedido[tamanho];
    }

    /*
    Retorna a lista de Pedidos
     */
    public Pedido[] getLista() {
        return this.lista;
    }

    /*
    Método buscarPedido( Integer numero )
    retorna Pedido ou null
     */
    public Pedido buscar( Integer numero )
    {
        if( !ehVazia( ) ) {
            for( Pedido pedido : lista )
                try {
                    if( pedido.getNumero( ) == numero )
                        return pedido;
                }
                catch( NullPointerException npe ) {
                    return null;
                }
        }

        return null;
    }

    /*
    Método buscarPedido
    Retorna index do array
     */
    private Integer buscar( Pedido p )
    {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getNumero() == p.getNumero())
                return i;
        }
        return -1;
    }

    // Método cadastrarPedido( Pedido pedido ) retorna void, Precisa verificar se já existe pelo numero e
    // lance uma exception. Lançar exception se estiver cheia tambem.
    public void cadastrar( Pedido p )throws PedidoExistenteException, ListaPedidosCheiaException
    {
        // Testa se o pedido já existe
        if( this.buscar( p.getNumero( ) ) != null )
            throw new PedidoExistenteException( "Pedido nº " + p.getNumero( ) + " já existe na lista!" );

        // Testa se a lista está cheia
        if( this.taCheia( ) )
            throw new ListaPedidosCheiaException( );

        for( int i = 0; i < lista.length; i++ )
        {
            if (lista[i] == null) {
                lista[i] = p;
                System.out.println( "Pedido nº " + p.getNumero( ) + " adicionado com sucesso!" );
                return;
            }
        }
    }


    // Método atenderPedido( Integer numero ) retorna void altera a flag pedido.atendido para true.
    // Lançar exceção verificada caso não exista pedido com esse numero na lista.
    public void atenderPedido( Integer numero ) throws ListaPedidosVaziaException, PedidoNaoExistenteException
    {
        if( this.ehVazia( ) )
            throw new ListaPedidosVaziaException( );

        Pedido p = this.buscar( numero );

        if( p == null )
            throw new PedidoNaoExistenteException( numero );

        int i = this.buscar( p );

        if( i != -1 )
            lista[i].setAtendido( StatusEnum.ATENDIDO );
    }

//     Método relatorioCliente( Integer codCli, Boolean todos, Boolean atendidos) retorna void.
//     Imprime os pedidos do cliente informado no parametro.
//     Se o 2º parametro for true, então imprime todos os pedidos e o 3o parametro é ignorado.
//     Se o 2° for false imprime somente os atendidos ou somente os pendentes. Em todos os caso no final do
//     relatorio deve ser impresso o valor total dos pedidos listados.
    public void relatorioCliente( Integer codigoCliente, Boolean todos, Boolean atendidos )
    {
        Pedido[] lpc = this.listaPedidosPorCliente( codigoCliente );
        if (todos) {
            lista.toString();
            return;
        }

        if (atendidos) {
            for (lista:
            ) {

            }
        }

        System.out.println("Llista");

    }

    private Pedido[] listaPedidosPorCliente( Integer codigoCliente )
    {
        Pedido[] lista;
        int i = 0;

        for( Pedido pedido: this.lista )
        {
            if( pedido.getCodigoCliente( ) == codigoCliente )
                lista[i] = pedido;
            i++;
        }

    }

    // Método pagarVendedor( Integer codigoVendedor, Double porcent) retorna void. imprime todos os pedidos do vendedor
    // informado que já foram atendidos mas ainda não pagos. Alterar a flag ComissaoPaga para true. No final do
    // relatorio imprime o valor total dos pedidos impressos e a comissão que deve ser paga ao vendedor.
    // A comissão é calculada aplicando a porcentagem informada no parametro porcent ao valor total dos pedidos
    // listados.
//    public void pagarVendedor( Integer codigoVendedor, Double porcent )
//    {
//
//    }

    private boolean ehVazia( )
    {
        for( int i = 0; i < lista.length; i++ )
            if( lista[i] != null )
                return false;

        return true;
    }

    private boolean taCheia( )
    {
        if( lista[lista.length - 1] == null )
            return false;

        return true;
    }

    @Override
    public String toString( )
    {
        String saida = "ListaDePedidos[ \n";
        for( Pedido pedido: lista)
            saida += pedido.toString() + "\n";

        return saida + "]";
    }
}
