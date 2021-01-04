package com.example.demo.pojo.resident;

public class gytResident {
    private Integer rdtId;      //居民ID
    private String rdtEmail;    //居民邮箱
    private String rdtUnit;     //居民工作单位
    private Integer rdtFamily;  //居民家庭成员
    private String rdtAddress;  //居民家庭地址
    private String rdtDegree;   //居民学历
    private String rdtIcon;     //居民头像

    @Override
    public String toString() {
        return "gytResident{" +
                "rdtId=" + rdtId +
                ", rdtEmail='" + rdtEmail + '\'' +
                ", rdtUnit='" + rdtUnit + '\'' +
                ", rdtFamily=" + rdtFamily +
                ", rdtAddress='" + rdtAddress + '\'' +
                ", rdtDegree='" + rdtDegree + '\'' +
                ", rdtIcon='" + rdtIcon + '\'' +
                '}';
    }

    public Integer getRdtId() {
        return rdtId;
    }

    public void setRdtId(Integer rdtId) {
        this.rdtId = rdtId;
    }

    public String getRdtEmail() {
        return rdtEmail;
    }

    public void setRdtEmail(String rdtEmail) {
        this.rdtEmail = rdtEmail;
    }

    public String getRdtUnit() {
        return rdtUnit;
    }

    public void setRdtUnit(String rdtUnit) {
        this.rdtUnit = rdtUnit;
    }

    public Integer getRdtFamily() {
        return rdtFamily;
    }

    public void setRdtFamily(Integer rdtFamily) {
        this.rdtFamily = rdtFamily;
    }

    public String getRdtAddress() {
        return rdtAddress;
    }

    public void setRdtAddress(String rdtAddress) {
        this.rdtAddress = rdtAddress;
    }

    public String getRdtDegree() {
        return rdtDegree;
    }

    public void setRdtDegree(String rdtDegree) {
        this.rdtDegree = rdtDegree;
    }

    public String getRdtIcon() {
        return rdtIcon;
    }

    public void setRdtIcon(String rdtIcon) {
        this.rdtIcon = rdtIcon;
    }
}
