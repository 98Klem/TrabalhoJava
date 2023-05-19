import java.util.*;

public class Emprestimo {
    private Usuario usuario;
    private ItemBiblioteca item;
   
private Date dataEmprestimo;
private Date dataDevolucaoPrevista;


public Emprestimo(Usuario usuario, ItemBiblioteca item, Date dataEmprestimo, Date dataDevolucaoPrevista) {
    this.usuario = usuario;
    this.item = item;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucaoPrevista = dataDevolucaoPrevista;
}

public Usuario getUsuario() {
    return usuario;
}

public ItemBiblioteca getItem() {
    return item;
}

public Date getDataEmprestimo() {
    return dataEmprestimo;
}

public Date getDataDevolucaoPrevista() {
    return dataDevolucaoPrevista;
}
} 