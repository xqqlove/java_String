package comparable_yiwa;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparable {
    public static void main(String[] args) {
        String []str=new String[]{"AA","B","FF","DD","CC"};
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1=o1;
                    String s2=o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据不一致");
            }
        });
        System.out.println(Arrays.toString(str));

        Goods[] str1=new Goods[5];
        str1[0]=new Goods("huawei",1120);
        str1[1]=new Goods("xiaomi",1110);
        str1[2]=new Goods("Oppo",2120);
        str1[3]=new Goods("meizu",2500);
        str1[4]=new Goods("vivo",550);
        Arrays.sort(str1);
        System.out.println(Arrays.toString(str1));
        Arrays.sort(str1, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getName().equals(o2.getName())){
                    return -Double.compare(o1.getPrice(),o2.getPrice());
                }else {
                    return -o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(str1));
    }


}
