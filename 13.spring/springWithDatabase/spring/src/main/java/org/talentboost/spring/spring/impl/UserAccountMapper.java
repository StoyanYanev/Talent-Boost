package org.talentboost.spring.spring.impl;

import org.springframework.jdbc.core.RowMapper;
import org.talentboost.spring.spring.data.UserAccount;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAccountMapper implements RowMapper<UserAccount> {

    @Override
    public UserAccount mapRow(ResultSet resultSet, int i) throws SQLException {
        return new UserAccount(resultSet.getString("name"), resultSet.getString("role"));
    }
}
