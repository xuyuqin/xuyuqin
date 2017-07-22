package test;

import org.apache.commons.collections.functors.WhileClosure;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.collections.map.LinkedMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/13.
 */
public class MapTest {
    @Test
    public void Test() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        Set<String> key = map.keySet();
        Iterator<String> iterator = key.iterator();
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
        }
    }
    @Test
     public void test(){
        Map<String,Object> map=new LinkedMap();
        student stu1=new student();
        student stu2=new student();
         stu1.setId(1);
         stu1.setName("李白");
         stu1.setAge(22);
         stu2.setId(2);
         stu2.setName("张飞");
         stu2.setAge(33);
         map.put("2",stu1);
         map.put("1",stu2);
         Set<String> key=map.keySet();
         Iterator<String> iterater=key.iterator();
         while(iterater.hasNext()){
             student stu=(student)map.get(iterater.next());
             System.out.println(stu.toString());
         }
    }



}
