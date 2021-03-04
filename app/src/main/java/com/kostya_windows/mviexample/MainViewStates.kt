package com.kostya_windows.mviexample

sealed class MainViewStates {

    object loadingState:MainViewStates()

    data class successGetData(val data:String):MainViewStates()

    data class error(val message:String):MainViewStates()
}