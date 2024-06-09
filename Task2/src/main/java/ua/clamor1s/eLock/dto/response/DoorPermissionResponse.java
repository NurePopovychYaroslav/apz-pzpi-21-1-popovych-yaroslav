package ua.clamor1s.eLock.dto.response;

import java.time.LocalDateTime;


public record DoorPermissionResponse(Long doorId,
                                     Long permissionId,
                                     LocalDateTime createdAt,
                                     LocalDateTime updatedAt,
                                     String createdBy) {
}
