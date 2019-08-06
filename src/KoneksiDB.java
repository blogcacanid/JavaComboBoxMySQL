/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cacan
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
*
* @author www.myaspirasi.com
*/

public class KoneksiDB {

    private Connection koneksi;

    public Connection getKoneksi() {
        return koneksi;
    }

    public void koneksiDatabase() { // // Cek Driver
        try {
            Class.forName("com.mysql.jdbc.Driver"); /// Cek Database
            try {
                String url, user, password;
                url = "jdbc:mysql://localhost:3306/java_db"; //alamat DB
                user = "root";
                password = "";
                koneksi = DriverManager.getConnection(url, user, password);

                System.out.println("Koneksi Sukses");
            } catch (SQLException se) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal! " + se);
                System.exit(0);
            }
        } catch (ClassNotFoundException cnfe) {
        JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan! \n" + cnfe);
        System.exit(0);
        }
    }

    public static void main(String[] kon) {
        new KoneksiDB().koneksiDatabase();
    }
}