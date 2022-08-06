package Instituição.Contas;
//import Personas.Data;

import Personas.Data;
import Personas.Clientes.*;

public class Corrente extends Conta{
   
    // limite do cheque especial e valor da taxa administrativa.
    private float limCheque;
    private float taxAdmin;
    

    //Construtor conta única
    public Corrente(int Num_Conta, int Senha_Conta, float saldo, 
    boolean conjunta, Clientes Cliente_primario,
    int Num_Agencia, Data Abertura_de_Conta, float limite, float taxAdmin){
    super(Num_Conta, Senha_Conta, saldo, conjunta, Cliente_primario, Num_Agencia,
        Abertura_de_Conta);
        this.limCheque = 0; //Limite padrão de conta corrente
        this.taxAdmin = 30f;
        }

        @Override
        public String SaidaArquivo() {
            return  "Corrente;"+super.SaidaArquivo() + ";" + this.limCheque + ";" + this.taxAdmin ;
        }
       
        

    @Override
    public void sacar(float valor, int senha) {
        super.sacar(valor, senha);
    }

    @Override
    public void depositar(float valor, int senha) {
        super.depositar(valor, senha);
    }



    @Override
    public void desativarConta(int senha) {
        super.desativarConta(senha);
    }

    @Override
    public void transferir(Conta c, float valor, int senha) {
        super.transferir(c, valor, senha);
    }

    
        
    public float getLimCheque() {
        return limCheque;
    }

    public void setLimCheque(float limCheque) {
        this.limCheque = limCheque;
    }
    public float getTaxAdmin() {
        return taxAdmin;
    }
    public void setTaxAdmin(float taxAdmin) {
        this.taxAdmin = taxAdmin;
    }





    








    

    
}
