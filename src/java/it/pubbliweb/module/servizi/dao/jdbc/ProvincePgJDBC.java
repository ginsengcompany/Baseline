/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.pubbliweb.module.servizi.model.dao.jdbc;

import it.pubbliweb.module.servizi.exception.DataException;
import it.pubbliweb.module.servizi.model.dao.interfaces.ProvinceDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.codehaus.jettison.json.JSONArray;

/**
 *
 * @author sisto
 */
public class ProvincePgJDBC extends BasePgJDBC implements ProvinceDAO {

    @Override
    public String getLista() throws DataException {
        String returnValue = "[]";
        JSONArray jsonArray = new JSONArray();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();

            pstmt = connection.prepareStatement(SELECT_PROVINCE);
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
}
