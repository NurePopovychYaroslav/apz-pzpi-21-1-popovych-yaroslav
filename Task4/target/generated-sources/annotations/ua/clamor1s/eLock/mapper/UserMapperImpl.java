package ua.clamor1s.eLock.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ua.clamor1s.eLock.dto.request.UserRequest;
import ua.clamor1s.eLock.dto.response.UserResponse;
import ua.clamor1s.eLock.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T20:56:58+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse userEntityToUserResponse(User user) {
        if ( user == null ) {
            return null;
        }

        String email = null;
        String firstName = null;
        String lastName = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;

        email = user.getEmail();
        firstName = user.getFirstName();
        lastName = user.getLastName();
        createdAt = user.getCreatedAt();
        updatedAt = user.getUpdatedAt();

        UserResponse userResponse = new UserResponse( email, firstName, lastName, createdAt, updatedAt );

        return userResponse;
    }

    @Override
    public User userRequestToUserEntity(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userRequest.getEmail() );
        user.setFirstName( userRequest.getFirstName() );
        user.setLastName( userRequest.getLastName() );

        fillCreatableUpdatable( user );

        return user;
    }
}
