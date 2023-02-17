package dbTables;

import models.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class CustomersTable {
    Logger logger = LogManager.getLogger(CustomersTable.class);
    private DataBaseService dbService;

    public CustomersTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Create customers table...");

        String createTableSQL = "create table customers " +
                "(   id         SERIAL PRIMARY KEY," +
                "    firstname  CHARACTER VARYING(30)," +
                "    secondname CHARACTER VARYING(30)," +
                "    email      CHARACTER VARYING(255)," +
                "    age        INTEGER" +
                ");";
        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Drop customers table...");
        String dropTableSQL = "DROP TABLE if exist public.Customers";
        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getCustomers() {
        String sql = "SELECT * FROM public.customers " +
                "order by 1;";

        return dbService.executeQuery(sql);
    }

    public ResultSet getCustomerById(int id) {
        String sql = "SELECT * FROM public.customers " +
                "where id = " + id +
                " order by 1;";

        return dbService.executeQuery(sql);
    }

    public void addCustomer(CustomerBuilder customerBuilder) {
        String insertTableSQL = "INSERT INTO public.Customers(" +
                "firstname, secondname, email, age)" +
                "VALUES ('" + customerBuilder.getFirstName() + "', '" + customerBuilder.getSecondName() +
                "', '" + customerBuilder.getEmail() + "', " + customerBuilder.getAge() + ");";
        dbService.executeSQL(insertTableSQL);
    }

    public void updateCustomer(CustomerBuilder customerBuilder) {

    }

    public void deleteCustomer(int id) {

    }

}
