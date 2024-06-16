package ua.clamor1s.eLock.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ua.clamor1s.eLock.dto.request.CampusRequest;
import ua.clamor1s.eLock.dto.response.CampusResponse;
import ua.clamor1s.eLock.entity.Campus;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T20:56:58+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CampusMapperImpl implements CampusMapper {

    @Override
    public Campus campusRequestToCampus(CampusRequest campusRequest) {
        if ( campusRequest == null ) {
            return null;
        }

        Campus campus = new Campus();

        campus.setName( campusRequest.getName() );
        campus.setLocation( campusRequest.getLocation() );

        fillCreatableUpdatable( campus );

        return campus;
    }

    @Override
    public CampusResponse campusToCampusResponse(Campus campus) {
        if ( campus == null ) {
            return null;
        }

        String name = null;
        String location = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;
        String createdBy = null;
        Long id = null;

        name = campus.getName();
        location = campus.getLocation();
        createdAt = campus.getCreatedAt();
        updatedAt = campus.getUpdatedAt();
        createdBy = campus.getCreatedBy();
        id = campus.getId();

        CampusResponse campusResponse = new CampusResponse( name, location, createdAt, updatedAt, createdBy, id );

        return campusResponse;
    }

    @Override
    public void updateCampusByCampusRequest(Campus campus, CampusRequest campusRequest) {
        if ( campusRequest == null ) {
            return;
        }

        campus.setName( campusRequest.getName() );
        campus.setLocation( campusRequest.getLocation() );

        fillCreatableUpdatable( campus );
    }
}
