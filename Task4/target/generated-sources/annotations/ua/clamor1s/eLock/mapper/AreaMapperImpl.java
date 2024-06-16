package ua.clamor1s.eLock.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ua.clamor1s.eLock.dto.request.AreaRequest;
import ua.clamor1s.eLock.dto.response.AreaResponse;
import ua.clamor1s.eLock.entity.Area;
import ua.clamor1s.eLock.entity.Campus;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T20:56:58+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AreaMapperImpl implements AreaMapper {

    @Override
    public AreaResponse mapAreaToAreaResponse(Area area) {
        if ( area == null ) {
            return null;
        }

        Long campusId = null;
        String name = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;
        String createdBy = null;
        Long id = null;

        campusId = areaCampusId( area );
        name = area.getName();
        createdAt = area.getCreatedAt();
        updatedAt = area.getUpdatedAt();
        createdBy = area.getCreatedBy();
        id = area.getId();

        AreaResponse areaResponse = new AreaResponse( name, campusId, createdAt, updatedAt, createdBy, id );

        return areaResponse;
    }

    @Override
    public Area areaRequestToArea(AreaRequest areaRequest) {
        if ( areaRequest == null ) {
            return null;
        }

        Area area = new Area();

        area.setName( areaRequest.getName() );

        fillCreatableUpdatable( area );

        return area;
    }

    @Override
    public void updateAreByAreaRequest(Area area, AreaRequest areaRequest) {
        if ( areaRequest == null ) {
            return;
        }

        area.setName( areaRequest.getName() );

        fillCreatableUpdatable( area );
    }

    private Long areaCampusId(Area area) {
        if ( area == null ) {
            return null;
        }
        Campus campus = area.getCampus();
        if ( campus == null ) {
            return null;
        }
        Long id = campus.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
