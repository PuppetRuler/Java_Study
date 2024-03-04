package com.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * ClassName:SysUser
 * Description:
 * 1. 实体类的类名和表格名称应该对应 （对应不是一致）
 * 2. 实体类的属性名和表格的列名应该对应
 * 3. 每个属性都必须是私有的
 * 4. 每个属性都应该具备 getter setter 方法
 * 5. 必须具备无参构造器
 * 6. 应该实现序列化接口( 缓存 分布式项目传递数据 可能会将对象序列化 )
 * 7. 应该重写类的hasHash和equals方法
 * 8. toString是否重写都可以
 *
 *  使用 Lambok 帮助我们生成这些内容 getter setter 全参构造 无参构造 equals hashcode
 *      Lombo使用步骤
 *          1 检查idea是否已经安装类Lombok插件
 *          2 检查是否勾选上 enable annotation processing
 *          3 导入Lombok插件
 *          4 在实体类上添加注释
 *
 * @Author Sixty-three
 * @Create 2024/2/13 15:17
 * @Version 1.0
 */
@AllArgsConstructor // 添加类全参构造
@NoArgsConstructor // 添加了无参构造
@Data // getter setter equals hashcode toString
public class SysUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;
}
