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
public class RefHitsSearchResponseEntity {
    public double took;
    public boolean time_out;
    public ShardsEntity _shards=new ShardsEntity();
    public RefHitsEntity hits=new RefHitsEntity();
    
    public String toString(int art) {
        String result = "";
        switch (art) {
            case 0: result=this.toString(); break;
            case 1: result+="took="+took+"\n";
                    result+="time_out="+time_out+"\n";
                    result+="_shards:\n"+_shards.toString(art)+"\n";
                    result+="hits:\n"+hits.toString(art)+"\n";                    
                    break;
            default : break;
        }
        return result;
    }

}
