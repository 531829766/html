package cn.edu.hziee.model;

public class Class {
    //记录编号、年级、班级等信息
    private int id;
    private String class_name;//班级名称

    private String grade;//年级

    private String frequency;//几班

    private String class_place;//教室位置

    private String class_size;//班级人数

    private String headmaster;//班主任

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", class_name='" + class_name + '\'' +
                ", grade='" + grade + '\'' +
                ", frequency='" + frequency + '\'' +
                ", class_place='" + class_place + '\'' +
                ", class_size='" + class_size + '\'' +
                ", headmaster='" + headmaster + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getClass_place() {
        return class_place;
    }

    public void setClass_place(String class_place) {
        this.class_place = class_place;
    }

    public String getClass_size() {
        return class_size;
    }

    public void setClass_size(String class_size) {
        this.class_size = class_size;
    }

    public String getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(String headmaster) {
        this.headmaster = headmaster;
    }
}
