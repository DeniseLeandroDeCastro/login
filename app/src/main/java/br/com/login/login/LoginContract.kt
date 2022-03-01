package br.com.login.login


interface LoginContract {

    interface View {
        fun onLoginSuccess(message: String)
        fun onLoginError(message: String)
        fun openHome()
    }

    interface Presenter {
        fun onLogin(email: String, password: String)
        fun onClose()
    }
}