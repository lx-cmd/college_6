package com.example.common.utils

import android.content.Context
import android.widget.Toast

object MsgUtils {

    //提示信息
    fun showToast(cxt:Context,msg: String) {
           Toast.makeText(cxt, msg + "", Toast.LENGTH_SHORT).show()
    }
}