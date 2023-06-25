package net.musecom.database;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapSessionFactory {
   public static SqlSessionFactory ssf;
   static {
	   String res = "net/musecom/database/mybatis-config.xml";
	   InputStream inputStream = null;
	   try {
  		  inputStream = Resources.getResourceAsStream(res);
	   } catch (IOException e) {
		  e.printStackTrace();
	   }
	   ssf = new SqlSessionFactoryBuilder().build(inputStream);
   }
   
   public static SqlSessionFactory getSqlSessionFactory() {
	   return ssf;
   }
   
}
