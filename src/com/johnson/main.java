package com.johnson;

import java.util.ArrayList;
import java.util.Scanner;

class Item{
    int itemID;
    String name;
    int Price;

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getItemID() {
        return itemID;
    }

    public int getPrice() {
        return Price;
    }

    public String getName() {
        return name;
    }
}
class Utils{

    public void ShowMenu(){
        System.out.println("<菜單>");
        System.out.println("代號(itemID)  品名(itemName)    單價(unitPrice)");
        System.out.println("1001         阿薩姆奶茶           55");
        System.out.println("1002         珍珠奶              65");
        System.out.println("1005         茉香綠茶            35");
        System.out.println("1007         烏梅汁              45");
        System.out.println("1008         黑咖啡(美式)         40");
        System.out.println("1009         拿鐵                55");
    }
}


class Order{
    int itemID;
    int amount;

    /*Order( int itemID, int amount ){
        this.itemID = itemID;
        this.amount = amount;
    }*/

    public int getItemID() {
        return itemID;
    }

    public int getAmount() {
        return amount;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemID=" + itemID +
                ", amount=" + amount +
                '}';
    }
}

public class main {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Order> OrderList = new ArrayList<Order>();
        Order order = new Order();
        Utils utils = new Utils();
        System.out.println("<<<<< QQ 飲料店 點餐系統 >>>>>");
        System.out.print("(1) 建立訂單 (2) 離開: ");
        int number = scanner.nextInt();

        while ( number != 1 && number != 2){
            System.out.println(" Please input 1 or 2");
            System.out.print("(1) 建立訂單 (2) 離開: ");
            number = scanner.nextInt();
        }
        if ( number == 1 ){
            // Create Order
            System.out.println("=======================================");
            utils.ShowMenu();

            System.out.print(">(1) 點餐 (2)完成 (3) 取消單項 (4) 取消訂單: ");
            int number1 = scanner.nextInt();
            while (number1 != 1 && number1 != 2 && number1 != 3 && number1 != 4 ){
                System.out.println(" Please input 1、2、3 or 4");
                System.out.print(">(1) 點餐 (2)完成 (3) 取消單項 (4) 取消訂單: ");
                number1 = scanner.nextInt();
            }

            while( number1 != 4 ){
                if ( number1 == 1){
                    System.out.print("輸入代號與數量: ");
                    int ItemID = scanner.nextInt();
                    int Amount = scanner.nextInt();
                    order.setItemID(ItemID);
                    order.setAmount(Amount);

                    OrderList.add(order);
                    //Collections.sort(students);
                    for ( int i=0; i< OrderList.size(); ++i ){
                        System.out.println(OrderList.get(i));
                    }

                    System.out.print(">(1) 點餐 (2)完成 (3) 取消單項 (4) 取消訂單: ");
                    number1 = scanner.nextInt();
                    //System.out.println( "代號 " + ItemID + "數量" + Amount);

                }
                else if ( number1 == 2 ){

                }
                else if ( number1 == 3 ){

                }
            }
            System.out.println("退出系統");

        }
        else {
            // Stop System
            System.out.println("離開");
        }


    }
}
