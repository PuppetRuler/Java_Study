/**
 * ClassName:PersonTest
 * Description:
 * ① 使用满参构造方法创建Person对象，生命值传入一个负数
 * 由于一旦遇到异常,后面的代码的将不在执行,所以需要注释掉上面的代码
 * ② 使用空参构造创建Person对象
 * 调用setLifeValue(int lifeValue)方法,传入一个正数,运行程序
 * 调用setLifeValue(int lifeValue)方法,传入一个负数,运行程序
 * ③ 分别对①和②处理异常和不处理异常进行运行看效果
 *
 * @Author Sixty-three
 * @Create 2024/1/1 18:55
 * @Version 1.0
 */
public class PersonTest {
    public static void main(String[] args) {
        try {
            Person yaso = new Person("yaso", -8);
            System.out.println(yaso);
        }catch (NoLifeValueException e){
            System.out.println(e.getMessage());
        }
    }
}
