/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.lambda;

import java.util.Date;

/**
 *
 * @author odzhara-ongom
 */
public class DummyArticle {
    private Integer id;
    private String titel;
    private Date created;
    private String mainText;
    private DummyPerson autor;    
    
    public static String toString(DummyArticle a){
        if(a==null) return "null";
        return "id="+a.id+"; titel='"+a.getTitel()+"'; created="+a.getCreated()+
                ";\n"+a.getMainText()+"\nAutor: "+DummyPerson.toString(a.getAutor());
    }
    
    public DummyArticle() {
    }

    public DummyArticle(Integer id, String titel, Date created, String mainText, DummyPerson autor) {
        this.id = id;
        this.titel = titel;
        this.created = created;
        this.mainText = mainText;
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public DummyPerson getAutor() {
        return autor;
    }

    public void setAutor(DummyPerson autor) {
        this.autor = autor;
    }
    
    
}
