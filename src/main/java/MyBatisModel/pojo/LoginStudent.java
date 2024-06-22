package MyBatisModel.pojo;

public class LoginStudent {
    private String sid;
    private String password;

    public LoginStudent(String sid, String password) {
        this.sid = sid;
        this.password = password;
    }

    public LoginStudent() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
