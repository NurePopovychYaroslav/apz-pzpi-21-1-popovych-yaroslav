package ua.clamor1s.eLock.service;

import ua.clamor1s.eLock.dto.request.DoorRequest;
import ua.clamor1s.eLock.dto.response.DoorResponse;
import ua.clamor1s.eLock.entity.Area;
import ua.clamor1s.eLock.entity.Door;

import java.util.List;

public interface DoorService {
    List<Door> getFromDoorsByArea(Area area);

    List<Door> getToDoorsByArea(Area area);

    Door createDoor(Area from, Area to, DoorRequest doorRequest);

    DoorResponse convertDoorToDoorResponse(Door door);

    Door getDoorById(Long doorId);

    Door updateDoor(Door door, DoorRequest doorRequest, Area from, Area to);

    void deleteDoor(Door door);
}
