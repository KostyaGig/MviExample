package com.kostya_windows.mviexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity(),MainView{

    private val TAG = "MyMainActivity"

    lateinit var presenter:Presenter

    lateinit var textView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter(this)
        textView = findViewById(R.id.mainTv)

        textView.setOnClickListener {
            //for action
            presenter.obtainIntent(MainEvents.clicked(textView.text.toString()))
        }

    }

    override fun render(currentState: MainViewStates) {
        when(currentState){
            is MainViewStates.loadingState ->{
                Log.d(TAG, "Loading...")
            }
            is MainViewStates.successGetData -> {
                Log.d(TAG, "SuccessLoading data -> ${currentState.data}")
            }
            is MainViewStates.error -> {
                Log.d(TAG, "Error -> ${currentState.message}")
            }
        }
    }

}