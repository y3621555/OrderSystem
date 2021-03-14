package com.johnson;

import java.util.ArrayList;
import java.util.Scanner;

class ItemList{
    int itemID;
    String itemName;
    int Price;

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setName(String name) {
        this.itemName = name;
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
        return itemName;
    }

    @Override
    public String toString(){
        return String.format( itemID + " " + itemName + " " + Price);
    }
}
class Utils{

    public void ShowMenu(){
        System.out.println("<菜單>");
        System.out.println("代號(itemID)  品名(itemName)    單價(unitPrice)");
        System.out.println("1001         阿薩姆奶茶          55");
        System.out.println("1002         珍珠奶茶            65");
        System.out.println("1005         茉香綠茶            35");
        System.out.println("1007         烏梅汁              45");
        System.out.println("1008         黑咖啡(美式)         40");
        System.out.println("1009         拿鐵                55");
    }
}


class Order{
    int itemID;
    int amount;

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
    public String toString(){
        return String.format("ID: " + itemID + " 數量: " + amount);
    }
}


public class main {
    public static ArrayList<Order> OrderList = new ArrayList<Order>();
    public static ArrayList<ItemList> itemLists = new ArrayList<ItemList>();
    public static Order order = new Order();

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Utils utils = new Utils();
        int TotalMoney=0;
        int i = 0;
        CreateMenu();

        System.out.println("<<<<< QQ 飲料店 點餐系統 >>>>>");
        System.out.print("(1) 建立訂單 (2) 離開: ");
        int number = scanner.nextInt();

        while ( number != 1 && number != 2){
            System.out.println(" Please input 1 or 2");
            System.out.print("(1) 建立訂單 (2) 離開: ");
            number = scanner.nextInt();
        }

        /*for (ItemList itemList : itemLists){
            System.out.println(itemList);
        }*/

        while ( number == 1 ){
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
                    i = 0;
                    System.out.print("輸入代號與數量: ");
                    int ItemID = scanner.nextInt();
                    int Amount = scanner.nextInt();
                    EnterOrder(ItemID,Amount);


                    for (Order order1: OrderList){

                        String name = String.valueOf(order1.itemID);
                        name = name.replace("1001", "阿薩姆奶茶").replace("1002", "珍珠奶茶");
                        name = name.replace("1005", "茉香綠茶").replace("1007", "烏梅汁");
                        name = name.replace("1008", "黑咖啡(美式)").replace("1009", "拿鐵");
                        for (ItemList itemList : itemLists){
                            if (itemList.itemID == order1.itemID){
                                i+=1;
                                System.out.println("[" + i + "] " + name + " " + itemList.Price + "x" + order1.amount + " " + itemList.Price*order1.amount);
                            }

                        }

                        //System.out.println("[" + i + "] " + name + " " + order1.amount);


                    }

                    System.out.print(">(1) 點餐 (2)完成 (3) 取消單項 (4) 取消訂單: ");
                    number1 = scanner.nextInt();
                    //System.out.println( "代號 " + ItemID + "數量" + Amount);

                }
                else if ( number1 == 2 ){
                    System.out.println("***** 列印明細 *****");
                    for (Order order1: OrderList){

                        String name = String.valueOf(order1.itemID);
                        name = name.replace("1001", "阿薩姆奶茶").replace("1002", "珍珠奶茶");
                        name = name.replace("1005", "茉香綠茶").replace("1007", "烏梅汁");
                        name = name.replace("1008", "黑咖啡(美式)").replace("1009", "拿鐵");
                        for (ItemList itemList : itemLists){
                            if (itemList.itemID == order1.itemID){
                                TotalMoney = TotalMoney + (itemList.Price*order1.amount);

                                System.out.println(  name + " " + itemList.Price + "x" + order1.amount + " " + itemList.Price*order1.amount);
                            }

                        }

                        //System.out.println("[" + i + "] " + name + " " + order1.amount);
                    }
                    System.out.println("總價 " + TotalMoney);
                    OrderList.clear();
                    TotalMoney = 0;
                    System.out.print("(1) 建立訂單 (2) 離開: ");
                    number = scanner.nextInt();
                    break;


                }
                else if ( number1 == 3 ){
                    i = 0;
                    System.out.print(">>輸入編號: ");
                    int Del_Number = scanner.nextInt();

                    OrderList.remove(Del_Number-1);

                    for (Order order1: OrderList){

                        String name = String.valueOf(order1.itemID);
                        name = name.replace("1001", "阿薩姆奶茶").replace("1002", "珍珠奶茶");
                        name = name.replace("1005", "茉香綠茶").replace("1007", "烏梅汁");
                        name = name.replace("1008", "黑咖啡(美式)").replace("1009", "拿鐵");
                        for (ItemList itemList : itemLists){
                            if (itemList.itemID == order1.itemID){
                                i+=1;
                                System.out.println("[" + i + "] " + name + " " + itemList.Price + "x" + order1.amount + " " + itemList.Price*order1.amount);
                            }

                        }

                        //System.out.println("[" + i + "] " + name + " " + order1.amount);
                    }

                    System.out.print(">(1) 點餐 (2)完成 (3) 取消單項 (4) 取消訂單: ");
                    number1 = scanner.nextInt();


                }
            }
            System.out.println("退出系統");
            OrderList.clear();
            TotalMoney = 0;

        }
        // Stop System number2
        if ( number == 2){
            System.out.println("離開");
        }
    }

    public static void CreateMenu(){
        //1
        ItemList itemList0 = new ItemList();
        itemList0.itemID = 1001;
        itemList0.itemName = "阿薩姆奶茶";
        itemList0.Price = 55;
        itemLists.add(itemList0);
        //2
        ItemList itemList1 = new ItemList();
        itemList1.itemID = 1002;
        itemList1.itemName = "珍珠奶茶";
        itemList1.Price = 65;
        itemLists.add(itemList1);
        //3
        ItemList itemList2 = new ItemList();
        itemList2.itemID = 1005;
        itemList2.itemName = "茉香綠茶";
        itemList2.Price = 35;
        itemLists.add(itemList2);
        //4
        ItemList itemList3 = new ItemList();
        itemList3.itemID = 1007;
        itemList3.itemName = "烏梅汁";
        itemList3.Price = 45;
        itemLists.add(itemList3);
        //5
        ItemList itemList4 = new ItemList();
        itemList4.itemID = 1008;
        itemList4.itemName = "黑咖啡(美式)";
        itemList4.Price = 40;
        itemLists.add(itemList4);
        //6
        ItemList itemList5 = new ItemList();
        itemList5.itemID = 1009;
        itemList5.itemName = "拿鐵";
        itemList5.Price = 55;
        itemLists.add(itemList5);

    }

    public static void EnterOrder(int ItemID, int Amount){
        Order o = new Order();
        o.itemID = ItemID;
        o.amount = Amount;
        OrderList.add(o);
    }
}
