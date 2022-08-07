package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.model.Meal;
import com.example.springrestfulpractice.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Meal> mealList1 = new ArrayList<>();
    //
    private List<Meal> mealList2 = new ArrayList<>();
    private List<Meal> mealList3 = new ArrayList<>();
    private List<Meal> mealList4 = new ArrayList<>();

    private List<Order> orderList = new ArrayList<>();

    public List<Order> getAllOrders() {
        return this.orderList;
    }

    public Order getOrder(int seq) {
        for (Order order : this.orderList) {
            if (seq == order.getSeq()) {
                return order;
            }
        }
        return null;
    }

    public Order createOrder(Order order) {
        this.orderList.add(order);
        return order;
    }

    public Order updateOrder(int seq, Order order) {
        for (Order updateOrder : this.orderList) {
            if (seq == updateOrder.getSeq()) {
                updateOrder.setTotalPrice(order.getTotalPrice());
                updateOrder.setWaiter(order.getWaiter());
                updateOrder.setMealList(order.getMealList());
            }
        }
        return order;
    }

    public Order deleteOrder(int seq) {
        for (Order deleteOrder : this.orderList) {
            if (seq == deleteOrder.getSeq()) {
                this.orderList.remove(deleteOrder);
                return deleteOrder;
            }
        }
        return null;
    }

    public OrderService() {
        this.mealList1.add(new Meal("Hamburger", 100, "Real tasty"));// expression 不能寫在物件裡面
        this.mealList1.add(new Meal("Hamburger1", 100, "Real tasty"));// expression 不能寫在物件裡面

        this.mealList2.add(new Meal("Fries", 30, "Stinky"));
        this.mealList2.add(new Meal("Fries1", 30, "Stinky"));
        this.mealList3.add(new Meal("Cutie Pie", 50, "So cute"));
        this.mealList3.add(new Meal("Cutie Pie1", 50, "So cute"));
        this.mealList4.add(new Meal("Fried warms", 200, "So good you can't imagine"));
        this.mealList4.add(new Meal("Fried 1", 200, "So good you can't imagine"));


        this.orderList.add(new Order(1, getOrderTotalPrice(mealList1), "McDaddy", mealList1));
        this.orderList.add(new Order(2, getOrderTotalPrice(mealList2), "McPappy", mealList2));
        this.orderList.add(new Order(3, getOrderTotalPrice(mealList3), "Conor", mealList3));
        this.orderList.add(new Order(4, getOrderTotalPrice(mealList4), "Mcgregor", mealList4));
    }

    public int getOrderTotalPrice(List<Meal> mealList) {
        int sum = 0;
        for (Meal meal : mealList) {
            sum += meal.getPrice();
        }
        return sum;
    }

}
