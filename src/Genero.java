public class Genero {    
   private String descricao; 
   private int id;

    public Genero(String descricao,int id) {       
        this.descricao = descricao;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " - " + descricao ;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
}
