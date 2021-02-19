package uz.mahiich.model;

import jakarta.validation.constraints.*;

public class Student {

    private int id;

    @NotEmpty(message = "Name can not be empty")
    @Size(min = 3, max = 50, message = "Name should be between 3 to 50 characters")
    private String name;

    @Email(message = "Enter valid email")
    private String email;

    @Min(value = 1,message = "Course cannot be less than 1")
    @Max(value = 7,message = "Course can not be greater than 7")
    private short course;

    @Min(value = 5,message = "You too young for using this system, please grow up :)")
    @Max(value = 100,message = "If you are older than 100 you are genious :)")
    private short age;


    public Student() {
    }

    public Student(int id, String name, String email, short course, short age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        this.age = age;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getCourse() {
        return course;
    }

    public void setCourse(short course) {
        this.course = course;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }
}
