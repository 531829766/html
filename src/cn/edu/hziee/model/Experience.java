package cn.edu.hziee.model;

public class Experience {
    private int id;
    private String experience_code;//教育编号
    private String studentcode;//学生学号
    private String studentname;//学生姓名
    private String post;//职务
    private String start_time;//开始时间
    private String end_time;//结束时间

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", experience_code='" + experience_code + '\'' +
                ", studentcode='" + studentcode + '\'' +
                ", studentname='" + studentname + '\'' +
                ", post='" + post + '\'' +
                ", start_time='" + start_time + '\'' +
                ", end_time='" + end_time + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExperience_code() {
        return experience_code;
    }

    public void setExperience_code(String experience_code) {
        this.experience_code = experience_code;
    }

    public String getStudentcode() {
        return studentcode;
    }

    public void setStudentcode(String studentcode) {
        this.studentcode = studentcode;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
