package GerenciadorArquivos;

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
import Personas.Funcionarios.Funcionario;
import Personas.Funcionarios.Gerente;


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
                            new Endereco(campos[5],Integer.parseInt(campos [6]),campos[7],campos[8],campos[9],campos[10],campos[11],Integer.parseInt(campos[12])),campos[13],campos[14],campos[15],Integer.parseInt(campos[16])));
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
            try{
                for (int i = 0; i < clientes.size() ; i++) {
                String linha = clientes.get(i).SaidaArquivo();
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


    public static void CadastrarClientes (String Nome ,int CPF ,Data Data_de_Nascimento, Endereco Endereco, String Sexo, String Estado_Civil,
    String Escolaridade, int NumAgencia,LinkedList<Clientes> clientes) 
    {
        try {
            FileWriter arq = new FileWriter ( BaseDados+"clientes.txt" );
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
        
    
    
    /*
         * 
         * 
         * 
         * Carregar Geral kkk
         * 
         * 
         * 
         * 
         * 
    */

        public static LinkedList<Conta> Carregar_contas(int NumAgencia)
        {
            String NumeroAgencia = String.valueOf(NumAgencia);
            LinkedList<Conta> contas = new LinkedList<>();
            try {
    
                FileReader ent = new FileReader ( BaseDados+NumeroAgencia+"Contas.csv" );
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
    
        public static void SalvarArquivoContas (Agencia Agencia) 
        {
            String NumAgencia = String.valueOf(Agencia.getNum_Agencia());
            LinkedList <Conta> contas = Agencia.getContas();
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
                out.close ();
            } 
            catch ( IOException erro )
            {
            System .out. println (" Erro na escrita dos dados ");
            }
        }
    
        public static void CadastrarConta (int Num_Conta, int Senha_Conta, float saldo, 
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

        public static LinkedList<Agencia> Carregar_Agencias()
        {
            LinkedList<Agencia> Agencia = new LinkedList<>();
            try {
    
                FileReader ent = new FileReader ( BaseDados+"Agencia.csv" );
                BufferedReader br = new BufferedReader (ent);
                String linha ;
                String [] campos = null ;
                while (( linha = br. readLine ()) != null ) 
                {
                    campos = linha.split(";");
                    Agencia Nova = new Agencia(campos[0], Integer.parseInt(campos[1]));
                    Endereco End = new Endereco(campos[2], Integer.parseInt(campos[3]), campos[4], campos[5], campos[6], campos[7], campos[8], Integer.parseInt(campos[9]));
                    Nova.setEndereco_agencia(End);
                    Agencia.add(Nova);
                }   
                br. close ();
            }
            catch ( IOException erro ) 
            {
                System .out. println (" Erro na leitura dos dados ");
            }
            return Agencia;
        }

        public static LinkedList<Funcionario> Carregar_Funcioanrios(int NumAgencia)
        {
            LinkedList<Funcionario> Funcionarios = new LinkedList<>();
            String NumeroAgencia = String.valueOf(NumAgencia);
            try {
    
                FileReader ent = new FileReader ( BaseDados+NumeroAgencia+"Funcionarios.csv" );
                BufferedReader br = new BufferedReader (ent);
                String linha ;
                String [] campos = null ;
                while (( linha = br. readLine ()) != null ) 
                {
                    campos = linha.split(";");
                    Data[] Datas = new Data[3];
                    Datas[0] = new Data(Integer.parseInt(campos[2]), Integer.parseInt(campos[3]), Integer.parseInt(campos[4]));
                    Datas[1] = new Data(Integer.parseInt(campos[18]), Integer.parseInt(campos[19]), Integer.parseInt(campos[20]));
                    Endereco End = new Endereco(campos[5], Integer.parseInt(campos[6]), campos[7], campos[8], campos[9], campos[10], campos[11], Integer.parseInt(campos[12]));
                    if(campos[16].equals("Gerente"))
                    {
                        Datas[2] = new Data(Integer.parseInt(campos[24]), Integer.parseInt(campos[25]), Integer.parseInt(campos[26]));

                        Funcionario Novo = new Gerente(campos[0], Integer.parseInt(campos[1]), Datas[0], End, campos[13], campos[14], Integer.parseInt(campos[15]), Float.parseFloat(campos[17]),  Datas[1], Integer.parseInt(campos[21]), campos[22], Boolean.parseBoolean(campos[23]),  Datas[2]);
                        Funcionarios.add(Novo);
                    }
                    else 
                    {
                        Funcionario Novo = new Funcionario(campos[0], Integer.parseInt(campos[1]), Datas[0], End, campos[13], campos[14], Integer.parseInt(campos[15]),campos[16], Float.parseFloat(campos[17]),  Datas[1], Integer.parseInt(campos[21]), campos[22]);
                        Funcionarios.add(Novo);
                    }   
                }
                br. close ();
            }
            catch ( IOException erro ) 
            {
                System .out. println (" Erro na leitura dos dados ");
            }
            return Funcionarios;
        }

        public static void SalvarArquivoFuncionarios (Agencia Agencia) 
        {
            String NumAgencia = String.valueOf(Agencia.getNum_Agencia());
            LinkedList <Funcionario> funcionarios = Agencia.getFuncionarios();
            try {
                FileWriter arq = new FileWriter ( BaseDados+NumAgencia+"Funcionarios.csv" );
                PrintWriter out = new PrintWriter (arq);
                try{
                    for (int i = 0; i < funcionarios.size() ; i++) {
                    Funcionario Percorre = funcionarios.get(i);
                    String linha;

                    if(Percorre.getCargo_na_empresa().equals("Gerente"))
                         linha = Percorre.DadosGerente();
                    else linha = Percorre.DadosFuncionario();
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

        public static void SalvarArquivoFuncionarios (LinkedList<Agencia> Agencia) 
        {

            try {
                FileWriter arq = new FileWriter ( BaseDados+"Agencias.csv" );
                PrintWriter out = new PrintWriter (arq);
                try{
                    for (int i = 0; i < Agencia.size() ; i++) {
                   
                    String linha = Agencia.get(i).DadosAgencia();
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






    

}
