package Instituição.Contas;

import Instituição.Agencia;
import Personas.Data;
import Personas.Clientes.Clientes;

public abstract class Conta
{
    protected String Nome;
    protected int CPF;
    protected int Num_Conta;
    protected int Senha_Conta;
    protected float saldo;
    protected int StatusDaConta;
    protected boolean conjunta;
    protected Clientes Cliente_primario;
    protected Clientes[] Clientes;
    protected Agencia Agencia;
    protected Data Abertura_de_Conta;
    protected Data Ultima_Movimentacao;



    public Conta(String Nome, int CPF, int Num_Conta, int Senha_Conta, float saldo, int StatusDaConta, boolean conjunta, Clientes Cliente_primario, Clientes[] Clientes, Agencia Agencia, Data Abertura_de_Conta, Data Ultima_Movimentacao) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.Num_Conta = Num_Conta;
        this.Senha_Conta = Senha_Conta;
        this.saldo = saldo;
        this.StatusDaConta = StatusDaConta;
        this.conjunta = conjunta;
        this.Cliente_primario = Cliente_primario;
        this.Clientes = Clientes;
        this.Agencia = Agencia;
        this.Abertura_de_Conta = Abertura_de_Conta;
        this.Ultima_Movimentacao = Ultima_Movimentacao;
    }
    


    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getCPF() {
        return this.CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getNum_Conta() {
        return this.Num_Conta;
    }

    public void setNum_Conta(int Num_Conta) {
        this.Num_Conta = Num_Conta;
    }

    public int getSenha_Conta() {
        return this.Senha_Conta;
    }

    public void setSenha_Conta(int Senha_Conta) {
        this.Senha_Conta = Senha_Conta;
    }

    public float getSaldo() {
        return this.saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getStatusDaConta() {
        return this.StatusDaConta;
    }

    public void setStatusDaConta(int StatusDaConta) {
        this.StatusDaConta = StatusDaConta;
    }

    public boolean isConjunta() {
        return this.conjunta;
    }

    public boolean getConjunta() {
        return this.conjunta;
    }

    public void setConjunta(boolean conjunta) {
        this.conjunta = conjunta;
    }

    public Clientes getCliente_primario() {
        return this.Cliente_primario;
    }

    public void setCliente_primario(Clientes Cliente_primario) {
        this.Cliente_primario = Cliente_primario;
    }

    public Clientes[] getClientes() {
        return this.Clientes;
    }

    public void setClientes(Clientes[] Clientes) {
        this.Clientes = Clientes;
    }

    public Agencia getAgencia() {
        return this.Agencia;
    }

    public void setAgencia(Agencia Agencia) {
        this.Agencia = Agencia;
    }

    public int getNum_Agencia()
    {
        return this.Agencia.getNum_Agencia();
    }


    



}