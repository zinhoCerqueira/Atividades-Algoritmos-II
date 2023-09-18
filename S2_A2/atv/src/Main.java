import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner ler = new Scanner(System.in);

        List <Automovel> list_au = new ArrayList<>();


        boolean z = true;
        while(z){
            int n;

            System.out.println("1 - Cadastrar Carro Novo");
            System.out.println("2 - Consultar Carro Cadastrado");
            System.out.println("3 - Mostrar Todos os Carros");
            System.out.println("4 - Ver maior tempo");
            System.out.println("5 - Ver maior preço");

            n = ler.nextInt();

            if(n == 1){
                System.out.println("Qual o nome do dono ?");
                String nome = ler.next();
                System.out.println("Qual a entrada ?");
                String entrada = ler.next();
                System.out.println("Qual a saida ?");
                String saida = ler.next();
                System.out.println("Qual o valor ?");
                String valor = ler.next();

                Automovel a = new Automovel(nome, entrada, saida, valor);
                list_au.add(a);
            }
            else if(n == 3){
                for(Automovel m : list_au){
                    System.out.println(m.toString());
                }
            }


            System.out.println("CONTINUAR ?");
            z = ler.nextBoolean();
        }

    }
}