package indi.morven.Event.MassageEvent;

public class Author {

    private String avatar;
    private boolean bot;
    private String id;
    private String username;

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public boolean getBot() {
        return bot;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}