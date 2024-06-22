package MyBatisModel.pojo;

public class TeacherCourse {
    private String cname;
    private String cid;
    private int persons;

    public TeacherCourse() {
    }

    public TeacherCourse(String cname, String cid, int persons) {
        this.cname = cname;
        this.cid = cid;
        this.persons = persons;
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

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }
}
