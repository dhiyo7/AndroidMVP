package dev7.id.myapplication.presenters

import dev7.id.myapplication.contracts.MainActivityContract
import dev7.id.myapplication.models.User
import dev7.id.myapplication.webservices.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityPresenter (v: MainActivityContract.View) : MainActivityContract.Interactor{
    private var view : MainActivityContract.View? = v
    private var api = ApiClient.instance_api()

    override fun getAllUser() {
        view?.showLoading()
        api.allUsers().enqueue(object : Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                view?.hiddenLoading()
                view?.toast(t.message.toString())
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful){
                    val users = response.body()
                    users?.let {
                        view?.attachRecyler(users)
                    }
                }
                view?.hiddenLoading()
            }

        })
    }

    override fun destroy() {
        view = null
    }
}