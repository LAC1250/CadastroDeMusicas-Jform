
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class teste {
    public static void main(String args[]) {
        try {
            Connection conn = FactoryConnection.getConnection();
            Musica_Dao dao = new Musica_Dao(conn);
            //Musica m = new Musica(0, "teste", "test", "teste",new Genero("",2));

            /* Musica m = dao.get(1);
            System.out.println("musica 1: " + m);
            m.setTitulo("titulo alterado");
            dao.update(m);
            List<Musica> lista = dao.getAll();
            System.out.println(lista );*/
            Musica m = new Musica(6, "teste", "test", "teste",new Genero("",2));
            dao.delete(m);
            List<Musica> lista = dao.getAll();
            System.out.println(lista );
           conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
