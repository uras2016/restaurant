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
import ua.joit.java.spring.mvc.model.Ingredient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-annotation.xml", "classpath:hibernate-context.xml"})
public class HIngredientDaoTest {

    @Autowired
    private IngredientDao ingredientDao;

    @Test
    @Transactional
    @Rollback(true)
    public void test() {
        ingredientDao.addIngredient(new Ingredient("pork"));
        ingredientDao.addIngredient(new Ingredient("suet"));
        ingredientDao.addIngredient(new Ingredient("juice"));

        Assert.assertEquals("pork", ingredientDao.findByName("pork").getName());
        Assert.assertEquals("suet", ingredientDao.findByName("suet").getName());
        Assert.assertEquals("juice", ingredientDao.findByName("juice").getName());

//        Assert.assertEquals("pork", ingredientDao.findById(9L).getName());
//        Assert.assertEquals("suet", ingredientDao.findById(10L).getName());
//        Assert.assertEquals("juice", ingredientDao.findById(11L).getName());

        ingredientDao.removeIngredient(ingredientDao.findByName("pork"));
        ingredientDao.removeIngredient(ingredientDao.findByName("suet"));
        ingredientDao.removeIngredient(ingredientDao.findByName("juice"));


    }



}
