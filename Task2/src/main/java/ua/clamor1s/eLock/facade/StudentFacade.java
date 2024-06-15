package ua.clamor1s.eLock.facade;

import ua.clamor1s.eLock.dto.request.StudentRequest;
import ua.clamor1s.eLock.dto.response.StudentGroupResponse;
import ua.clamor1s.eLock.dto.response.StudentResponse;

import java.util.List;

public interface StudentFacade {
    List<StudentResponse> getAllStudents();

    List<StudentGroupResponse> getAllStudentGroups();

    StudentResponse createStudent(StudentRequest studentRequest);

    StudentResponse updateStudent(Long studentId, StudentRequest studentRequest);

    StudentResponse deleteStudent(Long studentId);
}