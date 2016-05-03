package library.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import library.business.Book;

public class JdbcBookDao implements BookDao {
	
	private final String databaseUrl;
	private final String databaseUsername;
	private final String databasePassword;
	
	public JdbcBookDao(final String databaseUrl, final String databaseUsername, final String databasePassword) {

		this.databaseUrl = databaseUrl;
		this.databaseUsername = databaseUsername;
		this.databasePassword = databasePassword;
	}
	
	@Override
	public List<Book> readAllBooks() {
		
		Connection connection;
		
		try {
			
			connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
		}
		catch(final SQLException sqlException) {
			
			throw new RuntimeException(sqlException);
		}
		
		Statement statement;
		
		try {
		
			statement = connection.createStatement();
		}
		catch(final SQLException sqlException1) {
			
			try {
				
				connection.close();
			}
			catch(final SQLException sqlException2) {
				
				throw new RuntimeException(sqlException2);
			}
			
			throw new RuntimeException(sqlException1);
		}
		
		final ArrayList<Book> books = new ArrayList<Book>();
		
		try {
			
			final ResultSet resultSet = statement.executeQuery("select * from book");
			
			while(resultSet.next()) {
				
				final Long bookId = resultSet.getLong("id");
				final String bookIsbn= resultSet.getString("isbn");
				final String bookTitle = resultSet.getString("title");
				
				final Book book = new Book();
				book.setId(bookId);
				book.setIsbn(bookIsbn);
				book.setTitle(bookTitle);
				
				books.add(book);
			}
		}
		catch(final SQLException sqlException) {
			
			throw new RuntimeException(sqlException);
		}
		finally {
			
			try {
				
				statement.close();
			}
			catch(final SQLException sqlException) {
				
				throw new RuntimeException(sqlException);
			}
			finally {
				
				try {
					
					connection.close();
				}
				catch(final SQLException sqlException) {
					
					throw new RuntimeException(sqlException);
				}
			}
		}
		
		return books;
	}
	
	@Override
	public void insertBook(final Book book) {
		
		Connection connection;
		
		try {
			
			connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
		}
		catch(final SQLException sqlException) {
			
			throw new RuntimeException(sqlException);
		}
		
		PreparedStatement preparedStatement;
		
		try {
			
			preparedStatement = connection.prepareStatement("insert into book(isbn, title) values (?, ?)");
		}
		catch(final SQLException sqlException1) {
			
			try {
				
				connection.close();
			}
			catch(final SQLException sqlException2) {
				
				throw new RuntimeException(sqlException2);
			}
			
			throw new RuntimeException(sqlException1);
		}
		
		
		try {
			
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getTitle());
			
			preparedStatement.executeUpdate();

		}
		catch(final SQLException sqlException) {
			
			throw new RuntimeException(sqlException);
		}
		finally {
			
			try {
				
				preparedStatement.close();
			}
			catch(final SQLException sqlException) {
				
				throw new RuntimeException(sqlException);
			}
			finally {
				
				try {
					
					connection.close();
				}
				catch(final SQLException sqlException) {
					
					throw new RuntimeException(sqlException);
				}
			}
		}
	}

	@Override
	public void updateBook(final Long bookId, final String newBookTitle) {
		
		Connection connection;
		
		try {
			
			connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
		}
		catch(final SQLException sqlException) {
			
			throw new RuntimeException(sqlException);
		}
		
		PreparedStatement preparedStatement;
		
		try {
			
			preparedStatement = connection.prepareStatement("update book set title = ? where id = ?");
		}
		catch(final SQLException sqlException1) {
			
			try {
				
				connection.close();
			}
			catch(final SQLException sqlException2) {
				
				throw new RuntimeException(sqlException2);
			}
			
			throw new RuntimeException(sqlException1);
		}
		
		
		try {
			
			preparedStatement.setString(1, newBookTitle);
			preparedStatement.setLong(2, bookId);
			
			preparedStatement.executeUpdate();

		}
		catch(final SQLException sqlException) {
			
			throw new RuntimeException(sqlException);
		}
		finally {
			
			try {
				
				preparedStatement.close();
			}
			catch(final SQLException sqlException) {
				
				throw new RuntimeException(sqlException);
			}
			finally {
				
				try {
					
					connection.close();
				}
				catch(final SQLException sqlException) {
					
					throw new RuntimeException(sqlException);
				}
			}
		}
	}

	@Override
	public void deleteBook(final Long bookId) {
		
		Connection connection;
		
		try {
			
			connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
		}
		catch(final SQLException sqlException) {
			
			throw new RuntimeException(sqlException);
		}
		
		PreparedStatement preparedStatement;
		
		try {
			
			preparedStatement = connection.prepareStatement("delete from book where id = ?");
		}
		catch(final SQLException sqlException1) {
			
			try {
				
				connection.close();
			}
			catch(final SQLException sqlException2) {
				
				throw new RuntimeException(sqlException2);
			}
			
			throw new RuntimeException(sqlException1);
		}
		
		
		try {
			
			preparedStatement.setLong(1, bookId);
			
			preparedStatement.executeUpdate();

		}
		catch(final SQLException sqlException) {
			
			throw new RuntimeException(sqlException);
		}
		finally {
			
			try {
				
				preparedStatement.close();
			}
			catch(final SQLException sqlException) {
				
				throw new RuntimeException(sqlException);
			}
			finally {
				
				try {
					
					connection.close();
				}
				catch(final SQLException sqlException) {
					
					throw new RuntimeException(sqlException);
				}
			}
		}
	}
}
