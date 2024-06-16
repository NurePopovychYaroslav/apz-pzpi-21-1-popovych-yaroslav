package ua.clamor1s.eLock.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ua.clamor1s.eLock.dto.request.GroupRequest;
import ua.clamor1s.eLock.dto.response.GroupResponse;
import ua.clamor1s.eLock.entity.Group;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T20:56:58+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class GroupMapperImpl implements GroupMapper {

    @Override
    public GroupResponse groupToGroupResponse(Group group) {
        if ( group == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;
        String createdBy = null;

        id = group.getId();
        name = group.getName();
        createdAt = group.getCreatedAt();
        updatedAt = group.getUpdatedAt();
        createdBy = group.getCreatedBy();

        GroupResponse groupResponse = new GroupResponse( id, name, createdAt, updatedAt, createdBy );

        return groupResponse;
    }

    @Override
    public Group groupRequestToGroup(GroupRequest groupRequest) {
        if ( groupRequest == null ) {
            return null;
        }

        Group group = new Group();

        group.setName( groupRequest.getName() );

        fillCreatableUpdatable( group );

        return group;
    }

    @Override
    public void updateGroup(Group group, GroupRequest groupRequest) {
        if ( groupRequest == null ) {
            return;
        }

        group.setName( groupRequest.getName() );

        fillCreatableUpdatable( group );
    }
}
