import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import GerenciadorArquivos.GerenArquivos;
import Instituição.Agencia;
import Instituição.Contas.Conta;
import Instituição.Contas.Poupanca;
import Personas.Data;
import Personas.Endereco;
import Personas.Pessoa;
import Personas.Clientes.Clientes;
import Personas.Funcionarios.Funcionario;

public class Banco {

    private LinkedList<Agencia> Agencias; 
    private LinkedList<Clientes> Clientes;
    private LinkedList<Conta> Contas;
    private String[] Admin = {"Admin","admin"}; //Usuario e Senha Administrador
    

    public Banco() {
        this.Agencias =  new LinkedList<>();
        this.Clientes = new LinkedList<>();
        CarregarBanco();
    }

/////////////////////////////////////////////////////////////////////////
///
///                 Getters e Setters                                ///
///
////////////////////////////////////////////////////////////////////////

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

    public boolean LoginAdministrador(String Usuario, String Senha)
    {
        if(this.Admin[0].equals(Usuario) && this.Admin[1].equals(Senha))
            return true;
        else return false;
    }

 //////////////////////////////////////////////////////////////////////////////
 //                                                                         ///
 //               Funcionarios                                              ///
 //                                                                         ///
 //////////////////////////////////////////////////////////////////////////////

    public void Area_do_Funcionario(Scanner scan)
    {
        int opcao =1;
        while(opcao!=0)
        {
            System.out.println();
            System.out.println("01 Entrar no sistema");
            System.out.println("02 Cadastrar Funcionario ");
            System.out.println("03 Promover a Gerente ");
            System.out.println("04 Cadastrar uma Nova Agencia");
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
                    System.out.println("A nova Agencia Precisa de um Gerente");
                    GerenArquivos.SalvarArquivoAgencia(Agencias);
                    Agencias=GerenArquivos.Carregar_Agencias();
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

    public void Encontrar_Funcionario()
    {
        int h = 1;
        System.out.println("N -> Numero Agencia, Nome, CPF");
        for(int i =0 ; i<Agencias.size(); i++)
        {
            Agencia Temp = Agencias.get(i);
            int NumAgencia = Temp.getNum_Agencia();
            LinkedList<Funcionario> Percorre = Temp.getFuncionarios();
            for(int j =0 ; i<Percorre.size();i++)
            {
                System.out.printf("%d -> %d ",h,NumAgencia);
                Percorre.get(j).ImprimeDadosFuncionario();
                System.out.println();
            }
        }

    }

    private void Cadastrar_funcionario(Scanner scan)
    {
        Encontrar_Agencias_Proximas();

        int index = scan.nextInt();

        System.out.printf("Nome Funcionairo: ");
        String Nome= scan.nextLine();
        
        System.out.printf("CPF: ");
        String CPF =scan.nextLine();
        
        System.out.printf("Genero: ");
        String Sexo = scan.nextLine();
        
        System.out.printf("Estado Civil: ");
        String Estado_Civil = scan.nextLine();

        System.out.printf("Cargo: ");
        String Cargo_na_empresa = scan.nextLine(); 

        System.out.printf("Endereco\nPais: ");
        String End_Pais = scan.nextLine();

        System.out.printf("Estado: ");
        String End_Estado = scan.nextLine();

        System.out.printf("Cidade: ");
        String End_Cidade = scan.nextLine();

        System.out.printf("Bairro: ");
        String End_Bairro = scan.nextLine();

        System.out.printf("Rua: ");
        String End_Rua = scan.nextLine();

        System.out.printf("Complamento: ");
        String End_Complemento = scan.nextLine();
        scan.nextInt();
        
        System.out.printf("Numero: ");        
        int End_Num = scan.nextInt();

        System.out.printf("CEP: ");
        int End_Cep = scan.nextInt();

        System.out.printf("RG UF: ");
        String RG_UF = scan.nextLine();
        scan.nextInt();
        
        System.out.printf("RG Numeros: ");
        int RG_Num = scan.nextInt(); 

        System.out.printf("Data de Ingresso\nDia: ");
        int dia = scan.nextInt();

        System.out.printf("Mes: ");
        int mes = scan.nextInt();

        System.out.printf("Ano: ");
        int ano = scan.nextInt();

        Data Data_de_Ingresso = new Data(dia, mes, ano);
        
        System.out.printf("Data Nascimento\nDia: ");
        dia = scan.nextInt();

        System.out.printf("Mes: ");
        mes = scan.nextInt();

        System.out.printf("Ano: ");
        ano = scan.nextInt();

        Data Data_de_Nascimento = new Data(dia, mes, ano); 

        System.out.printf("Salario: ");
        float salario = scan.nextFloat();

        System.out.printf("Numero da Carteira: ");
        int Numero_Carteira_de_trabalho = scan.nextInt();
        Endereco endereco = new Endereco(End_Rua, End_Num, End_Bairro, End_Cidade, End_Estado, End_Pais, End_Complemento, End_Cep);

        Funcionario Novo = new Funcionario(Nome, CPF, Data_de_Nascimento, endereco, Sexo, Estado_Civil, Numero_Carteira_de_trabalho, Cargo_na_empresa, salario, Data_de_Ingresso, RG_Num, RG_UF);
        
        Agencias.get(index).getFuncionarios().add(Novo);
    }

    private void Promover_A_Gerente(Scanner scan)
    {
        System.out.printf("Escolha um funcionario");
        Encontrar_Funcionario();

        int index = scan.nextInt();
        
        System.out.printf("Possui Formacao Basica em Gerencia? \n01 -> Sim \n02 -> Nao");
        int conversao = scan.nextInt();

        //pegar os dados do funcionario e reinstanciar ele como gerente e adicionar o novo no mesmo index
        boolean Formacao_Basica_EmGerencia;
    }
    
 //////////////////////////////////////////////////////////////////////////////
 ///
 ///                Agencias                                                ///
 ///
 //////////////////////////////////////////////////////////////////////////////

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
    
    public  void Encontrar_Agencias_Proximas()
    {
        for(int i =0 ;i<Agencias.size();i++)
        {
            System.out.printf((i+1) + " -> ");
            Agencias.get(i).ImprimeNome_e_Localizacao();
        }
    }

    private void Cadastrar_Agencia(Scanner scan)
    {
        System.out.println("Permitido Acesso apenas a Administradores");
        System.out.print("Usuario: ");
        String Usuario = scan.nextLine();
        System.out.print("Senha: ");
        String Senha = scan.nextLine();
        
        boolean AcessoAdmim = LoginAdministrador(Usuario, Senha);

        if(!AcessoAdmim)
            return;
        
        System.out.print("Nome da Agencia: ");
        String NomeAgencia = scan.nextLine();

        Agencia Nova = new Agencia(NomeAgencia, (Agencias.size()+100));
        System.out.print("Fica em qual Pais: ");
        String Pais = scan.nextLine();
        System.out.print("Estado: ");
        String Estado = scan.nextLine();
        System.out.printf("Cidade: ");
        String Cidade = scan.nextLine();
        System.out.printf("Bairro: ");
        String Bairro = scan.nextLine();
        System.out.printf("Rua: ");
        String Rua = scan.nextLine();
        System.out.printf("Complemento: ");
        String Complemento = scan.nextLine();
        System.out.printf("Numero: ");
        int Num = scan.nextInt();
        System.out.printf("CEP: ");
        int cep = scan.nextInt();
        scan.nextLine();

        Nova.setEndereco_agencia(new Endereco(Rua, Num, Bairro, Cidade, Estado, Pais, Complemento,cep));

        System.out.println("Nova Agencia dos Cria Cadastrada, Mandem seus curriculos! ");

    }

 //////////////////////////////////////////////////////////////////////////////
 ///
 ///                Clientes                                                ///
 ///
 //////////////////////////////////////////////////////////////////////////////

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

    

///////////////////////////////////////////////////////////////////////////////
///
///                 Contas                                                 ////
///
///////////////////////////////////////////////////////////////////////////////

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

    public void Cadastrar_Conta(Scanner scan)
    {
        //digtar cpf
        Cadastrar_Cliente(scan);
        //apenas teste
        System.out.println("Digite seu CPF");
        String CPF = scan.nextLine();
        for(int i =0;i<Clientes.size();i++){
            if(CPF == Clientes.get(i).getCPF()){
                System.out.println("Cliente já cadastrado!");
                System.out.println("Vamos cadastrar sua conta:");
                int op;
                String ag;
                while(true){
                System.out.println("Digite a agência que deseja: ");
                System.out.println("1- Agência de Uberlândia");
                System.out.println("2- Agência de Uberaba");
                op = scan.nextInt();
                
                if(op == 1){
                    ag = "Uberlandia";
                    break;
                }
                else if (op == 2){
                    ag = "Uberaba";
                    break;
                }
                else{
                    System.out.println("Opção não disponível, digite novamente");
                }
            }
                int Num_Agencia;
                if(ag == "Uberlandia") Num_Agencia = 1;
                else{
                    Num_Agencia = 2;
                }
                Random gerador = new Random();
                int numConta = gerador.nextInt(200000);
                System.out.println("Digite a senha: ");
                int senha = scan.nextInt();
                System.out.println("Escolha uma opção: ");
                System.out.println("1-Conta normal");
                System.out.println("2-Conta conjunta");
                boolean conjunta;
                int op1 = scan.nextInt();
                if(op1 == 1) conjunta = false;
                else conjunta = true;
                

                System.out.println("Digite o tipo da conta: ");
                System.out.printf("1-Poupança\n2-Corrente\n3-Salario");
                int op3 = scan.nextInt();
                switch(op1){
                    case 1: //Teve Alteracoes nos construtores
                    //Contas.add(new Poupanca(numConta,senha,0,conjunta,Clientes.get(i),new Agencia(ag, Num_Agencia),new Data(30, 2, 2022),0));
                    case 2:
                    //Contas.add new Corrente
                    case 3:
                    //Contas.add Salario
                }
                
            }
        }
        
    }
    
 //////////////////////////////////////////////////////////////////////////////
 ///
 ///                Salvar e Carregar Arquivos                              ///
 ///
 //////////////////////////////////////////////////////////////////////////////  
   
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
