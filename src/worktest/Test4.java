package worktest;

/**
 * 设计类A和A的派生类B，要求：
 * 1）A有两个数据成员a和b（都为int型）；B中继承了A中的a和b，又定义了自己的数据成员c（int型）。
 * 2）为A添加含有两个参数的构造方法，对a和b初始化。
 * 3）为B添加含有一个参数的构造方法，对c初始化。
 * 4）完成主控方法，在主控方法中用B e1=new B(5)创建对象，把a、b、c分别初始化成3、4、5，最后输出它们的和。
 *
 * @author ZhengJiawei
 * @date 2020-04-20 12:02 上午
 */
public class Test4 {

    public static void main(String[] args) {
        B b = new B(3, 4, 5);
        System.out.println(b.sum());
    }

}

class A{
    protected int a;
    protected int b;

    public A(int a, int b){
        this.a = a;
        this.b = b;
    }
}

class B extends A{
    protected int c;

    public B(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    public int sum(){
        return a + b + c;
    }
}
