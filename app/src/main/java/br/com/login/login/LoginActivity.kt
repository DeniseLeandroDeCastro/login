package br.com.login.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.login.R
import br.com.login.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity() : AppCompatActivity(), LoginContract.View {

    /**
     * É preciso implementar a interface, os métodos do contrato
     * e dizer que a view tem um presenter.
     */

    private val presenter = LoginPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter.view = this

        btnLogin.setOnClickListener {
            presenter.onLogin(edtEmail.text.toString(), edtPassword.text.toString())
        }
    }

    override fun onLoginSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun openHome() {
        val home = Intent(this, HomeActivity::class.java)
        startActivity(home)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onClose()
    }
}