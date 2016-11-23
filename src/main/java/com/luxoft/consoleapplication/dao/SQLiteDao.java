package com.luxoft.consoleapplication.dao;


import com.luxoft.consoleapplication.model.LineReport;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SQLiteDao implements StringsDao {

    private NamedParameterJdbcTemplate jdbcTemplate;

    public SQLiteDao() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("org.sqlite.JDBC");
        source.setUrl("jdbc:sqlite:db/StringsDB.db");
        jdbcTemplate = new NamedParameterJdbcTemplate(source);
    }

    public void insert(LineReport report) {
        String insetReport = "insert into string_statistics VALUES " +
                "(:line, :lenght, :shortest, :longest, :averageLength)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("line", report.getLine());
        params.addValue("lenght", report.getLineLength());
        params.addValue("shortest", report.getShortest());
        params.addValue("longest", report.getLongest());
        params.addValue("averageLength", report.getAverage());

        jdbcTemplate.update(insetReport, params);
    }

    public void delete(LineReport report) {
        String insetReport = "DELETE FROM string_statistics WHERE string =:string";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("string", report.getLine());

        jdbcTemplate.update(insetReport, params);
    }

    public List<LineReport> getAllReports(){
        String sql = "select * from string_statistics";

        MapSqlParameterSource params = new MapSqlParameterSource();

        return jdbcTemplate.query(sql, params, new ReportRowMapper());
    }

    private class ReportRowMapper implements RowMapper<LineReport> {
        @Override
        public LineReport mapRow(ResultSet resultSet, int i) throws SQLException {
            LineReport report = new LineReport();
            report.setLine(resultSet.getString("string"));
            report.setLongest(resultSet.getString("longest"));
            report.setShortest(resultSet.getString("shortest"));
            report.setLineLength(resultSet.getInt("lenght"));
            report.setAverage(resultSet.getInt("average_length"));

            return report;
        }
    }


}
