package Personas.Clientes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Personas.Data;
import Personas.Pessoa;
import Personas.Endereco;

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

    /* Pode ser que funcione, por enquanto não ta */
    public void escrita(){
        File arq = null;
        ObjectOutputStream obj = null;
        try {
            arq = new File("e:/POO1/Trabalho/Clientes/testeArquivo.txt");
            obj = new ObjectOutputStream(new FileOutputStream(arq,true));
            obj.writeObject(obj);
            obj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Clientes> ler(){
        FileInputStream arquivo = null;
        ArrayList<Clientes> clientes = new ArrayList<Clientes>();
        Clientes cliente = null;
        ObjectInputStream obj = null;
        try {
            arquivo = new FileInputStream("e:/POO1/Trabalho/src/Clientes/testeArquivo.txt");
            obj = new ObjectInputStream(arquivo);
            do {
                cliente = (Clientes) obj.readObject();
                if (cliente != null)
                    clientes.add(cliente);
           } while (cliente != null);
            arquivo.close();
            obj.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
        return clientes;
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
