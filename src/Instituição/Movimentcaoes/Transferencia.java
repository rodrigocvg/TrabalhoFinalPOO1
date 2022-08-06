package Instituição.Movimentcaoes;

import Personas.Data;

public class Transferencia extends Movimentacoes{
    private int Num_Conta_Destinatario;
    private int Num_Agencia_Destinario;
    private int Num_Banco_Destinario;


    public Transferencia(Data Data_transacao, float valor, String tipo_transacao, int Num_Conta_Destinatario, int Num_Agencia_Destinario, int Num_Banco_Destinario) {
        
        super(Data_transacao, valor, tipo_transacao);
        this.Num_Conta_Destinatario = Num_Conta_Destinatario;
        this.Num_Agencia_Destinario = Num_Agencia_Destinario;
        this.Num_Banco_Destinario = Num_Banco_Destinario;
    }

    public String DadosTransferencia()
    {
        return DadosMovimentacao() + ";" + Num_Conta_Destinatario +";" +Num_Conta_Destinatario +";"+ Num_Banco_Destinario;
    }

    public int getNum_Conta_Destinatario() {
        return this.Num_Conta_Destinatario;
    }

    public void setNum_Conta_Destinatario(int Num_Conta_Destinatario) {
        this.Num_Conta_Destinatario = Num_Conta_Destinatario;
    }

    public int getNum_Agencia_Destinario() {
        return this.Num_Agencia_Destinario;
    }

    public void setNum_Agencia_Destinario(int Num_Agencia_Destinario) {
        this.Num_Agencia_Destinario = Num_Agencia_Destinario;
    }

    public int getNum_Banco_Destinario() {
        return this.Num_Banco_Destinario;
    }

    public void setNum_Banco_Destinario(int Num_Banco_Destinario) {
        this.Num_Banco_Destinario = Num_Banco_Destinario;
    }

    

}
