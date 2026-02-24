package controller;

import javax.inject.Named;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import model.Contato;
import model.CRUD;

@Named
@RequestScoped
public class ContatoMB {
    
	private Contato c = new Contato();
    
	private List<Contato> listaContatos;  
    
    
    public ContatoMB() {
    }
    
    
    public String getId() {
        return String.valueOf(c.getId());
    }
    
    public void setId(String id) {
        c.setId(Integer.parseInt(id));
    }
    
    public String getNome() {
        return c.getNome();
    }
    
    public void setNome(String nome) {
        c.setNome(nome);
    }
    
    public String getSobrenome() {
        return c.getSobrenome();
    }
    
    public void setSobrenome(String sobrenome) {
        c.setSobrenome(sobrenome);
    }
    
    public String getTelefone() {
        return c.getTelefone();
    }
    
    public void setTelefone(String telefone) {
        c.setTelefone(telefone);
    }
    
    public String getEmail() {
        return c.getEmail();
    }
    
    public void setEmail(String email) {
        c.setEmail(email);
    }
    
    public void salvar() {
        try {
            System.out.println("=== TENTANDO SALVAR ===");
            System.out.println("Nome: " + c.getNome());
            System.out.println("Sobrenome: " + c.getSobrenome());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Email: " + c.getEmail());
            
            CRUD.inserir(c);
            
            System.out.println("=== SALVO COM SUCESSO ===");
            
            // Limpar o formulário após salvar
            c = new Contato();
            // Recarregar a lista
            listaContatos = CRUD.listarTodos();
        } catch(Exception ex) {
            ex.printStackTrace();
        } 
    }
    
    //MÉTODO PARA CARREGAR A LISTA
    public List<Contato> getListaContatos() {
        if (listaContatos == null) {
            listaContatos = CRUD.listarTodos();
        }
        return listaContatos;
    }
 
}