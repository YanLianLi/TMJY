package MyBatisModel.pojo;

public class Course {
    private String cid;
    private String cname;
    private String tid;
    private String ctime;

    public Course(String cid, String cname, String tid, String ctime) {
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
        this.ctime = ctime;
    }

    public Course() {
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

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
}
