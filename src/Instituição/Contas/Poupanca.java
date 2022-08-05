package Instituição.Contas;

import Personas.Data;

public class Poupanca extends Conta {
   

    // rendimento do mês atual. 
    private float rendimento;
    
    
    
    public Poupanca(int Num_Conta, int Senha_Conta, float saldo,
    boolean conjunta, Personas.Clientes.Clientes Cliente_primario,
    Instituição.Agencia Agencia, Data Abertura_de_Conta,float rendimento) {
    super(Num_Conta, Senha_Conta, saldo, conjunta, Cliente_primario, Agencia,
        Abertura_de_Conta);
    this.rendimento = saldo * 0.5f;

}


@Override
    public String SaidaArquivo() {
        return super.SaidaArquivo() + ";" + this.rendimento;
    }
    @Override
    public void depositar(float valor,int senha){
        if(this.verificaSenha(senha)){
        this.saldo += valor;
        this.rendimento = saldo* 0.5f;
        }
    }

    @Override
    public void sacar(float valor,int senha){
        if(this.verificaSenha(senha)){
        this.saldo -= valor;
        this.rendimento = saldo*0.5f;
        }

    }
    @Override
    public void transferir(Conta c, float valor, int senha) {
        super.transferir(c, valor, senha);
        this.rendimento = saldo*0.5f;
    }


    public float getRendimento() {
        return rendimento;
    }

    public void setRendimento(float rendimento) {
        this.rendimento = rendimento;
    }
    
}
