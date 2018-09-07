package it.gesan.module.anagrafica.model.dao.jdbc;

import it.gesan.module.anagrafica.exception.DataException;
import it.gesan.module.anagrafica.model.dao.interfaces.AnagraficaDAO;
import it.gesan.module.anagrafica.vo.AnagraficaVO;
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


public class AnagraficaPgJDBC implements AnagraficaDAO {

    private final String LISTA = "SELECT update_user, codice_fiscale, cognome, data_nascita, nome, provincia_nascita, create_user, create_date, localita_nascita, update_date, codice_fiscale_madre, codice_fiscale_padre, id FROM gesan_anagrafica;";
    
    private final String LISTA_BY_FILTRO_ID = "SELECT gesan_strutture.denominazione, gesan_tipo_anagrafica.descrizione AS \"tipo_anagrafica_descrizione\", gesan_anagrafica_tipo.id_tipo_anagrafica, gesan_anagrafica.* FROM gesan_anagrafica\n" +
"LEFT JOIN gesan_anagrafica_tipo ON gesan_anagrafica_tipo.id_anagrafica = gesan_anagrafica.id\n" +
"LEFT JOIN gesan_tipo_anagrafica ON gesan_tipo_anagrafica.id = gesan_anagrafica_tipo.id_tipo_anagrafica\n" +
"LEFT JOIN pub_security_utenti ON pub_security_utenti.username = gesan_anagrafica.proprietario\n" +
"LEFT JOIN gesan_strutture ON gesan_strutture.id = pub_security_utenti.id_anagrafica\n" +
"WHERE gesan_anagrafica_tipo.id_tipo_anagrafica = '3' AND (gesan_anagrafica.id in (?) OR gesan_anagrafica.proprietario = ? ) ORDER BY gesan_anagrafica.cognome, gesan_anagrafica.nome;";
    
    private final String LISTA_PAZIENTI = "SELECT gesan_strutture.denominazione, gesan_tipo_anagrafica.descrizione AS \"tipo_anagrafica_descrizione\", gesan_anagrafica_tipo.id_tipo_anagrafica, gesan_anagrafica.* FROM gesan_anagrafica\n" +
"LEFT JOIN gesan_anagrafica_tipo ON gesan_anagrafica_tipo.id_anagrafica = gesan_anagrafica.id\n" +
"LEFT JOIN gesan_tipo_anagrafica ON gesan_tipo_anagrafica.id = gesan_anagrafica_tipo.id_tipo_anagrafica\n" +
"LEFT JOIN pub_security_utenti ON pub_security_utenti.username = gesan_anagrafica.proprietario\n" +
"LEFT JOIN gesan_strutture ON gesan_strutture.id = pub_security_utenti.id_anagrafica\n" +
"WHERE gesan_anagrafica_tipo.id_tipo_anagrafica = '3'";

    private final String ANAGRAFICA_BY_ID = "SELECT update_user, codice_fiscale, cognome, data_nascita, nome, provincia_nascita, create_user, create_date, localita_nascita, update_date, codice_fiscale_madre, codice_fiscale_padre, id FROM gesan_anagrafica WHERE id = ?;";

    private final String INSERT_ANAGRAFICA = "INSERT INTO gesan_anagrafica (update_user, codice_fiscale, cognome, data_nascita, nome, provincia_nascita, create_user, create_date, localita_nascita, update_date, codice_fiscale_madre, codice_fiscale_padre, proprietario, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE_ANAGRAFICA = "UPDATE gesan_anagrafica SET update_user = ?, codice_fiscale = ?, cognome = ?, data_nascita = ?, nome = ?, provincia_nascita = ?, create_user = ?, create_date = ?, localita_nascita = ?, update_date = ?, proprietario = ? WHERE id = ? ;";

    private final String DELETE_ANAGRAFICA = "DELETE FROM gesan_anagrafica WHERE id = ? ;";

    private final JDBCManager jdbcMan = new JDBCManager();
    
    @Override
    public EsitoBean getLista(AnagraficaVO anagraficaVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA_PAZIENTI);
            rs = pstmt.executeQuery();
            ArrayList<AnagraficaVO> lista = new ArrayList<>();
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
    public EsitoBean getLista(String filtriId, String usernameProprietrio) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA_BY_FILTRO_ID);
            pstmt.setString(1, filtriId);
            pstmt.setString(2, usernameProprietrio);
            rs = pstmt.executeQuery();
            ArrayList<AnagraficaVO> lista = new ArrayList<>();
            while (rs.next()) {
                lista.add(this.build(rs));
            }
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
    public EsitoBean getAnagraficaById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(ANAGRAFICA_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            AnagraficaVO object = new AnagraficaVO();
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
    public EsitoBean salva(AnagraficaVO anagraficaVO) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;

        String updateUser = anagraficaVO.getUpdateUser();
        String codiceFiscale = (anagraficaVO.getCodiceFiscale() == null) ? null : anagraficaVO.getCodiceFiscale().toUpperCase();
        String cognome = anagraficaVO.getCognome().toUpperCase();
        Date dataNascita = anagraficaVO.getDataNascita();
        String nome = anagraficaVO.getNome().toUpperCase();
        String provinciaNascita = anagraficaVO.getProvinciaNascita();
        String id = anagraficaVO.getId();
        String createUser = anagraficaVO.getCreateUser();
        Date createDate = anagraficaVO.getCreateDate();
        String localitaNascita = anagraficaVO.getLocalitaNascita();
        Date updateDate = anagraficaVO.getUpdateDate();
        String proprietario = anagraficaVO.getProprietario();
        
        try {

            connection = jdbcMan.getConnection();

            if (anagraficaVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_ANAGRAFICA);
                id = UUID.randomUUID().toString();
            } else {
                pstmt = connection.prepareStatement(UPDATE_ANAGRAFICA);
            }
            pstmt.setString(1, updateUser);
            pstmt.setString(2, codiceFiscale);
            pstmt.setString(3, cognome);
            pstmt.setTimestamp(4, new Timestamp(dataNascita.getTime()));
            pstmt.setString(5, nome);
            pstmt.setString(6, provinciaNascita);
            pstmt.setString(7, createUser);
            pstmt.setTimestamp(8, new Timestamp(createDate.getTime()));
            pstmt.setString(9, localitaNascita);
            pstmt.setTimestamp(10, new Timestamp(updateDate.getTime()));
            pstmt.setString(11, proprietario);
            pstmt.setString(12, id);

            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                anagraficaVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(anagraficaVO);
            }

            } catch (Exception e) {
                esito.setReturnValue(ReturnValues.NOT_SAVED);
                esito.setMessaggio(e.getMessage());
                esito.setObject(anagraficaVO);
            } finally {
                jdbcMan.close(pstmt);
                jdbcMan.close(connection);
            }

        return esito;
    }

    protected EsitoBean salva(AnagraficaVO anagraficaVO, Connection connection)  {
        EsitoBean esito = new EsitoBean();
        
        PreparedStatement pstmt = null;

        String updateUser = anagraficaVO.getUpdateUser();
        String codiceFiscale = (anagraficaVO.getCodiceFiscale() == null) ? null : anagraficaVO.getCodiceFiscale().toUpperCase();
        String cognome = anagraficaVO.getCognome().toUpperCase();
        Date dataNascita = anagraficaVO.getDataNascita();
        String nome = anagraficaVO.getNome().toUpperCase();
        String provinciaNascita = anagraficaVO.getProvinciaNascita();
        String id = anagraficaVO.getId();
        String createUser = anagraficaVO.getCreateUser();
        Date createDate = anagraficaVO.getCreateDate();
        String localitaNascita = anagraficaVO.getLocalitaNascita();
        Date updateDate = anagraficaVO.getUpdateDate();
        String proprietario = anagraficaVO.getProprietario();
        
        try {
            if (anagraficaVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_ANAGRAFICA);
                id = UUID.randomUUID().toString();
            } else {
                pstmt = connection.prepareStatement(UPDATE_ANAGRAFICA);
            }
            pstmt.setString(1, updateUser);
            pstmt.setString(2, codiceFiscale);
            pstmt.setString(3, cognome);
            pstmt.setTimestamp(4, new Timestamp(dataNascita.getTime()));
            pstmt.setString(5, nome);
            pstmt.setString(6, provinciaNascita);
            pstmt.setString(7, createUser);
            pstmt.setTimestamp(8, new Timestamp(createDate.getTime()));
            pstmt.setString(9, localitaNascita);
            pstmt.setTimestamp(10, new Timestamp(updateDate.getTime()));
            pstmt.setString(11, proprietario);
            pstmt.setString(12, id);

            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                anagraficaVO.setId(id);
                anagraficaVO.setPrimaryKey(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(anagraficaVO);
            }

            } catch (Exception e) {
                esito.setReturnValue(ReturnValues.NOT_SAVED);
                esito.setMessaggio("SALVA ANAGRAFICA: " + e.toString());
                esito.setObject(anagraficaVO);
            } finally {
                jdbcMan.close(pstmt);
            }

        return esito;
    }

    @Override
    public EsitoBean delete(AnagraficaVO anagraficaVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_DELETED);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            String id = anagraficaVO.getPrimaryKey();
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DELETE_ANAGRAFICA);
            pstmt.setString(1, id);
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                returnValue.setReturnValue(ReturnValues.DELETED);
                returnValue.setMessaggio("Cancellazione avvenuta con successo");
                returnValue.setObject(anagraficaVO);
            }
        } catch (Exception e) {
            throw new DataException(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    private AnagraficaVO build(ResultSet rs) throws SQLException {
        AnagraficaVO returnValue = new AnagraficaVO();

        returnValue.setPrimaryKey(rs.getString("id"));

        String updateUser = rs.getString("update_user");
        returnValue.setUpdateUser(updateUser);

        String codiceFiscale = rs.getString("codice_fiscale");
        returnValue.setCodiceFiscale(codiceFiscale);

        String cognome = rs.getString("cognome");
        returnValue.setCognome(cognome);

        Date dataNascita = rs.getTimestamp("data_nascita");
        returnValue.setDataNascita(dataNascita);

        String nome = rs.getString("nome");
        returnValue.setNome(nome);

        String provinciaNascita = rs.getString("provincia_nascita");
        returnValue.setProvinciaNascita(provinciaNascita);

        String id = rs.getString("id");
        returnValue.setId(id);

        String createUser = rs.getString("create_user");
        returnValue.setCreateUser(createUser);

        Date createDate = rs.getTimestamp("create_date");
        returnValue.setCreateDate(createDate);

        String localitaNascita = rs.getString("localita_nascita");
        returnValue.setLocalitaNascita(localitaNascita);

        Date updateDate = rs.getTimestamp("update_date");
        returnValue.setUpdateDate(updateDate);

        String proprietario = rs.getString("proprietario");
        returnValue.setProprietario(proprietario);

        String denominazione = rs.getString("denominazione");
        returnValue.setDenominazione(denominazione);

        return returnValue;
    } 

};
