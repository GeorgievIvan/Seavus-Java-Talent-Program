package twitter.data_access;

import twitter.business.Message;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class JdbcMessageDao implements MessageDao {

	private final String databaseUrl;
	private final String databaseUsername;
	private final String databasePassword;
	
	public JdbcMessageDao(final String databaseUrl, final String databaseUsername, final String databasePassword) {

		this.databaseUrl = databaseUrl;
		this.databaseUsername = databaseUsername;
		this.databasePassword = databasePassword;
	} 

	@Override
	public List<Message> readAllMessages(final boolean orderByDateDescending) throws RuntimeException {

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
		
		final ArrayList<Message> messages = new ArrayList<Message>();
		
		try {
			
			ResultSet resultSet;
			
			if(orderByDateDescending) {
				
				resultSet = statement.executeQuery("select * from message order by timestamp desc");
			}
			else {
				
				resultSet = statement.executeQuery("select * from message");
			}
			
			while (resultSet.next()) {
				
				final Long messageId = resultSet.getLong("id");
				final String messageText = resultSet.getString("text");
				final Timestamp messageTimestamp = resultSet.getTimestamp("timestamp");
				
				final Message message = new Message(messageId, messageText, messageTimestamp);
				
				messages.add(message);
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
		
		return messages;
	}
	
	@Override
	public void insertMessage(final Message message) throws RuntimeException {

		Connection connection;
		
		try {
			
			connection = DriverManager.getConnection(databaseUrl, databaseUsername, databasePassword);
		}
		catch(final SQLException sqlException) {
			
			throw new RuntimeException(sqlException);
		}

		PreparedStatement preparedStatement;
		
		try {
			
			preparedStatement = connection.prepareStatement("insert into message(text, timestamp) values(?, ?)");
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
			
			preparedStatement.setString(1, message.getText());
			preparedStatement.setTimestamp(2, message.getTimestamp());
			
			preparedStatement.executeUpdate();
		}
		catch(final SQLException sqlException1) {
			
			throw new RuntimeException(sqlException1);
		}
		finally {
			
			try {
				
				preparedStatement.close();
			}
			catch(final SQLException sqlException2) {

				throw new RuntimeException(sqlException2);
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
