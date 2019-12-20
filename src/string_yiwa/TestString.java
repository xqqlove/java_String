package string_yiwa;

public class TestString {
    public static void main(String[] args) {
        String s="helso";
        String s1="demo"+s+"left"+67;
        System.out.println(s1);
        char [] a=new char[]{'1','2','3','4','5'};
        s.getChars(2,4,a,1);
        System.out.println(a);
        System.out.println(s);
        String[] arr =s.split(",");
        String concat=s.concat("3456");
        System.out.println(concat);
        System.out.println(concat.isEmpty());
        int index=concat.indexOf("o");
        System.out.println(index);
//        String trim="  abc  ".trim();
        System.out.println('1' >= ' ');
        String join =String.join(",","5454","AAA");



        
    }

}
