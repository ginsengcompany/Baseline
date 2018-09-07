package it.gesan.module.portale.model.dao.jdbc;

import it.gesan.module.portale.exception.DataException;
import it.gesan.module.portale.model.dao.interfaces.PortalePagineDAO;
import it.gesan.module.portale.vo.PortalePaginaVO;
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

public class PortalePaginePgJDBC implements PortalePagineDAO {
    
    private final String LISTA = "SELECT tipo, titolo, body, create_user, create_date, update_user, update_date, proprietario, pubblicato, view_titolo, id FROM gesan_portale_page;";
    
    private final String LISTA_BY_FILTER_ID = "SELECT tipo, titolo, body, create_user, create_date, update_user, update_date, proprietario, pubblicato, view_titolo, id FROM gesan_portale_page WHERE id in (?) OR proprietario = ?;";
    
    private final String PORTALEPAGINA_BY_ID = "SELECT tipo, titolo, body, create_user, create_date, update_user, update_date, proprietario, pubblicato, view_titolo, id FROM gesan_portale_page WHERE id = ?;";
    
    private final String INSERT_PORTALEPAGINA = "INSERT INTO gesan_portale_page (tipo, titolo, body, create_user, create_date, update_user, update_date, proprietario, pubblicato, view_titolo, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    private final String UPDATE_PORTALEPAGINA = "UPDATE gesan_portale_page SET tipo = ?, titolo = ?, body = ?, create_user = ?, create_date = ?, update_user = ?, update_date = ?, proprietario = ?, pubblicato = ?, view_titolo = ? WHERE id = ? ;";
    
    private final String DELETE_PORTALEPAGINA = "DELETE FROM gesan_portale_page WHERE id = ? ;";
    
    private final JDBCManager jdbcMan = new JDBCManager();

    @Override
    public EsitoBean getLista(PortalePaginaVO portalePaginaVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;
        
        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA);
            rs = pstmt.executeQuery();
            ArrayList<PortalePaginaVO> lista = new ArrayList<>();
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
            ArrayList<PortalePaginaVO> lista = new ArrayList<>();
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
    public EsitoBean getPortalePaginaById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;
        
        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(PORTALEPAGINA_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            PortalePaginaVO object = new PortalePaginaVO();
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
    public EsitoBean salva(PortalePaginaVO portalePaginaVO) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        String id = portalePaginaVO.getId();
        String tipo = portalePaginaVO.getTipo();
        String titolo = portalePaginaVO.getTitolo();
        String body = portalePaginaVO.getBody();
        String createUser = portalePaginaVO.getCreateUser();
        Date createDate = portalePaginaVO.getCreateDate();
        String updateUser = portalePaginaVO.getUpdateUser();
        Date updateDate = portalePaginaVO.getUpdateDate();
        String proprietario = portalePaginaVO.getProprietario();
        boolean pubblicato = portalePaginaVO.isPubblicato();
        boolean viewTitolo = portalePaginaVO.isViewTitolo();
        
        try {
            
            connection = jdbcMan.getConnection();
            
            if (portalePaginaVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_PORTALEPAGINA);
                id = UUID.randomUUID().toString();                
            } else {
                id = portalePaginaVO.getPrimaryKey();                
                pstmt = connection.prepareStatement(UPDATE_PORTALEPAGINA);
            }
            pstmt.setString(1, tipo);
            pstmt.setString(2, titolo);
            pstmt.setString(3, body);
            pstmt.setString(4, createUser);
            pstmt.setTimestamp(5, new Timestamp(createDate.getTime()));
            pstmt.setString(6, updateUser);
            pstmt.setTimestamp(7, new Timestamp(updateDate.getTime()));
            pstmt.setString(8, proprietario);
            pstmt.setBoolean(9, pubblicato);
            pstmt.setBoolean(10, viewTitolo);
            pstmt.setString(11, id);
            
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                portalePaginaVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(portalePaginaVO);
                esito.setEsito(true);
            }
            
        } catch (Exception e) {
            esito.setReturnValue(ReturnValues.NOT_SAVED);
            esito.setMessaggio(e.getMessage());
            esito.setObject(portalePaginaVO);
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }
        
        return esito;
    }
    
    @Override
    public EsitoBean delete(PortalePaginaVO portalePaginaVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_DELETED);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;
        
        try {
            String id = portalePaginaVO.getPrimaryKey();
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DELETE_PORTALEPAGINA);
            pstmt.setString(1, id);
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                returnValue.setReturnValue(ReturnValues.DELETED);
                returnValue.setMessaggio("Cancellazione avvenuta con successo");
                returnValue.setObject(portalePaginaVO);
            }
        } catch (Exception e) {
            returnValue.setMessaggio(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }
        
        return returnValue;
    }
    
    private PortalePaginaVO build(ResultSet rs) throws SQLException {
        PortalePaginaVO returnValue = new PortalePaginaVO();
        
        returnValue.setPrimaryKey(rs.getString("id"));
        
        String id = rs.getString("id");
        returnValue.setId(id);
        
        String tipo = rs.getString("tipo");
        returnValue.setTipo(tipo);
        
        String titolo = rs.getString("titolo");
        returnValue.setTitolo(titolo);
        
        String body = rs.getString("body");
        returnValue.setBody(body);
        
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
