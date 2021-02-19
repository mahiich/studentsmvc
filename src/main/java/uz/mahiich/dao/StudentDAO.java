package uz.mahiich.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import uz.mahiich.model.Student;

import java.util.List;
@Component
public class StudentDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }

    public List<Student> getStudents(){
        return jdbcTemplate.query("SELECT * FROM students", new BeanPropertyRowMapper<>(Student.class));
//        return jdbcTemplate.query("SELECT * FROM students", new StudentMapper());    HERE we can use our mapper
    }

    public Student searchStudent(String searchValue){
        return jdbcTemplate.query("SELECT * FROM students WHERE name ILIKE=?",new Object[]{searchValue}, new BeanPropertyRowMapper<>(Student.class))
                .stream().findAny().orElse(null);
    }

    public void addStudent(Student student){
        jdbcTemplate.update("INSERT INTO students(name,email,course,age) VALUES(?,?,?,?)",
                student.getName(),student.getEmail(),student.getCourse(),student.getAge(), new BeanPropertyRowMapper<>(Student.class));
    }



}
