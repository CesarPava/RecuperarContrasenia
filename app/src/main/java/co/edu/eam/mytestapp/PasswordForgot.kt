package co.edu.eam.mytestapp

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import co.edu.eam.mytestapp.databinding.ActivityPasswordForgotBinding
import com.google.firebase.auth.FirebaseAuth

class PasswordForgot : AppCompatActivity() {
    lateinit var binding: ActivityPasswordForgotBinding
    private lateinit var aAuth:FirebaseAuth

    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)
        aAuth = FirebaseAuth.getInstance()
        binding.btnSend.setOnClickListener{
            val email = binding.emailUser.text.toString()
            if(email.isNotEmpty()) {
                aAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(baseContext, "Email Enviado", Toast.LENGTH_LONG).show()
                            finish()
                        }
                    }
            }
        }
    }
}