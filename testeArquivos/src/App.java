import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Clientes c1 = new Clientes("Rodrigo", 1099999);
        Clientes c2 = new Clientes("lucas", 9493845);
        Clientes c3 = new Clientes("maria", 22222);
        ArrayList<Object> clientes = new ArrayList<Object>();
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        

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

        gravarArq.printf("Nome|%s;CPF|%s",
          ((Clientes)item2).getNome(),
          ((Clientes)item2).getCPF());
      }

      gravarArq.close();

      System.out.printf("\nExportação realizada com sucesso.\n");
      }
    }
    
}
