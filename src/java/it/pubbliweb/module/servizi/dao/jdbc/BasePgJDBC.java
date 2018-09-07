/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pubbliweb.module.servizi.model.dao.jdbc;

import it.gesan.rdb.JDBCManager;
import it.gesan.utility.Utility;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 *
 * @author sisto
 */
public class BasePgJDBC {

    protected final JDBCManager jdbcMan = new JDBCManager();    

    protected final String SELECT_BY_CODICE_AZIENDA = "SELECT * FROM pub_servizi_iva WHERE codice_azienda = ?  ";
    
    protected final String SELECT_PROVINCE = "SELECT provincia, regione, numero_comuni, codice_istat, sigla, sito_provincia FROM pub_servizi_province ORDER BY provincia;";
    
    protected final String SELECT_COMUNI = "SELECT comune, provincia, cap, prefisso_tel, codice_istat, codice_catastale, sito_comune FROM pub_servizi_comuni WHERE provincia = ?; ";
    
    protected final String SELECT_METODI_PAGAMENTO_BY_CODICE_AZIENDA = "SELECT codice_metodo_pagamento, descrizione_metodo_pagamento, fm_metodo_pagamento, df_metodo_pagamento, codice_aziende, id FROM pub_servizi_metodo_pagamento WHERE codice_aziende = ?; ";

    protected final String SELECT_LISTA_MAGAZZINI_BY_CODICE_AZIENDA = "";
    
    protected final String SELECT_SCADENZE_BY_CODICE_AZIENDA = "SELECT numero_documento, tipo_documento, data_documento, descrizione, data_scadenza, importo_scadenza, tipo_scadenza, note_scadenza, stato, codice_azienda, id, codice_documento FROM pub_servizi_scadenzario WHERE codice_azienda = ?;";
    
    protected JSONObject build(ResultSet rs) throws SQLException, JSONException {
        JSONObject jsonObject = new JSONObject();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            String columnName = rsmd.getColumnName(i);
            if (columnName.equals("permessi")) {
                jsonObject.put(Utility.convertToCamelCase(columnName), new JSONArray(rs.getString(columnName)));
            } else {
                jsonObject.put(Utility.convertToCamelCase(columnName), rs.getString(columnName));
            }
        }
        return jsonObject;
    }    
}
