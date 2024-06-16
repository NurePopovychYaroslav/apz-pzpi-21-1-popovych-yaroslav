package ua.clamor1s.eLock.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ua.clamor1s.eLock.dto.request.StudentRequest;
import ua.clamor1s.eLock.dto.response.StudentResponse;
import ua.clamor1s.eLock.entity.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T20:56:58+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentResponse studentToStudentResponse(Student student) {
        if ( student == null ) {
            return null;
        }

        Long id = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;
        String createdBy = null;

        id = student.getId();
        firstName = student.getFirstName();
        lastName = student.getLastName();
        email = student.getEmail();
        createdAt = student.getCreatedAt();
        updatedAt = student.getUpdatedAt();
        createdBy = student.getCreatedBy();

        StudentResponse studentResponse = new StudentResponse( id, firstName, lastName, email, createdAt, updatedAt, createdBy );

        return studentResponse;
    }

    @Override
    public Student studentRequestToStudent(StudentRequest studentRequest) {
        if ( studentRequest == null ) {
            return null;
        }

        Student student = new Student();

        student.setFirstName( studentRequest.getFirstName() );
        student.setLastName( studentRequest.getLastName() );
        student.setEmail( studentRequest.getEmail() );

        fillCreatableUpdatable( student );

        return student;
    }

    @Override
    public void updateStudent(Student student, StudentRequest studentRequest) {
        if ( studentRequest == null ) {
            return;
        }

        student.setFirstName( studentRequest.getFirstName() );
        student.setLastName( studentRequest.getLastName() );
        student.setEmail( studentRequest.getEmail() );

        fillCreatableUpdatable( student );
    }
}
