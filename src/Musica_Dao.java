
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Musica_Dao  implements Dao<Musica>{
    private Connection bd;

    public Musica_Dao(Connection bd) {
        this.bd = bd;
    }
    
    @Override
    public Musica get(int id) {       
      String sql = "SELECT musica.*, genero.descricao as genero_descricao FROM musica LEFT JOIN genero ON musica.genero_id = genero.id WHERE musica.id=?";
      Musica musica = null;
      try {
          PreparedStatement sentenca = bd.prepareStatement(sql);
          sentenca.setInt(1, id);
          ResultSet resultado = sentenca.executeQuery();         
          if(resultado.next()) {
              String titulo = resultado.getString("titulo");
              String artista = resultado.getString("artista");
              String compositor = resultado.getString("compositor");
              int genero_id = resultado.getInt("genero_id");
              String genero_descricao = resultado.getString("genero_descricao");
              Genero genero = new Genero(genero_descricao,genero_id);
              musica = new Musica(id, titulo, artista, compositor, genero);
          }
          resultado.close();
          sentenca.close();
      } catch (SQLException ex) {
          System.out.println("Erro: "+ex);
      }
      return musica;
    }

    @Override
    public List<Musica> getAll() {
      List<Musica> lista = new ArrayList<Musica>();
      String sql = "SELECT musica.*, genero.descricao as genero_descricao FROM musica LEFT JOIN genero ON genero.id =  musica.genero_id ORDER BY id";
      try {
          Statement sentenca = bd.createStatement();
          ResultSet resultado = sentenca.executeQuery(sql);
          while(resultado.next()) {
              int id = resultado.getInt("id");
              String titulo = resultado.getString("titulo");
              String artista = resultado.getString("artista");
              String compositor = resultado.getString("compositor");
              
              String genero_descricao = resultado.getString("genero_descricao");
              int genero_id = resultado.getInt("genero_id");
              
              Genero genero = new Genero(genero_descricao,genero_id);
              Musica musica = new Musica(id, titulo, artista, compositor, genero);
              lista.add(musica);
          }
          resultado.close();
          sentenca.close();
      } catch (SQLException ex) {
          System.out.println("Erro");
      }
      return lista;
    }
  
    @Override
    public int save(Musica musica) {
      int lastId = 0;
      String sql = "INSERT INTO musica (titulo,artista,compositor,genero_id) VALUES (?,?,?,?)";     
      try {
          PreparedStatement sentenca = bd.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          sentenca.setString(1, musica.getTitulo());
          sentenca.setString(2, musica.getArtista());
          sentenca.setString(3, musica.getCompositor());
          sentenca.setInt(4,musica.getGenero().getId());
          sentenca.executeUpdate();
          final ResultSet rs = sentenca.getGeneratedKeys();
          if(rs.next()){
            lastId = rs.getInt(1);
            System.out.println("id: "+lastId);
          }
          rs.close();
          sentenca.close();
      } catch (SQLException ex) {
          System.out.println("Erro: "+ex);
      }
      return lastId;
    }

    @Override
    public void update(Musica musica) {
      String sql = "UPDATE musica SET titulo=?, artista=?, compositor=?,genero_id=? WHERE id=?";
      try {
          PreparedStatement sentenca = bd.prepareStatement(sql);
          sentenca.setString(1, musica.getTitulo());
          sentenca.setString(2, musica.getArtista());
          sentenca.setString(3, musica.getCompositor());
          sentenca.setInt(4, musica.getGenero().getId());
          sentenca.setInt(5, musica.getId());
          
          sentenca.execute();
          sentenca.close();
      } catch (SQLException ex) {
          System.out.println("Erro: "+ex);
      }
    }

    @Override
    public void delete(Musica musica) {
      String sql = "DELETE FROM musica WHERE id=?";
      try {
          PreparedStatement sentenca = bd.prepareStatement(sql);
          sentenca.setInt(1, musica.getId());
          sentenca.execute();
          sentenca.close();
      } catch (SQLException ex) {
          System.out.println("Erro: "+ex);
      }
    }
    
}
