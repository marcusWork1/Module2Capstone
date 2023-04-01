package com.techelevator.tenmo.datasource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JDBCtransferDAO implements TransferDAO {

    //attributes
    private JdbcTemplate theDatabase;
    //constructor with dependency injection
    public JDBCtransferDAO(JdbcTemplate jdbcTemplate) {this.theDatabase = jdbcTemplate;}



    @Override
    public Transfer getTransferById(int id) {
        Transfer newTransfer = null;

        String sql = "SELECT * FROM transfer WHERE transfer_id = ? ; ";

        SqlRowSet results = theDatabase.queryForRowSet(sql, id);
        if (results.next()) {
            newTransfer = mapToRowTransfer(results);

            return newTransfer;
        } else {
            return null;
        }
    }

    @Override
    public List<Transfer> transferList(int id) {
        return null;
    }

    @Override
    //public Transfer createTransfer(int user1, int user2, BigDecimal amount) {
    public Transfer createTransfer(TransferDTO transfer) {
       // Transfer newTransfer = new Transfer();

        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES ( ?, ?, ?, ?, ?) RETURNING transfer_id;";
        Integer id = theDatabase.update(sql, Integer.class, transfer.getTransferType(), transfer.getTransferStatus(), transfer.getFromAccount().getId(), transfer.getToAccount().getId(), transfer.getAmount());

        return getTransferById(id);

    }

    @Override
    public Transfer completeTransfer() {


        return null;
    }

    private Transfer mapToRowTransfer(SqlRowSet results){
        Transfer transfer = new Transfer();
        transfer.setTransferId(results.getInt("transfer_id"));
        transfer.setTransferType(results.getInt("transfer_type"));
        transfer.setAccount_to(results.getInt("account_to"));
        transfer.setAccountFrom(results.getInt("account_from"));
        transfer.setAmount(results.getBigDecimal("amount"));
        transfer.setStatusId(results.getInt("transfer_status_id"));

        return transfer;
    }

}
