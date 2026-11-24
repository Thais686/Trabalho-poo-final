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

    public String consultar(int id) throws ClienteNaoEncontradoException {

        String resultado= "";
    for (Cliente c : clientesCadastrados) {


        if (c.getId() == id) {
            resultado += "Cliente encontrado!\n";
            resultado +="ID: " + c.getId() + "\n";
            resultado += "Nome: " + c.getNome() + "\n";
            resultado += "Telefone: " + c.getTelefone() + "\n";
            resultado += "Email: " + c.getEmail() + "\n";
            return resultado;
        }
    }

    throw new ClienteNaoEncontradoException(id);
}

   public String listar() {

        String resultado= "";

    for (Cliente c : clientesCadastrados) {
        resultado +=("ID: " + c.getId() + " | Nome: " + c.getNome() + " | Telefone: " + c.getTelefone() + " | Email: " + c.getEmail()+ "\n");
    }

    return resultado;
}

public Cliente buscarPorId(int id) throws ClienteNaoEncontradoException {
    for (Cliente c : clientesCadastrados) {
        if (c.getId() == id) {
            return c;
        }
    }

    throw new ClienteNaoEncontradoException(id);
}
}
