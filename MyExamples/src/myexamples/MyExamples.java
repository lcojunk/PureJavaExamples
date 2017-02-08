/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import myexamples.Entities.RefEntity;
import myexamples.sorting.SortingExample;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author odzhara-ongom
 */
public class MyExamples {

    public static CloseableHttpClient httpclient;
    public static Gson gson = new Gson();

    public static void getExample() throws IOException {
        HttpGet httpGet = new HttpGet("http://localhost:9200/gb/tweet/9");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        // The underlying HTTP connection is still held by the response object
        // to allow the response content to be streamed directly from the network socket.
        // In order to ensure correct deallocation of system resources
        // the user MUST call CloseableHttpResponse#close() from a finally clause.
        // Please note that if response content is not fully consumed the underlying
        // connection cannot be safely re-used and will be shut down and discarded
        // by the connection manager.
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            if (entity1 != null) {
                long len = entity1.getContentLength();
                if (len != -1 && len < 2048) {
                    System.out.println(EntityUtils.toString(entity1));
                } else {
                    System.out.println("entity length=" + len);
                }
            }

            EntityUtils.consume(entity1);
        } finally {
            response1.close();
        }
    }

    public static String getTweet() throws IOException {
        String result = "";
        HttpGet httpGet = new HttpGet("http://localhost:9200/gb/tweet/9");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
        // The underlying HTTP connection is still held by the response object
        // to allow the response content to be streamed directly from the network socket.
        // In order to ensure correct deallocation of system resources
        // the user MUST call CloseableHttpResponse#close() from a finally clause.
        // Please note that if response content is not fully consumed the underlying
        // connection cannot be safely re-used and will be shut down and discarded
        // by the connection manager.
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            if (entity1 != null) {
                long len = entity1.getContentLength();
                if (len != -1 && len < 2048) {
                    //      System.out.println(EntityUtils.toString(entity1));
                    result = EntityUtils.toString(entity1);
                } else {
                    System.out.println("entity length=" + len);
                }
            }

            EntityUtils.consume(entity1);
        } finally {
            response1.close();
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("myexamples.MyExamples.main()");
        new SortingExample().run();
    }

    private static void sometest() throws IOException, ParseException, JsonSyntaxException {
        String tweetString = "";
        RefEntity refEntity = new RefEntity();
        String refEntityString = gson.toJson(refEntity);
        httpclient = HttpClients.createDefault();
        try {
            //getExample();
            tweetString = getTweet();
            StringEntity stringEntity = new StringEntity(refEntityString);
            HttpPost httppost = new HttpPost("http://localhost:9200/referenzer/reference");
            httppost.setEntity(stringEntity);
            CloseableHttpResponse response1 = httpclient.execute(httppost);
            System.out.println("responseStatus=" + response1.getStatusLine());
            PostResponseEntity pRE = gson.fromJson(EntityUtils.toString(response1.getEntity()), PostResponseEntity.class);
            System.out.println(pRE.toString(1));
            //System.out.println("response="+EntityUtils.toString(response1.getEntity()));
        } finally {
            httpclient.close();
        }

        System.out.println(tweetString);

        Gson gson = new Gson();
        TweetResponse tweetResponse = gson.fromJson(tweetString, TweetResponse.class);
        System.out.println(tweetResponse.toString(1));

        System.out.println(refEntityString);
    }

}
