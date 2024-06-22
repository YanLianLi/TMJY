package MyBatisModel.pojo;

public class Teachers {
    private String tid;
    private String tname;
    private String tsex;
    private String tbirth;
    private String address;

    public Teachers(String tid, String tname, String tsex, String tbirth, String address) {
        this.tid = tid;
        this.tname = tname;
        this.tsex = tsex;
        this.tbirth = tbirth;
        this.address = address;
    }

    public Teachers() {
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTbirth() {
        return tbirth;
    }

    public void setTbirth(String tbirth) {
        this.tbirth = tbirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
