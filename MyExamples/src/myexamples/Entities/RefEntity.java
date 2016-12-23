/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.Entities;

import java.util.Date;

/**
 *
 * @author odzhara-ongom
 */
public class RefEntity extends MyPOJO {
    private String ref_id="no id";
    private String refContent="No Content now";
    private String owner_id="no id";
    private String date= (new Date()).toGMTString();
    private int refStatus=0;

    public String getRef_id() {
        return ref_id;
    }

    public void setRef_id(String ref_id) {
        this.ref_id = ref_id;
    }

    public String getRefContent() {
        return refContent;
    }

    public void setRefContent(String refContent) {
        this.refContent = refContent;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(String owner_id) {
        this.owner_id = owner_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRefStatus() {
        return refStatus;
    }

    public void setRefStatus(int refStatus) {
        this.refStatus = refStatus;
    }
    
    public String toString(int art) {
        String result = "";
        switch (art) {
            case 0: result=this.toString(); break;
            case 1: result+="ID="+ref_id+"\n";
                    result+="Owner="+owner_id+"\n";
                    result+="Status="+refStatus+"\n";
                    result+="Date="+date+"\n";
                    result+="Content="+refContent+"\n";
                    break;
            default : break;
        }
        return result;
    }
}
