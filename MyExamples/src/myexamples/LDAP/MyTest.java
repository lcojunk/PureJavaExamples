/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples.LDAP;

import java.util.Properties;
import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/**
 *
 * @author odzhara-ongom
 */
public class MyTest {
    public final static String ADESSO_DC_IP="10.100.0.11";//???
    public final static String ADESSO_DC_NAME="adesso.local";
    
    public static boolean isUserLDAPAuthenticated( String user, String password, String domainController ) {

        Properties env = new Properties();
        env.put( Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory" );
        //env.put( Context.PROVIDER_URL, profilerSystemServiceBean.getLDAPServer() );
        env.put( Context.PROVIDER_URL,"LDAP://" + domainController);
        env.put( Context.SECURITY_AUTHENTICATION, "simple" );
        env.put( Context.SECURITY_PRINCIPAL, user + "@adesso.local" );
        env.put( Context.SECURITY_CREDENTIALS, password );

        try {

            DirContext ctx = new InitialDirContext( env );
            
            System.out.println(ctx);
            
            ctx.close();

            env.remove( Context.SECURITY_PRINCIPAL );
            env.remove( Context.SECURITY_CREDENTIALS );

            return Boolean.TRUE;

        } catch( final AuthenticationException e ) {

            env.put( Context.SECURITY_CREDENTIALS, "*********" );
            //log.info( "User konnte nicht bei LDAP authentifiziert werden: " + env, e );
            System.out.println("User konnte nicht bei LDAP authentifiziert werden: " + env+" Error:"+e.toString());

            return Boolean.FALSE;

        } catch( NamingException e ) {

            //throw new ProfilerException( "Fehler bei der Verbindung zu LDAP", e );
            System.out.println( "Fehler bei der Verbindung zu LDAP:"+e.toString() );
        }
        return Boolean.FALSE;
    }    
    
    public static void test1(){
        ActiveDirectory activeDirectory = new ActiveDirectory("odzhara-ongm", "...", "ades");
        if (activeDirectory.getDirContext()==null) System.err.println("null!");
        System.out.println(activeDirectory.getDirContext().toString());;
        activeDirectory.closeLdapConnection();
        
    }
    
    public static void test2(){
        //System.out.println("User exists?"+ADConnection.testUserByUsernamePassDC("odzhara-ongom", "", "bla.bla"));
        //System.out.println("User exists?"+ADConnection.testUserByUsernamePassDC("odzhara-ongom", "", ADESSO_DC_NAME));
        //System.out.println("User exists?"+isUserLDAPAuthenticated("odzhara-ongom", "", ADESSO_DC_NAME));
        System.out.println("User exists?"+isUserLDAPAuthenticated("o", "", ADESSO_DC_NAME));
    }
    

    
    
    public static void main(String[] args) {
        test2();
        
    }
}
