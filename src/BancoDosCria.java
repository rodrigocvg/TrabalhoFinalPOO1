import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import Personas.Clientes.*;


// ATENÇÃO MUDEI TODOS NEXTLINE PARA NEXT INT - POIS N TAVA RODANDO, PARA LER UMA LINHA INTEIRA TEM QUE SER O BUFFERED READ, DPS NOIS COLOCA 

public class BancoDosCria {
    public static void main(String[] args) throws IOException {
        LinkedList<Clientes> clientes = new LinkedList<>();
        clientes = GerenArquivos.Carregar_clientes();
        
        
        Scanner sc = new Scanner(System.in);
        /* 
        String nome = sc.next();
        int CPF = sc.nextInt();
        int dia = sc.nextInt();
        int mes = sc.nextInt();
        int ano = sc.nextInt();
        //sc.nextLine();
        String End_Rua = sc.next();
        int End_Num = sc.nextInt();
        //sc.nextLine();
        String End_Cidade = sc.next();
        String End_Estado = sc.next();
        String End_Pais = sc.next();
        String End_Complemento = sc.next();
        int End_Cep = sc.nextInt();
        //sc.nextL();
        String Sexo = sc.next();
        String Estado_Civil = sc.next();
        String Escolaridade = sc.next();
        int Num_Agencia = sc.nextInt();

        */
        
        
        //GerenArquivos.CadastrarClientes(nome, CPF, new Data(dia, mes, ano),new Endereco(End_Rua, End_Num, End_Cidade, End_Estado, End_Pais, End_Complemento, End_Cep),Sexo,Estado_Civil,Escolaridade, Num_Agencia,clientes);
        
        clientes = GerenArquivos.Carregar_clientes();
        
        System.out.println("Digite o index do cliente que vc deseja alterar");
        int j = sc.nextInt();
        clientes.get(j).setEscolaridade("animal");
        clientes.get(j).setCPF(0000000);
        //chamar função salvar arquivo
        GerenArquivos.SalvarArquivo(clientes);

        
        

        for(int i =0;i<clientes.size();i++){
            if(clientes.get(i).getNome().equals("israel")){
                System.out.println("Achei");
            }
        }
       
        
        
        
        
        
        
        //Clientes[] Vclientes = new Clientes[30];
        //Vclientes[0] = new Clientes(nome, CPF);

       


        /* 
        Vclientes[0] = new Clientes(nome, CPF);

        FileWriter arq = new FileWriter("E:\\POO1\\Trabalho\\testeArquivos\\src\\file1");
        PrintWriter gravarArq = new PrintWriter(arq);

        gravarArq.printf("Nome: " + nome + "\nCPF: " + CPF + "\n");

        */
        

        /* OutputStream os = new FileOutputStream("E:\\POO1\\Trabalho\\testeArquivos\\src\\file1"); // nome do arquivo que será escrito
        Writer wr = new OutputStreamWriter(os); // criação de um escritor
        BufferedWriter br = new BufferedWriter(wr); // adiciono a um escritor de buffer
        
        br.write(nome + " " + CPF);
        br.newLine();
        br.newLine();
        //br.write("Vamos escrever outra linha aqui embaixo hahaha!!!");
        br.close();
        */
    }








/*
    public static ArrayList<Object> clientes = new ArrayList<>();
    public static int i;

   
    
    public static void main(String[] args) throws IOException {
        
        
       



        int opcao = 999;
        Scanner scan = new Scanner(System.in);
        String NomeBanco = "Banco Dos Crias";
        Clientes Vclientes[] = new Clientes[30];
        
        Empacotamento.lerArquivoBinario("clientes.dat");
        //criar lista de agencias.

        //inicializar agencias e contas lendo arquivos presalvos. para primeiro acesso sera necessario cadastrar manual. 
        
        //Pensando em usar Scanner para ler um arquivo e criar essa parte do primeiro acesso.


        System.out.println("Seja Bem ao "+ NomeBanco);
        //menu
        while(opcao!=0)
        {
            System.out.println("Primeiro me diz voce quer: ");
            System.out.println("01 -> Acessar Minha Conta");
            System.out.println("02 -> Abrir uma Conta");
            System.out.println("03 -> Sou Funcionario");
            System.out.println("04 -> Encontrar Agencia mais proxima");
            System.out.println("00 -> Sair do Sistema");    
            
            opcao = scan.nextInt(); // Escolhendo opcao

            switch(opcao)
            {
                case 0: // Sai do programa
                    break;
                case 1: // Entra em Acessar conta
                    try {
                        Acessar_Conta(scan);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 2: // Abrir uma conta
                    try {
                        Criar_Conta(scan);
                        gravarArquivo();
                       
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 3: // Acesso Funcionario
                    Acesso_Funcionario();
                    break;
                default:
                    System.out.println("Essa opcao nao existe meu cria! \nDa uma olhada nas opcoes disponiveis e tenta novamente");
                    break;
            }   
        }
        scan.close();


    }

    public static void gravarArquivo() throws IOException{
       
        
        Empacotamento.gravarArquivoBinario(clientes, "clientes.dat"); 
                
                FileWriter arq = new FileWriter("export.txt");
                PrintWriter gravarArq = new PrintWriter(arq);
                int j = 1;
                int n = clientes.size();
          
                for (Object item2: clientes) {
                  System.out.printf("Exportando %do. registro de %d: %s\n",
                    j++, n, ((Clientes)item2).getNome());
                    
                  gravarArq.printf("Nome|%s : CPF|%s\n",
                    ((Clientes)item2).getNome(),
                    ((Clientes)item2).getCPF());
                }
          
                gravarArq.close();

                
          
                System.out.printf("\nExportação realizada com sucesso.\n");    
                
    }

    //Menu para quem ja e cliente
    public static void Acessar_Conta(Scanner scan) throws IOException
    {

        




        int opcao =1;
        boolean conta_encontrada = false; //pode ser temporario o uso desse booleano ou 
                                            //definitivo vamos descobri com o tempo
        while(opcao!=0)
        {
            System.out.println("Fala Cria vou precisar dos seguintes daddos");
            System.out.printf("Agencia: ");
            int Num_Agencia = scan.nextInt();
            System.out.printf("Conta: ");
            int Num_Conta = scan.nextInt();
            System.out.printf("Senha: ");
            int Senha = scan.nextInt();

            //*************Me Deleta *****************/
            /*
            //so para tirar erro de variavel não existe, apagar as proximas 4 linha.
            System.out.println("Os dados digitados foram:");
            System.out.println("Agencia: " + Num_Agencia);
            System.out.println("Conta: " + Num_Conta);
            System.out.println("Senha: " + (Senha-Senha) + " *****");
            //*************Me Deleta *****************/

            //Aqui vai econtrar ou não a conta informada sera necessario fazer tratamento de erros.
            
            //Se for encontrado conta_encontrada = true;
            /*
            while(conta_encontrada && opcao!=0)
            {
                System.out.println("Seja Bem vindo Cliente.getnome()");
                System.out.println("Oque você deseja fazer?");
                System.out.println("01 -> Consultar Saldo");
                System.out.println("02 -> Realizar PIX");
                System.out.println("03 -> Depositar");
                System.out.println("04 -> Sacar");
                System.out.println("05 -> ");
                System.out.println("00 -> Sair da Conta");
                
                opcao = scan.nextInt();
                
                switch(opcao)
                {
                    case 0:
                        System.out.println("Deseja entrar em outra conta?");
                        break;
                    case 1: 
                        //consultar saldo
                        break;
                    case 2: 
                        //Fazer um pix/transferencia
                        break;
                    case 3: 
                        //Depositar valor
                        break;
                    case 4: 
                        //sacar
                        break;
                    default:
                        System.out.println("Essa opcao nao existe meu cria! \nDa uma olhada nas opcoes disponiveis e tenta novamente");
                        opcao=999;
                }
            }
            

            if(!conta_encontrada)
            {
                System.out.println("Conta não encontrada deseja tentar novamente? ");
            }   
            
            System.out.println("0 para Não ou Qualquer outro numero para Sim");
            opcao = scan.nextInt();
        }

    }

    public static void Criar_Conta(Scanner scan) throws IOException{ // provavelmente sera necessario colocar essa funcao
                                                //dentro do acesso do funcioanrio para dar sentido a ele.
        

                                                
        File f = new File("E:\\POO1\\Trabalho\\testeArquivos\\src\\i");
        FileReader flr = new FileReader(f);
        BufferedReader br = new BufferedReader(flr);
        String linha = br.readLine();
        i = Integer.parseInt(linha);
        br.close();
       
        System.out.println(i);
        OutputStream os = new FileOutputStream("i.txt");
        int opcao =1;
        
            Pessoa Cliente_Novo[] = new Clientes[30];
            boolean cpf_encontrado = false;
            System.out.println("Vamos cadastrar sua conta meu cria");
            System.out.println("Digite seu CPF: ");
            int cpf = scan.nextInt();
            String cpf2 = Integer.toString(cpf);
            boolean cpfvalido = ValidaCPF.isCPF(cpf2);
            Cliente_Novo[i] = new Clientes();
            Cliente_Novo[i].setCPF(cpf);

            if(cpfvalido)
                return;

            //buscar nos clientes se possui algum ja cadastrado com esse cpf
            //caso encontrado
         //   if(cpf_encontrado) // quando cpf tiver cadastrado como cliente ja
         //   {
          //      System.out.println("CPF ja cadastrado com os seguintes dados: ");
                //printar nome data nascimento e endereco.
           //     System.out.println("Caso os dados estiverem incorretos va ate uma agencia mais proxima para realizar atualização");
           //    System.out.println("Deseja continuar a cadastrar sua conta com os dados informados?");
           // }
            

            
            if(!cpf_encontrado) // caso cpf ainda não cadastrado
            {   
                
                System.out.print("Digite seu nome completo: ");
                Cliente_Novo[i].setNome(scan.next());
                System.out.print("Cria se nasceu que dia? ");
                int dia_nascimento = scan.nextInt();
                System.out.print("No mes de Numero? ");
                int mes = scan.nextInt();
                System.out.print("E qual ano era?");
                int ano = scan.nextInt();
                Cliente_Novo[i].setData_de_Nascimento(dia_nascimento,mes,ano);
                System.out.print("Voce e de qual Genero? ");
                Cliente_Novo[i].setSexo(scan.next());
                System.out.print("Qual seu estado civil? ");
                Cliente_Novo[i].setEstado_Civil(scan.next());
                System.out.print("Preciso do seu endereço começando pela rua: ");
                String Rua = scan.next();
                System.out.print("Numero: ");
                int numero = scan.nextInt();
                System.out.print("Cidade: ");
                String Cidade = scan.next();
                System.out.print("Estado: ");
                String Estado = scan.next();
                System.out.print("Pais: ");
                String Pais = scan.next();
                System.out.print("Complemento: ");
                String End_Complemento = scan.next();
                System.out.print("CEP: ");
                int CEP = scan.nextInt();
                Endereco End_Novo_Cliente = new Endereco(Rua, numero, Cidade, Estado, Pais, End_Complemento, CEP);
                Cliente_Novo[i].setEndereco(End_Novo_Cliente); 
                clientes.add((Clientes)Cliente_Novo[i]);   
                i++;

                Writer wr = new OutputStreamWriter(os);
                BufferedWriter br1 = new BufferedWriter(wr);
                br1.write(i);
                br1.close();
                
                
            }
        
    }

    public static void Acesso_Funcionario()
    {
        // funcoes para funcionarios
        //oque um funcionario vai fazer?? Alterar limite, adicionar titular, desativar conta, 
        System.out.println();
    }
} import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Clientes c1 = new Clientes("Rodrigo", 1099999);
        Clientes c2 = new Clientes("lucas", 9493845);
        Clientes c3 = new Clientes("maria", 22222);
        Clientes c4 = new Clientes("teste", 1111111);
        ArrayList<Object> clientes = new ArrayList<Object>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);
        

        //SalvarObjeto.salvar(c1, "E:\\POO1\\Trabalho\\testeArquivos\\clientes.txt");
        Empacotamento.gravarArquivoBinario(clientes, "clientes.dat");

        Empacotamento.lerArquivoBinario("clientes.dat");

        int i = 1;
      for (Object item: clientes) {
        System.out.printf("Ficha nro....: %d.\n", i++);
        // ((clientes)item) - implementa o mecanismo de downcast, ou seja,
        //                  o objeto "item" declarado a partir da classe
        //                  base "Object" é referenciado como um objeto "clientes"
        System.out.println(((Clientes)item).getNome());
        System.out.println(((Clientes)item).getCPF());
        //System.out.printf("CPF: %.2f kgs\n", ((Clientes)item).getCPF());

      FileWriter arq = new FileWriter("export.txt");
      PrintWriter gravarArq = new PrintWriter(arq);

      int j = 1;
      int n = clientes.size();

      for (Object item2: clientes) {
        System.out.printf("Exportando %do. registro de %d: %s\n",
          j++, n, ((Clientes)item2).getNome());

        gravarArq.printf("Nome|%s : CPF|%s\n",
          ((Clientes)item2).getNome(),
          ((Clientes)item2).getCPF());
      }

      gravarArq.close();

      System.out.printf("\nExportação realizada com sucesso.\n");
      }
    }
    */
    
}
