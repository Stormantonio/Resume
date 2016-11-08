package com.company;

import java.io.IOException;

/**
 * Created by Anton on 03.11.2016.
 */
public interface Storage {
    // CRUD
    // create
    void save(Resume uuid) throws IOException;
    // delete
    void delete(String uuid) throws IOException;
    // read
    Resume get(String uuid) throws IOException;
    // update
    void update(Resume r) throws IOException;
}
