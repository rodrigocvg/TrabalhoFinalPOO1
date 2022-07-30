package Instituição.Contas;
import Personas.Clientes.Clientes;
import Personas.Data;
import Instituição.Agencia;

public class Salario extends Conta {
    // limite para saque e limite para transferência.
    private float Limite_saque;
    private float Limite_Trnaferencia;


    public Salario(String Nome, int CPF, int Num_Conta, int Senha_Conta, float saldo, boolean conjunta, Clientes Cliente_primario, Agencia Agencia, Data Abertura_de_Conta,
        float Limite_saque, float Limite_Trnaferencia) 
    {
        super(Nome, CPF, Num_Conta, Senha_Conta, saldo, conjunta, Cliente_primario, Agencia, Abertura_de_Conta);
        this.Limite_saque = Limite_saque;
        this.Limite_Trnaferencia = Limite_Trnaferencia;
    }


    public float getLimite_saque(int Senha) throws IllegalArgumentException
    {
        if(this.Senha_Conta == Senha)
            return this.Limite_saque;
        throw new IllegalArgumentException("Senha incorreta");
    }

    public void setLimite_saque(float Limite_saque) {
        this.Limite_saque = Limite_saque;
    }

    public float getLimite_Trnaferencia(int Senha) throws IllegalArgumentException 
    {
        if(this.Senha_Conta == Senha)
            return this.Limite_Trnaferencia;

        throw new IllegalArgumentException("Senha incorreta");
    }

    public void setLimite_Trnaferencia(float Limite_Trnaferencia) {
        this.Limite_Trnaferencia = Limite_Trnaferencia;
    }




}
