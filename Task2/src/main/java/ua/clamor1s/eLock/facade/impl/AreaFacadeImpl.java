package ua.clamor1s.eLock.facade.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.clamor1s.eLock.dto.request.AreaRequest;
import ua.clamor1s.eLock.dto.response.AreaResponse;
import ua.clamor1s.eLock.entity.Area;
import ua.clamor1s.eLock.entity.Campus;
import ua.clamor1s.eLock.facade.AreaFacade;
import ua.clamor1s.eLock.service.AreaService;
import ua.clamor1s.eLock.service.CampusService;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AreaFacadeImpl implements AreaFacade {
    private final CampusService campusService;
    private final AreaService areaService;

    @Transactional(readOnly = true)
    @Override
    public List<AreaResponse> getAllByCampusId(Long campusId) {
        Campus campus = campusService.getCampusById(campusId);
        List<Area> areas = areaService.getAreasByCampus(campus);
        return areas.stream()
                .map(area -> areaService.convertAreaToAreaResponse(area))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public AreaResponse createArea(Long campusId, AreaRequest areaRequest) {
        Campus campus = campusService.getCampusById(campusId);
        Area area = areaService.createArea(campus, areaRequest);
        return areaService.convertAreaToAreaResponse(area);
    }
}
