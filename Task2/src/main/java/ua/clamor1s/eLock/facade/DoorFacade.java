package ua.clamor1s.eLock.facade;

import ua.clamor1s.eLock.dto.request.DoorRequest;
import ua.clamor1s.eLock.dto.response.DoorResponse;

import java.util.List;

public interface DoorFacade {
    List<DoorResponse> getFromDoors(Long areaId);

    List<DoorResponse> getToDoors(Long areaId);

    DoorResponse createDoor(DoorRequest doorRequest);

    DoorResponse updateDoor(Long doorId, DoorRequest doorRequest);

    DoorResponse deleteDoor(Long doorId);
}
