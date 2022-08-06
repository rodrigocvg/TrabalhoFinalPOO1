package GerenciadorArquivos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import Instituição.Agencia;
import Instituição.Contas.Conta;
import Instituição.Contas.Corrente;
import Personas.Data;
import Personas.Clientes.Clientes;

public class AntigoGerenArquivos {
    
    private static final String BaseDados ="C:\\Users\\israe\\Meu Drive\\Trello\\Estudos Dev\\POO\\Trabalho Poo\\TrabalhoFinalPOO1\\src\\data\\";

    // ------------------------------------------------------   //
    // ------------------------------------------------------   //
    //              ARQUIVO PARA CLIENTES                 //
    // ------------------------------------------------------   //
    // ------------------------------------------------------   //

    /*public static LinkedList<Clientes> Carregar_clientes ()
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
                            new Endereco(campos[5],Integer.parseInt(campos [6]),campos[7],campos[8],campos[9],campos[10],campos[11],Integer.parseInt(campos[12])),campos[13],campos[14],campos[15],Integer.parseInt(campos[16])));
            }   
            br. close ();
        }
        catch ( IOException erro ) 
        {
            System .out. println (" Erro na leitura dos dados ");
        }
        return clientes;
    }*/

    public static void CadastrarClientes (Clientes Novo,LinkedList<Clientes> clientes) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"clientes.csv" );
            PrintWriter out = new PrintWriter (arq);
            try{
                for (int i = 0; i < clientes.size() ; i++) {
                String linha = clientes.get(i).SaidaArquivo();
                out.println( linha );
                }
            }
            catch(NullPointerException e)
            {
            }
            String linha = Novo.SaidaArquivo();
            System.out.println("clientes cadastrado: ");
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

    /* public static LinkedList<Conta> Carregar_contaCorrente()
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
    }*/

    public static void SalvarArquivoCorrente (LinkedList<Corrente> contas) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"ContasCorrente.txt" );
            PrintWriter out = new PrintWriter (arq);
            try{
                for (int i = 0; i < contas.size() ; i++) {
                String linha = contas.get(i).SaidaArquivo();
                out.println( linha );
                }
            }
            catch(NullPointerException e)
            {
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
            try{
                for (int i = 0; i < contas.size() ; i++) {
                String linha = contas.get(i).SaidaArquivo();
                out.println( linha );
                }
            }
            catch(NullPointerException e)
            {
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

    /*public static LinkedList<Conta> Carregar_contaPoupanca()
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
    }*/

    public static void SalvarArquivoPoupanca (LinkedList<Corrente> contas) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"ContasPoupanca.txt" );
            PrintWriter out = new PrintWriter (arq);
            try{
                for (int i = 0; i < contas.size() ; i++) {
                String linha = contas.get(i).SaidaArquivo();
                out.println( linha );
                }
            }
            catch(NullPointerException e)
            {
            }
            out.close ();
        } 
        catch ( IOException erro )
        {
        System .out. println (" Erro na escrita dos dados ");
        }
    }

    public static void CadastrarContaPoupanca (int Num_Conta, int Senha_Conta, float saldo, 
    boolean conjunta, Clientes Cliente_primario,
   Agencia Agencia, Data Abertura_de_Conta, float rendimento, LinkedList<Conta> contas) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"ContasPoupanca.txt" );
            PrintWriter out = new PrintWriter (arq);
            try{
                for (int i = 0; i < contas.size() ; i++) {
                String linha = contas.get(i).SaidaArquivo();
                out.println( linha );
                }
            }
            catch(NullPointerException e)
            {
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


    public static void CadastrarConta (String TipoConta, int Num_Conta, int Senha_Conta, float saldo, 
        boolean conjunta, Clientes Cliente_primario,
       Agencia Agencia, Data Abertura_de_Conta, float rendimento) 
        {
            String NumAgencia = String.valueOf(Agencia.getNum_Agencia());
            LinkedList<Conta> contas = Agencia.getContas();
            try {
                FileWriter arq = new FileWriter ( BaseDados+NumAgencia+"Contas.csv" );
                PrintWriter out = new PrintWriter (arq);
                try{
                    for (int i = 0; i < contas.size() ; i++) {
                    String linha = contas.get(i).SaidaArquivo();
                    out.println( linha );
                    }
                }
                catch(NullPointerException e)
                {
                }
                String linha =TipoConta + ";" + Num_Conta + ";" + Senha_Conta + ";"  + saldo + ";" + conjunta+ ";" + Cliente_primario.getNome() + ";"+ Cliente_primario.getCPF() + ";" + 
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
