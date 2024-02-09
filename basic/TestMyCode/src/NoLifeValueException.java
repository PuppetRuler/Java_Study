/**
 * ClassName:NoLifeValueException
 * Description:
 * （1）自定义异常类NoLifeValueException继承RuntimeException
 *      ①提供空参和有参构造
 *      ②在有参构造中，需要调用父类的有参构造，把异常信息传入
 *
 * @Author Sixty-three
 * @Create 2024/1/1 18:46
 * @Version 1.0
 */
public class NoLifeValueException extends RuntimeException {
    public NoLifeValueException(String message) {
        super(message);
    }

    public NoLifeValueException() {
    }
}
