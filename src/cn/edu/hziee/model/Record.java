package cn.edu.hziee.model;

public class Record {
    private int rid;
    private int l_uid;
    private String date_time;
    private int gnumber;
    private int l_gid;

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getL_uid() {
        return l_uid;
    }

    public void setL_uid(int l_uid) {
        this.l_uid = l_uid;
    }


    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public int getGnumber() {
        return gnumber;
    }

    public void setGnumber(int gnumber) {
        this.gnumber = gnumber;
    }

    public int getL_gid() {
        return l_gid;
    }

    public void setL_gid(int l_gid) {
        this.l_gid = l_gid;
    }

    @Override
    public String toString() {
        return "Record{" +
                "rid=" + rid +
                ", l_uid=" + l_uid +
                ", date_time='" + date_time + '\'' +
                ", gnumber=" + gnumber +
                ", l_gid=" + l_gid +
                '}';
    }
}
