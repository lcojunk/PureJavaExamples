/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.dbase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author odzhara-ongom
 */
public class MyHelpMethods {
    private static Gson gson = new Gson();
    private static Gson gsonPretty = new GsonBuilder().setPrettyPrinting().create();
    private static final String DEFAULT_CHARSET="UTF-8";
    private static final long MAX_CONTENT_LENGTH=1024*1024;
    public static Random random = new Random();
    public static Gson getGson() {return gson;}
    
    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randomInt(int min, int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }
    
    public static String randomNumericString(int n) {
        String result=""+(new Date()).getTime();
        for (int i=0; i<n; i++ )
            result+=randomInt(0, 9);
        return result;
    }
    
    
    public static void saveObject2File(Object o, String filename) {

        FileOutputStream fop = null;
        File file;
        String content = gson.toJson(o);

        try {

                file = new File(filename);
                fop = new FileOutputStream(file);

                // if file doesnt exists, then create it
                if (!file.exists()) {
                        file.createNewFile();
                }

                // get the content in bytes
                byte[] contentInBytes = content.getBytes();

                fop.write(contentInBytes);
                fop.flush();
                fop.close();

                System.out.println("Done");

        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                        if (fop != null) {
                                fop.close();
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
    }
    
    public static void save2File(Object r, String filename) {

        FileOutputStream fop = null;
        File file;
        String content = gsonPretty.toJson(r);

        try {

                file = new File(filename);
                fop = new FileOutputStream(file);

                // if file doesnt exists, then create it
                if (!file.exists()) {
                        file.createNewFile();
                }

                // get the content in bytes
                byte[] contentInBytes = content.getBytes();

                fop.write(contentInBytes);
                fop.flush();
                fop.close();

                System.out.println("Done");

        } catch (IOException e) {
                e.printStackTrace();
        } finally {
                try {
                        if (fop != null) {
                                fop.close();
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
    }
    
    public static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
    
    public static String object2PrettyString (Object o) { 
        if (o!=null) return gsonPretty.toJson(o);
        else return "null";
    }

    public static String object2GsonString (Object o) { 
        if (o!=null) return gson.toJson(o);
        else return "null";
    }
    
    public static String sendHttpRequest(String url, String requestBody, String requestType) throws IOException{
        String result = null;        
        CloseableHttpClient httpclient = HttpClients.createDefault();        
        CloseableHttpResponse httpResponse;
        try {
            switch (requestType) {
                case "Get":     httpResponse = httpclient.execute(new HttpGet(url));                        
                                break;
                case "Post":    HttpPost httppost = new HttpPost(url);
                                if (requestBody!=null)                                     
                                    httppost.setEntity(new StringEntity(requestBody,DEFAULT_CHARSET));                                                                    
                                httpResponse = httpclient.execute(httppost);                        
                                break;
                case "Put":     HttpPut httpPut = new HttpPut(url);
                                httpPut.addHeader("Content-Type", "application/json");
                                httpPut.addHeader("Accept", "application/json");
                                if (requestBody!=null)                                     
                                    httpPut.setEntity(new StringEntity(requestBody,DEFAULT_CHARSET));
                                httpResponse = httpclient.execute(httpPut);                        
                                break;
                case "Delete":  httpResponse = httpclient.execute(new HttpDelete(url));                        
                                break;
                default:        httpResponse = httpclient.execute(new HttpGet(url));                        
                                break;
            }
            try {                
                HttpEntity entity1 = httpResponse.getEntity();
                if (entity1 != null) {
                    long len = entity1.getContentLength();
                    if (len != -1 && len < MAX_CONTENT_LENGTH) {
                        result  = EntityUtils.toString(entity1,DEFAULT_CHARSET);
                    } else {
                        System.out.println("Error!!!! entity length="+len);
                    }
                }
                EntityUtils.consume(entity1);
            } finally {
                httpResponse.close();
            }            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        return result;        
    }

public static String sendHttpRequest2(String url, String requestBody, String requestType) throws IOException{
        String result = null;        
        CloseableHttpClient httpclient = HttpClients.createDefault();        
        CloseableHttpResponse httpResponse;
        try {
            switch (requestType) {
                case "Get":     httpResponse = httpclient.execute(new HttpGet(url));                        
                                break;
                case "Post":    HttpPost httppost = new HttpPost(url);
                                if (requestBody!=null)                                     
                                    httppost.setEntity(new StringEntity(requestBody));                                                                    
                                httpResponse = httpclient.execute(httppost);                        
                                break;
                case "Put":     HttpPut httpPut = new HttpPut(url);
                                httpPut.addHeader("Content-Type", "application/json");
                                httpPut.addHeader("Accept", "application/json");
                                if (requestBody!=null)                                     
                                    httpPut.setEntity(new StringEntity(requestBody,DEFAULT_CHARSET));
                                httpResponse = httpclient.execute(httpPut);                        
                                break;
                case "Delete":  httpResponse = httpclient.execute(new HttpDelete(url));                        
                                break;
                default:        httpResponse = httpclient.execute(new HttpGet(url));                        
                                break;
            }
            try {                
                HttpEntity entity1 = httpResponse.getEntity();
                if (entity1 != null) {
                    long len = entity1.getContentLength();
                    if (len != -1 && len < MAX_CONTENT_LENGTH) {
                        result  = EntityUtils.toString(entity1,DEFAULT_CHARSET);
                    } else {
                        System.out.println("Error!!!! entity length="+len);
                    }
                }
                EntityUtils.consume(entity1);
            } finally {
                httpResponse.close();
            }            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.close();
        }
        return result;        
    }    
    
        public static String hashMap2String(HashMap hm) {
        return MyHelpMethods.object2GsonString(hm);
    }

}
