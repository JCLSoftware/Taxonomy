/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcl.kdd.zoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dalva
 */
public class TaxonomicImporter {

    //Kingdom
    public final static String kingdoms_SQL = "select * from kingdoms";
    //Rank
    public final static String taxon_unit_types_SQL = "select * from taxon_unit_types";
    //Taxonomy Author
    //public final static String _SQL = "";
    //Taxonomy
    public final static String taxonomic_units_SQL = "select tsn,parent_tsn,taxon_autor_id,kingdom_id,rank_id,complete_name from taxonomic_units order by tsn";
    private final Connection con;

    public TaxonomicImporter(Connection c) {
        con = c;
    }

    public void run() throws SQLException {
        PreparedStatement ps = con.prepareStatement(kingdoms_SQL);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("kingdom_name"));
        }
    }

    public static void main(String[] arg) {
        String host = "192.168.9.56";
        String user = JOptionPane.showInputDialog("Usuario");
        String password = JOptionPane.showInputDialog("Senha");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + "/ITIS?serverTimezone=UTC", user, password);
            TaxonomicImporter i = new TaxonomicImporter(c);
            i.run();
        } catch (SQLException ex) {
            Logger.getLogger(TaxonomicImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TaxonomicImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TaxonomicImporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TaxonomicImporter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
