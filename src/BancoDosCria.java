import java.util.Scanner;

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
            
            scan = new Scanner(System.in);//Limpando o Scanner
            
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


}
