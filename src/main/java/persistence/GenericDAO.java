package persistence;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Gui on 30/11/15.
 */
public interface GenericDAO<T, ID extends Serializable>{

        T save(T entity);
        T update(T entity);
        void delete(T entity);
        T findById(long id);
        List<T> findAll();
        void flush();

}