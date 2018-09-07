/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pubbliweb.module.servizi.model.dao.jdbc;

import it.pubbliweb.module.servizi.exception.DataException;
import it.pubbliweb.module.servizi.model.dao.interfaces.ScadenzarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.codehaus.jettison.json.JSONArray;

/**
 *
 * @author sisto
 */
public class ScadenzarioPgJDBC extends BasePgJDBC implements ScadenzarioDAO {

    @Override
    public String getLista(String codiceAzienda) throws DataException {
        String returnValue = "[]";
        JSONArray jsonArray = new JSONArray();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();

            pstmt = connection.prepareStatement(SELECT_SCADENZE_BY_CODICE_AZIENDA);
            pstmt.setString(1, codiceAzienda);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                jsonArray.put(this.build(rs));
            }
            returnValue = jsonArray.toString();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    @Override
    public String getListaByCodiceDocumento(String codiceAzienda) throws DataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getScadenzaById(String id) throws DataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String salva(String jsonParams) throws DataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(String jsonParams) throws DataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
