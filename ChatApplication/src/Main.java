public class Main {
    public static void main(String[] args) {
        ChatApplication chat = new ChatApplication();

        // Create a new user
        User user = new User("johndoe", "12345");

        // Register the user
        chat.registerUser(user);

        // Simulate sending a message
        String message = "Hello, world!";
        chat.sendMessage(user, message);

        // Display messages
        chat.displayMessages();
    }
}
