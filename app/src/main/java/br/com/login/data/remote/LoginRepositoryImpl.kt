package br.com.login.data.remote

import android.text.TextUtils
import android.util.Patterns
import br.com.login.enums.LoginState


class LoginRepositoryImpl(override val email: String, override val password: String) : LoginRepository {

    override fun isDataValid(): LoginState {
        return when {
            TextUtils.isEmpty(email) -> LoginState.OTHER_ERROR //Outros erros de autenticação
            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> LoginState.LOGIN_EMAIL_ERROR //Erro no padrão do email
            password.length <=6 -> LoginState.LOGIN_PASSWORD_ERROR //Erro no tamanho da senha
            else -> LoginState.LOGIN_SUCCESS //Login efetuado com sucesso
        }
    }
}