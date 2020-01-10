package utils;

import java.util.List;

public class MySQLDbService {
    private final DbHelper dbHelper;
    private static final String dbUrl = "jdbc:mysql://10.141.209.138:6603/compatdroid?" +
            "user=compatdroid&password=compatdroid";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    private static MySQLDbService ourInstance = new MySQLDbService();

    public static MySQLDbService getInstance() {return ourInstance;}

    private MySQLDbService(){dbHelper = new DbHelper(JDBC_DRIVER, dbUrl);}

    public void createTestTable(){
        String sql = "create table if not exists testAPK" +
                "(id int primary key not null auto_increment," +
                "apkHash varchar(255)," +
                "apiName varchar(255)," +
                "apiInvokeStmtMethodFullName varchar(255)," +
                "apiInvokeStmtUnitOffset int," +
                "checked int," +
                "isSingleIf int," +
                "checkedCondition varchar(255)," +
                "checkStmtMethodFullName varchar(255)," +
                "checkStmtUnitOffset int)";
        dbHelper.doUpdate(sql);
    }

    public void insertTestTable(List<TestModel> list){
        String sql = "insert into testAPK(apkHash, apiName, apiInvokeStmtMethodFullName," +
                "apiInvokeStmtUnitOffset, checked, isSingleIf, checkedCondition, checkStmtMethodFullName," +
                "checkStmtUnitOffset) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        dbHelper.doBatchUpdate(sql, ps -> {
            for (TestModel line : list){
                ps.setString(1, line.apkHash);
                ps.setString(2, line.apiName);
                ps.setString(3, line.apiInvokeStmtMethodFullName);
                ps.setInt(4, line.apiInvokeStmtUnitOffset);
                ps.setInt(5, line.checked);
                ps.setInt(6, line.isSingleIf);
                ps.setString(7, line.checkedCondition);
                ps.setString(8, line.checkStmtMethodFullName);
                ps.setInt(9, line.checkStmtUnitOffset);
                ps.addBatch();
            }
        });
    }
}
