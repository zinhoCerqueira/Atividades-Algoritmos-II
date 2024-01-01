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
        boolean ok = true;

        while (ok) {
            try {
                ////////////////////Limpar console
                for (int i = 0; i < 15 ; i++){
                    System.out.println("");
                }

                exibirMenu();
                int valor = scanner.nextInt();
                scanner.nextLine();

                ////////////////////Limpar console
                for (int i = 0; i < 15 ; i++){
                    System.out.println("");
                }

                if (valor >= 1 && valor <= 5) {
                    realizarAcao(valor);
                } else {
                    System.out.println("Por favor, insira um valor entre 1 e 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um valor inteiro válido de 1 a 5.");
                scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("= AGENDA === AGENDA === AGENDA =");
        System.out.println("===============================");
        System.out.println("1 - ADICIONAR CONTATO");
        System.out.println("2 - PESQUISAR CONTATO");
        System.out.println("3 - ATUALIZAR CONTATO");
        System.out.println("4 - EXCLUIR CONTATO");
        System.out.println("5 - LISTAR CONTATO");
        System.out.println("===============================");
        System.out.print("DIGITE UMA OPÇÃO - > ");
    }

    private static void realizarAcao(int opcao) {
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
            default:
                System.out.println("Opção inválida.");
        }
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

        System.out.println("");
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
    }

    private static void atualizarContato() {
        // Implemente a lógica para atualizar um contato aqui
        System.out.println("Função de atualizar contato.");
    }

    private static void excluirContato() {
        // Implemente a lógica para excluir um contato aqui
        System.out.println("Função de excluir contato.");
    }

    private static void listarContato() {
        // Implemente a lógica para listar contatos aqui
        System.out.println("=LISTAR CONTATOS === LISTAR CONTATOS =");
        ArrayList<Contato> contato = controller.listarContatos();
        for (Contato c : contato) {
            System.out.println(c.toString());
        }

        System.out.println("");
        System.out.println("PRESSIONE ENTER PARA CONTINUAR...");
        scanner.nextLine(); // Aguarda até que o usuário pressione Enter

    }
}
