package ua.clamor1s.eLock.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.eLock.dto.request.StudentRequest;
import ua.clamor1s.eLock.dto.response.StudentGroupResponse;
import ua.clamor1s.eLock.dto.response.StudentResponse;
import ua.clamor1s.eLock.entity.Student;
import ua.clamor1s.eLock.facade.StudentFacade;
import ua.clamor1s.eLock.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentFacadeImpl implements StudentFacade {

    private final StudentService studentService;

    @Transactional(readOnly = true)
    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return students.stream()
                .map(studentService::convertStudentToStudentResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentGroupResponse> getAllStudentGroups() {
        List<Student> students = studentService.getAllStudents();
        return students.stream()
                .flatMap(student -> studentService.getStudentGroups(student).stream())
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = studentService.createStudent(studentRequest);
        return studentService.convertStudentToStudentResponse(student);
    }

    @Transactional
    @Override
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        Student student = studentService.getStudentById(studentId);
        student = studentService.updateStudent(student, studentRequest);
        return studentService.convertStudentToStudentResponse(student);
    }

    @Transactional
    @Override
    public StudentResponse deleteStudent(Long studentId) {
        Student student = studentService.getStudentById(studentId);
        StudentResponse response = studentService.convertStudentToStudentResponse(student);
        studentService.deleteStudent(student);
        return response;
    }
}
