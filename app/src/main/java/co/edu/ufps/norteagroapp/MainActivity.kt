package co.edu.ufps.norteagroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance();
        val usuario: TextInputEditText = findViewById(R.id.usuario)
        val clave: TextInputEditText = findViewById(R.id.clave)
        val iniciar: Button = findViewById(R.id.iniciar)
        iniciar.setOnClickListener(){
            signIn(usuario.text.toString(),clave.text.toString())

        }

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if(currentUser != null){
           // reload();
        }
    }

    fun signIn(email: String, password: String){
        val TAG: String ="MainActivity "
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Toast.makeText(baseContext, "Authentication exitosa.",
                        Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "signInWithEmail:success")
                   // val user = auth.currentUser
                    irInicio()
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }

    }

    fun irInicio(){
        val intent = Intent(this,InicioActivity::class.java)
        startActivity(intent)
    }
}