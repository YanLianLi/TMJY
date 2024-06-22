package MyBatisModel.pojo;

public class MyGrade {
    private String cid;
    private String cname;
    private double grade;

    public MyGrade() {
    }

    public MyGrade(String cid, String cname, double grade) {
        this.cid = cid;
        this.cname = cname;
        this.grade = grade;
    }

    public String getCid() {

        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
