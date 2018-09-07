package it.gesan.module.icdix.model.dao.jdbc;

import it.gesan.module.icdix.exception.DataException;
import it.gesan.module.icdix.model.dao.interfaces.IcdixDAO;
import it.gesan.module.icdix.vo.IcdixVO;
import it.gesan.rdb.JDBCManager;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.constants.ReturnValues;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class IcdixPgJDBC implements IcdixDAO {

    private final String LISTA = "SELECT fine_nodo, codice_icdix, liv3, tipo_nodo, liv1, liv2, descrizione_icdix, nota, diagnosi_report, id FROM gesan_icdix;";

    private final String ICDIX_BY_ID = "SELECT fine_nodo, codice_icdix, liv3, tipo_nodo, liv1, liv2, descrizione_icdix, nota, diagnosi_report, id FROM gesan_icdix WHERE id = ?;";

    private final String INSERT_ICDIX = "INSERT INTO gesan_icdix (fine_nodo, codice_icdix, liv3, tipo_nodo, liv1, liv2, descrizione_icdix, nota, diagnosi_report, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE_ICDIX = "UPDATE gesan_icdix SET fine_nodo = ?, codice_icdix = ?, liv3 = ?, tipo_nodo = ?, liv1 = ?, liv2 = ?, descrizione_icdix = ?, nota = ?, diagnosi_report = ?, id = ? WHERE id = ? ;";

    private final String DELETE_ICDIX = "DELETE FROM gesan_icdix WHERE id = ? ;";

    private final JDBCManager jdbcMan = new JDBCManager();
    @Override
    public EsitoBean getLista(IcdixVO icdixVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA);
            rs = pstmt.executeQuery();
            ArrayList<IcdixVO> lista = new ArrayList<>();
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
    public EsitoBean getIcdixById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(ICDIX_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            IcdixVO object = new IcdixVO();
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
    public EsitoBean salva(IcdixVO icdixVO) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;

        String fineNodo = icdixVO.getFineNodo();
        String codiceIcdix = icdixVO.getCodiceIcdix();
        int liv3 = icdixVO.getLiv3();
        String tipoNodo = icdixVO.getTipoNodo();
        int liv1 = icdixVO.getLiv1();
        int id = icdixVO.getId();
        int liv2 = icdixVO.getLiv2();
        String descrizioneIcdix = icdixVO.getDescrizioneIcdix();
        String nota = icdixVO.getNota();
        String diagnosiReport = icdixVO.getDiagnosiReport();

        try {

            connection = jdbcMan.getConnection();

            if (icdixVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_ICDIX);
                id = id;
            } else {
                pstmt = connection.prepareStatement(UPDATE_ICDIX);
            }
            pstmt.setString(1, fineNodo);
            pstmt.setString(2, codiceIcdix);
            pstmt.setInt(3, liv3);
            pstmt.setString(4, tipoNodo);
            pstmt.setInt(5, liv1);
            pstmt.setInt(6, id);
            pstmt.setInt(7, liv2);
            pstmt.setString(8, descrizioneIcdix);
            pstmt.setString(9, nota);
            pstmt.setString(10, diagnosiReport);

            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                icdixVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(icdixVO);
            }

            } catch (Exception e) {
                esito.setReturnValue(ReturnValues.NOT_SAVED);
                esito.setMessaggio(e.getMessage());
                esito.setObject(icdixVO);
            } finally {
                jdbcMan.close(pstmt);
                jdbcMan.close(connection);
            }

        return esito;
    }

    @Override
    public EsitoBean delete(IcdixVO icdixVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_DELETED);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            String id = icdixVO.getPrimaryKey();
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DELETE_ICDIX);
            pstmt.setString(1, id);
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                returnValue.setReturnValue(ReturnValues.DELETED);
                returnValue.setMessaggio("Cancellazione avvenuta con successo");
                returnValue.setObject(icdixVO);
            }
        } catch (Exception e) {
            throw new DataException(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    private IcdixVO build(ResultSet rs) throws SQLException {
        IcdixVO returnValue = new IcdixVO();

        returnValue.setPrimaryKey(rs.getString("id"));

        String fineNodo = rs.getString("fine_nodo");
        returnValue.setFineNodo(fineNodo);

        String codiceIcdix = rs.getString("codice_icdix");
        returnValue.setCodiceIcdix(codiceIcdix);

        int liv3 = rs.getInt("liv3");
        returnValue.setLiv3(liv3);

        String tipoNodo = rs.getString("tipo_nodo");
        returnValue.setTipoNodo(tipoNodo);

        int liv1 = rs.getInt("liv1");
        returnValue.setLiv1(liv1);

        int id = rs.getInt("id");
        returnValue.setId(id);

        int liv2 = rs.getInt("liv2");
        returnValue.setLiv2(liv2);

        String descrizioneIcdix = rs.getString("descrizione_icdix");
        returnValue.setDescrizioneIcdix(descrizioneIcdix);

        String nota = rs.getString("nota");
        returnValue.setNota(nota);

        String diagnosiReport = rs.getString("diagnosi_report");
        returnValue.setDiagnosiReport(diagnosiReport);

        return returnValue;
    } 

};
