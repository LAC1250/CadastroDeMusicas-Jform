public class Musica {
    private int id;
    private String titulo;
    private String artista;
    private String compositor;
    private Genero genero;

    public Musica(int id, String titulo, String artista, String compositor, Genero genero) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.compositor = compositor;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Musica{" + "id=" + id + ", titulo=" + titulo + ", artista=" + artista + ", compositor=" + compositor + ", genero=" + genero + '}';
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCompositor() {
        return compositor;
    }

    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Musica other = (Musica) obj;
        return this.id == other.id;
    }

  

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }    
}
