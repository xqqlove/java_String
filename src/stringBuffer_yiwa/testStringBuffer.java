package stringBuffer_yiwa;

public class testStringBuffer {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abc");
        sb.setCharAt(0, 'm');
        System.out.println(sb);
        sb.append("123");
        System.out.println(sb.length());
        System.out.println(sb);
        sb.append(123);

        System.out.println(sb);
        sb.delete(2,5);//左闭右开
        System.out.println(sb);
        sb.replace(2,4,"hello");
        System.out.println(sb);
        System.out.println(sb.capacity());
        System.out.println("============");
        System.out.println(sb.length());
        sb.insert(4,false);
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);
        String s1= sb.substring(2,6);
        System.out.println(sb);
        System.out.println(s1);
        System.out.println("+++++++++++++++++++++++++");
        int x=123;
        System.out.println(x << 1);//数字的2倍


    }
}
