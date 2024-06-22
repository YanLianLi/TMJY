package MyBatisModel.pojo;

public class SelectCourse {
    private String cname;
    private String cid;
    private String tname;

    public SelectCourse(String cname, String cid, String tname) {
        this.cname = cname;
        this.cid = cid;
        this.tname = tname;
    }

    public SelectCourse() {
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
}
