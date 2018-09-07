package it.gesan.module.medici.model.dao.jdbc;

import it.gesan.module.medici.model.dao.beans.MedicoBean;
import it.gesan.module.anagrafica.model.dao.jdbc.AnagraficaPgJDBC;
import it.gesan.module.anagrafica.vo.AnagraficaVO;
import it.gesan.module.medici.exception.DataException;
import it.gesan.module.medici.model.dao.interfaces.MediciDAO;
import it.gesan.module.medici.vo.MedicoVO;
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

public class MediciPgJDBC extends AnagraficaPgJDBC implements MediciDAO {

    private final String LISTA = "SELECT   gesan_anagrafica.cognome,\n"
            + "         gesan_anagrafica.nome,\n"
            + "         gesan_anagrafica.data_nascita,\n"
            + "         gesan_anagrafica.provincia_nascita,\n"
            + "         gesan_anagrafica.localita_nascita,\n"
            + "         gesan_anagrafica.codice_fiscale,\n"
            + "         gesan_strutture.denominazione,\n"
            + "         gesan_medici.id_specializzazione,\n"
            + "         gesan_medici.id_anagrafica,\n"
            + "         gesan_medici.id_struttura,\n"
            + "         gesan_medici.numero_ordine,\n"
            + "         gesan_medici.email,\n"
            + "         gesan_medici.create_date,\n"
            + "         gesan_medici.create_user,\n"
            + "         gesan_medici.update_date,\n"
            + "         gesan_medici.update_user,\n"
            + "         gesan_medici.proprietario,\n"
            + "         gesan_specializzazione_medico.descrizione,\n"
            + "         gesan_medici.id\n"
            + "FROM     gesan_medici \n"
            + "INNER JOIN gesan_anagrafica  ON gesan_medici.id_anagrafica = gesan_anagrafica.id \n"
            + "INNER JOIN gesan_strutture  ON gesan_medici.id_struttura = gesan_strutture.id \n"
            + "INNER JOIN gesan_specializzazione_medico  ON gesan_medici.id_specializzazione = gesan_specializzazione_medico.id ";

    private final String LISTA_REGISTRATI = "SELECT   gesan_anagrafica.cognome,\n"
            + "         gesan_anagrafica.nome,\n"
            + "         gesan_anagrafica.data_nascita,\n"
            + "         gesan_anagrafica.provincia_nascita,\n"
            + "         gesan_anagrafica.localita_nascita,\n"
            + "         gesan_anagrafica.codice_fiscale,\n"
            + "         gesan_strutture.denominazione,\n"
            + "         gesan_medici.id_specializzazione,\n"
            + "         gesan_medici.id_anagrafica,\n"
            + "         gesan_medici.id_struttura,\n"
            + "         gesan_medici.numero_ordine,\n"
            + "         gesan_medici.email,\n"
            + "         gesan_medici.create_date,\n"
            + "         gesan_medici.create_user,\n"
            + "         gesan_medici.update_date,\n"
            + "         gesan_medici.update_user,\n"
            + "         gesan_medici.proprietario,\n"
            + "         gesan_specializzazione_medico.descrizione,\n"
            + "         pub_security_utenti.id AS id_utente,\n"
            + "         gesan_medici.id\n"
            + "FROM     gesan_medici \n"
            + "INNER JOIN gesan_anagrafica  ON gesan_medici.id_anagrafica = gesan_anagrafica.id \n"
            + "INNER JOIN gesan_strutture  ON gesan_medici.id_struttura = gesan_strutture.id \n"
            + "INNER JOIN gesan_specializzazione_medico  ON gesan_medici.id_specializzazione = gesan_specializzazione_medico.id\n"
            + "INNER JOIN pub_security_utenti  ON pub_security_utenti.id_anagrafica = gesan_anagrafica.id\n"
            + "WHERE pub_security_utenti.username != ? ";

    private final String LISTA_BY_FILTER_ID = "SELECT   gesan_anagrafica.cognome,\n"
            + "         gesan_anagrafica.nome,\n"
            + "         gesan_anagrafica.data_nascita,\n"
            + "         gesan_anagrafica.provincia_nascita,\n"
            + "         gesan_anagrafica.localita_nascita,\n"
            + "         gesan_anagrafica.codice_fiscale,\n"
            + "         gesan_strutture.denominazione,\n"
            + "         gesan_medici.id_specializzazione,\n"
            + "         gesan_medici.id_anagrafica,\n"
            + "         gesan_medici.id_struttura,\n"
            + "         gesan_medici.numero_ordine,\n"
            + "         gesan_medici.email,\n"
            + "         gesan_medici.create_date,\n"
            + "         gesan_medici.create_user,\n"
            + "         gesan_medici.update_date,\n"
            + "         gesan_medici.update_user,\n"
            + "         gesan_medici.proprietario,\n"
            + "         gesan_specializzazione_medico.descrizione,\n"
            + "         gesan_medici.id\n"
            + "FROM     gesan_medici \n"
            + "INNER JOIN gesan_anagrafica  ON gesan_medici.id_anagrafica = gesan_anagrafica.id \n"
            + "INNER JOIN gesan_strutture  ON gesan_medici.id_struttura = gesan_strutture.id \n"
            + "INNER JOIN gesan_specializzazione_medico  ON gesan_medici.id_specializzazione = gesan_specializzazione_medico.id  WHERE gesan_medici.id in (?) OR gesan_medici.proprietario = ?;";

    //private final String MEDICO_BY_ID = "SELECT id_anagrafica, id_specializzazione, id_struttura, numero_ordine, create_date, create_user, update_date, update_user, proprietario, id FROM gesan_medici WHERE id = ?;";
    private final String MEDICO_BY_ID = "SELECT   gesan_anagrafica.cognome,\n"
            + "         gesan_anagrafica.nome,\n"
            + "         gesan_anagrafica.data_nascita,\n"
            + "         gesan_anagrafica.provincia_nascita,\n"
            + "         gesan_anagrafica.localita_nascita,\n"
            + "         gesan_anagrafica.codice_fiscale,\n"
            + "         gesan_strutture.denominazione,\n"
            + "         gesan_medici.id_specializzazione,\n"
            + "         gesan_medici.id_anagrafica,\n"
            + "         gesan_medici.id_struttura,\n"
            + "         gesan_medici.numero_ordine,\n"
            + "         gesan_medici.email,\n"
            + "         gesan_medici.create_date,\n"
            + "         gesan_medici.create_user,\n"
            + "         gesan_medici.update_date,\n"
            + "         gesan_medici.update_user,\n"
            + "         gesan_medici.proprietario,\n"
            + "         gesan_specializzazione_medico.descrizione,\n"
            + "         gesan_medici.id\n"
            + "FROM     gesan_medici \n"
            + "INNER JOIN gesan_anagrafica  ON gesan_medici.id_anagrafica = gesan_anagrafica.id \n"
            + "INNER JOIN gesan_strutture  ON gesan_medici.id_struttura = gesan_strutture.id \n"
            + "INNER JOIN gesan_specializzazione_medico  ON gesan_medici.id_specializzazione = gesan_specializzazione_medico.id \n"
            + "WHERE gesan_medici.id = ?; ";

    private final String MEDICO_BY_CODICE_FISCALE = "SELECT   gesan_anagrafica.cognome,\n"
            + "         gesan_anagrafica.nome,\n"
            + "         gesan_anagrafica.data_nascita,\n"
            + "         gesan_anagrafica.provincia_nascita,\n"
            + "         gesan_anagrafica.localita_nascita,\n"
            + "         gesan_anagrafica.codice_fiscale,\n"
            + "         gesan_strutture.denominazione,\n"
            + "         gesan_medici.id_specializzazione,\n"
            + "         gesan_medici.id_anagrafica,\n"
            + "         gesan_medici.id_struttura,\n"
            + "         gesan_medici.numero_ordine,\n"
            + "         gesan_medici.email,\n"
            + "         gesan_medici.create_date,\n"
            + "         gesan_medici.create_user,\n"
            + "         gesan_medici.update_date,\n"
            + "         gesan_medici.update_user,\n"
            + "         gesan_medici.proprietario,\n"
            + "         gesan_specializzazione_medico.descrizione,\n"
            + "         gesan_medici.id\n"
            + "FROM     gesan_medici \n"
            + "INNER JOIN gesan_anagrafica  ON gesan_medici.id_anagrafica = gesan_anagrafica.id \n"
            + "INNER JOIN gesan_strutture  ON gesan_medici.id_struttura = gesan_strutture.id \n"
            + "INNER JOIN gesan_specializzazione_medico  ON gesan_medici.id_specializzazione = gesan_specializzazione_medico.id \n"
            + "WHERE gesan_anagrafica.codice_fiscale = ?; ";

    private final String INSERT_MEDICO = "INSERT INTO gesan_medici (id_anagrafica, id_specializzazione, id_struttura, numero_ordine, create_date, create_user, update_date, update_user, proprietario, email, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE_MEDICO = "UPDATE gesan_medici SET id_anagrafica = ?, id_specializzazione = ?, id_struttura = ?, numero_ordine = ?, create_date = ?, create_user = ?, update_date = ?, update_user = ?, proprietario = ?, email = ? WHERE id = ? ;";

    private final String DELETE_MEDICO = "DELETE FROM gesan_medici WHERE id = ? ;";

    private final JDBCManager jdbcMan = new JDBCManager();

    @Override
    public EsitoBean getLista() throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA);
            rs = pstmt.executeQuery();
            ArrayList<MedicoBean> lista = new ArrayList<>();
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
    public EsitoBean getListaRegistrati(String username) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA_REGISTRATI);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            ArrayList<MedicoBean> lista = new ArrayList<>();
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
    public EsitoBean getLista(String filtroId, String proprietario) {
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
            ArrayList<MedicoBean> lista = new ArrayList<>();
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
    public EsitoBean getMedicoById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(MEDICO_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            MedicoBean object = new MedicoBean();
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
    public EsitoBean getMedicoByCodiceFiscale(String codiceFiscale) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(MEDICO_BY_CODICE_FISCALE);
            pstmt.setString(1, codiceFiscale);
            rs = pstmt.executeQuery();
            MedicoBean object = new MedicoBean();
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
    public EsitoBean salva(MedicoBean medicoBean) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        try {
            AnagraficaVO anagrafica = medicoBean.getAnagrafica();
            MedicoVO medicoVO = medicoBean.getMedico();

            medicoVO.setId(medicoBean.getPrimaryKey());
            medicoVO.setPrimaryKey(medicoBean.getPrimaryKey());
            connection = jdbcMan.getConnection();

            connection.setAutoCommit(false);

            esito = this.salva(anagrafica, connection);

            if (esito.getReturnValue() == ReturnValues.SAVED) {
                medicoVO.setIdAnagrafica(anagrafica.getPrimaryKey());
                esito = this.salva(medicoVO, connection);
                if (esito.getReturnValue() == ReturnValues.SAVED) {
                    esito.setEsito(true);
                    esito.setMessaggio("Salvataggio avvenuto con successo!");
                    connection.commit();
                } else {
                    connection.rollback();
                }
            } else {
                connection.rollback();
            }

        } catch (SQLException ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {

            }
            esito.setMessaggio(ex.getMessage());
        } finally {
            jdbcMan.close(connection);
        }

        return esito;
    }

    private EsitoBean salva(MedicoVO medicoVO, Connection connection) {
        EsitoBean esito = new EsitoBean();

        PreparedStatement pstmt = null;

        String id;
        String idAnagrafica = medicoVO.getIdAnagrafica();
        String idSpecializzazione = medicoVO.getIdSpecializzazione();
        String idStruttura = medicoVO.getIdStruttura();
        String numeroOrdine = medicoVO.getNumeroOrdine();
        Date createDate = medicoVO.getCreateDate();
        String createUser = medicoVO.getCreateUser();
        Date updateDate = medicoVO.getUpdateDate();
        String updateUser = medicoVO.getUpdateUser();
        String proprietario = medicoVO.getProprietario();
        String email = medicoVO.getEmail();

        try {

            if (medicoVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_MEDICO);
                id = UUID.randomUUID().toString();
            } else {
                id = medicoVO.getPrimaryKey();
                pstmt = connection.prepareStatement(UPDATE_MEDICO);
            }
            pstmt.setString(1, idAnagrafica);
            pstmt.setString(2, idSpecializzazione);
            pstmt.setString(3, idStruttura);
            pstmt.setString(4, numeroOrdine);
            pstmt.setTimestamp(5, new Timestamp(createDate.getTime()));
            pstmt.setString(6, createUser);
            pstmt.setTimestamp(7, new Timestamp(updateDate.getTime()));
            pstmt.setString(8, updateUser);
            pstmt.setString(9, proprietario);
            pstmt.setString(10, email);
            pstmt.setString(11, id);

            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                medicoVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(medicoVO);
            }

        } catch (Exception e) {
            esito.setReturnValue(ReturnValues.NOT_SAVED);
            esito.setMessaggio(e.getMessage());
            esito.setObject(medicoVO);
        } finally {
            jdbcMan.close(pstmt);
            //jdbcMan.close(connection);
        }

        return esito;
    }

    @Override
    public EsitoBean delete(MedicoVO medicoVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_DELETED);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            String id = medicoVO.getPrimaryKey();
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DELETE_MEDICO);
            pstmt.setString(1, id);
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                returnValue.setReturnValue(ReturnValues.DELETED);
                returnValue.setMessaggio("Cancellazione avvenuta con successo");
                returnValue.setObject(medicoVO);
            }
        } catch (Exception e) {
            returnValue.setMessaggio(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    private MedicoBean build(ResultSet rs) throws SQLException {
        MedicoBean returnValue = new MedicoBean();

        returnValue.setPrimaryKey(rs.getString("id"));

        String id = rs.getString("id");
        returnValue.setId(id);

        String idAnagrafica = rs.getString("id_anagrafica");
        returnValue.setIdAnagrafica(idAnagrafica);

        String idSpecializzazione = rs.getString("id_specializzazione");
        returnValue.setIdSpecializzazione(idSpecializzazione);

        String idStruttura = rs.getString("id_struttura");
        returnValue.setIdStruttura(idStruttura);

        String numeroOrdine = rs.getString("numero_ordine");
        returnValue.setNumeroOrdine(numeroOrdine);

        Date createDate = rs.getDate("create_date");
        returnValue.setCreateDate(createDate);

        String createUser = rs.getString("create_user");
        returnValue.setCreateUser(createUser);

        Date updateDate = rs.getDate("update_date");
        returnValue.setUpdateDate(updateDate);

        String updateUser = rs.getString("update_user");
        returnValue.setUpdateUser(updateUser);

        String proprietario = rs.getString("proprietario");
        returnValue.setProprietario(proprietario);

        String cognome = rs.getString("cognome");
        returnValue.setCognome(cognome);

        String nome = rs.getString("nome");
        returnValue.setNome(nome);

        Date dataNascita = rs.getTimestamp("data_nascita");
        returnValue.setDataNascita(dataNascita);

        String provinciaNascita = rs.getString("provincia_nascita");
        returnValue.setProvinciaNascita(provinciaNascita);

        String localitaNascita = rs.getString("localita_nascita");
        returnValue.setLocalitaNascita(localitaNascita);

        String codiceFiscale = rs.getString("codice_fiscale");
        returnValue.setCodiceFiscale(codiceFiscale);

        String denominazione = rs.getString("denominazione");
        returnValue.setDenominazione(denominazione);

        String descrizione = rs.getString("descrizione");
        returnValue.setDescrizione(descrizione);

        String email = rs.getString("email");
        returnValue.setEmail(email);

        try {
            String idUtente = rs.getString("id_utente");
            returnValue.setIdUtente(idUtente);
        } catch (java.sql.SQLException e) {

        }

//        String sesso = rs.getString("sesso");
//        returnValue.setSesso(sesso);
        return returnValue;
    }

}
