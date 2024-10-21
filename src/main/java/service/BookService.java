package service;

import model.Book;
import util.DBManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService implements BookServiceI {

    private DataSource dataSource;
    private Connection connection;
    private AuthorServiceI authorService;

    public BookService() throws SQLException {
        dataSource = DBManager.getInstance().getDataSource();
        authorService = new AuthorService();
    }

    //read
    @Override
    public List<Book> getAll() throws SQLException {
        try {
            List<Book> books = new ArrayList<>();
            this.connection = dataSource.getConnection();
            try (PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM book")) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setTitle(resultSet.getString("title"));
                    book.setPrice(new Double(resultSet.getString("price")));
//                    long author_id = resultSet.getLong("author_id");
//                    book.setAuthor(authorService.getAuthorById(author_id));
                    books.add(book);
                }
                return books;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (connection != null) {
                System.out.println("Closing database connection...");
                connection.close();
                System.out.println("Connection valid: " + connection.isValid(5));
            }
        }
        return null;
    }

    //create
//    save

    //update
//    update

    //delete
//    delete

}
