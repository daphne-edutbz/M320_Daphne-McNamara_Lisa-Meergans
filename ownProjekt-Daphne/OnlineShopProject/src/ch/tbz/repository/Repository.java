package ch.tbz.repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Generic repository for storing objects of any type in-memory.
 *
 * <p> demonstrates simple persistence using an in-memory list.
 * It provides basic CRUD-like operations: save an item and retrieve all items.</p>
 *
 * @param <T> the type of objects stored in this repository
 */
public class Repository<T> {
    private List<T> items = new ArrayList<>();

    /**
     * Saves an item in the repository.
     *
     * @param item the object to save
     */
    public void save(T item) {
        items.add(item);
    }

    /**
     * Retrieves all items currently stored in the repository.
     *
     * @return a list containing all stored items
     */
    public List<T> getAll() {
        return items;
    }
}
