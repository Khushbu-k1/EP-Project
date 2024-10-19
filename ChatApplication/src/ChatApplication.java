import java.util.ArrayList;
import java.util.List;

public class ChatApplication {
    private List<User> users;
    private List<String> messages;

    public ChatApplication() {
        users = new ArrayList<>();
        messages = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.getUsername());
    }

    public void sendMessage(User user, String message) {
        messages.add(user.getUsername() + ": " + message);
        System.out.println("Message sent from " + user.getUsername() + ": " + message);
    }

    public void displayMessages() {
        System.out.println("Chat Messages:");
        for (String msg : messages) {
            System.out.println(msg);
        }
    }
}
