/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcl.kdd.zoo;

import java.sql.Connection;

/**
 *
 * @author Dalva
 */
public class TaxonomicImporter {
    //Kingdom
    //Rank
    public final static String taxon_unit_types_SQL="select * from taxon_unit_types";
    //Taxonomy Author
    public final static String _SQL="";
    //Taxonomy
    public final static String taxonomic_units_SQL = "select tsn,parent_tsn,taxon_autor_id,kingdom_id,rank_id,complete_name from taxonomic_units";
    
    public TaxonomicImporter(Connection c){
        
    }
    public void run(){
    }
}
