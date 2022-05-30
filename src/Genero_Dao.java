
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Genero_Dao implements Dao<Genero>{
    private Connection bd;

    public Genero_Dao(Connection bd) {
        this.bd = bd;
    }
    
    @Override
    public Genero get(int id) {
       
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       
    }
    @Override
    public List<Genero> getAll() {
      List<Genero> lista = new ArrayList<Genero>();
      String sql = "SELECT * FROM genero ORDER BY id";
      try {
          Statement sentenca = bd.createStatement();
          ResultSet resultado = sentenca.executeQuery(sql);
          while(resultado.next()) {
              String descricao = resultado.getString("descricao");
              int id = resultado.getInt("id");
              Genero genero = new Genero(descricao, id);
              lista.add(genero);
          }
          resultado.close();
          sentenca.close();
      } catch (SQLException ex) {
          System.out.println("Erro");
      }
      return lista;
    }

    @Override
    public int save(Genero t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Genero t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Genero t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
