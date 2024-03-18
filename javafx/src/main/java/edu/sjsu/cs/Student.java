package edu.sjsu.cs;

/**
 * Student
 */
public class Student {

    private String name;
    private int studentID;
    private String imgURL;

    public Student() {
        name = "";
        studentID = 0;
        imgURL = "";
    }

    public Student(String name, int studentID, String imgURL) {
        this.name = name;
        this.studentID = studentID;
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}