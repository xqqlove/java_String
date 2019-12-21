package stringBuffer_yiwa;

import java.io.IOException;
import java.util.Arrays;

public class MyAbstractStringBuilder implements Appendable,CharSequence {
    char[] value;
    int count;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    MyAbstractStringBuilder(){};
    MyAbstractStringBuilder(int capacity){value=new char[capacity];}
    public int capacity(){
        return value.length;
    }
    public void ensureCapacity(int minimumCapacity){
        if (minimumCapacity>0){
            ensureCapacityInternal(minimumCapacity);
        }
    }
    private void ensureCapacityInternal(int minimumCapacity){
        if(minimumCapacity-value.length>0){
            value = Arrays.copyOf(value,newCapacity(minimumCapacity));
        }
    }
    private int newCapacity(int minCapacity){
        int newCapacity=(value.length<<1)+2;
        if (newCapacity-minCapacity<=0){
            newCapacity=minCapacity;
        }
        return (newCapacity<=0||MAX_ARRAY_SIZE-newCapacity<0)?hugeCapacity(minCapacity):newCapacity;
    }
    private int hugeCapacity(int mincapacity){
        if (Integer.MAX_VALUE-mincapacity<0){
            throw new OutOfMemoryError();
        }
        return (mincapacity>MAX_ARRAY_SIZE)?mincapacity:MAX_ARRAY_SIZE;
    }
    public void setLength(int newLength){
        if(newLength<0)
            throw new StringIndexOutOfBoundsException(newLength);
        ensureCapacityInternal(newLength);
        if (count<newLength){
            Arrays.fill(value,count,newLength,'\0');
        }
        count=newLength;
    }
    private MyAbstractStringBuilder appendNull(){
        int c=count;
        ensureCapacityInternal(c+4);
        value[c++]='n';
        value[c++]='u';
        value[c++]='l';
        value[c++]='l';
        count=c;
        return this;
    }
    public MyAbstractStringBuilder append(String str){
        if (str==null)
            return appendNull();
        int len =str.length();
        ensureCapacityInternal(count+len);
        str.getChars(0,len,value,count);
        count+=len;
        return this;
    }
    public MyAbstractStringBuilder append(MyStringBuffer sb){
        if (sb==null)
            return appendNull();
        int len =sb.length();
        ensureCapacityInternal(count+len);
        sb.getChars(0,len,value,count);
        count+=len;
        return this;
    }

    public MyAbstractStringBuilder append(Object obj){
        return append(String.valueOf(obj));
    }

    @Override
    public Appendable append(CharSequence csq) throws IOException {
        return null;
    }

    @Override
    public Appendable append(CharSequence csq, int start, int end) throws IOException {
        return null;
    }

    @Override
    public Appendable append(char c) throws IOException {
        return null;
    }

    @Override
    public int length() {
        return count;
    }

    @Override
    public char charAt(int index) {
        if ((index<0)||(index>count)){
            throw new StringIndexOutOfBoundsException(index);
        }
        return value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }
    public void getChars(int srcB,int srcE,char[] dst,int dstB){
        if (srcB<0)
            throw new StringIndexOutOfBoundsException(srcB);
        if (srcE<0||srcE>count)
            throw  new StringIndexOutOfBoundsException(srcE);
        if (srcB>srcE)
            throw new StringIndexOutOfBoundsException("srcB>srcE");
        System.arraycopy(value,srcB,dst,dstB,srcE-srcB);
    }

}
