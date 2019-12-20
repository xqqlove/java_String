package stringBuffer_yiwa;

public class testStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();
        sb.append("abcd",2,4);
        sb.append(2);
        Integer arr[]={1,2,3};
        sb.append(arr);
        System.out.println(sb);
    }


}
