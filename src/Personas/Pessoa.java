package Personas;

public abstract class Pessoa {
    private String Nome;
    private int CPF;
    private Data Data_de_Nascimento;
    private Endereco Endereco;
    private String Sexo;
    private String Estado_Civil;


    public Pessoa(String Nome, int CPF, Data Data_de_Nascimento, Endereco Endereco, String Sexo, String Estado_Civil) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.Data_de_Nascimento = Data_de_Nascimento;
        this.Endereco = Endereco;
        this.Sexo = Sexo;
        this.Estado_Civil = Estado_Civil;
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

    public Data getData_de_Nascimento() {
        return this.Data_de_Nascimento;
    }

    public void setData_de_Nascimento(Data Data_de_Nascimento) {
        this.Data_de_Nascimento = Data_de_Nascimento;
    }

    public Endereco getEndereco() {
        return this.Endereco;
    }

    public void setEndereco(Endereco Endereco) {
        this.Endereco = Endereco;
    }

    public String getSexo() {
        return this.Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getEstado_Civil() {
        return this.Estado_Civil;
    }

    public void setEstado_Civil(String Estado_Civil) {
        this.Estado_Civil = Estado_Civil;
    }




    
}