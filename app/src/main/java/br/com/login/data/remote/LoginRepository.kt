package br.com.login.data.remote

import br.com.login.enums.LoginState

interface LoginRepository {
    /**
     * O repositório recebe um email, uma senha,
     * uma função de sucesso e uma de falha.
     */
    val email: String
    val password: String
    fun isDataValid() : LoginState
}