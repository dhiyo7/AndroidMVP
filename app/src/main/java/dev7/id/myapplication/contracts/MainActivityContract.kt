package dev7.id.myapplication.contracts

import dev7.id.myapplication.models.User

interface MainActivityContract {

    interface View{
        fun attachRecyler(user: List<User>)
        fun showLoading()
        fun hiddenLoading()
        fun toast(message: String)
    }
    interface Interactor{
        fun getAllUser()
        fun destroy()
    }
}