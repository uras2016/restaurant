package ua.joit.java.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.MenuDao;
import ua.joit.java.spring.mvc.model.Menu;

import java.util.List;

public class MenuService {
    private MenuDao menuDao;

    @Transactional
    public List<Menu> getMenus(){
        return menuDao.findAll();
    }
    @Transactional
    public Menu getMenuByName(String name){
        return menuDao.getByName(name);
    }

    @Autowired
    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
}
