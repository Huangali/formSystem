package com.formSysytem.util;




import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * @author U
 * @className: mongoUtil
 * @description: TODO
 * @date 2023/11/17 18:07
 */
//@PropertySource("classpath:application.yml")
public class MongoUtil {

//    @Value("{mongodb.host}")
//    private static String host;
//    @Value("{mongodb.port}")
//    private static int port;
//    @Value("{mongodb.database}")
    private static String database;

//   public static MongoDatabase getCollection(){
////        MongoClient mongoClient = new MongoClient(host,port);
////        MongoClient mongoClient = new MongoClient("localhost",27017);
////        MongoDatabase database = mongoClient.getDatabase("form");
////        return database;
//   }

}
