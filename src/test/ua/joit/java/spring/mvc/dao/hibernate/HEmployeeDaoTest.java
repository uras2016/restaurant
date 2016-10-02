package joit.java.spring.mvc.dao.hibernate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ua.joit.java.spring.mvc.dao.*;
import ua.joit.java.spring.mvc.model.Employee;
import ua.joit.java.spring.mvc.model.Position;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-annotation.xml", "classpath:hibernate-context.xml"})
public class HEmployeeDaoTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private WarehouseDao warehouseDao;
    @Autowired
    private PreparedDishesDAO preparedDishesDAO;


    @Test
    @Transactional
    @Rollback(true)
    public void test() {
//        employeeDao.removeAllEmployees();

        employeeDao.save(bornTom());
        employeeDao.save(bornJerry());
        employeeDao.save(bornDon());

//        Assert.assertEquals("Tom",employeeDao.getById(9L).getName());
//        Assert.assertEquals("Jerry",employeeDao.getById(10L).getName());
//        Assert.assertEquals("Don",employeeDao.getById(11L).getName());

        Assert.assertEquals("Tom",employeeDao.findByName("Tom").getName());
        Assert.assertEquals("Jerry",employeeDao.findByName("Jerry").getName());
        Assert.assertEquals("Don",employeeDao.findByName("Don").getName());

        Assert.assertEquals("Fox",employeeDao.findBySurname("Fox").getSurname());
        Assert.assertEquals("Win",employeeDao.findBySurname("Win").getSurname());
        Assert.assertEquals("Karleone",employeeDao.findBySurname("Karleone").getSurname());

        Assert.assertEquals("Fox",employeeDao.findByNameAndSurname("Tom","Fox").getSurname());
        Assert.assertEquals("Win",employeeDao.findByNameAndSurname("Jerry","Win").getSurname());
        Assert.assertEquals("Karleone",employeeDao.findByNameAndSurname("Don","Karleone").getSurname());

        employeeDao.remove(employeeDao.findByName("Tom"));
        employeeDao.remove(employeeDao.findByName("Jerry"));
        employeeDao.remove(employeeDao.findByName("Don"));



    }






    public Employee bornTom(){
        Employee tom = new Employee();
        tom.setName("Tom");
        tom.setSurname("Fox");
        tom.setTelephone(12656789);
        tom.setPosition(Position.WAITER);
        tom.setSalary(8514.0F);
        tom.setBirthday("1986-05-08");
        return tom;
    }
    public Employee bornJerry(){
        Employee jerry = new Employee();
        jerry.setName("Jerry");
        jerry.setSurname("Win");
        jerry.setTelephone(126789);
        jerry.setPosition(Position.COOKER);
        jerry.setSalary(85994.0F);
        jerry.setBirthday("1980-05-08");
        return jerry;
    }
    public Employee bornDon(){
        Employee don = new Employee();
        don.setName("Don");
        don.setSurname("Karleone");
        don.setTelephone(126789);
        don.setPosition(Position.MANAGER);
        don.setSalary(8999514.0F);
        don.setBirthday("1979-05-01");
        return don;
    }
}
