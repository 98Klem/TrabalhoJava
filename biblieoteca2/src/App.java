import java.util.*;
import java.io.*;
public class App {
    public static void main(String[] args) {
    Biblioteca biblioteca = new Biblioteca();
    biblioteca.cadastrar();
    
   
        try {
            Usuario usuario = biblioteca.getUsuarios().get(0);
            ItemBiblioteca item = biblioteca.getItens().get(0);
            biblioteca.realizarEmprestimo(usuario, item);
        } catch (Exception e) {
            System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
        }
    
        biblioteca.consultar();
        biblioteca.gerarRelatorios();
        biblioteca.salvarDadosEmArquivo("dados_biblioteca.dat");
    
        Biblioteca biblioteca2 = new Biblioteca();
        biblioteca2.carregarDadosDeArquivo("dados_biblioteca.dat");
        biblioteca2.consultar();
        biblioteca2.gerarRelatorios();
    }
    }