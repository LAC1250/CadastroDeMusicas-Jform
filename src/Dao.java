
import java.util.List;

public interface Dao<T> {
    public T get(int id);
    
    public List<T> getAll();
    
    public int save(T t);
    public void update(T t);
    public void delete(T t);
}
