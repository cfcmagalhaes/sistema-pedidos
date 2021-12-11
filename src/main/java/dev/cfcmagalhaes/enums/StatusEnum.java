package dev.cfcmagalhaes.enums;

public enum StatusEnum
{
    ATENDIDO( "Atendido" ), PENDENTE( "Pendente" );

    private String status;

    StatusEnum( String status )
    {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
