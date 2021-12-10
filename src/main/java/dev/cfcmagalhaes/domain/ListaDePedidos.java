package dev.cfcmagalhaes.domain;

import dev.cfcmagalhaes.domain.Pedido;
import dev.cfcmagalhaes.util.ListaEncadeada;

public class ListaDePedidos
{
    ListaEncadeada<Pedido> lista;
    Integer tamanho;
    Double valorTotal;

    public ListaDePedidos( Integer tamanho )
    {
        this.tamanho = tamanho;
        this.valorTotal = 0.0;
	this.lista = new ListaEncadeada<>();
    }

    public ListaEncadeada<Pedido> getLista( )
    {
        return lista;
    }

    public void setLista( ListaEncadeada<Pedido> lista )
    {
        this.lista = lista;
    }

    public Integer getTamanho( )
    {
        return tamanho;
    }

    public void setTamanho( Integer tamanho )
    {
        this.tamanho = tamanho;
    }

    public Double getValorTotal( )
    {
        return valorTotal;
    }

    @Override public String toString( )
    {
        return "ListaDePedidos{" + "lista=" + lista + '}';
    }

    // Método cadastrarPedido( Pedido pedido ) retorna void, Precisa verificar se já existe pelo numero e lance uma
    // exception. Lançar exception se estiver cheia tambem.
    public void cadastrar( Pedido p )
    {
        for( int i = 0; this.lista.get ; i++ )
        {

        }
//        lista.validaIndice( p.getNumero( ) ) )


        if( lista.get( p.getNumero( ) ) != null )
            throw new RuntimeException( "Não foi possivel cadastrar: Pedido já cadastrado!" );

        lista.add( p );

        System.out.println( "Pedido nº " + p.getNumero( ) + " cadastrado com sucesso" );
    }

    // Método buscarPedido( Integer numero ) retorna Pedido ou null
    public Pedido buscar( Integer numero )
    {
        return lista.get( numero );
    }

    // Método atenderPedido( Integer numero ) retorna void altera a flag pedido.atendido para true. Lançar exceção
    // verificada caso não exista pedido com esse numero na lista.
    public void atender( Integer numero )
    {
        if( lista.isEmpty( ) )
            throw new RuntimeException( "Lista vazia." );

        if( lista.get( numero ) == null )
            throw new RuntimeException( "Não foi possivel encontrar o pedido." );  //(Criar classe exception)

        lista.get( numero ).setAtendido( true );

        System.out.println( "Alteração de status para o pedido n° " + numero );
    }

    // Método relatorioCliente( Integer codCli, Boolean todos, Boolean atendidos) retorna void.
    // Imprime os pedidos do cliente informado no parametro.
    // Se o 2º parametro for true, então imprime todos os pedidos e o 3o parametro é ignorado.
    // Se o 2° for false imprime somente os atendidos ou somente os pendentes. Em todos os caso no final do
    // relatorio deve ser impresso o valor total dos pedidos listados.

    //    public void relatorioCliente( Integer codigoCliente, Boolean todos, Boolean atendidos )
    //    {
    //	if( lista.isEmpty( ) )
    //	    throw new RuntimeException( "Lista vazia." );
    //
    //	if( todos )
    //	{
    //	    lista.toString( );
    //	    return;
    //	}
    //
    //	if( atendidos )
    //	{
    //	    for( lista:
    //		  )
    //	    {
    //
    //	    }
    //	}
    //
    //	System.out.println( "Llista" );
    //
    //    }

    // Método pagarVendedor( Integer codigoVendedor, Double porcent) retorna void. imprime todos os pedidos do vendedor
    // informado que já foram atendidos mas ainda não pagos. Alterar a flag ComissaoPaga para true. No final do
    // relatorio imprime o valor total dos pedidos impressos e a comissão que deve ser paga ao vendedor.
    // A comissão é calculada aplicando a porcentagem informada no parametro porcent ao valor total dos pedidos
    // listados.
    public void pagarVendedor( Integer codigoVendedor, Double porcent )
    {

    }
}
