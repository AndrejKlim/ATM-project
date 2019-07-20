package atm.project.utils;


import atm.project.model.Account;
import atm.project.repository.AccountFileSystemRepo;
import atm.project.repository.AccountFileSystemRepoImpl;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidationUtils {

    public static boolean isNumberValid(String number) {
        //check the number for compliance format XXXX-XXXX-XXXX-XXXX-XXXX
        ArrayList<String> numberArray = new ArrayList<String>(Arrays.asList(number.split("-")));
        boolean numberLengthCorrect;
        boolean numberPartsCountCorrect = true;
        boolean numberPartsInt = true;

        if (numberArray.size() == 4) {
            numberLengthCorrect = true;
        } else {
            numberLengthCorrect = false;
        }

        for (String num : numberArray) {
            try {
                Integer.parseInt(num);
            } catch (Exception e) {
                e.printStackTrace();
                numberPartsInt = false;
            }
        }

        for (String num : numberArray) {
            if (num.length() != 4) {
                numberPartsCountCorrect = false;
            }


        }

        if (numberLengthCorrect && numberPartsCountCorrect && numberPartsInt) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPinValid(String pin, Account acc ){
        return pin.equals(acc.getPin());

    }
    public static boolean isNumberExists(String number, AccountFileSystemRepoImpl rep){
        return rep.getNumberAndAcc().containsKey(number);
    }



}
