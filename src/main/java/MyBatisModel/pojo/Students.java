package MyBatisModel.pojo;

public class Students {
    private String sid;
    private String sname;
    private String ssex;
    private String birth;
    private String address;

    public Students(){

    }

    public Students(String sid, String sname, String ssex, String birth, String address) {
        this.sid = sid;
        this.sname = sname;
        this.ssex = ssex;
        this.birth = birth;
        this.address = address;
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

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
