package string_yiwa;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.Arrays;

public class MyString implements Serializable,Comparable<MyString>,CharSequence {

    private static final long serialVersionUID=1L;

    private final char[] value;

    public MyString(){
        this.value=new char[0];
    }
    public MyString(MyString original){
        this.value=original.value;
    }
    public MyString(@NotNull char value[]){
        this.value= Arrays.copyOf(value,value.length);
    }
    public MyString(byte[] bytes){
        this.value=new char[bytes.length];
        for (int i=0;i<bytes.length;i++){
            this.value[i]=(char)bytes[i];
        }
    }
    public MyString(char value[] ,int offset,int count){
         if (offset<0){
             throw new StringIndexOutOfBoundsException();
         }
         if (count<=0){
             if (count<0){
                 throw  new StringIndexOutOfBoundsException(count);
             }
             if (offset<=value.length){
                 this.value=new char[0];
                 return;
             }

         }
         if (offset>value.length-count){
             throw new StringIndexOutOfBoundsException(offset);
         }
         this.value=Arrays.copyOfRange(value,offset,count+offset);
    }


    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        if (index>this.value.length||index<0){
            throw new StringIndexOutOfBoundsException(index);
        }
        return this.value[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        if(start<0){
            throw new StringIndexOutOfBoundsException(start);
        }
        if (end>value.length){
            throw new StringIndexOutOfBoundsException(end);
        }
        if (start>end){
            throw new StringIndexOutOfBoundsException("start index is bigger than end  index");
        }
        MyString result=new MyString(Arrays.copyOfRange(value,start,end));
        return result;
    }


    @Override
    public int compareTo(MyString o) {
       int len1=value.length;
       int len2=o.value.length;
       int lim=Math.min(len1,len2);
       char v1[]=value;
       char v2[]=o.value;
       int k=0;
       while(k<lim){
           char c1=v1[k];
           char c2=v2[k];
           if (c1!=c2){
               return c1-c2;
           }
           k++;
       }
       return len1-len2;
    }

    @Override
    public String toString() {
        return "MyString{" +
                "value=" + Arrays.toString(value) +
                '}';
    }

    public boolean equals(Object anObject){
        if (this==anObject){
            return true;
        }
        if (anObject instanceof MyString){
            MyString anotherString = (MyString) anObject;
            int n=value.length;
            if (n==anotherString.value.length){
                char v1[]=value;
                char v2[]=anotherString.value;
                int i=0;
                while (n--!=0){
                    if (v1[i]!=v2[i]){
                        return false;
                    }
                    i++;
                }
                return true;
            }
        }
        return false;
    }

    public boolean contains(CharSequence s){
          return false;
    }

    void getChars(char dst[],int dstBegin){
        System.arraycopy(value,0,dst,dstBegin,value.length);
    }
    public void getChars(int srcBegin,int srcEnd,@NotNull char dst[],int dstBegin){
        if (srcBegin<0){
            throw new StringIndexOutOfBoundsException(srcBegin);
        }
        if (srcEnd>value.length){
            throw new StringIndexOutOfBoundsException(srcEnd);
        }
        if (srcBegin>srcEnd){
            throw new StringIndexOutOfBoundsException(srcEnd-srcBegin);
        }
        System.arraycopy(value,srcBegin,dst,dstBegin,srcEnd-srcBegin);
    }
//    public String[] split(@NotNull String regex){
//        return split(regex,0);
//    }
    public MyString concat(@NotNull MyString str){
        int otherLen=str.length();
        if (otherLen==0) return this;
        int len =value.length;
        char buf[]=Arrays.copyOf(value,len+otherLen);
        str.getChars(buf,len);
        return new MyString(buf);
    }
    public boolean isEmpty(){
        return value.length==0;
    }
    public MyString substring(int beginIndex,int endIndex ){
          if (beginIndex<0)
              throw new StringIndexOutOfBoundsException(beginIndex);
          if (endIndex>value.length)
              throw new StringIndexOutOfBoundsException(endIndex);
          int subLen=endIndex-beginIndex;
          if (subLen<0)
              throw new StringIndexOutOfBoundsException(subLen);
          return ((beginIndex==0)&&(endIndex==value.length))?this:new MyString(value,beginIndex,subLen);
    }
    public MyString trim(){
        int len =value.length;
        int st=0;
        char[] val=value;
        while ((st<len)&&(val[st]<=' '))
            st++;
        while ((st<len)&&(val[len-1]<=' '))
            len--;
        return ((st>0)||(len<value.length))?substring(st,len):this;
    }
    public char[] toCharArray(){
        char [] result=new char[value.length];
        System.arraycopy(value,0,result,0,value.length);
        return result;
    }
}
