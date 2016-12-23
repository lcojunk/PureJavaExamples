/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.dbase;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author odzhara-ongom
 */
public class AllLobs {
    private static AllLobs instance;
    private List <LOB> lobs;
    
    private AllLobs() {
        lobs=new ArrayList<LOB>();
        addLOB(createDefaultLOB());
    }
    
    private LOB createDefaultLOB(){
        return new LOB("Test LOB","New created Line Of Bussness");
    }
    
    public static AllLobs getInstance(){
        if (instance == null)
        {instance = new AllLobs();}
        return instance;
    }
    
    public String addLOB(LOB l) {
        l.setId(MyHelpMethods.randomNumericString(16));
        lobs.add(l);
        return l.getId();
    }
    
    public LOB getLOB(String id) {
        LOB result=null;
        for (LOB l:lobs) 
            if(l.getId()!=null)
                if (l.getId().compareTo(id)==0) return l;
        return result;
    }
    
    public boolean updateLOB(LOB lob) {
        if (lob==null) return false;
        if (lob.getId()==null) return false;
        LOB l=null;
        for (int i=0; i<lobs.size(); i++){ 
            l=lobs.get(i);
            if(l.getId()!=null)
                if (l.getId().compareTo(lob.getId())==0) {
                    lobs.set(i, lob);
                    return true;
                }
        }
        return false;
    }
    
    public boolean deleteLOB(LOB lob){
        if (lob==null) return false;
        if (lob.getId()==null) return false;
        LOB l=null;
        for (int i=0; i<lobs.size(); i++){ 
            l=lobs.get(i);
            if(l.getId()!=null)
                if (l.getId().compareTo(lob.getId())==0) {
                    lobs.remove(i);
                    return true;
                }
        }
        return false;
    }

    public boolean deleteLOB(String id){        
        if (id==null) return false;
        return deleteLOB(new LOB(id));
    }
    
    
    public List <LOB> getLOBs() {
        return lobs;
    }
}
