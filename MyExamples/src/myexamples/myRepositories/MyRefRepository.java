/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.myRepositories;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import myexamples.Entities.GetRefResponse;
import myexamples.Entities.GetRefScoredResponse;
import myexamples.Entities.RefEntity;
import myexamples.Entities.RefHitsEntity;
import myexamples.Entities.RefHitsSearchResponseEntity;
import static myexamples.MyExamples.httpclient;
import myexamples.PostResponseEntity;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author odzhara-ongom
 */
public class MyRefRepository {
    private static final String POST_STRING="http://localhost:9200/referenzer/reference";
    private static final String GET_STRING="http://localhost:9200/referenzer/reference/";
    private static final String GET_AlL_REF_STRING="http://localhost:9200/referenzer/reference/_search";
    private static Gson gson=new Gson();
    public static CloseableHttpClient httpclient;
    
    public static RefEntity readRefEntityFromDB(String id) throws IOException {
        RefEntity result = null;
        httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(GET_STRING+id);
            CloseableHttpResponse getResponse = httpclient.execute(httpGet);
            try {                
                HttpEntity entity1 = getResponse.getEntity();
                if (entity1 != null) {
                    long len = entity1.getContentLength();
                    if (len != -1 && len < 1024*1024) {
                  //      System.out.println(EntityUtils.toString(entity1));
                        GetRefResponse getRefResponse  = gson.fromJson(EntityUtils.toString(entity1),GetRefResponse.class);
                        if (getRefResponse!=null) result=getRefResponse.getSource();
                    } else {
                        System.out.println("Error!!!! entity length="+len);
                    }
                }
                EntityUtils.consume(entity1);
            } finally {
                getResponse.close();
            }            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        return result;
    }
    
    public static String insertRefEnityIntoDB(RefEntity refEntity)throws IOException {
        String result=null;
        httpclient = HttpClients.createDefault();
        try {
            StringEntity stringEntity= new StringEntity( gson.toJson(refEntity));
            HttpPost httppost = new HttpPost(POST_STRING);
            httppost.setEntity(stringEntity);
            CloseableHttpResponse postResponse = httpclient.execute(httppost);
            try {                
                HttpEntity postResponseEntity = postResponse.getEntity();
                if (postResponseEntity != null) {
                    long len = postResponseEntity.getContentLength();
                    if (len != -1 && len < 1024*1024) {
                  //      System.out.println(EntityUtils.toString(entity1));
                        PostResponseEntity pRE=gson.fromJson(EntityUtils.toString(postResponseEntity), PostResponseEntity.class);
                        if (pRE!=null) result=pRE.getId();
                    } else {
                        System.out.println("Error!!!! entity length="+len);
                    }
                }
                EntityUtils.consume(postResponseEntity);
            } finally {
                postResponse.close();
            }            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }       
        return result;
    }
    
    public static RefHitsSearchResponseEntity readAllRef() throws IOException  {
        RefHitsSearchResponseEntity result = new RefHitsSearchResponseEntity();
        httpclient = HttpClients.createDefault();
        try {
            HttpGet httpGet = new HttpGet(GET_AlL_REF_STRING);
            CloseableHttpResponse getResponse = httpclient.execute(httpGet);
            try {                
                HttpEntity entity1 = getResponse.getEntity();
                if (entity1 != null) {
                    long len = entity1.getContentLength();
                    if (len != -1 && len < 1024*1024) {
                  //      System.out.println(EntityUtils.toString(entity1));
                        result  = gson.fromJson(EntityUtils.toString(entity1),RefHitsSearchResponseEntity.class);                       
                    } else {
                        System.out.println("Error!!!! entity length="+len);
                    }
                }
                EntityUtils.consume(entity1);
            } finally {
                getResponse.close();
            }            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        return result;
    }
    
    public static List<RefEntity> readAllReferences() throws IOException {
        List<RefEntity> result = new ArrayList<RefEntity>();
        RefHitsSearchResponseEntity refHitsSearchResponseEntity = readAllRef();
        if (refHitsSearchResponseEntity!=null) {
            if (refHitsSearchResponseEntity.hits!=null){
                List <GetRefScoredResponse> rList=refHitsSearchResponseEntity.hits.getHits();
                for (GetRefScoredResponse r:rList) {
                    if (r!=null) result.add(r.getSource());
                }
            }
        }
        return result;
    }    
}
