package dev7.id.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import dev7.id.myapplication.adapters.UserAdapter
import dev7.id.myapplication.contracts.MainActivityContract
import dev7.id.myapplication.models.User
import dev7.id.myapplication.presenters.MainActivityPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , MainActivityContract.View{
    override fun attachRecyler(user: List<User>) {
        rv_main.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UserAdapter(user, this@MainActivity)
        }
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hiddenLoading() {
        loading.visibility = View.INVISIBLE
    }

    override fun toast(message: String) = Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()

    private var presenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getAllUser()

    }
}
