package com.plantit.dto.service.impl;

import com.plantit.dal.entities.Maintenance;
import com.plantit.dal.repositories.MaintenanceRepository;
import com.plantit.dto.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    MaintenanceRepository maintenanceRepository;

    public Maintenance createMaintenance(Maintenance m) {
        return maintenanceRepository.save(m);
    }
    public Maintenance saveMaintenance(Maintenance m) { return maintenanceRepository.save(m); };
    public Maintenance updateMaintenance(Maintenance m) { return maintenanceRepository.save(m); };
    public void deleteMaintenance(Maintenance m) { maintenanceRepository.delete(m); };
    public void deleteMaintenanceById(Long id) { maintenanceRepository.deleteById(id); };
    public Maintenance getMaintenance(Long id) { return maintenanceRepository.findById(id).get(); };
    public List<Maintenance> getAllMaintenances() { return maintenanceRepository.findAll(); };

}
