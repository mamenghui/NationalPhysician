package com.example.demo.pojo.yxtapp;

public class GytDoctorInfo {

    private Integer  doctorId;
    private String  docLoginAccount;
    private String  docLoginName;
    private Integer  docLoginSex;
    private String  docLoginBirthday;
    private Integer  doctorHospitalId;//执业点，医院
    private Integer  doctorDeskId;
    private String  doctorIcon;
    private Integer  doctorPositionId;//职位
    private String  doctorIntroduce;
    private Integer  doctorSkillId;
    private String  doctorDanwei;//单位
    private String  doctorRegionId;//地区
    private Integer  doctorDegree;
    private String  doctorAcademy;
    private Integer  doctorSchool;
    private String doctorYiling;
    private String docLoginGoodat;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDoctorHospitalId() {
        return doctorHospitalId;
    }

    public void setDoctorHospitalId(Integer doctorHospitalId) {
        this.doctorHospitalId = doctorHospitalId;
    }

    public Integer getDoctorDeskId() {
        return doctorDeskId;
    }

    public void setDoctorDeskId(Integer doctorDeskId) {
        this.doctorDeskId = doctorDeskId;
    }

    public String getDoctorIcon() {
        return doctorIcon;
    }

    public void setDoctorIcon(String doctorIcon) {
        this.doctorIcon = doctorIcon;
    }

    public Integer getDoctorPositionId() {
        return doctorPositionId;
    }

    public void setDoctorPositionId(Integer doctorPositionId) {
        this.doctorPositionId = doctorPositionId;
    }

    public String getDoctorIntroduce() {
        return doctorIntroduce;
    }

    public void setDoctorIntroduce(String doctorIntroduce) {
        this.doctorIntroduce = doctorIntroduce;
    }

    public Integer getDoctorSkillId() {
        return doctorSkillId;
    }

    public void setDoctorSkillId(Integer doctorSkillId) {
        this.doctorSkillId = doctorSkillId;
    }

    public String getDoctorDanwei() {
        return doctorDanwei;
    }

    public void setDoctorDanwei(String doctorDanwei) {
        this.doctorDanwei = doctorDanwei;
    }

    public String getDoctorRegionId() {
        return doctorRegionId;
    }

    public void setDoctorRegionId(String doctorRegionId) {
        this.doctorRegionId = doctorRegionId;
    }

    public Integer getDoctorDegree() {
        return doctorDegree;
    }

    public void setDoctorDegree(Integer doctorDegree) {
        this.doctorDegree = doctorDegree;
    }

    public String getDoctorAcademy() {
        return doctorAcademy;
    }

    public void setDoctorAcademy(String doctorAcademy) {
        this.doctorAcademy = doctorAcademy;
    }

    public Integer getDoctorSchool() {
        return doctorSchool;
    }

    public void setDoctorSchool(Integer doctorSchool) {
        this.doctorSchool = doctorSchool;
    }

    public String getDocLoginAccount() {
        return docLoginAccount;
    }

    public void setDocLoginAccount(String docLoginAccount) {
        this.docLoginAccount = docLoginAccount;
    }

    public String getDocLoginName() {
        return docLoginName;
    }

    public void setDocLoginName(String docLoginName) {
        this.docLoginName = docLoginName;
    }

    public Integer getDocLoginSex() {
        return docLoginSex;
    }

    public void setDocLoginSex(Integer docLoginSex) {
        this.docLoginSex = docLoginSex;
    }

    public String getDocLoginBirthday() {
        return docLoginBirthday;
    }

    public void setDocLoginBirthday(String docLoginBirthday) {
        this.docLoginBirthday = docLoginBirthday;
    }

    public String getDoctorYiling() {
        return doctorYiling;
    }

    public void setDoctorYiling(String doctorYiling) {
        this.doctorYiling = doctorYiling;
    }

    public String getDocLoginGoodat() {
        return docLoginGoodat;
    }

    public void setDocLoginGoodat(String docLoginGoodat) {
        this.docLoginGoodat = docLoginGoodat;
    }

    @Override
    public String toString() {
        return "GytDoctorInfo{" +
                "doctorId=" + doctorId +
                ", docLoginAccount='" + docLoginAccount + '\'' +
                ", docLoginName='" + docLoginName + '\'' +
                ", docLoginSex=" + docLoginSex +
                ", docLoginBirthday='" + docLoginBirthday + '\'' +
                ", doctorHospitalId=" + doctorHospitalId +
                ", doctorDeskId=" + doctorDeskId +
                ", doctorIcon='" + doctorIcon + '\'' +
                ", doctorPositionId=" + doctorPositionId +
                ", doctorIntroduce='" + doctorIntroduce + '\'' +
                ", doctorSkillId=" + doctorSkillId +
                ", doctorDanwei=" + doctorDanwei +
                ", doctorRegionId=" + doctorRegionId +
                ", doctorDegree=" + doctorDegree +
                ", doctorAcademy='" + doctorAcademy + '\'' +
                ", doctorSchool=" + doctorSchool +
                ", doctorYiling='" + doctorYiling + '\'' +
                '}';
    }
}
