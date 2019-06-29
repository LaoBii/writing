package zookeeper;

import java.util.LinkedHashMap;

/**
 * @ClassName LinkedHashMapMain
 * @Description TODO
 * @Author LaoBii
 * @Version
 **/
public class LinkedHashMapMain {
    public static void main(String[] args) {
        System.out.println("defaultAccessOrder = false:");
        defaultLinkedHashMap();
        //linkedHashMap设置为accessOrder=true按照插入顺序排序
        System.out.println("\nAccessOrder = true:");
        accessOrderLinkedHashMap();
    }

    public static void defaultLinkedHashMap(){
        //默认构造方法,linkedHashMap中accessOrder=false,即:不按照插入顺序排序
        LinkedHashMap lMap = new LinkedHashMap();
        lMap.put("A", 1);
        lMap.put("B", 2);
        lMap.put("C", 3);
        //此时的插入顺序为A->B->C,输出与插入顺序一致
        System.out.println(lMap.toString());
        //此时,对于key=B进行了覆盖,但输出顺序仍然是A->B->C,对比39行
        lMap.put("B", 2.1);
        System.out.println(lMap);
    }

    public static void accessOrderLinkedHashMap(){
        LinkedHashMap lMap = new LinkedHashMap(16, 0.75f, true);
        lMap.put("A", 1);
        lMap.put("B", 2);
        lMap.put("C", 3);
        //此时的插入顺序为A->B->C,输出与插入顺序一致
        System.out.println(lMap.toString());
        //此时,对于key=B进行了覆盖,输出的顺序(A->C->B)与初始插入的顺序不一致(A->B->C)
        lMap.put("B", 2.1);
        System.out.println(lMap);
    }
}

/*
 console out:
        defaultAccessOrder = false:
        {A=1, B=2, C=3}
        {A=1, B=2.1, C=3}

        AccessOrder = true:
        {A=1, B=2, C=3}
        {A=1, C=3, B=2.1}
*/

