package ru.innopolis.dz_16.task_1;

//import ch.qos.logback.classic.spi.ILoggingEvent;
//import ch.qos.logback.core.db.DBAppenderBase;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * https://github.com/qos-ch/logback/blob/master/logback-access/src/main/java/ch/qos/logback/access/db/DBAppender.java
 */

public class CustomDBAppender { /*extends DBAppenderBase<ILoggingEvent> {
    protected static final Method GET_GENERATED_KEYS_METHOD;
    protected static final String INSERTSQL;

    static {
        Method getGeneratedKeysMethod;
        try {
            getGeneratedKeysMethod = PreparedStatement.class.getMethod("getGeneratedKeys", (Class[]) null);
        } catch (Exception ex) {
            getGeneratedKeysMethod = null;
        }
        GET_GENERATED_KEYS_METHOD = getGeneratedKeysMethod;

        INSERTSQL = "insert into logs (log_level, message, exception) values (?, ?, ?)";
    }

    @Override
    protected Method getGeneratedKeysMethod() {
        return GET_GENERATED_KEYS_METHOD;
    }

    @Override
    protected String getInsertSQL() {
        return INSERTSQL;
    }

    @Override
    protected void subAppend(ILoggingEvent eventObject, Connection connection, PreparedStatement statement) throws Throwable {
        PreparedStatement preparedStatement = null;
        try (Connection connectDB = connection) {
            preparedStatement = connectDB.prepareStatement(INSERTSQL);
            preparedStatement.setString(1, eventObject.getLevel().levelStr);
            if ("INFO".equals(eventObject.getLevel().levelStr)) {
                preparedStatement.setString(2, eventObject.getMessage());
            } else {
                preparedStatement.setString(2, null);
            }
            if ("ERROR".equals(eventObject.getLevel().levelStr)) {
                preparedStatement.setString(3, eventObject.getMessage());
            } else {
                preparedStatement.setString(3, null);
            }
            preparedStatement.execute();
            connectDB.commit();
        }
    }

    @Override
    protected void secondarySubAppend(ILoggingEvent eventObject, Connection connection, long eventId) throws Throwable {
    }*/
}