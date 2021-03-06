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
public class TweetResponse {
    private String _index;
    private String _type;
    private String _id;
    private long _version;
    private boolean found;
    private TweetEntity _source;

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

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public TweetEntity getSource() {
        return _source;
    }

    public void setSource(TweetEntity _source) {
        this._source = _source;
    }
    
    public String toString(int art) {
        String result = "";
        switch (art) {
            case 0: result=this.toString(); break;
            case 1: result+="Index="+_index+"\n";
                    result+="Type="+_type+"\n";
                    result+="Id="+_id+"\n";
                    result+="Version="+_version+"\n";
                    result+="Found="+found+"\n";
                    result+="-----Tweet----\n"+_source.toString(1)+"\n";
                    break;
            default : break;
        }
        return result;
    }
}
