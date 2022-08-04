import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class GerenArquivos {


    private static final String BaseDados ="E:\\POO1\\Trabalho\\testeArquivos\\";

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
                clientes.add(new Clientes(campos [1],Integer.parseInt(campos [0])));
            }
            br. close ();
        }
        catch ( IOException erro ) 
        {
            System .out. println (" Erro na leitura dos dados ");
        }
        return clientes;
    }


    public static void CadastrarClientes ( String Nome ,int CPF ,LinkedList<Clientes> clientes) 
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
            
            Boolean CheckID = true;
            
            int id=100;
            if(!primeiroClientes)
            {
                for(int i = 100; i< 130; i++)
                {
                    for(Clientes j : clientes)
                    {
                        if(j.getID()==i)
                            CheckID= false;
                    }
                    if (CheckID)
                    {
                        id=i;
                        break;
                    }
                    else CheckID= true;
                }
            }
            String linha = Nome + ";" + CPF ;
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
