package Instituição.Contas;
//import Personas.Data;


import Personas.Data;

public class Corrente extends Conta {
   
    // limite do cheque especial e valor da taxa administrativa.
    private float limCheque;
    private float taxAdmin;
    
    public Corrente(String Nome, int CPF, int Num_Conta, int Senha_Conta, float saldo, 
    boolean conjunta, Personas.Clientes.Clientes Cliente_primario,
    Instituição.Agencia Agencia, Data Abertura_de_Conta, float limite, float taxAdmin){
    super(Nome, CPF, Num_Conta, Senha_Conta, saldo, conjunta, Cliente_primario, Agencia,
        Abertura_de_Conta);
        this.limCheque = 0; //Limite padrão de conta corrente
        this.taxAdmin = 30f;
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
