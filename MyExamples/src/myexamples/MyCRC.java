/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myexamples;

import java.util.zip.CRC32;

/**
 *
 * @author odzhara-ongom
 */
public class MyCRC {
    public static void main(String[] args) {
        CRC32 crc32 = new CRC32();
        byte[] bytes = new byte[10];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = 1;
        }
        crc32.update(bytes);
        System.out.println((int) crc32.getValue());
    }
}
