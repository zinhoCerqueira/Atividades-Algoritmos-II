package View;

import Controller.Controller;
import Exceptions.CamposVaziosException;
import Exceptions.ContatoRepetidoException;
import Model.Contato;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Controller controller = new Controller();



    public static void main(String[] args) {

        rotinaTeste();


        boolean ok = true;
        while (ok) {
            try {
                ////////////////////Limpar console
                for (int i = 0; i < 15 ; i++){
                    System.out.println();
                }

                exibirMenu();
                controller.salvar();
                int valor = scanner.nextInt();
                scanner.nextLine();

                ////////////////////Limpar console
                for (int i = 0; i < 15 ; i++){
                    System.out.println();
                }

                if (valor >= 0 && valor <= 5) {
                    ok = realizarAcao(valor);
                } else {
                    System.out.println("Por favor, insira um valor entre 0 e 5.");
                    System.out.println();
                    System.out.println("PRESSIONE ENTER PARA CONTINUAR...");
                    scanner.nextLine(); // Aguarda até que o usuário pressione Enter
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um valor inteiro válido de 0 a 5.");
                scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
                System.out.println();
                System.out.println("PRESSIONE ENTER PARA CONTINUAR...");
                scanner.nextLine(); // Aguarda até que o usuário pressione Enter
            }
        }

        scanner.close();
    }

    private static void rotinaTeste() {
//        Contato x = new Contato("Jader", "075 9 000000000", "Avenida Central", "meu@email.com");
//        Contato a = new Contato("Fulano", "075 9 123456789", "Avenida DisneyWorld", "fulano@email.com");
//        Contato b = new Contato("Beltrano", "075 9 234567891", "Rua do Parque Central", "beltrano@email.com");
//        Contato c = new Contato("Ciclano", "075 9 345678912", "Travessa do Circulo Quadrado", "ciclano@email.com");
//
//        controller.adicionarContato(a);
//        controller.adicionarContato(b);
//        controller.adicionarContato(c);
//        controller.adicionarContato(x);
//
//        controller.salvar();
        controller.recuperarContatos("contatos.txt");

    }

    private static void exibirMenu() {
        System.out.println("================================");
        System.out.println("= AGENDA === AGENDA === AGENDA =");
        System.out.println("================================");
        System.out.println("1 - ADICIONAR CONTATO");
        System.out.println("2 - PESQUISAR CONTATO");
        System.out.println("3 - ATUALIZAR CONTATO");
        System.out.println("4 - EXCLUIR CONTATO");
        System.out.println("5 - LISTAR CONTATO");
        System.out.println("0 - FECHAR");
        System.out.println("================================");
        System.out.print("DIGITE UMA OPÇÃO --> ");
    }

    private static boolean realizarAcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarContato();
                break;
            case 2:
                pesquisarContato();
                break;
            case 3:
                atualizarContato();
                break;
            case 4:
                excluirContato();
                break;
            case 5:
                listarContato();
                break;
            case 0:
                return false;
            default:
                System.out.println("Opção inválida.");
        }
        return true;

    }

    private static void adicionarContato() {
        // Implemente a lógica para adicionar um contato aqui
        String nome, telefone, endereco, email;

        try {
            System.out.println("= ADICIONAR CONTATO =");
            System.out.println("= NOME =");
            nome = scanner.nextLine();
            System.out.println("= TELEFONE =");
            telefone = scanner.nextLine();
            System.out.println("= ENDEREÇO =");
            endereco = scanner.nextLine();
            System.out.println("= EMAIL =");
            email = scanner.nextLine();

            validarCamposNaoVazios(nome, telefone, endereco, email);
            validarContatoRepetido(nome, telefone, endereco, email);

            Contato contato = new Contato(nome, telefone, endereco, email);
            controller.adicionarContato(contato);

        } catch (CamposVaziosException | ContatoRepetidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println();
        System.out.println("PRESSIONE ENTER PARA CONTINUAR...");
        scanner.nextLine(); // Aguarda até que o usuário pressione Enter


    }

    private static void validarContatoRepetido(String nome, String telefone, String endereco, String email) throws ContatoRepetidoException {
        ArrayList<Contato> contatos = controller.listarContatos();
        for(Contato c : contatos){
            if(c.getEmail().equals(email) && c.getEndereco().equals(endereco) &&
            c.getNome().equals(nome) && c.getTelefone().equals(telefone)){
                throw new ContatoRepetidoException("Este contato já está cadastrado.");
            }
        }
    }

    private static void validarCamposNaoVazios(String... campos) throws CamposVaziosException {
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                throw new CamposVaziosException("Nenhum campo pode ser vazio.");
            }
        }
    }

    private static void pesquisarContato() {
        // Implemente a lógica para pesquisar um contato aqui
        System.out.println("=PESQUISAR CONTATO === PESQUISAR CONTATO=");

        System.out.println("1 - POR ID");
        System.out.println("2 - POR NOME");
        int valor = scanner.nextInt();
        scanner.nextLine();
        if(valor == 1){
            System.out.println("INFORME O ID A SER PROCURADO.");
            int id = scanner.nextInt();
            scanner.nextLine();
            Contato c = controller.pesquisarID(valor);

            if(c == null){
                System.out.println("ESSE USUÁRIO NÃO EXISTE");
            }
            else{
                System.out.println(c.toString());
            }

        } else if (valor == 2) {
            System.out.println("INFORME O NOME A SER PROCURADO.");
            String nome = scanner.nextLine();
            ArrayList<Contato> c = controller.pesquisarNome(nome);

            if(c.isEmpty()){
                System.out.println("ESSE USUÁRIO NÃO EXISTE");
            }
            else{
                for(Contato x : c){
                    System.out.println(x.toString());
                }
            }
        }
        else {
            System.out.println("Valor Incorreto");
        }



        System.out.println();
        System.out.println("PRESSIONE ENTER PARA CONTINUAR...");
        scanner.nextLine(); // Aguarda até que o usuário pressione Enter
    }

    private static void atualizarContato() {
        // Implemente a lógica para atualizar um contato aqui
        System.out.println("=ATUALIZAR CONTATO === ATUALIZAR CONTATO=");
        System.out.println("INFORME O ID DO CONTATO QUE DEVE SER ATUALIZADO");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("INFORME OS DADOS NOVOS");

        String nome, telefone, endereco, email;
        try {
            System.out.println("= ADICIONAR CONTATO =");
            System.out.println("= NOME =");
            nome = scanner.nextLine();
            System.out.println("= TELEFONE =");
            telefone = scanner.nextLine();
            System.out.println("= ENDEREÇO =");
            endereco = scanner.nextLine();
            System.out.println("= EMAIL =");
            email = scanner.nextLine();

            validarCamposNaoVazios(nome, telefone, endereco, email);
            validarContatoRepetido(nome, telefone, endereco, email);

            Contato contato = new Contato(nome, telefone, endereco, email);
            boolean b = controller.atualizarContato(id, contato);

            if(b){
                System.out.println("SUCESSO");
            }
            else{
                System.out.println("ID NÃO EXISTENTE");

            }

        } catch (CamposVaziosException | ContatoRepetidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println();
        System.out.println("PRESSIONE ENTER PARA CONTINUAR...");
        scanner.nextLine(); // Aguarda até que o usuário pressione Enter

    }

    private static void excluirContato() {
        // Implemente a lógica para excluir um contato aqui
        System.out.println("=EXCLUIR CONTATO === EXCLUIR CONTATO=");
        System.out.println("INFORME O ID DO CONTATO QUE DEVE SER EXCLUIDO");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean b = controller.excluirContato(id);

        if(b){
            System.out.println("SUCESSO");
        }
        else{
            System.out.println("ID NÃO EXISTENTE");
        }
        System.out.println();
        System.out.println("PRESSIONE ENTER PARA CONTINUAR...");
        scanner.nextLine(); // Aguarda até que o usuário pressione Enter
    }

    private static void listarContato() {
        // Implemente a lógica para listar contatos aqui
        System.out.println("=LISTAR CONTATOS === LISTAR CONTATOS =");
        ArrayList<Contato> contato = controller.listarContatos();
        if(contato.isEmpty()){
            System.out.println("A AGENDA ESTÁ VAZIA");
        }
        else{
            for (Contato c : contato) {
                System.out.println(c.toString());
            }
        }

        System.out.println();
        System.out.println("PRESSIONE ENTER PARA CONTINUAR...");
        scanner.nextLine(); // Aguarda até que o usuário pressione Enter

    }
}
