    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author odzhara-ongom
 */
public class EnumTest {

    public static enum Day {

        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    Day day;

    public EnumTest(Day day) {
        this.day = day;
    }

    public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    public static void runExternalJar() {
        // Run a java app in a separate system process
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("java -jar A.jar");
            proc.waitFor();
            InputStream in = proc.getInputStream();
            OutputStream out = proc.getOutputStream();
            InputStream err = proc.getErrorStream();
            byte b[] = new byte[in.available()];
            in.read(b, 0, b.length);
            System.out.println(new String(b));
        } catch (Exception ex) {
            // Logger.getLogger(EnumTest.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        // Then retreive the process output
    }

    public static void runExternalJar2() {
        String[] command = {"java", "-jar", "d:\\!Leon\\Tempo\\demo.jar"};
        //String[] command = {"java", "-version"};
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.redirectOutput(Redirect.INHERIT);
        pb.redirectError(Redirect.INHERIT);
        try {
            Process p = pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.tellItLikeItIs();
        EnumTest thirdDay = new EnumTest(Day.WEDNESDAY);
        thirdDay.tellItLikeItIs();
        EnumTest fifthDay = new EnumTest(Day.FRIDAY);
        fifthDay.tellItLikeItIs();
        EnumTest sixthDay = new EnumTest(Day.SATURDAY);
        sixthDay.tellItLikeItIs();
        EnumTest seventhDay = new EnumTest(Day.SUNDAY);
        seventhDay.tellItLikeItIs();

        String Str = new String("Welcome to Tutorialspoint.com");

        System.out.print("Return Value :");
        System.out.println(Str.toLowerCase());
        runExternalJar2();
    }
}
