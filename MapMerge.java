package zookeeper;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Test2222
 * @Description TODO
 * @Author LaoBii
 * @Version
 **/
public class MapMerge {
    public static void main(String[] args) {
        // java 8  , merge()
        Map<String,Integer> map=new HashMap<>();
        map.put("A", 100);
        map.put("B", 200);
        map.put("C", null);

        //替换原来A对应的值(100)为199(100+99)
        Integer newValue1 = map.merge("A", 99, (X,Y) -> (Y+X));
        System.out.println("A:" + map.get("A"));
        //替换原来C对应的值(null)为66
        Integer newValue2 = map.merge("C", 66, (X,Y) -> X);
        System.out.println("C:" + map.get("C"));

        //替换原来C对应的值(66)为null,值'888'不生效,并且,C赋值为null时,C的Entry被删除了
        Integer newValue3 = map.merge("C", 888, (X,Y) -> null);
        System.out.println("C:" + map.get("C"));

        //如果原本的key不存在,则添加对应的key-value
        Integer newValue4 = map.merge("D", 666, (X,Y) -> Y);
        for(String s:map.keySet()){
            System.out.println(s+" : "+map.get(s));
        }
    }
}
