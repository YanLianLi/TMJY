package MyBatisModel.pojo;

public class LoginTeacher {
    private String tid;
    private String password;

    public LoginTeacher(String tid, String password) {
        this.tid = tid;
        this.password = password;
    }

    public LoginTeacher() {
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
