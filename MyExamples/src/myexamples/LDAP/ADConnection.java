/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.LDAP;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author odzhara-ongom
 */
public class ADConnection {
    private DirContext dirContext;
    private Properties properties;
    
    public String testfield;

    public DirContext getDirContext() {
        return dirContext;
    }

    public Properties getProperties() {
        return properties;
    }
    
    public ADConnection (){}
    
    public ADConnection(String username, String password, String domainController) {
        properties = new Properties();        

        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        properties.put(Context.PROVIDER_URL, "LDAP://" + domainController);
        properties.put(Context.SECURITY_PRINCIPAL, username + "@" + domainController);
        properties.put(Context.SECURITY_CREDENTIALS, password);
        
        //initializing active directory LDAP connection
        try {
            dirContext = new InitialDirContext(properties);
        } catch (NamingException e) {
            //LOG.severe(e.getMessage());
            System.err.println("Error by starting connection");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } finally {
            closeLdapConnection();
        }
    }
    
    public static boolean testUserByUsernamePassDCSimple(String username, String password, String domainController) {
        boolean result=false;
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        properties.put(Context.PROVIDER_URL, "LDAP://" + domainController);
        properties.put(Context.SECURITY_PRINCIPAL, username + "@" + domainController);
        properties.put(Context.SECURITY_CREDENTIALS, password);
        DirContext dirContext=null;
        //initializing active directory LDAP connection
        try {
            dirContext = new InitialDirContext(properties);
            result=true;
        } catch (NamingException e) {
            //LOG.severe(e.getMessage());
//            System.err.println("Error by starting connection");
//            System.err.println(e.getMessage());
//            e.printStackTrace();
        } finally {
            closeLdapConnection(dirContext);
        }
        return result;
    }
    
    public static boolean testUserByUsernamePassDC(String username, String password, String domainController) {
        boolean result=false;
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        properties.put(Context.PROVIDER_URL, "LDAP://" + domainController);
        properties.put(Context.SECURITY_PRINCIPAL, username + "@" + domainController);
        properties.put(Context.SECURITY_CREDENTIALS, password);
        DirContext dirContext=null;
        //initializing active directory LDAP connection
        try {
            dirContext = new InitialDirContext(properties);
            result=true;
        }
        catch (javax.naming.AuthenticationException e) {
            System.out.println("Authentication Error");
        }
        catch (javax.naming.CommunicationException e) {
            System.out.println("Communication Error");
        }
        catch (NamingException e) {
            //LOG.severe(e.getMessage());
//            System.err.println("Error by starting connection");
//            System.err.println(e.getMessage());
//            e.printStackTrace();
            System.out.println(e.getClass().toString());
        } finally {
            closeLdapConnection(dirContext);
        }
        return result;
    }
    
    /**
     * closes the LDAP connection with Domain controller
     */
    public void closeLdapConnection(){
        try {
            if(dirContext != null)
                dirContext.close();
        }
        catch (NamingException e) {
        	//LOG.severe(e.getMessage());            
            System.err.println("Error by closing connection");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static void closeLdapConnection(DirContext dirContext){
        try {
            if(dirContext != null)
                dirContext.close();
        }
        catch (NamingException e) {
        	//LOG.severe(e.getMessage());            
            System.err.println("Error by closing connection");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
