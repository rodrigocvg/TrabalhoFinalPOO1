package Instituição.Contas;

import Instituição.Agencia;
import Personas.Data;
import Personas.Clientes.Clientes;


//
public abstract class Conta
{
    //protected String Nome;
    //protected int CPF;
    protected int Num_Conta;
    protected int Senha_Conta;
    protected float saldo;
    protected boolean StatusDaConta;
    protected boolean conjunta;
    protected Clientes Cliente_primario; //?
    protected Clientes Cliente_secundario;
    protected Agencia Agencia;
    protected Data Abertura_de_Conta;
    protected Data Ultima_Movimentacao;


    //Construtor Conta Unica
    public Conta(int Num_Conta, int Senha_Conta, float saldo, boolean conjunta, Clientes Cliente_primario, Agencia Agencia, Data Abertura_de_Conta) {
        //this.Nome = Nome;
        //this.CPF = CPF;
        this.Num_Conta = Num_Conta;
        this.Senha_Conta = Senha_Conta;
        this.saldo = saldo;
        this.StatusDaConta = true;
        this.conjunta = conjunta;
        this.Cliente_primario = Cliente_primario;
        this.Cliente_secundario = null;
        this.Agencia = Agencia;
        this.Abertura_de_Conta = Abertura_de_Conta;
    }

    public String SaidaArquivo(){
        return this.Num_Conta + ";" +  this.Senha_Conta + ";" + this.saldo + ";" + this.conjunta + ";" + this.Cliente_primario.getNome() + ";" + this.Cliente_primario.getCPF() + ";" + 
                this.Agencia.getNome_Agencia() + ";" + this.Agencia.getNum_Agencia() + ";" + this.Abertura_de_Conta.getDia() + ";" + this.Abertura_de_Conta.getMes() + ";" + this.Abertura_de_Conta.getAno();
    }

    public void verifica(){
        if(this.conjunta){

        }
    }

    public boolean verificaSenha(int senha){         //fiz e não vi que Israel ja tinha feito 
        if(this.Senha_Conta == senha){
            return true;
        }
        else{
            return false;
        }
    }

    public void desativarConta(int senha){
        if(this.verificaSenha(senha) && this.StatusDaConta == true){
            this.setStatusDaConta(false);
            System.out.println("Conta desativada com sucesso");
        }
    }

    public void depositar(float valor, int senha){
        if(this.verificaSenha(senha)){
            this.saldo += valor;
        }
        else{ //TRATAR ERRO DEPOIS
            System.out.println("Senha incorreta");
        }
    }

    public void sacar(float valor,int senha){
        if(this.verificaSenha(senha)){
        this.saldo -= valor;
        }
        else{ //TRATAR ERRO DEPOIS
            System.out.println("Senha incorreta");
        }

    }

    public void transferir(Conta c,float valor,int senha){
        if(this.verificaSenha(senha)){
        c.setSaldo(c.getSaldo()+valor);
        this.saldo -= valor;
        }
        else{ //TRATAR ERRO DEPOIS
            System.out.println("Senha incorreta");
        }

    }

    public void consultaSaldo(int senha){
        if(this.verificaSenha(senha)){
            System.out.println("O saldo atual é de:" + this.getSaldo());
            }
            else{ //TRATAR ERRO DEPOIS
                System.out.println("Senha incorreta");
            }
        
    }

    public void realizarPag(float valor,int senha){
        if(this.verificaSenha(senha)){
        this.saldo -= valor;
        }
        else{ //TRATAR ERRO DEPOIS
            System.out.println("Senha incorreta");
        }

    }

    
    //public boolean ValidaSenha(int Senha)
  //  {
    //    boolean validacao = false; // senha incorreta
    //    if (this.Senha_Conta == Senha) // se a senha tiver certa altera valor do boleano
    //        validacao=true;
    //    return validacao; // retorna resultado.
    //}

    

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

    public boolean getStatusDaConta() {
        return this.StatusDaConta;
    }

    public void setStatusDaConta(boolean StatusDaConta) {
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