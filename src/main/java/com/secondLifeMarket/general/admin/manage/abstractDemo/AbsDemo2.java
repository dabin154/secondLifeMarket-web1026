package com.secondLifeMarket.general.admin.manage.abstractDemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: XiaXB
 * @Description:
 * @Date: Created in 11:57 2018/7/25
 * @Modified By ：
 */
public class AbsDemo2 extends AbsDemo{


    private void countDouble(){
        List<String> list  = new ArrayList<>();
        list.add(0,"0000");
        Map<String,String> map1 = new ConcurrentHashMap<String,String>();
        Map<String,String> map2 = new HashMap<>();
        System.out.println(countAmount(2.31d));

    }




    public Double countAmount2(Double aa){

        return null;

    }

}
