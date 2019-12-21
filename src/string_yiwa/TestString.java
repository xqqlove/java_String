package string_yiwa;

public class TestString {
    public static void main(String[] args) {
        String s="hello";
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
        System.out.println(join);
        char [] cha=join.toCharArray();
        for (int i=0;i<cha.length;i++){
            System.out.println(cha[i]);
        }
        char [] char1={'a','b','c','d','e'};
        char char2[]={'4','5','6','7','8'};
        System.arraycopy(char1,2,char2,1,char1.length-2);
        System.out.println(char2);
        byte[] bytes=s.getBytes();
        for (int i=0;i<bytes.length;i++){
            System.out.println(bytes[i]);
        }
        String s5=s.replace("ll","QQ");
        System.out.println(s5);
        int x=Integer.parseInt("1234");
        System.out.println(x);
        String s123=String.valueOf(x);
        System.out.println(s123);
        String s12=s123.intern();
        System.out.println(s12==s123);

        String str1="ab"+"cd";
        String str2="abcd";
        System.out.println(str1==str2);
        String s2=new String("ac");
        String s3="ac";
        System.out.println(s2.intern() == s3);
        char c[]={'a','c'};
        String s7=new String(c);
        System.out.println(s7);
        System.out.println(s7.intern() == s3);

    }

}
