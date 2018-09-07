package it.gesan.module.medici.model.dao.jdbc;

import it.gesan.module.medici.exception.DataException;
import it.gesan.module.medici.model.dao.interfaces.SpecializzazioniMedicoDAO;
import it.gesan.module.medici.vo.SpecializzazioneMedicoVO;
import it.gesan.rdb.JDBCManager;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.constants.ReturnValues;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;
public class SpecializzazioniMedicoPgJDBC implements SpecializzazioniMedicoDAO {

    private final String LISTA = "SELECT descrizione, id FROM gesan_specializzazione_medico;";

    private final String LISTA_BY_FILTER_ID = "SELECT descrizione, id FROM gesan_specializzazione_medico WHERE id in (?) OR proprietario = ?;";

    private final String SPECIALIZZAZIONEMEDICO_BY_ID = "SELECT descrizione, id FROM gesan_specializzazione_medico WHERE id = ?;";

    private final String INSERT_SPECIALIZZAZIONEMEDICO = "INSERT INTO gesan_specializzazione_medico (descrizione, id) VALUES(?, ?);";

    private final String UPDATE_SPECIALIZZAZIONEMEDICO = "UPDATE gesan_specializzazione_medico SET descrizione = ? WHERE id = ? ;";

    private final String DELETE_SPECIALIZZAZIONEMEDICO = "DELETE FROM gesan_specializzazione_medico WHERE id = ? ;";

    private final JDBCManager jdbcMan = new JDBCManager();
    @Override
    public EsitoBean getLista(SpecializzazioneMedicoVO specializzazioneMedicoVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA);
            rs = pstmt.executeQuery();
            ArrayList<SpecializzazioneMedicoVO> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(this.build(rs));
            }
            returnValue.setEsito(true);
            returnValue.setReturnValue(ReturnValues.FOUND);
            returnValue.setObject(lista);
        } catch (Exception e) {
            returnValue.setMessaggio(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }
    @Override
    public EsitoBean getLista(String filtroId, String proprietario) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA_BY_FILTER_ID);
            pstmt.setString(1, filtroId);
            pstmt.setString(2, proprietario);
            rs = pstmt.executeQuery();
            ArrayList<SpecializzazioneMedicoVO> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(this.build(rs));
            }
            returnValue.setEsito(true);
            returnValue.setReturnValue(ReturnValues.FOUND);
            returnValue.setObject(lista);
        } catch (Exception e) {
            returnValue.setMessaggio(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    @Override
    public EsitoBean getSpecializzazioneMedicoById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(SPECIALIZZAZIONEMEDICO_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            SpecializzazioneMedicoVO object = new SpecializzazioneMedicoVO();
            if (rs.next()) {
                object= this.build(rs);
                returnValue.setEsito(true);
                returnValue.setReturnValue(ReturnValues.FOUND);
                returnValue.setObject(object);
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
    public EsitoBean salva(SpecializzazioneMedicoVO specializzazioneMedicoVO) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;

        String id = specializzazioneMedicoVO.getId();
        String descrizione = specializzazioneMedicoVO.getDescrizione();

        try {

            connection = jdbcMan.getConnection();

            if (specializzazioneMedicoVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_SPECIALIZZAZIONEMEDICO);
                id = UUID.randomUUID().toString(); 
            } else {
                id = specializzazioneMedicoVO.getPrimaryKey(); 
                pstmt = connection.prepareStatement(UPDATE_SPECIALIZZAZIONEMEDICO);
            }
            pstmt.setString(1, descrizione);
            pstmt.setString(2, id);

            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                specializzazioneMedicoVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(specializzazioneMedicoVO);
            }

            } catch (Exception e) {
                esito.setReturnValue(ReturnValues.NOT_SAVED);
                esito.setMessaggio(e.getMessage());
                esito.setObject(specializzazioneMedicoVO);
            } finally {
                jdbcMan.close(pstmt);
                jdbcMan.close(connection);
            }

        return esito;
    }

    @Override
    public EsitoBean delete(SpecializzazioneMedicoVO specializzazioneMedicoVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_DELETED);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            String id = specializzazioneMedicoVO.getPrimaryKey();
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DELETE_SPECIALIZZAZIONEMEDICO);
            pstmt.setString(1, id);
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                returnValue.setReturnValue(ReturnValues.DELETED);
                returnValue.setMessaggio("Cancellazione avvenuta con successo");
                returnValue.setObject(specializzazioneMedicoVO);
            }
        } catch (Exception e) {
            returnValue.setMessaggio(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    private SpecializzazioneMedicoVO build(ResultSet rs) throws SQLException {
        SpecializzazioneMedicoVO returnValue = new SpecializzazioneMedicoVO();

        returnValue.setPrimaryKey(rs.getString("id"));

        String id = rs.getString("id");
        returnValue.setId(id);

        String descrizione = rs.getString("descrizione");
        returnValue.setDescrizione(descrizione);

        return returnValue;
    } 

}
