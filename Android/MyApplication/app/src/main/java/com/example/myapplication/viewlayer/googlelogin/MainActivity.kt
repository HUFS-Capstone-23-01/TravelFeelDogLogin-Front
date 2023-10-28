package com.example.myapplication.viewlayer.googlelogin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.BuildConfig
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.viewlayer.common.toast
import com.example.myapplication.viewlayer.googlelogin.viewmodel.GoogleLoginViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val viewModel: GoogleLoginViewModel by viewModel()

    private lateinit var _binding: ActivityMainBinding
    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(BuildConfig.GOOGLE_CLIENT_ID)
        .requestEmail()
        .build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(_binding.root)

        _binding.vm = viewModel

        val googleSignInClient = GoogleSignIn.getClient(this, gso)
        val googleLogInRequest =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
                    try {
                        val account = task.getResult(ApiException::class.java)
                        account?.let { user ->
                            user.idToken?.let { idToken ->
                                Timber.d("Get Account idToken! : ${account.idToken}")
                                handleLoginResponse()
                                viewModel.googleLoginByToken(idToken)
                            }
                        }
                    } catch (e: ApiException) {
                        Timber.d(e)
                    }
                }
            }

        _binding.btnRequestGoogleLogin.setOnClickListener {
            googleLogInRequest.launch(googleSignInClient.signInIntent)
        }

        _binding.btnRequestGoogleSignOut.setOnClickListener {
            googleSignInClient.signOut().addOnCompleteListener {
                if(it.isComplete) {
                    viewModel.googleSignOut()
                    toast("Complete sign out!")
                }
                else { toast("Failure sign out!") }
            }
        }
    }

    private fun handleLoginResponse() {
        viewModel.account.observe(this) { _binding.accountInfo = it }
    }
}
