/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.Entities;

/**
 *
 * @author odzhara-ongom
 */
public class GetObjectScoredResponse {
    private String _index;
    private String _type;
    private String _id;
    private double _score;


    public String getIndex() {
        return _index;
    }

    public void setIndex(String _index) {
        this._index = _index;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public double getScore() {
        return _score;
    }

    public void setScore(double _score) {
        this._score = _score;
    }


    
    
    public String toString(int art) {
        String result = "";
        switch (art) {
            case 0: result=this.toString(); break;
            case 1: result+="Index="+_index+"\n";
                    result+="Type="+_type+"\n";
                    result+="Id="+_id+"\n";
                    result+="_score="+_score+"\n";
                    break;
            default : break;
        }
        return result;
    }    
}
