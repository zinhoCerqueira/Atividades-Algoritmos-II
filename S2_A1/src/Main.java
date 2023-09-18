public class Main {
    public static void main(String[] args) {

        System.out.println("ATIVIDADE 1 - JAVA");

        Funcionarios f1 = new Funcionarios("Jader", "Quarto", 0, "16/04/1997", "07459582573");

        System.out.println(f1.ganhoAnual());
        f1.recebeAumento(200);
        System.out.println(f1.getSalario());
        System.out.println(f1.ganhoAnual());
    }
}