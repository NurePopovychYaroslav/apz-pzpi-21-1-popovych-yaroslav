package ua.clamor1s.eLock.facade;

import org.springframework.retry.annotation.Retryable;
import ua.clamor1s.eLock.dto.request.StudentGroupRequest;
import ua.clamor1s.eLock.dto.request.StudentRequest;
import ua.clamor1s.eLock.dto.response.StudentGroupResponse;
import ua.clamor1s.eLock.dto.response.StudentResponse;

import java.sql.SQLException;
import java.util.List;

public interface StudentFacade {
    List<StudentResponse> getAllStudents();

    List<StudentGroupResponse> getAllStudentGroups();

    StudentResponse createStudent(StudentRequest studentRequest);

    StudentResponse updateStudent(Long studentId, StudentRequest studentRequest);

    StudentResponse deleteStudent(Long studentId);

    StudentGroupResponse addGroup(StudentGroupRequest studentGroupRequest);

    StudentGroupResponse removeGroup(Long studentId, Long groupId);

    boolean isDoorAvailable(Long doorId, Long studentId);
}
