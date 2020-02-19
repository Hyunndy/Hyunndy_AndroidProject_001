package com.example.hyunndy_01


import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.DialogInterface.BUTTON_POSITIVE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // 4. 리스너 세팅
        var listner = DialogListner()

        // 1. AlertDiaglouge 생성
        var builder = AlertDialog.Builder(activity)
        builder.setTitle("타이틀입니다")
        builder.setMessage("메세지 입니다")

        builder.setPositiveButton("positive", listner)
        builder.setNeutralButton("neutral", listner)
        builder.setNegativeButton("negative", listner)

        var alert = builder.create()

        return alert
    }


    // 4. 리스너 세팅
    inner class DialogListner : DialogInterface.OnClickListener{
        override fun onClick(dialog: DialogInterface?, which: Int) {
            var main_activity = activity as MainActivity

            when(which)
            {
                DialogInterface.BUTTON_POSITIVE ->
                {
                    main_activity.textView4.text = "긍정"
                }
                DialogInterface.BUTTON_NEUTRAL ->
                {
                    main_activity.textView4.text = "중립"
                }
                DialogInterface.BUTTON_NEGATIVE ->
                {
                    main_activity.textView4.text = "부정"
                }
            }
        }
    }
}
