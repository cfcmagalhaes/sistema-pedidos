package dev.cfcmagalhaes.domain;

import dev.cfcmagalhaes.enums.StatusEnum;

import java.util.Objects;

public class Pedido
{
    private Integer numero;
    private Integer codigoCliente;
    private Integer codigoVendedor;
    private Double valor;
    private StatusEnum atendido = StatusEnum.PENDENTE;
    private Boolean comissaoPaga = false;

    public Pedido( Integer numero,
                   Integer codigoCliente,
                   Integer codigoVendedor,
                   Double valor )
    {
        this.numero = numero;
        this.codigoCliente = codigoCliente;
        this.codigoVendedor = codigoVendedor;
        this.valor = valor;
    }

    public Integer getNumero( )
    {
        return numero;
    }

    public Integer getCodigoCliente( )
    {
        return codigoCliente;
    }

    public void setCodigoCliente( Integer codigoCliente )
    {
        this.codigoCliente = codigoCliente;
    }

    public Integer getCodigoVendedor( )
    {
        return codigoVendedor;
    }

    public void setCodigoVendedor( Integer codigoVendedor )
    {
        this.codigoVendedor = codigoVendedor;
    }

    public Double getValor( )
    {
        return valor;
    }

    public void setValor( Double valor )
    {
        this.valor = valor;
    }

    public StatusEnum getAtendido() {
        return atendido;
    }

    public void setAtendido(StatusEnum atendido) {
        this.atendido = atendido;
    }

    public Boolean getComissaoPaga( )
    {
        return comissaoPaga;
    }

    public void setComissaoPaga( Boolean comissaoPaga )
    {
        this.comissaoPaga = comissaoPaga;
    }

    @Override public boolean equals( Object o )
    {
        if( this == o )
            return true;
        if( o == null || getClass( ) != o.getClass( ) )
            return false;
        Pedido pedido = (Pedido)o;
        return Objects.equals( numero, pedido.numero );
    }

    @Override public int hashCode( )
    {
        return Objects.hash( numero );
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", codigoCliente=" + codigoCliente +
                ", codigoVendedor=" + codigoVendedor +
                ", valor=" + valor +
                ", atendido=" + atendido +
                ", comissaoPaga=" + comissaoPaga +
                "}";
    }
}
