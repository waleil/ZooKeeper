package org.example.typefilter;

import org.example.config.District;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.ClassUtils;
import org.springframework.util.PathMatcher;

import java.util.Properties;


/**
 * @Auther: csx
 * @Date: 2021/12/9 23:05
 * 自定义扫描规则过滤器
 */

public class DistrictTypeFilter extends AbstractTypeHierarchyTraversingFilter {
    //定义路径校验对象
    private PathMatcher pathMatcher;

    //定义区域名称  注意：此处的数据，应该是读取配置文件获取的；此处不能使用@value注解读取properties配置文件的内容
    //因为负责填充属性的InstantiationAwareBeanPostProcessor与TypeFilter实例创建根本不搭边
    private String districtName;


    protected DistrictTypeFilter() {
        //调用父类的构造函数
        //第一个参数，不考虑基类，第二个参数，不考虑接口上的信息
        super(false, false);

        //借助Spring默认的Resource通配符路径方式
        pathMatcher = new AntPathMatcher();

        //读取配置文件（硬编码）
        try{
            Properties properties = PropertiesLoaderUtils.loadAllProperties("district.properties");
            //给districtName复制
            districtName = properties.getProperty("common.distirct.name");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /***
     * 本类将注册为Exclude,返回true标识拒绝
     */
    @Override
    protected boolean matchClassName(String className){
        try {
            //判断是否在指定包下的类（只处理和区域相关的业务类）
            if (!isPotentialPackageClass(className)){
                 //不符合路径规则
                return false;
            }

            //判断当前区域和配置的区域是否一致，不一致则不能注册到springde IOC容器中
            Class<?> clazz = ClassUtils.forName(className, DistrictTypeFilter.class.getClassLoader());
            //获取District注解
            District district = clazz.getAnnotation(District.class);
            if (district == null){
                return false;
            }
            //取出注解属性
            String districtValue = district.value();
            //校验，如果取出的value属性的值和配置文件中提供值一致，则注册到IOC容器中，返回ture,否则返回false

            return (!districtName.equalsIgnoreCase(districtValue));
        } catch (ClassNotFoundException e) {
           throw new RuntimeException();
        }
    }
    //定义可以处理类的类名，指定的package下的
    private static  final String PATTERN_STANDARD = ClassUtils.convertClassNameToResourcePath("org.example.service.*.*");

    //本类逻辑中可以处理的类
    private boolean isPotentialPackageClass(String className) {
        //1.将类名转换成为资源路径，以匹配是否符合扫描条件
        String path = ClassUtils.convertClassNameToResourcePath(className);
        //2校验
        return pathMatcher.match(PATTERN_STANDARD, path);

    }

}
