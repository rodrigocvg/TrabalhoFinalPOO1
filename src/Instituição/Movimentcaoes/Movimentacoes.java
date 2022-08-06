package Instituição.Movimentcaoes;

import Personas.Data;

public class Movimentacoes {
    private Data Data_transacao;
    private float valor;
    private String tipo_transacao;


    public Movimentacoes(Data Data_transacao, float valor, String tipo_transacao) {
        this.Data_transacao = Data_transacao;
        this.valor = valor;
        this.tipo_transacao = tipo_transacao;
    }

    public String DadosMovimentacao()
    {
        return Data_transacao.DadosData() + ";" + valor + ";" + tipo_transacao;
    }

    public Data getData_transacao() {
        return this.Data_transacao;
    }

    public void setData_transacao(Data Data_transacao) {
        this.Data_transacao = Data_transacao;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTipo_transacao() {
        return this.tipo_transacao;
    }

    public void setTipo_transacao(String tipo_transacao) {
        this.tipo_transacao = tipo_transacao;
    }

    
    
}
