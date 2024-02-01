package com.xk;

import java.util.*;

/**
 * @Author 柯书洋
 * @Date 2024/2/1 16:00
 * @Description
 */
public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("输入是哪位顾客A,B,C,D");
            String condition = scanner.next();
            HashMap<FruitEnum, Float> map;  //分别存储每样水果的价格
            Float sum;  //总价
            switch (condition) {
                case "A":
                    map = fun1();
                    sum = getSum(map);
                    if (map.isEmpty()) {
                        System.out.println("水果一共购买了0斤！！！");
                        break;
                    }
                    System.out.println("总价为：" + sum);
                    break;
                case "B":
                    map = fun2();
                    sum = getSum(map);
                    if (map.isEmpty()) {
                        System.out.println("水果一共购买了0斤！！！");
                        break;
                    }
                    System.out.println("总价为：" + sum);
                    break;
                case "C":
                    map = fun3();
                    sum = getSum(map);
                    if (map.isEmpty()) {
                        System.out.println("水果一共购买了0斤！！！");
                        break;
                    }
                    System.out.println("总价为：" + sum);
                    break;
                case "D":
                    map = fun4();
                    sum = getSum(map);
                    if (map.isEmpty()) {
                        System.out.println("水果一共购买了0斤！！！");
                        break;
                    }
                    System.out.println("总价为：" + sum);
                    break;
                default:
                    System.out.println("客户输入错误,重新输入。");
                    break;
            }
        }
    }


    //出售苹果和草莓。其中苹果 8 元/斤，草莓 13 元/斤。
    private static HashMap<FruitEnum, Float> fun1() {
        System.out.println("输入购买苹果的重量：");
        float appleWeight = scanner.nextFloat();

        System.out.println("输入购买草莓的重量：");
        float strawberryWeight = scanner.nextFloat();

        //校验
        if (!isCorrect(appleWeight + strawberryWeight)) {
            return new HashMap<>();  //返回空的
        }

        HashMap<FruitEnum, Float> hashMap = new HashMap<>();
        hashMap.put(FruitEnum.APPLE, appleWeight * 8);
        hashMap.put(FruitEnum.STRAWBERRY, strawberryWeight * 13);
        return hashMap;
    }

    //超市增加了一种水果芒果，其定价为 20元/斤。
    private static HashMap<FruitEnum, Float> fun2() {
        //获取苹果和草莓
        HashMap<FruitEnum, Float> map = fun1();

        System.out.println("输入购买芒果的重量：");
        float mangoWeight = scanner.nextFloat();

        //获取前两种水果的总价，如果为0，则前两种水果的总斤数为0
        if (getSum(map) == 0 && !isCorrect(mangoWeight)) {
            return new HashMap<>();
        }
        map.put(FruitEnum.MANGO, mangoWeight * 20);
        return map;
    }

    //草莓限时打 8 折。
    private static HashMap<FruitEnum, Float> fun3() {
        HashMap<FruitEnum, Float> map = fun2();
        //先获取原先的价格
        Float price = map.get(FruitEnum.STRAWBERRY);
        //再打八折
        if (price != null) {
            map.put(FruitEnum.STRAWBERRY, (float) (price * 0.8));
        }
        return map;
    }

    //超市继续加大促销力度，购物满 100 减 10 块。
    private static HashMap<FruitEnum, Float> fun4() {
        //这里是否在草莓打折的基础上参加优惠卷活动？？？。如果是，则调用fun3方法
//        HashMap<FruitEnum, Float> map = fun3();
        HashMap<FruitEnum, Float> map = fun2();
        //获取总价，是否满足优惠要求
        float sum = getSum(map);
        if (sum >= 100) {
            //随便扣减一样东西的价格
            //先获取原先的价格
            Float price = map.get(FruitEnum.STRAWBERRY);
            if (price != null ) {
                //在扣减
                map.put(FruitEnum.STRAWBERRY, (price - 10));
            }
        }
        return map;
    }

    //获取总价
    private static Float getSum(HashMap<FruitEnum, Float> map) {
        Set<Map.Entry<FruitEnum, Float>> set = map.entrySet();
        Float sum = 0F;
        for (Map.Entry<FruitEnum, Float> entry : set) {
            sum += entry.getValue();
        }
        return sum;
    }

    //校验重量
    private static Boolean isCorrect(float num) {
        if (num <= 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
