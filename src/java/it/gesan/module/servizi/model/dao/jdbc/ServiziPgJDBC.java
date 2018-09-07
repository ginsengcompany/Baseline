package it.gesan.module.servizi.model.dao.jdbc;

import it.gesan.module.servizi.exception.DataException;
import it.gesan.module.servizi.model.dao.interfaces.ServiziDAO;
import it.gesan.module.servizi.vo.ServizioVO;
import it.gesan.rdb.JDBCManager;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.constants.ReturnValues;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;


public class ServiziPgJDBC implements ServiziDAO {

    private final String LISTA = "SELECT descrizione_servizio, update_user, codice_azienda, create_user, codice_servizio, create_date, update_date, id FROM pub_servizi;";

    private final String SERVIZIO_BY_ID = "SELECT descrizione_servizio, update_user, codice_azienda, create_user, codice_servizio, create_date, update_date, id FROM pub_servizi WHERE id = ?;";

    private final String INSERT_SERVIZIO = "INSERT INTO pub_servizi (descrizione_servizio, update_user, codice_azienda, create_user, codice_servizio, create_date, update_date, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE_SERVIZIO = "UPDATE pub_servizi SET descrizione_servizio = ?, update_user = ?, codice_azienda = ?, create_user = ?, codice_servizio = ?, create_date = ?, update_date = ?, id = ? WHERE id = ? ;";

    private final String DELETE_SERVIZIO = "DELETE FROM pub_servizi WHERE id = ? ;";

    private final JDBCManager jdbcMan = new JDBCManager();
    @Override
    public EsitoBean getLista(ServizioVO servizioVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA);
            rs = pstmt.executeQuery();
            ArrayList<ServizioVO> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(this.build(rs));
            }
            returnValue.setReturnValue(ReturnValues.FOUND);
            returnValue.setObject(lista);
        } catch (Exception e) {
            throw new DataException(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    @Override
    public EsitoBean getServizioById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(SERVIZIO_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            ServizioVO object = new ServizioVO();
            if (rs.next()) {
                object= this.build(rs);
            }
            returnValue.setReturnValue(ReturnValues.FOUND);
            returnValue.setObject(object);
        } catch (Exception e) {
            throw new DataException(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    @Override
    public EsitoBean salva(ServizioVO servizioVO) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;

        String descrizioneServizio = servizioVO.getDescrizioneServizio();
        String updateUser = servizioVO.getUpdateUser();
        String codiceAzienda = servizioVO.getCodiceAzienda();
        String id = servizioVO.getId();
        String createUser = servizioVO.getCreateUser();
        String codiceServizio = servizioVO.getCodiceServizio();
        Date createDate = servizioVO.getCreateDate();
        Date updateDate = servizioVO.getUpdateDate();

        try {

            connection = jdbcMan.getConnection();

            if (servizioVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_SERVIZIO);
                id = codiceAzienda + "-" + codiceServizio;
                pstmt.setTimestamp(6, new Timestamp(new Date().getTime()));
                               
            } else {
                pstmt = connection.prepareStatement(UPDATE_SERVIZIO);
                pstmt.setTimestamp(6, new Timestamp(createDate.getTime())); 
                pstmt.setString(9, servizioVO.getPrimaryKey());
            }
            pstmt.setString(1, descrizioneServizio.toUpperCase());
            pstmt.setString(2, updateUser);
            pstmt.setString(3, codiceAzienda);
            pstmt.setString(4, createUser);
            pstmt.setString(5, codiceServizio);
            pstmt.setTimestamp(7, new Timestamp(new Date().getTime())); 
            pstmt.setString(8, id);

            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                servizioVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(servizioVO);
            }

            } catch (Exception e) {
                esito.setReturnValue(ReturnValues.NOT_SAVED);
                esito.setMessaggio(e.getMessage());
                esito.setObject(servizioVO);
            } finally {
                jdbcMan.close(pstmt);
                jdbcMan.close(connection);
            }

        return esito;
    }

    @Override
    public EsitoBean delete(ServizioVO servizioVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_DELETED);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            String id = servizioVO.getPrimaryKey();
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DELETE_SERVIZIO);
            pstmt.setString(1, id);
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                returnValue.setReturnValue(ReturnValues.DELETED);
                returnValue.setMessaggio("Cancellazione avvenuta con successo");
                returnValue.setObject(servizioVO);
            }
        } catch (Exception e) {
            throw new DataException(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    private ServizioVO build(ResultSet rs) throws SQLException {
        ServizioVO returnValue = new ServizioVO();

        returnValue.setPrimaryKey(rs.getString("id"));

        String descrizioneServizio = rs.getString("descrizione_servizio");
        returnValue.setDescrizioneServizio(descrizioneServizio);

        String updateUser = rs.getString("update_user");
        returnValue.setUpdateUser(updateUser);

        String codiceAzienda = rs.getString("codice_azienda");
        returnValue.setCodiceAzienda(codiceAzienda);

        String id = rs.getString("id");
        returnValue.setId(id);

        String createUser = rs.getString("create_user");
        returnValue.setCreateUser(createUser);

        String codiceServizio = rs.getString("codice_servizio");
        returnValue.setCodiceServizio(codiceServizio);

        Timestamp createDate = rs.getTimestamp("create_date");
        returnValue.setCreateDate(createDate);

        Timestamp updateDate = rs.getTimestamp("update_date");
        returnValue.setUpdateDate(updateDate);

        return returnValue;
    } 

};
