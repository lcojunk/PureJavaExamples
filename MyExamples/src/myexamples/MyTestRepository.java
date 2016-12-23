/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import myexamples.Entities.GetRefResponse;
import myexamples.Entities.GetRefScoredResponse;
import myexamples.Entities.RefEntity;
import myexamples.Entities.RefHitsEntity;
import myexamples.Entities.RefHitsSearchResponseEntity;
import myexamples.Entities.ShardsEntity;
import myexamples.myRepositories.MyRefRepository;

/**
 *
 * @author odzhara-ongom
 */
public class MyTestRepository {
    static Gson gson=new Gson(); 
    public static void testsomething(){
        RefHitsEntity rhe= new RefHitsEntity();
        ArrayList <GetRefScoredResponse> reList=new  ArrayList <GetRefScoredResponse>();
        for (int i=0; i<3; i++) reList.add(new GetRefScoredResponse());
        rhe.setHits(reList);
        RefHitsSearchResponseEntity rhsr= new RefHitsSearchResponseEntity();
        rhsr._shards= new ShardsEntity();
        rhsr.hits=rhe;
        System.out.println(rhsr.toString(1));
        System.out.println(gson.toJson(rhsr));
        //System.out.println(gson.toJson(new GetRefResponse()));
 //       System.out.println((new GetRefResponse()).toString(1));       
    }
    
    public static void main(String[] args) throws IOException {
        String refID="AU12ZA9jW8pxTvC2MyAC";
        RefEntity re=MyRefRepository.readRefEntityFromDB(refID);
        System.out.println(re.toString(1));
        System.out.println("-------------------------");
        System.out.println(MyRefRepository.readAllRef().toString(1));
        System.out.println("===========================");
        List<RefEntity> rList = MyRefRepository.readAllReferences();
        for (RefEntity e: rList) System.out.println(e.toString(1));
        System.out.println("Total:"+rList.size());
  /*      
        RefEntity refTMP;
        for (int i=0; i<10; i++) {
            refTMP=new RefEntity();
            refTMP.setRefContent("This referense Nr."+i+" was created on"+(new Date()).toGMTString());
            System.out.println(MyRefRepository.insertRefEnityIntoDB(refTMP));            
        }
    */    
        
                
    }
}
