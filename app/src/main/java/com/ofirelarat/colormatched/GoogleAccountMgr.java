package com.ofirelarat.colormatched;

import android.app.Activity;
import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class GoogleAccountMgr {
    private static GoogleSignInAccount signInAccount;

    public static void init(Activity activity){
        if(signInAccount == null){
            GoogleSignInAccount lastSignedAcc = GoogleSignIn.getLastSignedInAccount(activity);
            if(lastSignedAcc == null) {
                GoogleSignInClient mGoogleSignInClient = GoogleSignIn.getClient(activity, GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN);

                Intent intent = mGoogleSignInClient.getSignInIntent();
                activity.startActivityForResult(intent, 1);
            }else{
                signInAccount = lastSignedAcc;
            }
        }
    }

    public static void setSignInAccount(GoogleSignInAccount signInAccount) {
        GoogleAccountMgr.signInAccount = signInAccount;
    }

    public static GoogleSignInAccount getSignInAccount(){
        return signInAccount;
    }
}
