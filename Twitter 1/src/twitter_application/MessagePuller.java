package twitter_application;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface MessagePuller {

	ArrayList<Message> pullAllMessages() throws FileNotFoundException, IOException, ParseException;
}
