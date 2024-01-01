package Controller;
import Model.Contato;
import java.util.ArrayList;
import java.util.HashSet;

public class Controller {
    private HashSet<Contato> contatos;

    public Controller(){
        this.contatos = new HashSet<>();
    }

    public void adicionarContato(Contato contato){
        contatos.add(contato);
    }

//    public Contato pesquisarContato(int id){
//
//    }
//
//    public ArrayList<Contato> pesquisarContato(String nome){
//
//    }
//
//    public void atualizarContato(Contato novo, int id){
//
//    }
//
//    public void excluirContato(int id){
//
//    }
//
    public ArrayList<Contato> listarContatos(){
        return new ArrayList<>(contatos);
    }
}
