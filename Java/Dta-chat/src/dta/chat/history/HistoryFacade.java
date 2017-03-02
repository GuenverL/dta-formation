package dta.chat.history;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import dta.chat.model.ChatMessage;
import dta.chat.model.socket.ChatClientException;

public class HistoryFacade {
	private Path file = Paths.get("history.txt");

	public List<ChatMessage> findLastMessages() throws ChatClientException {
		List<ChatMessage> msgs = new ArrayList<>();
		try {
			Files.readAllLines(file).forEach(line -> {
				msgs.add(new ChatMessage(line.split(":#")[0], line.split(":#")[1]));
			});
		} catch (IOException e) {
			throw new ChatClientException("File read error", e);
		}
		return msgs;
	}

	public void saveMessage(ChatMessage msg) throws ChatClientException {
		try {
			Files.write(file,
					(msg.getLogin() + ":#" + msg.getMsg().replaceAll("\\[0m|\\[[0-9]+m", "") + " \n").getBytes(),
					StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new ChatClientException("file writing error", e);
		}
	}
}
