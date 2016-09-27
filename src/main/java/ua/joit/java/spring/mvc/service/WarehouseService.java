package ua.joit.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.WarehouseDao;
import ua.joit.java.spring.mvc.model.Warehouse;

import java.util.List;

public class WarehouseService {

    private WarehouseDao warehouseDao;

    @Transactional
    public List<Warehouse> findAll() {
        return warehouseDao.findAll();
    }

    @Transactional
    public void create(Warehouse warehouse) {
        warehouseDao.create(warehouse);
    }

    @Transactional
    public Warehouse getById(Long id) {
        return warehouseDao.getById(id);
    }
    @Transactional
    public Warehouse findByName(String name) {
        return warehouseDao.findByName(name);
    }

    @Transactional
    public void remove(Warehouse warehouse) {
        warehouseDao.remove(warehouse);
    }

        @Autowired
    public void setWarehouseDao(WarehouseDao warehouseDao) {
        this.warehouseDao = warehouseDao;
    }
}
