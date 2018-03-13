package spring;

public class UserDao {
    private User user;

    public void add(){
        System.out.println("add from user dao");
        System.out.println(user.toString());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
