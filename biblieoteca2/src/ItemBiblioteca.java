interface Cadastro {
    void cadastrar();
}

interface Consulta {
    void consultar();
}


abstract class ItemBiblioteca {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numExemplares;
    private int numExemplaresDisponiveis;

    public ItemBiblioteca(String titulo, String autor, int anoPublicacao, int numExemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numExemplares = numExemplares;
        this.numExemplaresDisponiveis = numExemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getNumExemplares() {
        return numExemplares;
    }

    public int getNumExemplaresDisponiveis() {
        return numExemplaresDisponiveis;
    }

    public void decrementarNumExemplaresDisponiveis() {
        numExemplaresDisponiveis--;
    }

    public void incrementarNumExemplaresDisponiveis() {
        numExemplaresDisponiveis++;
    }

    public abstract void exibirInformacoes();
}