import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;



public class Clientes extends Pessoa implements Serializable{
    private String Escolaridade;
    private int NumAgencia;


    public Clientes() {
        super(null,0,null,null,null,null );
    }

    public Clientes(String Nome, int CPF){
        super(Nome,CPF, null,null,null,null);
    }


    public Clientes(String Nome, int CPF,
     Data Data_de_Nascimento, Endereco Endereco, String Sexo, String Estado_Civil,
        String Escolaridade, int NumAgencia) 
    {
        super(Nome, CPF, Data_de_Nascimento, Endereco, Sexo, Estado_Civil);
        this.Escolaridade = Escolaridade;
        this.NumAgencia = NumAgencia;
    }

   

    public void leitura(){

    }


    public String getEscolaridade() {
        return this.Escolaridade;
    }

    public void setEscolaridade(String Escolaridade) {
        this.Escolaridade = Escolaridade;
    }


    public int getNumAgencia() {
        return this.NumAgencia;
    }

    public void setNumAgencia(int NumAgencia) {
        this.NumAgencia = NumAgencia;
    }



    
}

