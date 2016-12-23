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
public class GetRefScoredResponse extends GetObjectScoredResponse{
    private RefEntity _source = new RefEntity();

    public RefEntity getSource() {
        return _source;
    }

    public void setSource(RefEntity _source) {
        this._source = _source;
    }

    public String toString(int art) {
        String result=super.toString(art);
        result+=_source.toString(art);
        return result;
    }
    
}
