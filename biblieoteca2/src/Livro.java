public class Livro extends ItemBiblioteca {
    private String categoria;

    public Livro(String titulo, String autor, int anoPublicacao, int numExemplares, String categoria) {
        super(titulo, autor, anoPublicacao, numExemplares);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Ano de Publicação: " + getAnoPublicacao());
        System.out.println("Número de Exemplares: " + getNumExemplares());
        System.out.println("Número de Exemplares Disponíveis: " + getNumExemplaresDisponiveis());
        System.out.println("Categoria: " + getCategoria());
    }
}
 
 