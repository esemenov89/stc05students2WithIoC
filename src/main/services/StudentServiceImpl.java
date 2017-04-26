package main.services;

import main.models.dao.StudentDao;
import main.models.dao.StudentDaoImpl;
import main.models.pojo.Student;
import main.utils.Benchmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
@Service
@Benchmark
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }

    public boolean addStudent(int id, String name, int age, int group_id) {
        return studentDao.insert(id, name, age, group_id);
    }

}
