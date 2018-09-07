package it.gesan.module.allegati.model.dao.jdbc;

import it.gesan.module.allegati.exception.DataException;
import it.gesan.module.allegati.model.dao.interfaces.AllegatiDAO;
import it.gesan.module.allegati.vo.AllegatoVO;
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


public class AllegatiPgJDBC implements AllegatiDAO {

    private final String LISTA = "SELECT data, id_riferimento, descrizione_tipo, tipo_riferimento, tipo_file, update_date, estensione, descrizione, codice_tipo, file, update_user, proprietario, id, create_user, create_date, id FROM gesan_allegati;";
    
    private final String LISTA_BY_ID_RISORSA_TIPO_RISORSA = "SELECT data, id_riferimento, descrizione_tipo, tipo_riferimento, tipo_file, update_date, estensione, descrizione, codice_tipo, file, update_user, proprietario, id, create_user, create_date, id FROM gesan_allegati WHERE id_riferimento = ? AND tipo_riferimento = ?";

    private final String ALLEGATO_BY_ID = "SELECT data, id_riferimento, descrizione_tipo, tipo_riferimento, tipo_file, update_date, estensione, descrizione, codice_tipo, file, update_user, proprietario, id, create_user, create_date, id FROM gesan_allegati WHERE id = ?;";

    private final String INSERT_ALLEGATO = "INSERT INTO gesan_allegati (data, id_riferimento, descrizione_tipo, tipo_riferimento, tipo_file, update_date, estensione, descrizione, codice_tipo, file, update_user, proprietario, create_user, create_date, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE_ALLEGATO = "UPDATE gesan_allegati SET data = ?, id_riferimento = ?, descrizione_tipo = ?, tipo_riferimento = ?, tipo_file = ?, update_date = ?, estensione = ?, descrizione = ?, codice_tipo = ?, file = ?, update_user = ?, proprietario = ?, id = ?, create_user = ?, create_date = ?, id = ? WHERE id = ? ;";

    private final String DELETE_ALLEGATO = "DELETE FROM gesan_allegati WHERE id = ? ;";

    private final JDBCManager jdbcMan = new JDBCManager();
    
    @Override
    public EsitoBean getLista(AllegatoVO allegatoVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA);
            rs = pstmt.executeQuery();
            ArrayList<AllegatoVO> lista = new ArrayList<>();
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
    public EsitoBean getLista(String idRisorsa, String tipoRisorsa) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA_BY_ID_RISORSA_TIPO_RISORSA);
            pstmt.setString(1, idRisorsa);
            pstmt.setString(2, tipoRisorsa);
            rs = pstmt.executeQuery();
            ArrayList<AllegatoVO> lista = new ArrayList<>();
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
    public EsitoBean getAllegatoById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(ALLEGATO_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            AllegatoVO object = new AllegatoVO();
            if (rs.next()) {
                object= this.build(rs);
                returnValue.setReturnValue(ReturnValues.FOUND);
                returnValue.setObject(object);
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
    public EsitoBean salva(AllegatoVO allegatoVO) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;

        Date data = allegatoVO.getData();
        String idRiferimento = allegatoVO.getIdRiferimento();
        String descrizioneTipo = allegatoVO.getDescrizioneTipo();
        String tipoRiferimento = allegatoVO.getTipoRiferimento();
        String tipoFile = allegatoVO.getTipoFile();
        Date updateDate = allegatoVO.getUpdateDate();
        String estensione = allegatoVO.getEstensione();
        String descrizione = allegatoVO.getDescrizione();
        String codiceTipo = allegatoVO.getCodiceTipo();
        String file = allegatoVO.getFile();
        String updateUser = allegatoVO.getUpdateUser();
        String proprietario = allegatoVO.getProprietario();
        String id = allegatoVO.getId();
        String createUser = allegatoVO.getCreateUser();
        Date createDate = allegatoVO.getCreateDate();

        try {

            connection = jdbcMan.getConnection();

            if (allegatoVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_ALLEGATO);
                id = UUID.randomUUID().toString(); 
                data = new Date();
            } else {
                pstmt = connection.prepareStatement(UPDATE_ALLEGATO);
            }
            pstmt.setTimestamp(1, new Timestamp(data.getTime()));
            pstmt.setString(2, idRiferimento);
            pstmt.setString(3, descrizioneTipo);
            pstmt.setString(4, tipoRiferimento);
            pstmt.setString(5, tipoFile);
            pstmt.setTimestamp(6, new Timestamp(updateDate.getTime()));
            pstmt.setString(7, estensione);
            pstmt.setString(8, descrizione);
            pstmt.setString(9, codiceTipo);
            pstmt.setString(10, file);
            pstmt.setString(11, updateUser);
            pstmt.setString(12, proprietario);
            pstmt.setString(13, createUser);
            pstmt.setTimestamp(14, new Timestamp(createDate.getTime()));
            pstmt.setString(15, id);
            
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                allegatoVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(allegatoVO);
                esito.setEsito(true);
            }

            } catch (Exception e) {
                esito.setReturnValue(ReturnValues.NOT_SAVED);
                esito.setMessaggio(e.getMessage());
                esito.setObject(allegatoVO);
            } finally {
                jdbcMan.close(pstmt);
                jdbcMan.close(connection);
            }

        return esito;
    }

    @Override
    public EsitoBean delete(AllegatoVO allegatoVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_DELETED);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            String id = allegatoVO.getPrimaryKey();
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DELETE_ALLEGATO);
            pstmt.setString(1, id);
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                returnValue.setReturnValue(ReturnValues.DELETED);
                returnValue.setMessaggio("Cancellazione avvenuta con successo");
                returnValue.setObject(allegatoVO);
            }
        } catch (Exception e) {
            throw new DataException(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    private AllegatoVO build(ResultSet rs) throws SQLException {
        AllegatoVO returnValue = new AllegatoVO();

        returnValue.setPrimaryKey(rs.getString("id"));

        Date data = rs.getDate("data");
        returnValue.setData(data);

        String idRiferimento = rs.getString("id_riferimento");
        returnValue.setIdRiferimento(idRiferimento);

        String descrizioneTipo = rs.getString("descrizione_tipo");
        returnValue.setDescrizioneTipo(descrizioneTipo);

        String tipoRiferimento = rs.getString("tipo_riferimento");
        returnValue.setTipoRiferimento(tipoRiferimento);

        String tipoFile = rs.getString("tipo_file");
        returnValue.setTipoFile(tipoFile);

        Date updateDate = rs.getDate("update_date");
        returnValue.setUpdateDate(updateDate);

        String estensione = rs.getString("estensione");
        returnValue.setEstensione(estensione);

        String descrizione = rs.getString("descrizione");
        returnValue.setDescrizione(descrizione);

        String codiceTipo = rs.getString("codice_tipo");
        returnValue.setCodiceTipo(codiceTipo);

        String file = rs.getString("file");
        returnValue.setFile(file);

        String updateUser = rs.getString("update_user");
        returnValue.setUpdateUser(updateUser);

        String proprietario = rs.getString("proprietario");
        returnValue.setProprietario(proprietario);

        String id = rs.getString("id");
        returnValue.setId(id);

        String createUser = rs.getString("create_user");
        returnValue.setCreateUser(createUser);

        Date createDate = rs.getDate("create_date");
        returnValue.setCreateDate(createDate);

        return returnValue;
    } 

};
