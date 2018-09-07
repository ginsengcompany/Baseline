package it.gesan.module.portale.model.dao.jdbc;

import it.gesan.module.portale.exception.DataException;
import it.gesan.module.portale.model.dao.interfaces.PortaleNewsDAO;
import it.gesan.module.portale.vo.PortaleNewsVO;
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

public class PortaleNewsPgJDBC implements PortaleNewsDAO {

    private final String LISTA = "SELECT tipo, titolo, descrizione_breve, body, image, create_user, create_date, update_user, update_date, proprietario, pubblicato, view_titolo, id FROM gesan_portale_news;";

    private final String LISTA_BY_FILTER_ID = "SELECT tipo, titolo, descrizione_breve, body, image, create_user, create_date, update_user, update_date, proprietario, pubblicato, view_titolo, id FROM gesan_portale_news WHERE id in (?) OR proprietario = ?;";

    private final String PORTALENEWS_BY_ID = "SELECT tipo, titolo, descrizione_breve, body, image, create_user, create_date, update_user, update_date, proprietario, pubblicato, view_titolo, id FROM gesan_portale_news WHERE id = ?;";

    private final String INSERT_PORTALENEWS = "INSERT INTO gesan_portale_news (tipo, titolo, descrizione_breve, body, image, create_user, create_date, update_user, update_date, proprietario, pubblicato, view_titolo, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE_PORTALENEWS = "UPDATE gesan_portale_news SET tipo = ?, titolo = ?, descrizione_breve = ?, body = ?, image = ?, create_user = ?, create_date = ?, update_user = ?, update_date = ?, proprietario = ?, pubblicato = ?, view_titolo = ? WHERE id = ? ;";

    private final String DELETE_PORTALENEWS = "DELETE FROM gesan_portale_news WHERE id = ? ;";

    private final JDBCManager jdbcMan = new JDBCManager();

    @Override
    public EsitoBean getLista(PortaleNewsVO portaleNewsVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA);
            rs = pstmt.executeQuery();
            ArrayList<PortaleNewsVO> lista = new ArrayList<>();
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
            ArrayList<PortaleNewsVO> lista = new ArrayList<>();
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
    public EsitoBean getPortaleNewsById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(PORTALENEWS_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            PortaleNewsVO object = new PortaleNewsVO();
            if (rs.next()) {
                object = this.build(rs);
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
    public EsitoBean salva(PortaleNewsVO portaleNewsVO) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;

        String id = portaleNewsVO.getId();
        String tipo = portaleNewsVO.getTipo();
        String titolo = portaleNewsVO.getTitolo();
        String descrizioneBreve = portaleNewsVO.getDescrizioneBreve();
        String body = portaleNewsVO.getBody();
        String image = portaleNewsVO.getImage();
        String createUser = portaleNewsVO.getCreateUser();
        Date createDate = portaleNewsVO.getCreateDate();
        String updateUser = portaleNewsVO.getUpdateUser();
        Date updateDate = portaleNewsVO.getUpdateDate();
        String proprietario = portaleNewsVO.getProprietario();
        boolean pubblicato = portaleNewsVO.isPubblicato();
        boolean viewTitolo = portaleNewsVO.isViewTitolo();

        try {

            connection = jdbcMan.getConnection();

            if (portaleNewsVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_PORTALENEWS);
                id = UUID.randomUUID().toString();
            } else {
                id = portaleNewsVO.getPrimaryKey();
                pstmt = connection.prepareStatement(UPDATE_PORTALENEWS);
            }
            pstmt.setString(1, tipo);
            pstmt.setString(2, titolo);
            pstmt.setString(3, descrizioneBreve);
            pstmt.setString(4, body);
            pstmt.setString(5, image);
            pstmt.setString(6, createUser);
            pstmt.setTimestamp(7, new Timestamp(createDate.getTime()));
            pstmt.setString(8, updateUser);
            pstmt.setTimestamp(9, new Timestamp(updateDate.getTime()));
            pstmt.setString(10, proprietario);
            pstmt.setBoolean(11, pubblicato);
            pstmt.setBoolean(12, viewTitolo);
            pstmt.setString(13, id);

            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                portaleNewsVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(portaleNewsVO);
                esito.setEsito(true);
            }

        } catch (Exception e) {
            esito.setReturnValue(ReturnValues.NOT_SAVED);
            esito.setMessaggio(e.getMessage());
            esito.setObject(portaleNewsVO);
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return esito;
    }

    @Override
    public EsitoBean delete(PortaleNewsVO portaleNewsVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_DELETED);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            String id = portaleNewsVO.getPrimaryKey();
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DELETE_PORTALENEWS);
            pstmt.setString(1, id);
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                returnValue.setReturnValue(ReturnValues.DELETED);
                returnValue.setMessaggio("Cancellazione avvenuta con successo");
                returnValue.setObject(portaleNewsVO);
            }
        } catch (Exception e) {
            returnValue.setMessaggio(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    private PortaleNewsVO build(ResultSet rs) throws SQLException {
        PortaleNewsVO returnValue = new PortaleNewsVO();

        returnValue.setPrimaryKey(rs.getString("id"));

        String id = rs.getString("id");
        returnValue.setId(id);

        String tipo = rs.getString("tipo");
        returnValue.setTipo(tipo);

        String titolo = rs.getString("titolo");
        returnValue.setTitolo(titolo);

        String descrizioneBreve = rs.getString("descrizione_breve");
        returnValue.setDescrizioneBreve(descrizioneBreve);

        String body = rs.getString("body");
        returnValue.setBody(body);

        String image = rs.getString("image");
        returnValue.setImage(image);

        String createUser = rs.getString("create_user");
        returnValue.setCreateUser(createUser);

        Date createDate = rs.getTimestamp("create_date");
        returnValue.setCreateDate(createDate);

        String updateUser = rs.getString("update_user");
        returnValue.setUpdateUser(updateUser);

        Date updateDate = rs.getTimestamp("update_date");
        returnValue.setUpdateDate(updateDate);

        String proprietario = rs.getString("proprietario");
        returnValue.setProprietario(proprietario);

        boolean pubblicato = rs.getBoolean("pubblicato");
        returnValue.setPubblicato(pubblicato);

        boolean viewTitolo = rs.getBoolean("view_titolo");
        returnValue.setViewTitolo(viewTitolo);

        return returnValue;
    }

}
