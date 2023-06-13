package com.ohgiraffers.team1.common;

import com.ohgiraffers.team1.container.ContextConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;
@SpringJUnitConfig(classes = {ContextConfiguration.class})
class BeverageDAOTest {
    @Autowired
    private BeverageDAO beverageDAO;
    // A Test 하나 끝날 때마다 실행
    @AfterEach
    public void clear(){
        beverageDAO.clear();
    }
    @Test
    void add() {
        //given
        Beverage beverage1=new Beverage("콜라",1200);
        //when
        Beverage add1 = beverageDAO.add(beverage1);
        //then
        assertEquals(add1.getName(),"콜라");
    }

    @Test
    void calc() {
        //given
        Beverage beverage1=new Beverage("콜라",1200);
        Beverage add1 = beverageDAO.add(beverage1);
        Beverage beverage2=new Beverage("사이다",2200);
        Beverage add2 = beverageDAO.add(beverage2);
        int bill=3000;
        int bevnum=1;
        //when
        String result=beverageDAO.calc(bevnum,bill);
        //then
        assertEquals(result,beverage1.getName());
        // A 예외상황
        assertThrows(IllegalArgumentException.class, ()-> {
           beverageDAO.calc(2,1000);
        });
    }
}