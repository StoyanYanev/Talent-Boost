package org.talentboost.spring.spring.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.talentboost.spring.spring.IRepository;
import org.talentboost.spring.spring.data.UserAccount;

import java.util.List;

@Repository
public class JavaJdbcRepository implements IRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getCapitalOf(String country) {
        return jdbcTemplate.queryForObject("select capital from capitals where country like ?", new Object[]{country}, String.class);
    }

    @Override
    public List<String> getCountries() {
        return jdbcTemplate.queryForList("select country from capitals", String.class);
    }

    @Override
    public List<UserAccount> getAccounts() {
        return jdbcTemplate.query("select name, role from users, roles where users.role_id=roles.id", new UserAccountMapper());
    }
}
