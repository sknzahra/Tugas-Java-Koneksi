/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanjavakoneksi;

import latihanjavakoneksi.Connection.DBConnection;
import latihanjavakoneksi.Frame.MainFrame;

/**
 *
 * @author Asus
 */
public class LatihanJavaKoneksi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnection connection = new DBConnection();
        System.out.println(connection.open());
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
    
}
