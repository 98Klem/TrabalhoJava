import java.util.*;
import java.io.*;
class Biblioteca implements Cadastro, Consulta {
    private List<ItemBiblioteca> itens;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;
    private List<Devolucao> devolucoes;
    
   
    public Biblioteca() {
        itens = new ArrayList<>();
        usuarios = new ArrayList<>();
        emprestimos = new ArrayList<>();
        devolucoes = new ArrayList<>();
    }
    
    public void cadastrar() {
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 1899, 5, "Romance");
        Livro livro2 = new Livro("1984", "George Orwell", 1949, 3, "Ficção Científica");
        Livro livro3 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943, 2, "Infantil");
    
        Usuario usuario1 = new Usuario("João", "(11) 1111-1111", "Rua A, 123", "joao@example.com");
        Usuario usuario2 = new Usuario("Maria", "(22) 2222-2222", "Rua B, 456", "maria@example.com");
        Usuario usuario3 = new Usuario("Pedro", "(33) 3333-3333", "Rua C, 789", "pedro@example.com");
    
        itens.add(livro1);
        itens.add(livro2);
        itens.add(livro3);
    
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
    }
    
    public void consultar() {
        System.out.println("Itens da Biblioteca:");
        for (ItemBiblioteca item : itens) {
            item.exibirInformacoes();
            System.out.println();
        }
    
        System.out.println("Usuários Cadastrados:");
        for (Usuario usuario : usuarios) {
            usuario.exibirInformacoes();
            System.out.println();
        }
    }
    
    public void realizarEmprestimo(Usuario usuario, ItemBiblioteca item) throws Exception {
        if (emprestimos.size() >= 3) {
            throw new Exception("Limite de empréstimos atingido para o usuário.");
    }
    
   
        if (item.getNumExemplaresDisponiveis() == 0) {
            throw new Exception("Não há exemplares disponíveis para empréstimo.");
        }
    
        Date dataEmprestimo = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataEmprestimo);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date dataDevolucaoPrevista = calendar.getTime();
    
        Emprestimo emprestimo = new Emprestimo(usuario, item, dataEmprestimo, dataDevolucaoPrevista);
        emprestimos.add(emprestimo);
        item.decrementarNumExemplaresDisponiveis();
    }
    
    public void realizarDevolucao(Usuario usuario, ItemBiblioteca item) throws Exception {
        boolean emprestado = false;
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getUsuario().equals(usuario) && emprestimo.getItem().equals(item)) {
                emprestado = true;
                emprestimos.remove(emprestimo);
                break;
            }
        }
    
        if (!emprestado) {
            throw new Exception("O usuário não possui esse item emprestado.");
        }
    
        Devolucao devolucao = new Devolucao(usuario, item, new Date());
        devolucoes.add(devolucao);
        item.incrementarNumExemplaresDisponiveis();
    }
    
    public void gerarRelatorios() {
        System.out.println("Livros Emprestados:");
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println("Usuário: " + emprestimo.getUsuario().getNome());
            System.out.println("Livro: " + emprestimo.getItem().getTitulo());
            System.out.println("Data de Empréstimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Data de Devolução Prevista: " + emprestimo.getDataDevolucaoPrevista());
            System.out.println();
        }
    
        System.out.println("Livros Devolvidos:");
        for (Devolucao devolucao : devolucoes) {
            System.out.println("Usuário: " + devolucao.getUsuario().getNome());
            System.out.println("Livro: " + devolucao.getItem().getTitulo());
            System.out.println("Data de Devolução: " + devolucao.getDataDevolucao());
            System.out.println();
        }
    }
    
    public void salvarDadosEmArquivo(String arquivo) {
        try (FileOutputStream fos = new FileOutputStream(arquivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(itens);
            oos.writeObject(usuarios);
            oos.writeObject(emprestimos);
            oos.writeObject(devolucoes);
            System.out.println("Dados salvos em arquivo com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados em arquivo: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public void carregarDadosDeArquivo(String arquivo) {
        try (FileInputStream fis = new FileInputStream(arquivo);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            itens = (List<ItemBiblioteca>) ois.readObject();
            usuarios = (List<Usuario>) ois.readObject();
            emprestimos = (List<Emprestimo>) ois.readObject();
            devolucoes = (List<Devolucao>) ois.readObject();
            System.out
    .println("Dados carregados do arquivo com sucesso.");
    } catch (IOException | ClassNotFoundException e) {
    System.out.println("Erro ao carregar os dados do arquivo: " + e.getMessage());
    }
    }

    public Object getUsuarios() {
        return null;
    }
    }