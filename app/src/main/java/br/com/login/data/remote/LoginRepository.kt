package br.com.login.data.remote

import br.com.login.enums.LoginState

interface LoginRepository {
    /**
     * O repositório recebe um email, uma senha,
     * uma função de sucesso e uma de falha.
     */

    fun login(email: String, password: String) : LoginState
}