package atm.project.repository;


import atm.project.model.Account;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccountFileSystemRepoImpl implements AccountFileSystemRepo {
    private Map<String, Account> numberAndAcc = new HashMap<String, Account>();
    private String fileName;



    public AccountFileSystemRepoImpl(String fileName) {
        this.fileName = fileName;
        fillMap(fileName);
    }

    private void fillMap(String pathname){
        try {
            File accounts = new File(pathname);
            FileReader fileReader = new FileReader(accounts);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            String[] params;

            while ((line = reader.readLine()) != null){
                params = line.split(" ");
                Account account = new Account(params[0], params[1], Integer.parseInt(params[2]));
                numberAndAcc.put(params[0], account);
                params = null;
                line = null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }

    }


    public Account getAccount(String cardNumber) {
        Account account = numberAndAcc.get(cardNumber);
        return account;
    }


    public void updateAcc(Account acc) {
        updateMap(acc);
        Set<String> elem = numberAndAcc.keySet();
        StringBuilder dataToWrite = new StringBuilder();
        try{
            FileWriter writer = new FileWriter(fileName);
            writer.write("");
            for (String el: elem){
                Account account = numberAndAcc.get(el);
                String tmp = account.getCardNumber() + " " + account.getPin() + " "+ account.getBalance() + "\n";
                dataToWrite.append(tmp);
                tmp = "";
            }
            writer.write(String.valueOf(dataToWrite));
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateMap(Account acc){
        getNumberAndAcc().remove(acc.getCardNumber());
        getNumberAndAcc().put(acc.getCardNumber(), acc);

    }

    public Map<String, Account> getNumberAndAcc() {
        return numberAndAcc;
    }
}
