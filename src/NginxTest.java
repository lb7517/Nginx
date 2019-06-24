import java.util.*;

public class NginxTest {
    public static void main(String args[]){
        int[] arr = {20, 40, 30, 10};
        NginxTest nt = new NginxTest();
        int pos;
        for(int i = 0,l = 10; i < l; i++){
            pos = nt.getWeight(arr);
            System.out.println("随机到第: "+pos+" 个");
        }
    }

    public int getWeight(int[] arr){
        int total = 0;
        int i = 0, l = arr.length;
        for(; i < l; i++){
            total = total + arr[i];
        }
        List<Double> list = new ArrayList<>();
        Map<Double, Integer> map = new HashMap();
        for(i = 0; i < l; i++){
            double tmp = (double) arr[i]/total;
            map.put(tmp, i); //第一个是权重比例，第二个是pos
            list.add(tmp);
        }
        Collections.sort(list);
        System.out.println("map: "+map.toString());
        Collections.sort(list);
        double random = Math.random();
        System.out.println("随机数: "+random);
        double num = 0.0;
        for(i = 0; i < l; i++){
            Double key = list.get(i);
            num = key + num;
            if(random <= num){
                return map.get(key);
            }
            continue;
        }
        System.out.println("直接取最后一个");
        return map.get(list.get(i-1));
    }
}
