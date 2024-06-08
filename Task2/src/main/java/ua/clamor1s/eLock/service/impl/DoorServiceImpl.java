package ua.clamor1s.eLock.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.eLock.dto.request.DoorRequest;
import ua.clamor1s.eLock.dto.response.DoorResponse;
import ua.clamor1s.eLock.entity.Area;
import ua.clamor1s.eLock.entity.Door;
import ua.clamor1s.eLock.entity.User;
import ua.clamor1s.eLock.mapper.DoorMapper;
import ua.clamor1s.eLock.repository.DoorRepository;
import ua.clamor1s.eLock.service.DoorService;
import ua.clamor1s.eLock.utils.AuthUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoorServiceImpl implements DoorService {

    private final AuthUtils authUtils;
    private final DoorMapper doorMapper;
    private final DoorRepository doorRepository;


    @Override
    @Transactional(readOnly = true)
    public List<Door> getFromDoorsByArea(Area area) {
        authUtils.validateUser(area.getCreatedBy());
        return area.getDoorsFrom();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Door> getToDoorsByArea(Area area) {
        authUtils.validateUser(area.getCreatedBy());
        return area.getDoorsTo();
    }

    @Override
    @Transactional
    public Door createDoor(Area from, Area to, DoorRequest doorRequest) {
        authUtils.validateUser(from.getCreatedBy());
        authUtils.validateUser(to.getCreatedBy());
        User user = authUtils.getCurrentUser().orElseThrow(() -> new RuntimeException());
        Door door = doorMapper.doorRequestToDoorEntity(doorRequest, from, to);
        door.setCreatedBy(user.getEmail());
        return doorRepository.save(door);
    }

    @Override
    @Transactional(readOnly = true)
    public Door getDoorById(Long doorId) {
        return doorRepository.findById(doorId).orElseThrow(() -> new RuntimeException());
    }

    @Override
    @Transactional
    public Door updateDoor(Door door, DoorRequest doorRequest, Area from, Area to) {
        door.setFrom(from);
        door.setTo(to);
        doorMapper.updateDoorByDoorRequest(door, doorRequest);
        return doorRepository.save(door);
    }

    @Override
    @Transactional
    public void deleteDoor(Door door) {
        doorRepository.delete(door);
    }

    @Override
    public DoorResponse convertDoorToDoorResponse(Door door) {
        return doorMapper.convertDoorToDoorResponse(door);
    }
}
