/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.*;

/**
 *
 * @author DELL
 */
public class Connect {
     public static void main(String[] args) {
       
          Mongo mongo=new Mongo("localhost",27017); //to establish a connection
          DB db=mongo.getDB("MUSIC");                // select the databse test

         Set<String> colls=db.getCollectionNames();  //get all the collection names in "test"

         for(String s:colls)
	 System.out.println(s);   //printing the collection names on to the console
         DBCollection collection = db.getCollection("Tudien");
   
        DBCursor cursor = collection.find();
        JSON json =new JSON();
        String serialize = json.serialize(cursor);
        System.out.println(serialize);
        
        DBObject obj = cursor.next();
        obj.removeField("_id");
         System.out.println(obj);
        JSONObject obj2 = new JSONObject(obj.toString());
        JSONArray array = obj2.getJSONArray("emotion");
        List<TuDien> list = new ArrayList<TuDien>();
        
        for(int i = 0;i<array.length();i++){
            String tu = array.getJSONObject(i).get("tu").toString();
            float trongso = Float.parseFloat(array.getJSONObject(i).get("trongso").toString());
            int hatgiong = Integer.parseInt(array.getJSONObject(i).get("tuhatgiong").toString());
            list.add(new TuDien(tu,trongso,hatgiong));
        }System.out.println(list.get(0).getTu()+" "+list.get(0).getTrongSo());
        



    
        }
    
    
}
