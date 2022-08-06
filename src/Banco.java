import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import GerenciadorArquivos.GerenArquivos;
import Instituição.Agencia;
import Personas.Endereco;
import Personas.Pessoa;
import Personas.Clientes.Clientes;

public class Banco {

    private LinkedList<Agencia> Agencias; 
    private LinkedList<Clientes> Clientes;
    private String[] Adim = {"Admin","admin"}; //Usuario e Senha Administrador
    

    public Banco() {
        this.Agencias =  new LinkedList<>();
        this.Clientes = new LinkedList<>();
        CarregarBanco();
    }

/***************************Getters e Setters**********************************************
* ******************************************************************************************/
    public LinkedList<Agencia> getAgencias() {
        return this.Agencias;
    }

    public void setAgencias(LinkedList<Agencia> Agencias) {
        this.Agencias = Agencias;
    }

    public LinkedList<Clientes> getClientes() {
        return this.Clientes;
    }

    public void setClientes(LinkedList<Clientes> Clientes) {
        this.Clientes = Clientes;
    }


/***************Fim Getters e Setters********************************************************
 * ******************************************************************************************/

    public void Encontrar_Agencias_Proximas(Scanner Scan)
    {
        int opcao = 1;
        String Estado;
        String Cidade;
        String Bairro;

        while(opcao!=0)
        {
            System.out.println("Deseja buscar por: ");
            System.out.println("01 - Estado");
            System.out.println("02 Cidade e Estado");
            System.out.println("03 Bairro, Cidade e Estado");
            System.out.println("00 Voltar ao menu anterior");
            try
            {
                opcao= Scan.nextInt();
                Scan.nextLine();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Digite um numero de 0 a 3");
                break;
            }
            switch(opcao)
            {
                case 0:
                    break;
                case 1: 
                    System.out.println("Qual o Estado?");
                    Estado = Scan.nextLine();
                    Encontrar_Agencias_Proximas(Estado);
                    opcao=0;
                    break;
                case 2: 
                    System.out.println("Qual o Estado?");
                    Estado = Scan.nextLine();
                    System.out.println("Qual a Cidade?");
                    Cidade = Scan.nextLine();
                    Encontrar_Agencias_Proximas(Cidade,Estado);
                    opcao=0;
                    break;
                case 3: 
                    System.out.println("Qual o Estado?");
                    Estado = Scan.nextLine();
                    System.out.println("Qual a Cidade?");
                    Cidade = Scan.nextLine();
                    System.out.println("Qual Bairro?");
                    Bairro=Scan.nextLine();
                    Encontrar_Agencias_Proximas(Bairro,Cidade,Estado);
                    opcao=0;
                    break;
                default:
                    System.out.println("Opcao Invalida, tente novamente");
                    break;
                
            }
        }
            

    }
    
    private void Encontrar_Agencias_Proximas(String Bairro, String Cidade, String Estado)
    {
        for(int i= 0; i< Agencias.size();i++)
        {
            Agencias.get(i).LocalizaAgencia(Bairro, Cidade, Estado);;
        }
    }
    private void Encontrar_Agencias_Proximas(String Cidade, String Estado)
    {
        for(int i= 0; i< Agencias.size();i++)
        {
            Agencias.get(i).LocalizaAgencia(Cidade, Estado);
        }
    }
    private void Encontrar_Agencias_Proximas(String Estado)
    {
        for(int i= 0; i< Agencias.size();i++)
        {
            Agencias.get(i).LocalizaAgencia(Estado);
        }
    }
    
    public void Acessar_Conta(Scanner scan)
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
            //so para tirar erro de variavel não existe, apagar as proximas 4 linha.
            System.out.println("Os dados digitados foram:");
            System.out.println("Agencia: " + Num_Agencia);
            System.out.println("Conta: " + Num_Conta);
            System.out.println("Senha: " + (Senha-Senha) + " *****");
            //*************Me Deleta *****************/

            //Aqui vai econtrar ou não a conta informada sera necessario fazer tratamento de erros.
            
            //Se for encontrado conta_encontrada = true;
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
            
            if(opcao==0)
            {
                break;
            }
            if(!conta_encontrada)
            {
                System.out.println("Conta não encontrada deseja tentar novamente? ");
            }   
            
            System.out.println("0 para Não ou Qualquer outro numero para Sim");
            opcao = scan.nextInt();
        }
    }
   
    public void Area_do_Funcionario(Scanner scan)
    {
        int opcao =1;
        while(opcao!=0)
        {
            System.out.println();
            System.out.println("01 Entrar no sistema");
            System.out.println("02 Cadastrar Funcionario ");
            System.out.println("03 Promover a Gerente ");
            System.out.println("00 Voltar ao menu anterior ");

            try{
                opcao=scan.nextInt();
                scan.nextLine();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Digite um numero de 0 a 3");
            }

            switch(opcao)
            {
                case 0:
                    break;
                case 1:
                    Acesso_Funcionario(scan);
                    opcao=0;
                    break;
                case 2: 
                    Cadastrar_funcionario(scan);
                    opcao=0;
                    break;
                case 3:
                    Promover_A_Gerente(scan);
                    opcao=0;
                    break;
                case 4:
                    Cadastrar_Agencia(scan);
                    opcao=0;
                    break;
                default:
                    System.out.println("Opcao Invalida");    

            }
        }
    }

    private void Acesso_Funcionario(Scanner scan)
    {

    }

    public void Cadastrar_Conta(Scanner scan)
    {
        //digtar cpf
        Cadastrar_Cliente(scan);
        //apenas teste
        
    }
    
    public void Cadastrar_Cliente(Scanner scan)
    {
        
        int opcao =3;
        scan.nextLine();
        while(opcao!=0)
        {
            try{
                System.out.println("Vamos fazer seu cadastro meu cria");
                System.out.print("Digite seu CPF: ");
                String cpf = scan.nextLine();
                boolean cpfvalido = ValidaCPF.isCPF(cpf);

                if(!cpfvalido)
                    {
                        opcao--;
                        System.out.println("Cpf invalido, voce tem mais " + opcao + " Tentativas");
                        break;
                    }
                
                else
                {

                    Pessoa Cliente_Novo = new Clientes();
                    //buscar nos clientes se possui algum ja cadastrado com esse cpf
                    for(int i = 0; i<Clientes.size();i++)
                    {
                        if(Clientes.get(i).getCPF().equals(cpf))
                        {
                            throw new IllegalArgumentException("CPF ja cadastrado! ");
                        }
                    }

                    // caso cpf ainda não cadastrado
                    
                    
                    System.out.print("Digite seu nome completo: ");
                    Cliente_Novo.setNome(scan.nextLine());
                    System.out.print("Voce e de qual Genero? ");
                    Cliente_Novo.setSexo(scan.nextLine());
                    System.out.print("Qual seu estado civil? ");
                    Cliente_Novo.setEstado_Civil(scan.nextLine());
                    System.out.print("Preciso do seu endereço começando pela rua: ");
                    String Rua = scan.next();
                    System.out.print("Bairro: ");
                    String Bairro = scan.nextLine();
                    System.out.print("Cidade: ");
                    String Cidade = scan.next();
                    System.out.print("Estado: ");
                    String Estado = scan.next();
                    System.out.print("Pais: ");
                    String Pais = scan.next();
                    System.out.print("Complemento: ");
                    String End_Complemento = scan.next();
                    scan.nextLine();
                    System.out.print("Numero: ");
                    int numero = scan.nextInt();
                    System.out.print("CEP: ");
                    int CEP = scan.nextInt();
                    System.out.print("Cria se nasceu que dia? ");
                    int dia_nascimento = scan.nextInt();
                    System.out.print("No mes de Numero? ");
                    int mes = scan.nextInt();
                    System.out.print("E qual ano era?");
                    int ano = scan.nextInt();
                    Cliente_Novo.setCPF(cpf);
                    Cliente_Novo.setData_de_Nascimento(dia_nascimento,mes,ano);
                    Endereco End_Novo_Cliente = new Endereco(Rua, numero, Bairro,Cidade, Estado, Pais, End_Complemento, CEP);
                    Cliente_Novo.setEndereco(End_Novo_Cliente);               
                    this.Clientes.add((Clientes) Cliente_Novo);
                }
                
            }catch(NumberFormatException e)
            {
                opcao--;
                System.out.println(e + "voce tem mais " + opcao+" Tentativas");
            }
            catch(InputMismatchException e)
            {
                opcao--;
                System.out.println("Digite valores validos " + opcao+" Tentativas");
                continue;
            }
            opcao=0;
        }
        
        GerenArquivos.SalvarArquivoClientes(Clientes);
    }
    
    
    private void Cadastrar_Agencia(Scanner scan)
    {
        //somente Administrador pode cadatrar Agencia. Esta declarado nos atributos dessa classe.
    }
    
    private void Cadastrar_funcionario(Scanner scan)
    {

    }
  
    private void Promover_A_Gerente(Scanner scan)
    {

    }

    public void CarregarBanco()
    {
        this.Agencias=GerenArquivos.Carregar_Agencias();
        //this.Clientes=GerenArquivos.clien
        for(int i =0; i<Agencias.size();i++)
        {
            Agencias.get(i).CarregarArquivos(Clientes);
        }
    }

    public void SalvarBanco()
    {
        GerenArquivos.SalvarArquivoClientes(Clientes);
        GerenArquivos.SalvarArquivoAgencia(Agencias);
        for(int i =0;i<Agencias.size();i++)
        {
            //Agencias.get(i).SalvarContas();
        }
    }

}
