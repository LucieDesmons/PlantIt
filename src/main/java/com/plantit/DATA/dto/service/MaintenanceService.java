package com.plantit.dto.service;

import com.plantit.dal.entities.Maintenance;

import java.util.List;

public interface MaintenanceService {

    Maintenance createMaintenance(Maintenance m);

    Maintenance saveMaintenance(Maintenance m);

    Maintenance updateMaintenance(Maintenance m);

    void deleteMaintenance(Maintenance m);

    void deleteMaintenanceById(Long id);

    Maintenance getMaintenance(Long id);

    List<Maintenance> getAllMaintenances();

}
