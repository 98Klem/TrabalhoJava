import java.util.*;

public class Devolucao {
    private Usuario usuario;
    private ItemBiblioteca item;
    private Date dataDevolucao;
    
    public Devolucao(Usuario usuario, ItemBiblioteca item, Date dataDevolucao) {
        this.usuario = usuario;
        this.item = item;
        this.dataDevolucao = dataDevolucao;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public ItemBiblioteca getItem() {
        return item;
    }
    
    public Date getDataDevolucao() {
        return dataDevolucao;
    }
    } 
