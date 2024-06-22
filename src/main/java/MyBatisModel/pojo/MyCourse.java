package MyBatisModel.pojo;

public class MyCourse {
    private String cname;
    private String cid;
    private String tname;
    private String ctime;

    public MyCourse(String cname, String cid, String tname, String ctime) {
        this.cname = cname;
        this.cid = cid;
        this.tname = tname;
        this.ctime = ctime;
    }

    public MyCourse() {
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

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }
}
