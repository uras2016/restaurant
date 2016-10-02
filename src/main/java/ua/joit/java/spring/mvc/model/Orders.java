package ua.joit.java.spring.mvc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

//    @Id@GeneratedValue(strategy=GenerationType.AUTO)
//    private Long id;


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne          /*много ордеров у одного емплоии*/
    @JoinColumn(name = "employee_id")   /*в колонку employee_id будем заносить айдишники емплоии*/
    @JsonIgnore
    private Employee waiter;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)             /* нужна третья таблица    в несколько ордеров могут входить много диш, несколько диш могут входить в разные ордеры*/
    @JoinTable(
            name = "dish_to_order",     /*имя третей таблицы*/
            joinColumns = @JoinColumn(name = "order_id"),    /*сюда запишет наш id*/
            inverseJoinColumns = @JoinColumn(name = "dish_id")  /*сюда запишет id связи*/
    )
    private List<Dish> dishes;   /*у этого листа будет одинаковый  id ордера*/
    @Column(name = "table_number")
    private int tableNumber;
    @Column(name = "order_date")
    private Date orderDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "open_status")
    private Status status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "prepared_dish_to_order",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "prepared_dish_id")
    )
    @JsonIgnore
    private List<PreparedDish> preparedDishes;

    public Orders(Employee waiter, List<Dish> dishes, int tableNumber, Date orderDate, Status status) {
        this.waiter = waiter;
        this.dishes = dishes;
        this.tableNumber = tableNumber;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Orders() {
    }
    public boolean isNew() {
        return (this.id == null);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getWaiter() {
        return waiter;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Status isOpen() {
        return Status.OPEN;
    }

    public Status getStatus() {
        return status;
    }

    public void setOpenStatus(Status status) {
        this.status = status;
    }

    public List<PreparedDish> getPreparedDishes() {
        return preparedDishes;
    }

    public void setPreparedDishes(List<PreparedDish> preparedDishes) {
        this.preparedDishes = preparedDishes;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
//                ", waiter=" + waiter +
                ", dishes=" + dishes +
                ", tableNumber=" + tableNumber +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }
}
