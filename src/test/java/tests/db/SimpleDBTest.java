package tests.db;

import baseEntities.BaseApiTest;
import dbTables.CustomersTable;
import models.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleDBTest extends BaseApiTest {

    Logger logger = LogManager.getLogger(SimpleDBTest.class);

    @Test
    public void simpleDBTest() {
        String sql = "SELECT * FROM public.customers " +
                "order by 1;";

        ResultSet rs = dbService.executeQuery(sql);
        try {
            while (rs.next()) {
                int userID = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String secondname = rs.getString("secondname");
                String email = rs.getString("email");
                int age = rs.getInt(5);

                logger.info("ID:" + userID);
                logger.info("firstname:" + firstname);
                logger.info("secondname:" + secondname);
                logger.info("email:" + email);
                logger.info("age:" + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void advancedDBTest() {
        CustomersTable customersTable = new CustomersTable(dbService);

        customersTable.dropTable();
        customersTable.createTable();
        customersTable.addCustomer(CustomerBuilder.builder()
                .firstName("Alex")
                .secondName("Vayteh")
                .age(45)
                .build());
        customersTable.addCustomer(CustomerBuilder.builder()
                .firstName("Vova")
                .secondName("Ivanov")
                .age(32)
                .build());
        customersTable.getCustomers();
        customersTable.getCustomerById(2);
        ResultSet rs = customersTable.getCustomerById(2);
        try {
            while (rs.next()) {
                int userID = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String secondname = rs.getString("secondname");
                String email = rs.getString("email");
                int age = rs.getInt(5);

                logger.info("ID:" + userID);
                logger.info("firstname:" + firstname);
                logger.info("secondname:" + secondname);
                logger.info("email:" + email);
                logger.info("age:" + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
