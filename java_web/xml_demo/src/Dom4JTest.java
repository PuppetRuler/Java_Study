import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;

/**
 * ClassName:Dom4JTest
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/10 2:00
 * @Version 1.0
 */
public class Dom4JTest {
    @Test
    public void ReadTest() throws DocumentException {
        // 读取jdbc.xml配置文件，获得document对象
        SAXReader saxReader = new SAXReader();
        // 通过类加载器获得指向字节码根路径下的指定文件的输入流
        InputStream resourceAsStream = Dom4JTest.class.getClassLoader().getResourceAsStream("jdbc.xml");
        // 通过输入流获得配置文件解析成一个dom对象
        Document document = saxReader.read(resourceAsStream);
        // 从document对象上获取鹿配置文件中的信息
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
        // 获取元素下方的子元素
        for (Element element : rootElement.elements()) {
            System.out.print("\t"+element.getName());
            // 从元素上获取属性
            Attribute idAttribute = element.attribute("id");
            System.out.println("\t"+idAttribute.getName()+"="+idAttribute.getValue());
            // 继续获取元素下方的子元素
            for (Element element1 : element.elements()) {
                System.out.println("\t\t"+element1.getName()+"="+element1.getText());
            }

        }

    }
}
