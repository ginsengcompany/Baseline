package it.gesan.module.anagraficatipo.model.dao.jdbc;

import it.gesan.module.anagraficatipo.exception.DataException;
import it.gesan.module.anagraficatipo.model.dao.interfaces.AnagraficaTipoDAO;
import it.gesan.module.anagraficatipo.vo.AnagraficaTipoVO;
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
import java.util.UUID;


public class AnagraficaTipoPgJDBC implements AnagraficaTipoDAO {

    private final String LISTA = "SELECT update_user, id_tipo_anagrafica, id_anagrafica, create_user, create_date, update_date, id FROM gesan_anagrafica_tipo;";

    private final String ANAGRAFICATIPO_BY_ID = "SELECT update_user, id_tipo_anagrafica, id_anagrafica, create_user, create_date, update_date, id FROM gesan_anagrafica_tipo WHERE id = ?;";

    private final String INSERT_ANAGRAFICATIPO = "INSERT INTO gesan_anagrafica_tipo (update_user, id_tipo_anagrafica, id_anagrafica, create_user, create_date, update_date, id) VALUES(?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE_ANAGRAFICATIPO = "UPDATE gesan_anagrafica_tipo SET update_user = ?, id_tipo_anagrafica = ?, id_anagrafica = ?, create_user = ?, create_date = ?, update_date = ?, id = ? WHERE id = ? ;";

    private final String DELETE_ANAGRAFICATIPO = "DELETE FROM gesan_anagrafica_tipo WHERE id = ? ;";

    private final JDBCManager jdbcMan = new JDBCManager();
    @Override
    public EsitoBean getLista(AnagraficaTipoVO anagraficaTipoVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA);
            rs = pstmt.executeQuery();
            ArrayList<AnagraficaTipoVO> lista = new ArrayList<>();
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
    public EsitoBean getAnagraficaTipoById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(ANAGRAFICATIPO_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            AnagraficaTipoVO object = new AnagraficaTipoVO();
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
    public EsitoBean salva(AnagraficaTipoVO anagraficaTipoVO) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;

        String updateUser = anagraficaTipoVO.getUpdateUser();
        String idTipoAnagrafica = anagraficaTipoVO.getIdTipoAnagrafica();
        String idAnagrafica = anagraficaTipoVO.getIdAnagrafica();
        String createUser = anagraficaTipoVO.getCreateUser();
        String id = anagraficaTipoVO.getId();
        Date createDate = anagraficaTipoVO.getCreateDate();
        Date updateDate = anagraficaTipoVO.getUpdateDate();

        try {

            connection = jdbcMan.getConnection();

            if (anagraficaTipoVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_ANAGRAFICATIPO);
                id = UUID.randomUUID().toString();
            } else {
                pstmt = connection.prepareStatement(UPDATE_ANAGRAFICATIPO);
            }
            pstmt.setString(1, updateUser);
            pstmt.setString(2, idTipoAnagrafica);
            pstmt.setString(3, idAnagrafica);
            pstmt.setString(4, createUser);
            pstmt.setTimestamp(5, new Timestamp(createDate.getTime()));
            pstmt.setTimestamp(6, new Timestamp(updateDate.getTime()));
            pstmt.setString(7, id);

            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                anagraficaTipoVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(anagraficaTipoVO);
            }

            } catch (Exception e) {
                esito.setReturnValue(ReturnValues.NOT_SAVED);
                esito.setMessaggio(e.getMessage());
                esito.setObject(anagraficaTipoVO);
            } finally {
                jdbcMan.close(pstmt);
                jdbcMan.close(connection);
            }

        return esito;
    }

    @Override
    public EsitoBean delete(AnagraficaTipoVO anagraficaTipoVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_DELETED);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            String id = anagraficaTipoVO.getPrimaryKey();
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DELETE_ANAGRAFICATIPO);
            pstmt.setString(1, id);
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                returnValue.setReturnValue(ReturnValues.DELETED);
                returnValue.setMessaggio("Cancellazione avvenuta con successo");
                returnValue.setObject(anagraficaTipoVO);
            }
        } catch (Exception e) {
            throw new DataException(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    private AnagraficaTipoVO build(ResultSet rs) throws SQLException {
        AnagraficaTipoVO returnValue = new AnagraficaTipoVO();

        returnValue.setPrimaryKey(rs.getString("id"));

        String updateUser = rs.getString("update_user");
        returnValue.setUpdateUser(updateUser);

        String idTipoAnagrafica = rs.getString("id_tipo_anagrafica");
        returnValue.setIdTipoAnagrafica(idTipoAnagrafica);

        String idAnagrafica = rs.getString("id_anagrafica");
        returnValue.setIdAnagrafica(idAnagrafica);

        String createUser = rs.getString("create_user");
        returnValue.setCreateUser(createUser);

        String id = rs.getString("id");
        returnValue.setId(id);

        Date createDate = rs.getTimestamp("create_date");
        returnValue.setCreateDate(createDate);

        Date updateDate = rs.getTimestamp("update_date");
        returnValue.setUpdateDate(updateDate);

        return returnValue;
    } 

};
