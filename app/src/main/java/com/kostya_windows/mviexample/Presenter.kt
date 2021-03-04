package com.kostya_windows.mviexample

import android.util.Log
import java.util.concurrent.TimeUnit
import kotlin.random.Random

class Presenter(val presenter: MainView) {


    fun obtainIntent(event:MainEvents){
         when(event){
             is MainEvents.clicked -> {
                 Log.d("MyMainActivity","TextView was clicked!")
                 //По нажатию на текствью вызвываетсяя данный метод тут мы отлавиваем событие
                 //В этом случае - нажатию текствью

                 //Что - то просиходит по нажатию на текствью
                 presenter.render(MainViewStates.loadingState)
                 //Задержка
                 TimeUnit.MILLISECONDS.sleep(1000)

                 //State с какими - то данными в нашем случае текст textView
                 presenter.render(MainViewStates.successGetData(data = event.viewText))

             }

         }
    }

    init {
        //Какой - то запрос на сервер
        presenter.render(MainViewStates.loadingState)
        
        TimeUnit.MILLISECONDS.sleep(3000)

        val randomNumber = Random(0).nextInt(10)

        Log.d("MyMainActivity","number -> $randomNumber")
        if (randomNumber > 5){
            presenter.render(MainViewStates.successGetData("Success"))
        } else {
            presenter.render(MainViewStates.error("number < 5"))
        }
    }

}