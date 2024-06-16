package ua.clamor1s.eLock.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ua.clamor1s.eLock.dto.request.PermissionRequest;
import ua.clamor1s.eLock.dto.response.PermissionResponse;
import ua.clamor1s.eLock.entity.Permission;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T20:56:58+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PermissionMapperImpl implements PermissionMapper {

    @Override
    public PermissionResponse permissionToPermissionResponse(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        LocalDateTime createdAt = null;
        LocalDateTime updatedAt = null;
        String createdBy = null;

        id = permission.getId();
        name = permission.getName();
        createdAt = permission.getCreatedAt();
        updatedAt = permission.getUpdatedAt();
        createdBy = permission.getCreatedBy();

        PermissionResponse permissionResponse = new PermissionResponse( id, name, createdAt, updatedAt, createdBy );

        return permissionResponse;
    }

    @Override
    public Permission permissionRequestToPermission(PermissionRequest permissionRequest) {
        if ( permissionRequest == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setName( permissionRequest.getName() );

        fillCreatableUpdatable( permission );

        return permission;
    }

    @Override
    public void updatePermission(Permission permission, PermissionRequest permissionRequest) {
        if ( permissionRequest == null ) {
            return;
        }

        permission.setName( permissionRequest.getName() );

        fillCreatableUpdatable( permission );
    }
}
