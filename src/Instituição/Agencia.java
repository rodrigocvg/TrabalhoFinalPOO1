package Instituição;
import java.util.LinkedList;
import Instituição.Contas.Conta;
import Personas.Endereco;
import Personas.Clientes.Clientes;
import Personas.Funcionarios.*;
import GerenciadorArquivos.GerenArquivos;

public class Agencia {
    private int Num_Agencia;
    private String Nome_Agencia;
    private Gerente Gerente;
    private Endereco endereco_agencia;
    private LinkedList<Conta> contas; 
    private LinkedList<Funcionario> Funcionarios;
    

    
    public Agencia(String nome_Agencia,int num_Agencia) {
        Num_Agencia = num_Agencia;
        Nome_Agencia = nome_Agencia;
        contas = new LinkedList<>();
        Funcionarios = new LinkedList<>();
    }

    public Agencia(int Num_Agencia, String Nome_Agencia, Gerente Gerente, Endereco endereco_agencia) {
        this.Num_Agencia = Num_Agencia;
        this.Nome_Agencia = Nome_Agencia;
        this.Gerente = Gerente;
        Gerente.setAgencia(this.Num_Agencia);
        Gerente.setEsta_Em_uma_Agencia(true);
        this.endereco_agencia = endereco_agencia;
        contas = new LinkedList<>();
        Funcionarios = new LinkedList<>();
    }

    /////////////////////////////////////////////////
    ///
    ///             Getters e Setters             ///
    ///
    /////////////////////////////////////////////////

    public int getNum_Agencia() {
        return this.Num_Agencia;
    }

    public void setNum_Agencia(int Num_Agencia) {
        this.Num_Agencia = Num_Agencia;
    }

    public String getNome_Agencia() {
        return this.Nome_Agencia;
    }

    public void setNome_Agencia(String Nome_Agencia) {
        this.Nome_Agencia = Nome_Agencia;
    }

    public Gerente getGerente() {
        return this.Gerente;
    }

    public LinkedList<Funcionario> getFuncionarios() {
        return this.Funcionarios;
    }

    public void setFuncionarios(LinkedList<Funcionario> Funcionarios) {
        this.Funcionarios = Funcionarios;
    }

    public void setGerente(Gerente Gerente) {
        this.Gerente.setAgencia(0);
        this.Gerente.setEsta_Em_uma_Agencia(false);
        Gerente.setAgencia(this.Num_Agencia);
        Gerente.setEsta_Em_uma_Agencia(true);       
        this.Gerente = Gerente;
    }

    public Endereco getEndereco_agencia() {
        return this.endereco_agencia;
    }

    public void setEndereco_agencia(Endereco endereco_agencia) {
        this.endereco_agencia = endereco_agencia;
    }
    
    public LinkedList<Conta> getContas() {
        return this.contas;
    }

    public void setContas(LinkedList<Conta> contas) {
        this.contas = contas;
    }
    
    ///////////////////////////////////////////////////
    ////
    ////       Saida de Dados                      ////
    ////
    ///////////////////////////////////////////////////


    public void ImprimeNome_e_Localizacao()
    {
        System.out.println(Nome_Agencia + ": " + endereco_agencia.getEnd_Rua() + ", " + endereco_agencia.getEnd_Num()+ ", " +endereco_agencia.getEnd_Cidade()+ ", " + endereco_agencia.getEnd_Estado()+ ", " + endereco_agencia.getEnd_Pais()+ ", " + endereco_agencia.getEnd_Cep());
    }

    public void LocalizaAgencia(String Cidade, String Estado)
    {
        if(this.endereco_agencia.getEnd_Cidade().equals(Cidade) && this.endereco_agencia.getEnd_Estado().equals(Estado))
        {
            ImprimeNome_e_Localizacao();
        }
    }

    public void LocalizaAgencia(String Bairro, String Cidade, String Estado)
    {
        if(this.endereco_agencia.getEnd_Bairro()==Bairro && this.endereco_agencia.getEnd_Cidade().equals(Cidade) && this.endereco_agencia.getEnd_Estado().equals(Estado))
        {
            ImprimeNome_e_Localizacao();
        }
    }

    public void LocalizaAgencia(String Estado)
    {
        if(this.endereco_agencia.getEnd_Estado().equals(Estado))
        {
            ImprimeNome_e_Localizacao();
        }
    }

    public String DadosAgencia()
    {
        String Data = this.Nome_Agencia +";"+
                        this.Num_Agencia +";"+
                        endereco_agencia.DadosEndereco();
        return Data;
    }


    ////////////////////////////////////////////////////
    ////
    ////          Salvar e Carregar Dados           ////
    ////
    ////////////////////////////////////////////////////

    public void CarregarArquivos(LinkedList<Clientes> Clientes)
    {
        this.contas=GerenArquivos.Carregar_contas(this.Num_Agencia, Clientes);
        this.Funcionarios=GerenArquivos.Carregar_Funcioanrios(this.Num_Agencia);
    }

    

    
}
