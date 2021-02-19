package uz.mahiich.dao;

import org.springframework.jdbc.core.RowMapper;
import uz.mahiich.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper  implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();

        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setEmail(resultSet.getString("email"));
        student.setCourse(resultSet.getShort("course"));
        student.setAge(resultSet.getShort("age"));

        return student;
    }
}
