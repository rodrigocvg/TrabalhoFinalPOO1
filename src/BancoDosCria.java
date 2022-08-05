import java.util.Scanner;

import GerenciadorArquivos.GerenArquivos;
import Personas.Pessoa;
import Personas.Clientes.Clientes;


// ATENÇÃO MUDEI TODOS NEXTLINE PARA NEXT INT - POIS N TAVA RODANDO, PARA LER UMA LINHA INTEIRA TEM QUE SER O BUFFERED READ, DPS NOIS COLOCA 

public class BancoDosCria {
    public static void main(String[] args) {
        int opcao = 999;
        Scanner scan = new Scanner(System.in);
        String NomeBanco = "Banco Dos Crias";
        Banco BancoDosCria = new Banco();

        System.out.println("Seja Bem ao "+ NomeBanco);
        //menu
        while(opcao!=0)
        {
            System.out.println("Primeiro me diz voce quer: ");
            System.out.println("01 -> Acessar Minha Conta");
            System.out.println("02 -> Abrir uma Conta");
            System.out.println("03 -> Area do Funcionario (Acesso Funcionario, Cadastrar Funcionario, Promover a Gerente, Cadastrar Agencia");
            System.out.println("04 -> Encontrar Agencia mais proxima");
            System.out.println("00 -> Sair do Sistema");    
            
            opcao = scan.nextInt(); // Escolhendo opcao

            switch(opcao)
            {
                case 0: // Sai do programa
                    break;
                case 1: // Entra em Acessar conta
                    BancoDosCria.Acessar_Conta(scan);
                    break;
                case 2: // Abrir uma conta
                    BancoDosCria.Cadastrar_Conta(scan);
                    break;
                case 3: // Acesso Funcionario
                    BancoDosCria.Area_do_Funcionario(scan);
                    break;
                case 4:
                    BancoDosCria.Encontrar_Agencias_Proximas(scan);
                    break;
                case 5: 
                    BancoDosCria.Cadastrar_Cliente(scan);
                    break;
                default:
                    System.out.println("Essa opcao nao existe meu cria! \nDa uma olhada nas opcoes disponiveis e tenta novamente");
                    break;
            }   
        }
        scan.close();


    }


    // apenas para rascunho deletar essa funcao abaixo depois
    public static void Criar_Conta(Scanner scan) // provavelmente sera necessario colocar essa funcao
                                                //dentro do acesso do funcioanrio para dar sentido a ele.
    {
        int opcao =1;
        while(opcao!=0)
        {
            boolean cpf_encontrado = false;
            System.out.println("Vamos cadastrar sua conta meu cria");
            System.out.print("Digite seu CPF: ");
            String cpf = scan.next();
            boolean cpfvalido = ValidaCPF.isCPF(cpf);

            if(cpfvalido)
                break;

            //buscar nos clientes se possui algum ja cadastrado com esse cpf
            //caso encontrado
         //   if(cpf_encontrado) // quando cpf tiver cadastrado como cliente ja
         //   {
          //      System.out.println("CPF ja cadastrado com os seguintes dados: ");
                //printar nome data nascimento e endereco.
           //     System.out.println("Caso os dados estiverem incorretos va ate uma agencia mais proxima para realizar atualização");
           //    System.out.println("Deseja continuar a cadastrar sua conta com os dados informados?");
           // }
            Pessoa Cliente_Novo = new Clientes();

            
            if(!cpf_encontrado) // caso cpf ainda não cadastrado
            {
                System.out.print("Digite seu nome completo: ");
                Cliente_Novo.setNome(scan.next());
                System.out.print("Cria se nasceu que dia? ");
                int dia_nascimento = scan.nextInt();
                System.out.print("No mes de Numero? ");
                int mes = scan.nextInt();
                System.out.print("E qual ano era?");
                int ano = scan.nextInt();
                Cliente_Novo.setData_de_Nascimento(dia_nascimento,mes,ano);
                System.out.print("Voce e de qual Genero? ");
                Cliente_Novo.setSexo(scan.next());
                System.out.print("Qual seu estado civil? ");
                Cliente_Novo.setEstado_Civil(scan.next());
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
                //Endereco End_Novo_Cliente = new Endereco(Rua, numero, Cidade, Estado, Pais, End_Complemento, CEP);
                //Cliente_Novo.setEndereco(End_Novo_Cliente);               

            }
        }
    }

}
