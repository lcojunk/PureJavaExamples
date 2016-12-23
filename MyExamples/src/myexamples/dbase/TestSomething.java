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
public class TestSomething {
   
    
    public static void testLOBGUI(){
        AllLobs allLobs=AllLobs.getInstance();
        int n=6;
        String lobsID[]=new String [n];
        for (int i=0; i<n; i++)
            lobsID[i]=allLobs.addLOB(new LOB("LOB #"+i," Test LOB"));
        
        LOB updateLOB= new LOB(lobsID[n-2],"LOB #"+(n-2)+"updated", " Updated Test LOB");
        System.out.println("Update LOB #"+(n-2)+": "+allLobs.updateLOB(updateLOB));
        System.out.println("Deleting LOB #"+(n-1)+": "+allLobs.deleteLOB(lobsID[n-1]));
        System.out.println("Update not existing LOB: "+allLobs.updateLOB(new LOB()));
        System.out.println("Deleting not existing LOB: "+allLobs.deleteLOB(" "));        
        //System.out.println(MyHelpMethods.object2PrettyString(allLobs));
        AllLobsDialog dialog= new AllLobsDialog( new javax.swing.JFrame(),allLobs.getLOBs(), true);
        dialog.setVisible(true);
    }
    
    public static void runMain(String[] args) {
        System.out.println("TestSomething.class");
 //       Key key = MacProvider.generateKey();
 //       System.out.println(MyHelpMethods.object2GsonString(key));
 //       String s= MyHelpMethods.object2GsonString(key);
 //       Key key2=MyHelpMethods.getGson().fromJson(s, Key.class);
        //System.out.println(MyHelpMethods.object2GsonString(key));
        
        testLOBGUI();
        

/*        
        LDAPUser user= new LDAPUser("user1","pass1");
        String s1="";
        try {
            s1 = MyHelpMethods.sendHttpRequest("http://localhost:9098/authenticate", 
                    MyHelpMethods.object2GsonString(user), "Post");
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        System.out.println(s1);
*/        
       //HttpsClient.runMain(args);
       //CreateSomeUsers.createAndSetSomeUsers(15);
           /*       try {
            SearchAllElasticUserReply searchAllElasticUserReply = ElasticUserRepository.readAllUserEntityFromDB();
            //System.out.println( MyHelpMethods.object2PrettyString(searchAllElasticUserReply));
            ElasticUser [] userArray =getElasticUsersFromElasticReply(searchAllElasticUserReply);
            for (int i=0; i<userArray.length; i++){
            System.out.println(MyHelpMethods.object2GsonString(userArray[i]));
            }
            } catch (Exception e) {
            }
            */       //for (int i=0; i<10; i++) System.out.println(MyDummyDatabase.getRandomName()+" "+MyDummyDatabase.getRandomSurName()+"\n"+MyDummyDatabase.getRandomAddress());
            
            
            
            
            //System.out.println(getSuggestion("tisch",10));
            //System.out.println(MyHelpMethods.object2PrettyString(getShardsExample(getSuggestion("tisch",10))));
            //List<String> sList=getSuggestedWords("tis",10);
            // List<String> sList=DictionarySuggestions.getSuggestedWordsList("tis","10");
            // for (String s:sList) System.out.println(s);
            
            // System.out.println(MyHelpMethods.object2PrettyString(new EStringType()));
            
            //System.out.println(MyHelpMethods.object2PrettyString(createTweetMapping()));        

       
       
    }
}
