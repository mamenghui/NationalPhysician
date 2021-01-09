package com.example.demo.pojo.resident;

public class gytResidentLogin {
    private Integer rdtLoginId;            //居民登录ID
    private String rdtLoginAccount;        //用户名(手机号)
    private String rdtLoginRealName;       //居民名字
    private Integer rdtLoginResidentId;    //居民id
    private String rdtLoginGender;        //性别
    private String rdtLoginBirthData;      //居民出生日期
    private String rdtLoginIcon;           //居民头像


    //自定义用户字段
    private String rdtEmail;    //居民邮箱
    private String rdtUnit;     //居民工作单位
    private Integer rdtFamily;  //居民家庭成员
    private String rdtAddress;  //居民家庭地址
    private String rdtDegree;   //居民学历


    @Override
    public String toString() {
        return "gytResidentLogin{" +
                "rdtLoginId=" + rdtLoginId +
                ", rdtLoginAccount='" + rdtLoginAccount + '\'' +
                ", rdtLoginRealName='" + rdtLoginRealName + '\'' +
                ", rdtLoginResidentId=" + rdtLoginResidentId +
                ", rdtLoginGender=" + rdtLoginGender +
                ", rdtLoginBirthData='" + rdtLoginBirthData + '\'' +
                ", rdtLoginIcon='" + rdtLoginIcon + '\'' +
                ", rdtEmail='" + rdtEmail + '\'' +
                ", rdtUnit='" + rdtUnit + '\'' +
                ", rdtFamily=" + rdtFamily +
                ", rdtAddress='" + rdtAddress + '\'' +
                ", rdtDegree='" + rdtDegree + '\'' +
                '}';
    }

    public Integer getRdtLoginId() {
        return rdtLoginId;
    }

    public void setRdtLoginId(Integer rdtLoginId) {
        this.rdtLoginId = rdtLoginId;
    }

    public String getRdtLoginAccount() {
        return rdtLoginAccount;
    }

    public void setRdtLoginAccount(String rdtLoginAccount) {
        this.rdtLoginAccount = rdtLoginAccount;
    }

    public String getRdtLoginRealName() {
        return rdtLoginRealName;
    }

    public void setRdtLoginRealName(String rdtLoginRealName) {
        this.rdtLoginRealName = rdtLoginRealName;
    }

    public Integer getRdtLoginResidentId() {
        return rdtLoginResidentId;
    }

    public void setRdtLoginResidentId(Integer rdtLoginResidentId) {
        this.rdtLoginResidentId = rdtLoginResidentId;
    }

    public String  getRdtLoginGender() {
        return rdtLoginGender;
    }

    public void setRdtLoginGender(String rdtLoginGender) {
        this.rdtLoginGender = rdtLoginGender;
    }

    public String getRdtLoginBirthData() {
        return rdtLoginBirthData;
    }

    public void setRdtLoginBirthData(String rdtLoginBirthData) {
        this.rdtLoginBirthData = rdtLoginBirthData;
    }

    public String getRdtLoginIcon() {
        return rdtLoginIcon;
    }

    public void setRdtLoginIcon(String rdtLoginIcon) {
        this.rdtLoginIcon = rdtLoginIcon;
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
}
