import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import Instituição.Agencia;
import Instituição.Contas.Conta;
import Instituição.Contas.Corrente;
import Instituição.Contas.Poupanca;
import Personas.Data;
import Personas.Endereco;
import Personas.Clientes.Clientes;


public class GerenArquivos {


    private static final String BaseDados ="E:\\POO1\\Trabalho\\src\\data\\";


     // ------------------------------------------------------   //
    // ------------------------------------------------------   //
    //              ARQUIVO PARA CLIENTES                 //
    // ------------------------------------------------------   //
    // ------------------------------------------------------   //


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

    public static void SalvarArquivoClientes (LinkedList<Clientes> clientes) 
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

    // ------------------------------------------------------   //
    // ------------------------------------------------------   //
    //              ARQUIVO PARA CONTA CORRENTE                 //
    // ------------------------------------------------------   //
    // ------------------------------------------------------   //

    public static LinkedList<Conta> Carregar_contaCorrente()
    {
        LinkedList<Conta> contas = new LinkedList<>();
        try {

            FileReader ent = new FileReader ( BaseDados+"ContasCorrente.txt" );
            BufferedReader br = new BufferedReader (ent);
            String linha ;
            String [] campos = null ;
            while (( linha = br. readLine ()) != null ) 
            {
                campos = linha.split(";");
                contas.add(new Corrente(Integer.parseInt(campos[0]),Integer.parseInt(campos[1]),Float.parseFloat(campos[2]),Boolean.parseBoolean(campos[3]), new Clientes(campos[4],Integer.parseInt(campos[5])),
                                   new Agencia(campos[6], Integer.parseInt(campos[7])), new Data(Integer.parseInt(campos[8]), Integer.parseInt(campos[9]), Integer.parseInt(campos[10])), Float.parseFloat(campos[11]), Float.parseFloat(campos[12])));
            }   
            br. close ();
        }
        catch ( IOException erro ) 
        {
            System .out. println (" Erro na leitura dos dados ");
        }
        return contas;
    }


    public static void SalvarArquivoCorrente (LinkedList<Corrente> contas) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"ContasCorrente.txt" );
            PrintWriter out = new PrintWriter (arq);
            boolean primeiroClientes = false;
            try{
                for (int i = 0; i < contas.size() ; i++) {
                String linha = contas.get(i).SaidaArquivo();
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


    public static void CadastrarContaCorrente (int Num_Conta, int Senha_Conta, float saldo, 
    boolean conjunta, Personas.Clientes.Clientes Cliente_primario,
    Instituição.Agencia Agencia, Data Abertura_de_Conta, float limite, float taxAdmin, LinkedList<Conta> contas) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"ContasCorrente.txt" );
            PrintWriter out = new PrintWriter (arq);
            boolean primeiroConta = false;
            try{
                for (int i = 0; i < contas.size() ; i++) {
                String linha = contas.get(i).SaidaArquivo();
                out.println( linha );
                }
            }
            catch(NullPointerException e)
            {
                primeiroConta = true;
            }
            String linha = Num_Conta + ";" + Senha_Conta + ";"  + saldo + ";" + conjunta+ ";" + Cliente_primario.getNome() + ";"+ Cliente_primario.getCPF() + ";" + 
                            Agencia.getNome_Agencia() + ";" + Agencia.getNum_Agencia() + ";" +  Abertura_de_Conta.getDia() + ";" + Abertura_de_Conta.getMes()+ ";" + 
                            Abertura_de_Conta.getAno() + ";" + limite + ";" + taxAdmin;
            System.out.println("Conta cadastrada: "+ Num_Conta);
            out.println( linha );
            out.close ();
        } 
        catch ( IOException erro )
        {
        System .out. println (" Erro na escrita dos dados ");
        }
        
    } 

    // ------------------------------------------------------   //
    // ------------------------------------------------------   //
    //              ARQUIVO PARA CONTA POUPANÇA                 //
    // ------------------------------------------------------   //
    // ------------------------------------------------------   //

    public static LinkedList<Conta> Carregar_contaPoupanca()
    {
        LinkedList<Conta> contas = new LinkedList<>();
        try {

            FileReader ent = new FileReader ( BaseDados+"ContasPoupanca.txt" );
            BufferedReader br = new BufferedReader (ent);
            String linha ;
            String [] campos = null ;
            while (( linha = br. readLine ()) != null ) 
            {
                campos = linha.split(";");
                contas.add(new Poupanca(Integer.parseInt(campos[0]),Integer.parseInt(campos[1]),Float.parseFloat(campos[2]),Boolean.parseBoolean(campos[3]), new Clientes(campos[4],Integer.parseInt(campos[5])),
                                   new Agencia(campos[6], Integer.parseInt(campos[7])), new Data(Integer.parseInt(campos[8]), Integer.parseInt(campos[9]), Integer.parseInt(campos[10])), Float.parseFloat(campos[11])));
            }   
            br. close ();
        }
        catch ( IOException erro ) 
        {
            System .out. println (" Erro na leitura dos dados ");
        }
        return contas;
    }

    public static void SalvarArquivoPoupanca (LinkedList<Corrente> contas) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"ContasPoupanca.txt" );
            PrintWriter out = new PrintWriter (arq);
            boolean primeiroClientes = false;
            try{
                for (int i = 0; i < contas.size() ; i++) {
                String linha = contas.get(i).SaidaArquivo();
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

    public static void CadastrarContaPoupanca (int Num_Conta, int Senha_Conta, float saldo, 
    boolean conjunta, Personas.Clientes.Clientes Cliente_primario,
    Instituição.Agencia Agencia, Data Abertura_de_Conta, float rendimento, LinkedList<Conta> contas) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"ContasPoupanca.txt" );
            PrintWriter out = new PrintWriter (arq);
            boolean primeiroConta = false;
            try{
                for (int i = 0; i < contas.size() ; i++) {
                String linha = contas.get(i).SaidaArquivo();
                out.println( linha );
                }
            }
            catch(NullPointerException e)
            {
                primeiroConta = true;
            }
            String linha = Num_Conta + ";" + Senha_Conta + ";"  + saldo + ";" + conjunta+ ";" + Cliente_primario.getNome() + ";"+ Cliente_primario.getCPF() + ";" + 
                            Agencia.getNome_Agencia() + ";" + Agencia.getNum_Agencia() + ";" +  Abertura_de_Conta.getDia() + ";" + Abertura_de_Conta.getMes()+ ";" + 
                            Abertura_de_Conta.getAno() + ";" + rendimento;
            System.out.println("Conta cadastrada: "+ Num_Conta);
            out.println( linha );
            out.close ();
        } 
        catch ( IOException erro )
        {
        System .out. println (" Erro na escrita dos dados ");
        }
        
    }








    

}
