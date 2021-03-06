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
import ua.joit.java.spring.mvc.dao.OrderDao;
import ua.joit.java.spring.mvc.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-annotation.xml", "classpath:hibernate-context.xml"})
public class HOrderDaoTest {
    @Autowired
    private DishDao dishDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private OrderDao orderDao;

    @Test
    @Transactional
    @Rollback(true)
    public void test() {

        employeeDao.save(bornTom());
        employeeDao.save(bornJerry());

        ingredientDao.addIngredient(new Ingredient("flour"));
        ingredientDao.addIngredient(new Ingredient("strawberry"));
        ingredientDao.addIngredient(new Ingredient("kefir"));

        List<Ingredient> pieIngredients = new ArrayList<>();
        pieIngredients.add(ingredientDao.findByName("flour"));
        pieIngredients.add(ingredientDao.findByName("strawberry"));
        pieIngredients.add(ingredientDao.findByName("kefir"));
        Dish pie = new Dish("Pie", DishCategory.DESSERT, 8.00F, 1.0F, Measures.PIECE, pieIngredients, employeeDao.findByName("Tom"));
        dishDao.save(pie);

        List<Dish> dishes = new ArrayList<>();
        dishes.add(dishDao.findByName("Pie"));
        Orders order = new Orders(employeeDao.findByName("Jerry"),dishes,28,new Date(),Status.OPEN);
        orderDao.addDishToOrder(dishDao.getById(1L), order);
        Assert.assertEquals("Plov",orderDao.findById(order.getId()).getDishes().get(1).getName());

        orderDao.deleteDishFromOrder(dishDao.getById(1L), order);
        Assert.assertEquals("Pie",orderDao.findById(order.getId()).getDishes().get(0).getName());


        orderDao.deleteOrder(order);
        dishDao.remove(pie);
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
    public Employee bornJerry(){
        Employee jerry = new Employee();
        jerry.setName("Jerry");
        jerry.setSurname("Win");
        jerry.setTelephone(126789);
        jerry.setPosition(Position.WAITER);
        jerry.setSalary(85994.0F);
        jerry.setBirthday("1980-05-08");
        return jerry;
    }
}
