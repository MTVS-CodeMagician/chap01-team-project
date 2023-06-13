package com.ohgiraffers.team1.common;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BeverageDAO {
    private final Map<Integer,Beverage> beverageMap;
    public BeverageDAO(){
        this.beverageMap=new HashMap<>();
    }
//    private BeverageDAO(){}
//
//    public BeverageDAO getInstance(){
//        return new BeverageDAO();
//    }
    private static int index=0;
    // A 자판기에 음료 추가 함수
    public Beverage add(Beverage beverage){
        beverage.setSequence(++index);
        beverageMap.put(beverage.getSequence(), beverage);
        return beverage;
    }

    public String calc(int sequence, int bill){
        Beverage beverage=beverageMap.get(sequence);
        int price=beverage.getPrice();
        if(price>bill){
            throw new IllegalArgumentException("금액이 부족합니다.");
        }
        return beverage.getName();
    }

    public void clear(){
        beverageMap.clear();
    }
}
