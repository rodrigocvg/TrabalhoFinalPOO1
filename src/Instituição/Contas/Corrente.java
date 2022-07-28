package Instituição.Contas;
//import Personas.Data;
import java.util.Date;

import Personas.Data;

public class Corrente extends Conta {
   
    // limite do cheque especial e valor da taxa administrativa.
    private float limCheque;
    private float taxAdmin;
    public float getLimCheque() {
        return limCheque;
    }

    public Corrente(String Nome, int CPF, int Num_Conta, int Senha_Conta, float saldo, int StatusDaConta,
    boolean conjunta, Personas.Clientes.Clientes Cliente_primario, Personas.Clientes.Clientes[] Clientes,
    Instituição.Agencia Agencia, Data Abertura_de_Conta, Data Ultima_Movimentacao, float limite, float taxAdmin) {
    super(Nome, CPF, Num_Conta, Senha_Conta, saldo, StatusDaConta, conjunta, Cliente_primario, Clientes, Agencia,
        Abertura_de_Conta, Ultima_Movimentacao);
        this.limCheque = 0;
        this.taxAdmin = 0;

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
