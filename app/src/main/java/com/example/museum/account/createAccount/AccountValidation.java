package com.example.museum.account.createAccount;

import com.example.museum.database.query.MongoDBQuery;
import com.google.android.material.textfield.TextInputLayout;

import org.bson.Document;

public class AccountValidation {
    public static boolean isEmailInvalid(TextInputLayout valInput) {
        String val = valInput.getEditText().getText().toString();
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

        if (val.isEmpty()) {
            valInput.setError("This field mustn't be empty!");
            return true;
        } else if (!val.matches(emailRegex)) {
            valInput.setError("Email format is invalid!");
            return true;
        }else if (MongoDBQuery.isExist("hanoi-museum", "users", new Document().append("email", val))) {
            valInput.setError("User name has existed!");
            return true;
        }  else {
            valInput.setError(null);
            return false;
        }
    }
    public static boolean isPasswordInvalid(TextInputLayout valInput) {
        String val = valInput.getEditText().getText().toString();


        if (val.isEmpty()) {
            valInput.setError("This field mustn't be empty!");
            return true;
        } else {
            valInput.setError(null);
            return false;
        }
    }
}
