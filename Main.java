package Main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;


public class Main {

    public static BigDecimal fac(int num){
        int i;
        BigDecimal result=new BigDecimal(1);
        for (i=2;i<=num;i++){
            result=result.multiply(new BigDecimal(i));
        }
        return result;
    }
    public static BigDecimal pow(int c){
        BigDecimal r=new BigDecimal(-0.25);
        int i;
        for (i=0;i<c;i++){
            r=r.multiply(r);
        }
        return r;
    }
    public static BigDecimal Count(int num,int pre,boolean v){
        int i;
        BigDecimal result=new BigDecimal(0.5);
        for (i=1;i<num;i++){
            result=result.multiply(BigDecimal.valueOf(0.5 - i));
        }
        BigDecimal p;
        if (v){
            p= BigDecimal.valueOf(0.5);
            p=p.pow(2*num+1);
            result=result.multiply(p);
            result=result.divide(BigDecimal.valueOf(2*num+1),pre, RoundingMode.HALF_UP);}
        else{
            p= BigDecimal.valueOf(-0.25);
            p=p.pow(num);
            result=result.multiply(p);
        }
        result=result.divide(fac(num),pre, RoundingMode.HALF_UP);

        System.out.println(result);
        return result;
    }

    public static BigDecimal three(int pre){
        int i;
        BigDecimal re=new BigDecimal(1);
        BigDecimal t;
        for (i=1;i<=pre;i++){
            t=Count(i,pre,false);
            re=re.add(t);
            System.out.println("j="+i);
        }
        re=re.multiply(BigDecimal.valueOf(2));
        return re;
    }
    public static void main(String[] args){
        BigDecimal re=new BigDecimal(0.5);
        System.out.println("请输入计算精度：");
        Scanner input = new Scanner(System.in);
        int pre = input.nextInt();
        int i;
        BigDecimal t;
        int pre_b=pre;//小数精度
        for (i=1;i<=pre;i++){
            t=Count(i,pre_b,true);
            re=re.subtract(t.abs());
            System.out.println("i="+i);
        }
        BigDecimal th=three(pre_b);
        System.out.println("√3="+th);
        re=re.subtract(th.multiply(BigDecimal.valueOf(0.125)));
        re=re.multiply(BigDecimal.valueOf(12));
        System.out.println("π="+re);
    }
}
