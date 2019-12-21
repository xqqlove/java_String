public class TestEffective {
    //对比String StringBuffer StringBuilder三者效率
//    StringBuilder>StringBuffer>String
    public static void main(String[] args) {
        long startTime=0L;
        long endTime=0L;
        String text="";
        StringBuffer buffer=new StringBuffer("");
        StringBuilder builder=new StringBuilder("");
        //开始比对
        startTime=System.currentTimeMillis();
        for (int i=0;i<20000;i++){
            buffer.append(String.valueOf(i));
        }
        endTime =System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间："+(endTime-startTime));

        startTime=System.currentTimeMillis();
        for (int i=0;i<20000;i++){
            builder.append(String.valueOf(i));
        }
        endTime =System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间："+(endTime-startTime));

        startTime=System.currentTimeMillis();
        for (int i=0;i<20000;i++){
            text+=i;
        }
        endTime =System.currentTimeMillis();
        System.out.println("String的执行时间："+(endTime-startTime));

    }
}
