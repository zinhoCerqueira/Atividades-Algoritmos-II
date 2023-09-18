public interface MyInterface {
    String umaConstante = "Uma constante pode ser definido em uma interface";

    public static void umMetodoEstatico(){
        System.out.println("Implementações são permitidos em métodos estáticos de uma interface.\n " +
                " - São acessadas apenas via interface: MyInterface.umMetodoEstatico() ");
    }

    public default void umMetodoPadrao(){
        System.out.println("Implementações são permitidos em métodos padrão de uma interface.\n " +
                " - São acessadas apenas via instância: meuObjeto.umMetodoPadrao() ");
    }

    public default void umMetodoPadraoDois(){
        System.out.println("Implementações são permitidos em métodos padrão de uma interface.\n " +
                "São acessadas apenas via instância: meuObjeto.umMetodoPadraoDois() ");
    }

    public void printNomeDaClasse();
}
