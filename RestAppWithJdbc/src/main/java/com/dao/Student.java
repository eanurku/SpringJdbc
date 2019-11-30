package com.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    @JsonProperty("student_id")
    int sid;

    @JsonProperty("student_name")
    String sname;

    @JsonProperty("contact")
    Long scontact;

    Date sdob;

    List<String> sskills;

    Address saddress;

    public Student(String sname,Long contact) {
        this.sname = sname;
        this.scontact=contact;
    }
    public Student(String sname,Long contact,int id) {
        this.sname = sname;
        this.scontact=contact;
        this.sid=id;
    }
    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Long getScontact() {
        return scontact;
    }

    public void setScontact(Long scontact) {
        this.scontact = scontact;
    }

    public Date getSdob() {
        return sdob;
    }

    public void setSdob(Date sdob) {
        this.sdob = sdob;
    }

    public List<String> getSskills() {
        return sskills;
    }

    public void setSskills(List<String> sskills) {
        this.sskills = sskills;
    }

    public Address getSaddress() {
        return saddress;
    }

    public void setSaddress(Address saddress) {
        this.saddress = saddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", scontact=" + scontact +
                ", sdob=" + sdob +
                ", sskills=" + sskills +
                ", saddress=" + saddress +
                '}';
    }
}
