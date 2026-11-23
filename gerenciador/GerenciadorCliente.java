package gerenciador;

import java.util.ArrayList;
import modelo.Cliente;
import excecoes.ClienteNaoEncontradoException;

public class GerenciadorCliente {
    private ArrayList<Cliente> clientesCadastrados;

    public GerenciadorCliente(){
        clientesCadastrados = new ArrayList<Cliente>();
    }

    public void cadastrar(Cliente c) {

    for (Cliente cliente : clientesCadastrados) {
        if (cliente.getId() == c.getId()) {
            throw new IllegalArgumentException("Já existe um cliente com esse ID!");
        }
    }

    clientesCadastrados.add(c);
}

    public void consultar(int id) throws ClienteNaoEncontradoException {

        
    for (Cliente c : clientesCadastrados) {
        if (c.getId() == id) {
            System.out.println("Cliente encontrado!");
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Email: " + c.getEmail());
            return;
        }
    }

    throw new ClienteNaoEncontradoException(id);
}

   public void listar() {
    for (Cliente c : clientesCadastrados) {
        System.out.println("ID: " + c.getId() + " | Nome: " + c.getNome() + " | Telefone: " + c.getTelefone() + " | Email: " + c.getEmail());
    }
}
}