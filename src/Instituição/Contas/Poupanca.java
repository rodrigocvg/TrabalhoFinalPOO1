package Instituição.Contas;

import Personas.Data;

public class Poupanca extends Conta {
   

    // rendimento do mês atual.
    private float rendimento;

    public Poupanca(String Nome, int CPF, int Num_Conta, int Senha_Conta, float saldo, int StatusDaConta,
    boolean conjunta, Personas.Clientes.Clientes Cliente_primario, Personas.Clientes.Clientes[] Clientes,
    Instituição.Agencia Agencia, Data Abertura_de_Conta, Data Ultima_Movimentacao, float rendimento) {
    super(Nome, CPF, Num_Conta, Senha_Conta, saldo, StatusDaConta, conjunta, Cliente_primario, Clientes, Agencia,
        Abertura_de_Conta, Ultima_Movimentacao);
    this.rendimento = rendimento;
//TODO Auto-generated constructor stub
}
    public float getRendimento() {
        return rendimento;
    }

    public void setRendimento(float rendimento) {
        this.rendimento = rendimento;
    }
    
}
