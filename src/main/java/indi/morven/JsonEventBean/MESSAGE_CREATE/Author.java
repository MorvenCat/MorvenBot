package indi.morven.JsonEventBean.MESSAGE_CREATE;

public class Author {
    private String avatar;
    private boolean bot;
    private String id;
    private String username;

    public Author() {
    }

    public Author(String avatar, boolean bot, String id, String username) {
        this.avatar = avatar;
        this.bot = bot;
        this.id = id;
        this.username = username;
    }

    /**
     * 获取
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取
     * @return bot
     */
    public boolean isBot() {
        return bot;
    }

    /**
     * 设置
     * @param bot
     */
    public void setBot(boolean bot) {
        this.bot = bot;
    }

    /**
     * 获取
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public String toString() {
        return "Author{avatar = " + avatar + ", bot = " + bot + ", id = " + id + ", username = " + username + "}";
    }
}
