/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.gesan.module.dispositivi.model.dao.jdbc;

import it.gesan.module.dispositivi.model.dao.interfaces.DispositiviDAO;
import it.gesan.module.dispositivi.exception.DataException;
import it.gesan.module.dispositivi.model.dao.beans.EsitoBean;
import it.gesan.module.dispositivi.vo.DispositivoVO;
import it.gesan.rdb.JDBCManager;
import it.gesan.rdb.constants.ReturnValues;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author sisto
 */
public class DispositiviPgJDBC implements DispositiviDAO {

    private final String LISTA = "SELECT id, codice_utente, tipo_dispositivo, client_id, descrizione, impronta, tipo, create_user, lastupdate_user, attivo, create_date, lastupdate_date, applicazione  FROM pub_dispositivi WHERE codice_utente LIKE ?;";

    private final String DISPOSITIVO_BY_CLIENT_ID_CODCIE_UTENTE = "SELECT id, codice_utente, tipo_dispositivo, client_id, descrizione, impronta, tipo, create_user, lastupdate_user, attivo, create_date, lastupdate_date, applicazione  FROM pub_dispositivi WHERE client_id = ? AND codice_utente = ?;";
    
    private final String DISPOSITIVO_BY_ID = "SELECT id, codice_utente, tipo_dispositivo, client_id, descrizione, impronta, tipo, create_user, lastupdate_user, attivo, create_date, lastupdate_date, applicazione FROM pub_dispositivi WHERE id = ?;";

    private final String MASTER_BY_CODCIE_AZIENDA = "SELECT id, codice_utente, tipo_dispositivo, client_id, descrizione, impronta, tipo, create_user, lastupdate_user, attivo, create_date, lastupdate_date, applicazione FROM pub_dispositivi WHERE tipo_dispositivo = 'M' AND codice_utente = ?;";

    private final String INSERT_DISPOSITIVO = "INSERT INTO pub_dispositivi (codice_utente, tipo_dispositivo, client_id, descrizione, impronta, tipo, create_user, create_date, lastupdate_user, attivo, lastupdate_date, applicazione, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE_DISPOSITIVO = "UPDATE pub_dispositivi SET codice_utente = ? , tipo_dispositivo = ? , client_id = ? , descrizione = ? , impronta = ? , tipo = ? , create_user = ? , create_date = ? , lastupdate_user = ?, attivo = ? , lastupdate_date = ? , applicazione = ?  WHERE id = ? ;";

    private final JDBCManager jdbcMan = new JDBCManager();

    @Override
    public EsitoBean getLista(DispositivoVO dispositivoVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA);
            pstmt.setString(1, "%" + dispositivoVO.getCodiceUtente() + "%");
            rs = pstmt.executeQuery();
            ArrayList<DispositivoVO> lista = new ArrayList<>();
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
    public EsitoBean getDispositivoByClientId(String clientId, String codiceUtente) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        returnValue.setMessaggio("Nessun Dispositivo Trovato");
        returnValue.setObject(new DispositivoVO());
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DISPOSITIVO_BY_CLIENT_ID_CODCIE_UTENTE);
            pstmt.setString(1, clientId);
            pstmt.setString(2, codiceUtente);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                returnValue.setReturnValue(ReturnValues.FOUND);
                returnValue.setMessaggio("Dispositivo Trovato");
                returnValue.setObject(this.build(rs));
            }
        } catch (Exception e) {
            returnValue.setMessaggio(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    @Override
    public EsitoBean getDispositivoById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DISPOSITIVO_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                returnValue.setReturnValue(ReturnValues.FOUND);

                returnValue.setObject(this.build(rs));
            }
        } catch (Exception e) {
            throw new DataException(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    @Override
    public EsitoBean getMaster(String codiceAzienda) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(MASTER_BY_CODCIE_AZIENDA);
            pstmt.setString(1, codiceAzienda);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                returnValue.setReturnValue(ReturnValues.FOUND);

                returnValue.setObject(this.build(rs));
            }
        } catch (Exception e) {
            throw new DataException(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    @Override
    public EsitoBean delete(DispositivoVO dispositivoVO) throws DataException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private DispositivoVO build(ResultSet rs) throws SQLException {
        DispositivoVO returnValue = new DispositivoVO();

        returnValue.setPrimaryKey(rs.getString("id"));
        
        String id = rs.getString("id");
        String codiceUtente = rs.getString("codice_utente");
        String tipoDispositivo = rs.getString("tipo_dispositivo");
        String clientId = rs.getString("client_id");
        String descrizione = rs.getString("descrizione");
        String impronta = rs.getString("impronta");
        String tipo = rs.getString("tipo");
        String createUser = rs.getString("create_user");
        Timestamp createDate = rs.getTimestamp("create_date");
        String lastupdateUser = rs.getString("lastupdate_user");
        Timestamp lastupdateDate = rs.getTimestamp("lastupdate_date");
        boolean attivo = rs.getBoolean("attivo");
        String applicazione = rs.getString("applicazione");

        returnValue.setId(id);
        returnValue.setCodiceUtente(codiceUtente);
        returnValue.setTipoDispositivo(tipoDispositivo);
        returnValue.setClientId(clientId);
        returnValue.setDescrizione(descrizione);
        returnValue.setImpronta(impronta);
        returnValue.setTipo(tipo);
        returnValue.setCreateUser(createUser);
        returnValue.setCreateDate(createDate);
        returnValue.setUpdateUser(lastupdateUser);
        returnValue.setUpdateDate(lastupdateDate);
        returnValue.setAttivo(attivo);
        returnValue.setApplicazione(applicazione);

        return returnValue;
    }

    @Override
    public EsitoBean salva(DispositivoVO dispositivoVO) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;
        String id = dispositivoVO.getId();
        String codiceAzienda = dispositivoVO.getCodiceUtente();
        String tipoDispositivo = dispositivoVO.getTipoDispositivo();
        String clientId = dispositivoVO.getClientId();
        String descrizione = dispositivoVO.getDescrizione();
        String impronta = dispositivoVO.getImpronta();
        String tipo = dispositivoVO.getTipo();
        String createUser = dispositivoVO.getCreateUser();
        Timestamp createDate = new Timestamp(dispositivoVO.getCreateDate().getTime());
        String lastupdateUser = dispositivoVO.getUpdateUser();
        Boolean attivo = dispositivoVO.isAttivo();
        Timestamp lastupdateDate = new Timestamp(dispositivoVO.getUpdateDate().getTime());
        String applicazione = dispositivoVO.getApplicazione();
        
        try {

            connection = jdbcMan.getConnection();

            if (dispositivoVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_DISPOSITIVO);
                id = codiceAzienda + "-" + clientId;
            } else {
                pstmt = connection.prepareStatement(UPDATE_DISPOSITIVO);
            }

            pstmt.setString(1, codiceAzienda);
            pstmt.setString(2, tipoDispositivo);
            pstmt.setString(3, clientId);
            pstmt.setString(4, descrizione);
            pstmt.setString(5, impronta);
            pstmt.setString(6, tipo);
            pstmt.setString(7, createUser);
            pstmt.setTimestamp(8, createDate);
            pstmt.setString(9, lastupdateUser);
            pstmt.setBoolean(10, attivo);
            pstmt.setTimestamp(11, lastupdateDate);
            pstmt.setString(12, applicazione);
            pstmt.setString(13, id);

            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                dispositivoVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(dispositivoVO);
            }

        } catch (Exception e) {
            esito.setReturnValue(ReturnValues.NOT_SAVED);
            esito.setMessaggio(e.getMessage());
            esito.setObject(dispositivoVO);
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return esito;
    }
}
