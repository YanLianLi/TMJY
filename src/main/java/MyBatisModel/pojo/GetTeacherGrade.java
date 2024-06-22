package MyBatisModel.pojo;

public class GetTeacherGrade {
    private String sid;
    private String sname;
    private String cname;
    private String cid;

    public GetTeacherGrade(String sid, String sname, String cname, String cid) {
        this.sid = sid;
        this.sname = sname;
        this.cname = cname;
        this.cid = cid;
    }

    public GetTeacherGrade() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
