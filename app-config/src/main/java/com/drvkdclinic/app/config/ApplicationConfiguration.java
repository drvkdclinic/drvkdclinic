package com.drvkdclinic.app.config;

import com.drvkdclinic.daoitf.IPersonDAO;
import com.drvkdclinic.db.conn.DBConnectionManager;
import com.drvkdclinic.db.dao.DBPersonDAO;
import com.drvkdclinic.entity.Person;
import com.drvkdclinic.repository.PersonRepository;
import com.drvkdclinic.services.PersonService;

import java.sql.Connection;
import java.sql.SQLException;

public class ApplicationConfiguration {

    private ApplicationConfiguration() {

        try {
            Connection connection = DBConnectionManager.getConnection();
            mPersonDAO = new DBPersonDAO(connection);

            mPersonRepository = new PersonRepository(mPersonDAO);
            mPersonService = new PersonService(mPersonRepository);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createInstance() {
        if (mAppConfig == null) {
            mAppConfig = new ApplicationConfiguration();
        }
    }

    public static PersonService getPersonService() {
        createInstance();
        return mAppConfig.mPersonService;
    }

    private static ApplicationConfiguration mAppConfig;
    private IPersonDAO mPersonDAO;
    private PersonRepository mPersonRepository;
    private final PersonService mPersonService;
}
