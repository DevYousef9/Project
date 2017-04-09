package com.dvb.electroniclibrary;



public class Student {
    private int id ;
    private String name;
    private String collage;
    private String section;
    private String demail;
    private int password;
    private int level;
    public Student(){

    }

    public Student(int id , String dname , String collage , String section , String kemail , int password ,
                   int level){
        this.id = id;
        this.name = dname;
        this.collage = collage;
        this.section = section;
        this.demail = kemail;
        this.password = password;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getEmail() {
        return demail;
    }

    public void setEmail(String email) {
        this.demail = email;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
