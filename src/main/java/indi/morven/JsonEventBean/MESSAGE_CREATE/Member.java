package indi.morven.JsonEventBean.MESSAGE_CREATE;

import java.util.Date;

public class Member {
    private Date joined_at;
    private String nick;
    private Date roles;

    public Member() {
    }

    public Member(Date joined_at, String nick, Date roles) {
        this.joined_at = joined_at;
        this.nick = nick;
        this.roles = roles;
    }

    /**
     * 获取
     * @return joined_at
     */
    public Date getJoined_at() {
        return joined_at;
    }

    /**
     * 设置
     * @param joined_at
     */
    public void setJoined_at(Date joined_at) {
        this.joined_at = joined_at;
    }

    /**
     * 获取
     * @return nick
     */
    public String getNick() {
        return nick;
    }

    /**
     * 设置
     * @param nick
     */
    public void setNick(String nick) {
        this.nick = nick;
    }

    /**
     * 获取
     * @return roles
     */
    public Date getRoles() {
        return roles;
    }

    /**
     * 设置
     * @param roles
     */
    public void setRoles(Date roles) {
        this.roles = roles;
    }

    public String toString() {
        return "Member{joined_at = " + joined_at + ", nick = " + nick + ", roles = " + roles + "}";
    }
}
