public class Main {
    public static void main(String[] args) {
        // Criação do Objeto MyClass.
        MyInterface minhaClasse = new MyClass();
        //MyClass minhaClasse = new MyClass(); Também funciona, mas devemos programar para a interface e não para a implementação.

        // Chamada dos métodos via instâncias
        minhaClasse.printNomeDaClasse();
        minhaClasse.umMetodoPadrao();
        minhaClasse.umMetodoPadraoDois();

        //Chamada método estático da interface
        MyInterface.umMetodoEstatico();
        // MyClass.umMetodoEstatico(); // Não visível, pois é um método da interface e não da classe.

        //Acesso à contante 'umaConstante'
        System.out.println(MyInterface.umaConstante);
        System.out.println(MyClass.umaConstante);
        //minhaClasse.umaConstante; Nâo funciona


    }
}