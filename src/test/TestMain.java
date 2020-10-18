package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.domain.Employee;



//测试类
public class TestMain {
	public static void main(String[] args) throws IOException {
		//1.读取配置文件xml为二进制数据
		InputStream inputStream=Resources.getResourceAsStream("SqlMapConfig.xml");
		
		//2.获取SessionFactory工厂对象
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//3.获取session对象(包含操作数据库的api)
		SqlSession sqlSession=sessionFactory.openSession();
		
		//4.操作数据
		Employee employee1=sqlSession.selectOne("employee.select_ById",2);
		System.out.println(employee1);
		
		sqlSession.close();
	}
}
