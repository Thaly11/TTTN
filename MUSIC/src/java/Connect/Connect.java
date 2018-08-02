/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;
import com.mongodb.util.JSON;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.types.ObjectId;
import org.json.*;

/**
 *
 * @author DELL
 */
public class Connect {

    public static List<TuDien> getTuDien() {

        Mongo mongo = new Mongo("localhost", 27017); //to establish a connection
        DB db = mongo.getDB("MUSIC");                // select the databse test

        Set<String> colls = db.getCollectionNames();  //get all the collection names in "test"

        for (String s : colls) {
            System.out.println(s);   //printing the collection names on to the console
        }
        DBCollection collection = db.getCollection("Tudien");

        DBCursor cursor = collection.find();
        JSON json = new JSON();
        String serialize = json.serialize(cursor);
        System.out.println(serialize);

        DBObject obj = cursor.next();
        obj.removeField("_id");
        System.out.println(obj);
        JSONObject obj2 = new JSONObject(obj.toString());
        JSONArray array = obj2.getJSONArray("tudien");
        List<TuDien> list = new ArrayList<TuDien>();

        for (int i = 0; i < array.length(); i++) {
            String tu = array.getJSONObject(i).get("tu").toString();
            float trongso = Float.parseFloat(array.getJSONObject(i).get("trongso").toString());
            int hatgiong = Integer.parseInt(array.getJSONObject(i).get("tuhatgiong").toString());
            list.add(new TuDien(tu, trongso, hatgiong));
        }

        return list;
    }

    public static List<Baihat> getMusics() {

        Mongo mongo = new Mongo("localhost", 27017); //to establish a connection
        DB db = mongo.getDB("MUSIC");                // select the databse test

        Set<String> colls = db.getCollectionNames();  //get all the collection names in "test"

        for (String s : colls) {
            System.out.println(s);   //printing the collection names on to the console
        }
        DBCollection collection = db.getCollection("Baihat");

        DBCursor cursor = collection.find();
        JSON json = new JSON();
        String serialize = json.serialize(cursor);

        int num = cursor.count();
        List<Baihat> list = new ArrayList<Baihat>();
        for (DBObject obj : cursor) {
            JSONObject obj2 = new JSONObject(obj.toString());
            JSONObject nhac = obj2.getJSONObject("nhac");
            JSONObject _id = obj2.getJSONObject("_id");
            String id = _id.get("$oid").toString();
            JSONArray binhluans = nhac.getJSONArray("binhluan");
            List<Comment> cmts = new ArrayList<Comment>();
            for (int i = 0; i < binhluans.length(); i++) {
                JSONObject binhluan = binhluans.getJSONObject(i);
                String email = binhluan.get("email").toString();
                String noiDung = binhluan.get("noidung").toString();
                String thoiGian = binhluan.get("thoigian").toString();
                cmts.add(new Comment(email, noiDung, thoiGian));
            }
            String khen = nhac.get("khen").toString();
            String che = nhac.get("che").toString();
            String ten = nhac.get("tenbaihat").toString();
            list.add(new Baihat(new ObjectId(id), cmts, Integer.parseInt(khen), Integer.parseInt(che), ten));
        }
        return list;
    }

    public static void main(String[] args) {

        List<Baihat> musics = getMusics();
        ModuleXtract xtract = new ModuleXtract();
        for (Baihat music : musics) {
            System.out.println(music.getName());
            int i = 1;
            int khen = music.getKhen();
            int che = music.getChe();
            System.out.println("Trước");
            System.out.println("khen: " + khen);
            System.out.println("chê: " + che);
            for (Comment cmt : music.getComments()) {
                System.out.println("comment " + i + ": " + cmt.getNoiDung());
                String tongthe = xtract.xTract(cmt.getNoiDung());
                i++;
                if ("Trung lập".equals(tongthe)) {
                    continue;
                }
                if ("Tích cực".equals(tongthe)) {
                    //System.out.println(a);
                    khen++;

                    continue;
                } else {

                    che++;
                    

                }

            }

            System.out.println("Sau");
            System.out.println("khen: " + khen);
            System.out.println("chê: " + che);
            // Cập nhật khen chê lại lên mongo
            Mongo mongo = new Mongo("localhost", 27017); //to establish a connection
            DB db = mongo.getDB("MUSIC");                // select the databse test

            DBCollection collection = db.getCollection("Baihat");
            DBObject whereClause = new BasicDBObject("_id", music.getId());
            DBObject values = new BasicDBObject();
            values.put("nhac.khen", khen);
            values.put("nhac.che", che);
            DBObject valuesWithSet = new BasicDBObject();
            valuesWithSet.put("$set", values);

            // Thực hiện việc update.
            WriteResult result = collection.update(whereClause, valuesWithSet);
            System.out.println("-------------------------------");
        }
    }

}
