package Instituição.Contas;

import Personas.Data;

public class Poupanca extends Conta {
   

    // rendimento do mês atual.
    private float rendimento;
    
    public void TesteGit(){
        System.out.println("Me Deleta");
    }
    public Poupanca(String Nome, int CPF, int Num_Conta, int Senha_Conta, float saldo, boolean StatusDaConta,
    boolean conjunta, Personas.Clientes.Clientes Cliente_primario,
    Instituição.Agencia Agencia, Data Abertura_de_Conta,float rendimento) {
    super(Nome, CPF, Num_Conta, Senha_Conta, saldo, conjunta, Cliente_primario, Agencia,
        Abertura_de_Conta);
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
