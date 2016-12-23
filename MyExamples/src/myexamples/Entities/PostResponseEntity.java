/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

/**
 *
 * @author odzhara-ongom
 */
public class PostResponseEntity {
    private String _index;
    private String _type;
    private String _id;
    private long _version;
    private boolean created;

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

    public long getVersion() {
        return _version;
    }

    public void setVersion(long _version) {
        this._version = _version;
    }

    public boolean isCreated() {
        return created;
    }

    public void setCreated(boolean created) {
        this.created = created;
    }
    
    public String toString(int art) {
        String result = "";
        switch (art) {
            case 0: result=this.toString(); break;
            case 1: result+="ID="+_id+"\n";
                    result+="Index="+_index+"\n";
                    result+="Type="+_type+"\n";
                    result+="Version="+_version+"\n";
                    result+="Created="+created+"\n";
                    break;
            default : break;
        }
        return result;
    }    
}
