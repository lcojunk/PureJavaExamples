/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.dbase;



/**
 *
 * @author odzhara-ongom
 */
public class LOB {
    private String id;
    private String name;
    private String description;

    public LOB() {
        id=MyHelpMethods.randomNumericString(16);
    }

    public LOB(String id) {
        this.id = id;
    }

    public LOB(String name, String description) {
        id=MyHelpMethods.randomNumericString(16);
        this.name = name;
        this.description = description;
    }

    public LOB(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
