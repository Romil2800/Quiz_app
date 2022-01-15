package romilp.quizapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import romilp.quizapp.R
import romilp.quizapp.databinding.ActivityLoginIntroBinding
import java.lang.Exception

class LoginIntro : AppCompatActivity() {

    private lateinit var binding: ActivityLoginIntroBinding
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_intro)
        firebaseAuth = FirebaseAuth.getInstance()

        if(firebaseAuth.currentUser!=null){
            Toast.makeText(this, "User is already logged in", Toast.LENGTH_LONG).show()
            redirect("MAIN")
        }
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_login_intro)
        binding.btnGetStarted.setOnClickListener {
            redirect("LOGIN")
        }

    }

    private fun redirect(name: String) {
        var intent: Intent = when (name) {
            "LOGIN" -> Intent(this, LoginActivity::class.java)
            "MAIN" -> Intent(this, MainActivity::class.java)
            else -> throw Exception("No Path Exists")
        }
        startActivity(intent)
        finishAfterTransition()
    }
}