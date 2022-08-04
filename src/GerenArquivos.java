import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import Personas.Data;
import Personas.Endereco;
import Personas.Clientes.Clientes;


public class GerenArquivos {


    private static final String BaseDados ="E:\\POO1\\Trabalho\\src\\data\\";

    public static LinkedList<Clientes> Carregar_clientes ()
    {
        LinkedList<Clientes> clientes = new LinkedList<>();
        try {

            FileReader ent = new FileReader ( BaseDados+"clientes.txt" );
            BufferedReader br = new BufferedReader (ent);
            String linha ;
            String [] campos = null ;
            while (( linha = br. readLine ()) != null ) 
            {
                campos = linha.split(";");
                clientes.add(new Clientes(campos[0],Integer.parseInt(campos [1]),new Data(Integer.parseInt(campos[2]),Integer.parseInt(campos[3]),Integer.parseInt(campos[4])),
                            new Endereco(campos[5],Integer.parseInt(campos [6]),campos[7],campos[8],campos[9],campos[10],Integer.parseInt(campos[11])),campos[12],campos[13],campos[14],Integer.parseInt(campos[15])));
            }   
            br. close ();
        }
        catch ( IOException erro ) 
        {
            System .out. println (" Erro na leitura dos dados ");
        }
        return clientes;
    }

    public static void SalvarArquivo (LinkedList<Clientes> clientes) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"clientes.txt" );
            PrintWriter out = new PrintWriter (arq);
            boolean primeiroClientes = false;
            try{
                for (int i = 0; i < clientes.size() ; i++) {
                String linha = clientes.get(i).SaidaArquivo();
                out.println( linha );
                }
            }
            catch(NullPointerException e)
            {
                primeiroClientes = true;
            }
            out.close ();
        } 
        catch ( IOException erro )
        {
        System .out. println (" Erro na escrita dos dados ");
        }
    }


    public static void CadastrarClientes (String Nome ,int CPF ,Data Data_de_Nascimento, Endereco Endereco, String Sexo, String Estado_Civil,
    String Escolaridade, int NumAgencia,LinkedList<Clientes> clientes) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"clientes.txt" );
            PrintWriter out = new PrintWriter (arq);
            boolean primeiroClientes = false;
            try{
                for (int i = 0; i < clientes.size() ; i++) {
                String linha = clientes.get(i).SaidaArquivo();
                out.println( linha );
                }
            }
            catch(NullPointerException e)
            {
                primeiroClientes = true;
            }
            String linha = Nome + ";" + CPF + ";" + Data_de_Nascimento.getDia() + ";" + Data_de_Nascimento.getMes()+ ";" + Data_de_Nascimento.getAno() + ";" + Endereco.getEnd_Rua() + ";" + Endereco.getEnd_Num() + ";"+ Endereco.getEnd_Cidade() + ";" + Endereco.getEnd_Estado() + ";" + Endereco.getEnd_Pais() + ";" +  Endereco.getEnd_Complemento() + ";" + Endereco.getEnd_Cep() + ";" + Sexo + ";" + Estado_Civil + ";" + Escolaridade + ";" + NumAgencia;
            System.out.println("clientes cadastrado: "+ Nome);
            out.println( linha );
            out.close ();
        } 
        catch ( IOException erro )
        {
        System .out. println (" Erro na escrita dos dados ");
        }
    } 

}
