package model;

public class Doctor {
    private int doctor_id;
    private String doctor_name;
    private String doctor_password;
    private int doctor_phone;
    private int doctor_identity;
    private String doctor_specialty;

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_password() {
        return doctor_password;
    }

    public void setDoctor_password(String doctor_password) {
        this.doctor_password = doctor_password;
    }

    public int getDoctor_phone() {
        return doctor_phone;
    }

    public void setDoctor_phone(int doctor_phone) {
        this.doctor_phone = doctor_phone;
    }

    public int getDoctor_identity() {
        return doctor_identity;
    }

    public void setDoctor_identity(int doctor_identity) {
        this.doctor_identity = doctor_identity;
    }

    public String getDoctor_specialty() {
        return doctor_specialty;
    }

    public void setDoctor_specialty(String doctor_specialty) {
        this.doctor_specialty = doctor_specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctor_id=" + doctor_id +
                ", doctor_name='" + doctor_name + '\'' +
                ", doctor_password='" + doctor_password + '\'' +
                ", doctor_phone=" + doctor_phone +
                ", doctor_identity=" + doctor_identity +
                ", doctor_specialty='" + doctor_specialty + '\'' +
                '}';
    }
}
