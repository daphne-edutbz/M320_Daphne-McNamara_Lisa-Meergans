package ch.tbz.repository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private List<T> items = new ArrayList<>();

    public void save(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }
}
