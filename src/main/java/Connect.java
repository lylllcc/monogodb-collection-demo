import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jaxlying on 2016/11/4.
 */
public class Connect {

    public static void main(String[] args) {

        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
            System.out.println("连接成功");



//            创建结合
//            mongoDatabase.createCollection("mongotest");
//            System.out.println("集合创建成功");

//            选择集合
            MongoCollection<Document> collection = mongoDatabase.getCollection("monogotest");
            System.out.println("选择集合 monogotest");

//            插入一条文档
//            Document document = new Document("name","liuyang");
//            collection.insertOne(document);


//            插入多条文档
//            Document document = new Document("a","liu").append("age","11").append("nn","23");
//            List<Document> list = new ArrayList<Document>();
//            list.add(document);
//            collection.insertMany(list);

//            检索文档
            FindIterable<Document> iterable = collection.find();
            MongoCursor<Document> cursor = iterable.iterator();
            while(cursor.hasNext()){
                System.out.println(cursor.next());
            }

//            更新文档
//            collection.updateMany(Filters.eq("name","liuyang"),new Document("$set",new Document("name","lalala")));

            //删除符合条件的第一个文档
            collection.deleteOne(Filters.eq("name", "lala"));
            //删除所有符合条件的文档
            collection.deleteMany (Filters.eq("name", "ad"));

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
