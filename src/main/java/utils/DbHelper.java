package utils;

import java.sql.*;

public class DbHelper {
    private final String CLASS_NAME;
    private final String DB_URL;

    public DbHelper(String CLASS_NAME, String DB_URL){
        this.CLASS_NAME = CLASS_NAME;
        this.DB_URL = DB_URL;
    }

    public Connection createConnection(){
        Connection conn = null;
        try{
            Class.forName(this.CLASS_NAME);
            conn = DriverManager.getConnection(this.DB_URL);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public int doUpdate(String sql){
        try (Connection conn = createConnection();
             Statement stmt = conn.createStatement()){
            return stmt.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int doUpdate(String sql, StatementPreparor statementPreparor) throws SQLException{
        try(Connection conn = createConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            statementPreparor.prepare(ps);
            return ps.executeUpdate();
        }catch (SQLException e){
            throw e;
        }
    }

    public int[] doBatchUpdate(String sql, StatementPreparor statementPreparor){
        try (Connection conn = createConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            statementPreparor.prepare(ps);
            conn.setAutoCommit(false);
            int[] ret = ps.executeBatch();
            conn.commit();
            return ret;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void doQuery(String sql, ResultHandler resultHandler){
        try (Connection conn = createConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)){
            resultHandler.handle(rs);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void doQuery(String sql, StatementPreparor statementPreparor, ResultHandler resultHandler){
        try(Connection conn = createConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            statementPreparor.prepare(ps);
            ResultSet rs = ps.executeQuery();
            resultHandler.handle(rs);
            rs.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
