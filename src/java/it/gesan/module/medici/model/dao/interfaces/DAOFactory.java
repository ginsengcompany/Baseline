package it.gesan.module.medici.model.dao.interfaces;

import java.util.ResourceBundle;

public class DAOFactory {

        private static ResourceBundle bundle;

        private static String DAO_CONFIG = "it/gesan/module/medici/config/DAOConfig";

        public static String getDAO_CONFIG() {
                return DAO_CONFIG;
        }

        public static void setConfig(String dao_config) {
                DAO_CONFIG = dao_config;
        }

        static {
                try {
                        bundle = ResourceBundle.getBundle(DAO_CONFIG);
                } catch (RuntimeException e) {
                        //logger.error("DAOConfig.properties non trovato.", e);
                }
        }

        public static Object getDAO(String className) throws DAOException {
                Object dao = null;
                String daoClassName = bundle.getString(className);
                try {
                        dao = (Object) Class.forName(daoClassName).newInstance();
                } catch (Throwable e) {
                        String errorMessage = "Errore nella creazione del DAO: " + className;
                        //logger.error(errorMessage, e);
                        throw new DAOException(errorMessage, e);
                }
                return dao;
        }
}
