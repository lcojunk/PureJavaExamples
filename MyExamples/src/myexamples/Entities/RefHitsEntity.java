/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author odzhara-ongom
 */
public class RefHitsEntity extends HitsEntity{
    private List <GetRefScoredResponse> hits=new ArrayList<GetRefScoredResponse>();

    public List<GetRefScoredResponse> getHits() {
        return hits;
    }

    public void setHits(List<GetRefScoredResponse> hits) {
        this.hits = hits;
    }
    
        public String toString(int art) {
        String result=super.toString(art)+"hits:\n";
        for (GetRefScoredResponse re:hits) result+=re.toString(art);
        return result;
    }

}
