package Controller;
import Model.Contato;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Controller {
    private Map<Integer, Contato> contatos;
    private int id;

    public Controller(){
        this.contatos = new HashMap<>();
    }

    public void adicionarContato(Contato contato){
        contato.setId(this.id);
        this.id++;
        contatos.put(contato.getId(), contato);
    }

    public ArrayList<Contato> listarContatos(){
        return new ArrayList<>(contatos.values());
    }

    public Contato pesquisarID(int valor) {
        return contatos.get(valor);
    }

    public ArrayList<Contato> pesquisarNome(String nome) {
        ArrayList<Contato> c = new ArrayList<>();

        for (Contato contato : contatos.values()) {
            if (contato.getNome().equals(nome)) {
                c.add(contato);
            }
        }

        return c;
    }

    public boolean atualizarContato(int id, Contato contato) {
        contato.setId(id);
        if(contatos.containsKey(id)){
            contatos.replace(id, contato);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean excluirContato(int id) {
        if(contatos.containsKey(id)){
            contatos.remove(id);
            return true;
        }
        else{
            return false;
        }
    }

    public void salvar(){
        try (PrintWriter writer = new PrintWriter(new FileWriter("contatos.txt"))) {
            // Salvando o HashMap em formato de texto
            for (Map.Entry<Integer, Contato> entry : contatos.entrySet()) {
                writer.println(entry.getValue().getId() + "," + entry.getValue().getNome() + "," + entry.getValue().getTelefone()+ ","+ entry.getValue().getEndereco()+ "," + entry.getValue().getEmail());
            }
//            System.out.println("Salvo em arquivo de texto com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recuperarContatos(String nomeArquivo) {
        this.contatos = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 5) {
                    int id = Integer.parseInt(partes[0]);
                    String nome = partes[1];
                    String endereco = partes[2];
                    String telefone = partes[3];
                    String email = partes[4];
                    contatos.put(id, new Contato(id, nome, endereco,telefone, email));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Arquivo não encontrado.");
        }

    }

    public  void valorID(){
        int maiorChave = Integer.MIN_VALUE;
        for (Contato contato : contatos.values()) {
            if (contato.getId() > maiorChave) {
                this.id = contato.getId();
            }
        }
        this.id++;
    }
}
