package br.com.login.login

import br.com.login.data.remote.LoginRepository
import br.com.login.data.remote.LoginRepositoryImpl
import br.com.login.enums.LoginState

class LoginPresenter(private var view: LoginContract.View?, private val loginRepository: LoginRepository) : LoginContract.Presenter {

    /**
     * Para implementar as regras de negócio, o presenter
     * precisa conhecer a interface, é preciso adicionar
     * um objeto view e implementar os métodos de validação.
     */

    override fun onLogin(email: String, password: String) {
        val loginCode = loginRepository.login(email, password)
            if (loginCode == LoginState.OTHER_ERROR)
                view?.onLoginError("Falha ao tentar fazer login.")
            else if (loginCode == LoginState.LOGIN_EMAIL_ERROR)
                view?.onLoginError("Email inválido!")
            else if (loginCode == LoginState.LOGIN_PASSWORD_ERROR)
                view?.onLoginError("Senha inválida!")
            else {
                view?.onLoginSuccess("Login efetuado com sucesso!")
                view?.openHome()
        }
    }

    override fun onClose() {
        view= null
    }
}