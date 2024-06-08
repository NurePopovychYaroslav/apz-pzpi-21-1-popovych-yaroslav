package ua.clamor1s.eLock.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.eLock.dto.request.DoorRequest;
import ua.clamor1s.eLock.dto.response.DoorResponse;
import ua.clamor1s.eLock.entity.Area;
import ua.clamor1s.eLock.entity.Door;
import ua.clamor1s.eLock.facade.DoorFacade;
import ua.clamor1s.eLock.service.AreaService;
import ua.clamor1s.eLock.service.DoorService;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DoorFacadeImpl implements DoorFacade {

    private final DoorService doorService;
    private final AreaService areaService;


    @Override
    @Transactional(readOnly = true)
    public List<DoorResponse> getFromDoors(Long areaId) {
        Area area = areaService.getAreaById(areaId);
        return doorService.getFromDoorsByArea(area).stream()
                .map(doorService::convertDoorToDoorResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<DoorResponse> getToDoors(Long areaId) {
        Area area = areaService.getAreaById(areaId);
        return doorService.getToDoorsByArea(area).stream()
                .map(doorService::convertDoorToDoorResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DoorResponse createDoor(DoorRequest doorRequest) {
        Area from = areaService.getAreaById(doorRequest.getAreaFrom());
        Area to = areaService.getAreaById(doorRequest.getAreaTo());
        Door door = doorService.createDoor(from, to, doorRequest);
        return doorService.convertDoorToDoorResponse(door);
    }

    @Override
    @Transactional
    public DoorResponse updateDoor(Long doorId, DoorRequest doorRequest) {
        Door door = doorService.getDoorById(doorId);
        Area from = areaService.getAreaById(doorRequest.getAreaFrom());
        Area to = areaService.getAreaById(doorRequest.getAreaTo());
        door = doorService.updateDoor(door, doorRequest, from, to);
        return doorService.convertDoorToDoorResponse(door);
    }

    @Override
    @Transactional
    public DoorResponse deleteDoor(Long doorId) {
        Door door = doorService.getDoorById(doorId);
        var response = doorService.convertDoorToDoorResponse(door);
        doorService.deleteDoor(door);
        return response;
    }
}
