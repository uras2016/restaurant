package joit.java.spring.mvc.dao.hibernate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.DishDao;
import ua.joit.java.spring.mvc.dao.EmployeeDao;
import ua.joit.java.spring.mvc.dao.IngredientDao;
import ua.joit.java.spring.mvc.model.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-annotation.xml", "classpath:hibernate-context.xml"})
public class HDishDaoTest {
    @Autowired
    private DishDao dishDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private IngredientDao ingredientDao;

    @Test
    @Transactional
    @Rollback(true)
    public void test() {
        employeeDao.save(bornTom());
        ingredientDao.addIngredient(new Ingredient("flour"));
        ingredientDao.addIngredient(new Ingredient("strawberry"));
        ingredientDao.addIngredient(new Ingredient("kefir"));

        List<Ingredient> pieIngredients = new ArrayList<>();
        pieIngredients.add(ingredientDao.findByName("flour"));
        pieIngredients.add(ingredientDao.findByName("strawberry"));
        pieIngredients.add(ingredientDao.findByName("kefir"));
        Dish pie = new Dish("Pie", DishCategory.DESSERT, 8.00F, 1.0F, Measures.PIECE, pieIngredients, employeeDao.findByName("Tom"));
        dishDao.save(pie);

        Assert.assertEquals("Pie", dishDao.findByName("Pie").getName());
        Assert.assertEquals("Pie", dishDao.getById(7L).getName());

        dishDao.remove(dishDao.findByName("Pie"));
        employeeDao.remove(employeeDao.findByName("Tom"));
        ingredientDao.removeIngredient(ingredientDao.findByName("flour"));
        ingredientDao.removeIngredient(ingredientDao.findByName("strawberry"));
        ingredientDao.removeIngredient(ingredientDao.findByName("kefir"));

    }




    public Employee bornTom(){
        Employee tom = new Employee();
        tom.setName("Tom");
        tom.setSurname("Fox");
        tom.setTelephone(12656789);
        tom.setPosition(Position.COOKER);
        tom.setSalary(8514.0F);
        tom.setBirthday("1986-05-08");
        return tom;
    }
}
