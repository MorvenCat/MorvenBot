package indi.morven.Event.MassageEvent;


import java.util.Date;
import java.util.List;

public class Member {

    private Date joined_at;
    private String nick;
    private List<String> roles;

    public void setJoined_at(Date joined_at) {
        this.joined_at = joined_at;
    }

    public Date getJoined_at() {
        return joined_at;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNick() {
        return nick;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }
}