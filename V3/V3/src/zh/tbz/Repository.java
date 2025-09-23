package zh.tbz;

import java.util.List;

public interface Repository<T> {
    void add(T item);

    void remove(Car car);

    T get(String name);
    List<T> getAll();


    void remove(String name);
}
