package ua.clamor1s.eLock.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ua.clamor1s.eLock.dto.request.DoorRequest;
import ua.clamor1s.eLock.dto.response.DoorResponse;
import ua.clamor1s.eLock.entity.Area;
import ua.clamor1s.eLock.entity.Door;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T20:56:58+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DoorMapperImpl implements DoorMapper {

    @Override
    public DoorResponse convertDoorToDoorResponse(Door door) {
        if ( door == null ) {
            return null;
        }

        Long areaFromId = null;
        Long areaToId = null;
        Long id = null;
        String name = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;
        String createdBy = null;

        areaFromId = doorFromId( door );
        areaToId = doorToId( door );
        id = door.getId();
        name = door.getName();
        createdAt = door.getCreatedAt();
        updatedAt = door.getUpdatedAt();
        createdBy = door.getCreatedBy();

        DoorResponse doorResponse = new DoorResponse( id, name, areaFromId, areaToId, createdAt, updatedAt, createdBy );

        return doorResponse;
    }

    @Override
    public Door doorRequestToDoorEntity(DoorRequest doorRequest, Area from, Area to) {
        if ( doorRequest == null && from == null && to == null ) {
            return null;
        }

        Door door = new Door();

        if ( doorRequest != null ) {
            door.setName( doorRequest.getName() );
        }
        door.setFrom( from );
        door.setTo( to );

        fillCreatableUpdatable( door );

        return door;
    }

    @Override
    public void updateDoorByDoorRequest(Door door, DoorRequest doorRequest) {
        if ( doorRequest == null ) {
            return;
        }

        door.setName( doorRequest.getName() );

        fillCreatableUpdatable( door );
    }

    private Long doorFromId(Door door) {
        if ( door == null ) {
            return null;
        }
        Area from = door.getFrom();
        if ( from == null ) {
            return null;
        }
        Long id = from.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long doorToId(Door door) {
        if ( door == null ) {
            return null;
        }
        Area to = door.getTo();
        if ( to == null ) {
            return null;
        }
        Long id = to.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
