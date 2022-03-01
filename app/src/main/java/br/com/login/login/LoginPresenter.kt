package br.com.login.login

import br.com.login.data.remote.LoginRepositoryImpl
import br.com.login.enums.LoginState

class LoginPresenter(private var loginContract: LoginContract.View?) : LoginContract.Presenter {

    /**
     * Para implementar as regras de negócio, o presenter
     * precisa conhecer a interface, é preciso adicionar
     * um objeto view e implementar os métodos de validação.
     */
    lateinit var view: LoginContract.View

    override fun onLogin(email: String, password: String) {
        val user = LoginRepositoryImpl(email, password)
        val loginCode = user.isDataValid()

        if (loginCode == LoginState.OTHER_ERROR)
            loginContract?.onLoginError("Falha ao tentar fazer login.")
        else if (loginCode == LoginState.LOGIN_EMAIL_ERROR)
            loginContract?.onLoginError("Email inválido!")
        else if (loginCode == LoginState.LOGIN_PASSWORD_ERROR)
            loginContract?.onLoginError("Senha inválida!")
        else {
            loginContract?.onLoginSuccess("Login efetuado com sucesso!")
            loginContract?.openHome()
        }
    }

    override fun onClose() {
        loginContract = null
    }
}