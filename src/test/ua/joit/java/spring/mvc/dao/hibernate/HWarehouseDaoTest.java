package joit.java.spring.mvc.dao.hibernate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.IngredientDao;
import ua.joit.java.spring.mvc.dao.WarehouseDao;
import ua.joit.java.spring.mvc.model.Ingredient;
import ua.joit.java.spring.mvc.model.Measures;
import ua.joit.java.spring.mvc.model.Warehouse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-annotation.xml", "classpath:hibernate-context.xml"})
public class HWarehouseDaoTest {
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private WarehouseDao warehouseDao;

    @Test
    @Transactional
    @Rollback(true)
    public void test() {

        Ingredient pork = new Ingredient("pork");
        ingredientDao.addIngredient(pork);

        Warehouse warehouse = new Warehouse(ingredientDao.findByName("pork"), 4F, Measures.KG);
        warehouseDao.create(warehouse);
        Assert.assertEquals("pork", warehouseDao.findByName("pork").getIngredient().getName());
        Assert.assertEquals("pork", warehouseDao.getById(9L).getIngredient().getName());
        Assert.assertEquals("pork", warehouseDao.findEndsIngredients().get(0).getIngredient().getName());
        warehouseDao.changeQuantity(warehouseDao.findByName("pork"),11F);
        Assert.assertEquals(11F, warehouseDao.findByName("pork").getQuantity(),0);

        warehouseDao.remove(warehouse);
        ingredientDao.removeIngredient(ingredientDao.findByName("pork"));

    }


}
