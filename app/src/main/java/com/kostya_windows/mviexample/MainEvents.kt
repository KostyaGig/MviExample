package com.kostya_windows.mviexample

sealed class MainEvents{

    data class clicked(val viewText:String):MainEvents()

}