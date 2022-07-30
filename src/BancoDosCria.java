import java.util.Scanner;

public class BancoDosCria {
    public static void main(String[] args) {
        int opcao = 999;
        Scanner scan = new Scanner(System.in);
        String NomeBanco = "Banco Dos Crias";


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
                    Acessar_Conta(scan);
                    break;
                case 2: // Abrir uma conta
                    Criar_Conta();
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

    //Menu para quem ja e cliente
    public static void Acessar_Conta(Scanner scan)
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
            

            if(!conta_encontrada)
            {
                System.out.println("Conta não encontrada deseja tentar novamente? ");
            }   
            
            System.out.println("0 para Não ou Qualquer outro numero para Sim");
            opcao = scan.nextInt();
        }

    }

    public static void Criar_Conta()
    {
        // funções para criar conta
    }

    public static void Acesso_Funcionario()
    {
        // funcoes para funcionarios
    }
}
