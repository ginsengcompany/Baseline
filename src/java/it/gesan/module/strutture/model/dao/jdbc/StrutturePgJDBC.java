package it.gesan.module.strutture.model.dao.jdbc;

import it.gesan.module.strutture.exception.DataException;
import it.gesan.module.strutture.model.dao.interfaces.StruttureDAO;
import it.gesan.module.strutture.vo.StrutturaVO;
import it.gesan.rdb.JDBCManager;
import it.gesan.rdb.beans.EsitoBean;
import it.gesan.rdb.constants.ReturnValues;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.ArrayList;


public class StrutturePgJDBC implements StruttureDAO {

    private final String LISTA = "SELECT codice_sys, abilitata, indirizzo, codice_distretto, provincia, codice_struttura, comune, legale_rappresentante, denominazione, codice_regione, telefono, fax, email, partita_iva, id FROM gesan_strutture;";

    private final String STRUTTURA_BY_ID = "SELECT codice_sys, abilitata, indirizzo, codice_distretto, provincia, codice_struttura, comune, legale_rappresentante, denominazione, codice_regione, telefono, fax, email, partita_iva, id FROM gesan_strutture WHERE id = ?;";
    
    private final String STRUTTURA_BY_CODICE_STRUTTURA = "SELECT codice_sys, abilitata, indirizzo, codice_distretto, provincia, codice_struttura, comune, legale_rappresentante, denominazione, codice_regione, telefono, fax, email, partita_iva, id FROM gesan_strutture WHERE codice_struttura = ?;";

    private final String INSERT_STRUTTURA = "INSERT INTO gesan_strutture (codice_sys, abilitata, indirizzo, codice_distretto, provincia, codice_struttura, comune, legale_rappresentante, denominazione, codice_regione, telefono, fax, email, partita_iva, id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE_STRUTTURA = "UPDATE gesan_strutture SET codice_sys = ?, abilitata = ?, indirizzo = ?, codice_distretto = ?, provincia = ?, codice_struttura = ?, comune = ?, legale_rappresentante = ?, denominazione = ?, codice_regione = ?, telefono = ?, fax = ?, email = ?, partita_iva = ? WHERE id = ? ;";

    private final String DELETE_STRUTTURA = "DELETE FROM gesan_strutture WHERE id = ? ;";

    private final JDBCManager jdbcMan = new JDBCManager();
    @Override
    public EsitoBean getLista(StrutturaVO strutturaVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(LISTA);
            rs = pstmt.executeQuery();
            ArrayList<StrutturaVO> lista = new ArrayList<>();
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
    public EsitoBean getStrutturaById(String id) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(STRUTTURA_BY_ID);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            StrutturaVO object = new StrutturaVO();
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
    public EsitoBean getStrutturaByCodiceStruttura(String codiceStruttura) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_FOUND);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(STRUTTURA_BY_CODICE_STRUTTURA);
            pstmt.setString(1, codiceStruttura.substring(3, 6));
            rs = pstmt.executeQuery();
            StrutturaVO object = new StrutturaVO();
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
    public EsitoBean salva(StrutturaVO strutturaVO) throws DataException {
        EsitoBean esito = new EsitoBean();
        Connection connection = null;
        PreparedStatement pstmt = null;

        String codiceSys = strutturaVO.getCodiceSys();
        boolean abilitata = strutturaVO.isAbilitata();
        String indirizzo = strutturaVO.getIndirizzo();
        String codiceDistretto = strutturaVO.getCodiceDistretto();
        String provincia = strutturaVO.getProvincia();
        String codiceStruttura = strutturaVO.getCodiceStruttura();
        String comune = strutturaVO.getComune();
        String legaleRappresentante = strutturaVO.getLegaleRappresentante();
        String denominazione = strutturaVO.getDenominazione();
        String id = strutturaVO.getId();
        String codiceRegione = strutturaVO.getCodiceRegione();
        String telefono = strutturaVO.getTelefono();
        String fax = strutturaVO.getFax();
        String email = strutturaVO.getEmail();
        String partitaIva = strutturaVO.getPartitaIva();

        try {

            connection = jdbcMan.getConnection();

            if (strutturaVO.getPrimaryKey() == null) {
                pstmt = connection.prepareStatement(INSERT_STRUTTURA);
                id = UUID.randomUUID().toString(); 
            } else {
                pstmt = connection.prepareStatement(UPDATE_STRUTTURA);
            }
            pstmt.setString(1, codiceSys);
            pstmt.setBoolean(2, abilitata);
            pstmt.setString(3, indirizzo);
            pstmt.setString(4, codiceDistretto);
            pstmt.setString(5, provincia);
            pstmt.setString(6, codiceStruttura);
            pstmt.setString(7, comune);
            pstmt.setString(8, legaleRappresentante);
            pstmt.setString(9, denominazione);
            pstmt.setString(10, codiceRegione);
            pstmt.setString(11, telefono);
            pstmt.setString(12, fax);
            pstmt.setString(13, email);
            pstmt.setString(14, partitaIva);
            pstmt.setString(15, id);

            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                strutturaVO.setId(id);
                esito.setReturnValue(ReturnValues.SAVED);
                esito.setMessaggio("Salvataggio avvenuto con successo");
                esito.setObject(strutturaVO);
            }

            } catch (Exception e) {
                esito.setReturnValue(ReturnValues.NOT_SAVED);
                esito.setMessaggio(e.getMessage());
                esito.setObject(strutturaVO);
            } finally {
                jdbcMan.close(pstmt);
                jdbcMan.close(connection);
            }

        return esito;
    }

    @Override
    public EsitoBean delete(StrutturaVO strutturaVO) throws DataException {
        EsitoBean returnValue = new EsitoBean();
        returnValue.setReturnValue(ReturnValues.NOT_DELETED);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs;

        try {
            String id = strutturaVO.getPrimaryKey();
            connection = jdbcMan.getConnection();
            pstmt = connection.prepareStatement(DELETE_STRUTTURA);
            pstmt.setString(1, id);
            int exu = pstmt.executeUpdate();
            if (exu > 0) {
                returnValue.setReturnValue(ReturnValues.DELETED);
                returnValue.setMessaggio("Cancellazione avvenuta con successo");
                returnValue.setObject(strutturaVO);
            }
        } catch (Exception e) {
            throw new DataException(e.getMessage());
        } finally {
            jdbcMan.close(pstmt);
            jdbcMan.close(connection);
        }

        return returnValue;
    }

    private StrutturaVO build(ResultSet rs) throws SQLException {
        StrutturaVO returnValue = new StrutturaVO();

        returnValue.setPrimaryKey(rs.getString("id"));

        String codiceSys = rs.getString("codice_sys");
        returnValue.setCodiceSys(codiceSys);

        boolean abilitata = rs.getBoolean("abilitata");
        returnValue.setAbilitata(abilitata);

        String indirizzo = rs.getString("indirizzo");
        returnValue.setIndirizzo(indirizzo);

        String codiceDistretto = rs.getString("codice_distretto");
        returnValue.setCodiceDistretto(codiceDistretto);

        String provincia = rs.getString("provincia");
        returnValue.setProvincia(provincia);

        String codiceStruttura = rs.getString("codice_struttura");
        returnValue.setCodiceStruttura(codiceStruttura);

        String comune = rs.getString("comune");
        returnValue.setComune(comune);

        String legaleRappresentante = rs.getString("legale_rappresentante");
        returnValue.setLegaleRappresentante(legaleRappresentante);

        String denominazione = rs.getString("denominazione");
        returnValue.setDenominazione(denominazione);

        String id = rs.getString("id");
        returnValue.setId(id);

        String codiceRegione = rs.getString("codice_regione");
        returnValue.setCodiceRegione(codiceRegione);

        String telefono = rs.getString("telefono");
        returnValue.setTelefono(telefono);

        String fax = rs.getString("fax");
        returnValue.setFax(fax);

        String email = rs.getString("email");
        returnValue.setEmail(email);

        String partitaIva = rs.getString("partita_iva");
        returnValue.setPartitaIva(partitaIva);

        return returnValue;
    } 

};
