package za.co.appchemy.plugins.digits;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import com.google.firebase.auth.PhoneAuthProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class FirebaseDigits extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        } else if (action.equals('verifyPhoneNumber')) {
            String phoneNumber = args.getString(0);
            this.verifyPhoneNumber(phoneNumber, callbackContext);
            return true
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void verifyPhoneNumber(String phoneNumber, CallbackContext callbackContext) {
        if (phoneNumber == null || phoneNumber.length() == 0) {
            callbackContext.error('Phone number needed')
        } else {
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
        }
    }
}
