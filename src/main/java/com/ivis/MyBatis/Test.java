package com.ivis.MyBatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ivis.pojo.User;


public class Test 
{
    public static void main( String[] args ) throws IOException
    {
    	List<User> userlist =getSqlSession().selectList("com.ivis.pojo.User.mapper.getAllUser");
    	for (User user : userlist) {
    			System.out.println(user);
			}
    	User user =new User();
    	user.setUserId(777);
    	user.setUserName("1");
    	user.setUserEmail("77777777@qq.com");
    	int insert = getSqlSession().insert("com.ivis.pojo.User.mapper.insert",user);
    	System.out.println(insert);
    	getSqlSession().commit();
    	getSqlSession().close();
    	
    	
    		//希尔排序
    	    int[]a={49,38,65,97,76,13,27,49,78,34,12,64,1};
    	        System.out.println("排序之前：");
    	        for(int i=0;i<a.length;i++)
    	        {
    	            System.out.print(a[i]+" ");
    	        }
    	        //希尔排序
    	        int d=a.length;
    	            while(true)
    	            {
    	                d=d/2;
    	                for(int x=0;x<d;x++)
    	                {
    	                    for(int i=x+d;i<a.length;i=i+d)
    	                    {
    	                        int temp=a[i];
    	                        int j;
    	                        for(j=i-d;j>=0&&a[j]>temp;j=j-d)
    	                        {
    	                            a[j+d]=a[j];
    	                        }
    	                        a[j+d]=temp;
    	                    }
    	                }
    	                if(d==1)
    	                {
    	                    break;
    	                }
    	            }
    	            System.out.println();
    	            System.out.println("排序之后：");
    	                for(int i=0;i<a.length;i++)
    	                {
    	                    System.out.print(a[i]+" ");
    	                }
    }

	private static SqlSession getSqlSession() throws IOException {
		String resource="MyBatisConfig.xml";
		InputStream resourceAsReader = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsReader);
		SqlSession openSession = sqlSessionFactory.openSession();
		return  openSession;
	}
	
	
}
