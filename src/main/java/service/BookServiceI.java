package service;

import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookServiceI {

    public List<Book> getAll() throws SQLException;
}
