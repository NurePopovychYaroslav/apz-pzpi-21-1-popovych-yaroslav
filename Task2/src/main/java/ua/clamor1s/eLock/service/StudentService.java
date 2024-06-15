package ua.clamor1s.eLock.service;

import ua.clamor1s.eLock.dto.request.StudentRequest;
import ua.clamor1s.eLock.dto.response.StudentGroupResponse;
import ua.clamor1s.eLock.dto.response.StudentResponse;
import ua.clamor1s.eLock.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    StudentResponse convertStudentToStudentResponse(Student student);

    List<StudentGroupResponse> getStudentGroups(Student student);

    Student createStudent(StudentRequest studentRequest);

    Student getStudentById(Long studentId);

    Student updateStudent(Student student, StudentRequest studentRequest);

    void deleteStudent(Student student);
}
