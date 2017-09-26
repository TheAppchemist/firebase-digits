var exec = require('cordova/exec');

exports.coolMethod = function(arg0, success, error) {
    exec(success, error, "FirebaseDigits", "coolMethod", [arg0]);
};

exports.echojs = function(arg0, success, error) {
    // Do something
    success(arg0);
};