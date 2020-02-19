package com.example.hyunndy_01


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_second.*
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : Fragment() {

    var button: Button? = null
    var edit1: TextView? = null
    var edit2: TextView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        var view = inflater!!.inflate(R.layout.fragment_second, container, false)
        button = view.findViewById<Button>(R.id.button2)
        edit1 = view.findViewById<TextView>(R.id.textView)
        edit2 = view.findViewById<TextView>(R.id.textView2)

        var main_activity = activity as MainActivity
        // 6. 메인액티비티에 세팅된 프래그먼트1의 텍스트를 가져옴.
        edit1?.text = main_activity.value1
        edit2?.text = main_activity.value2


        button?.setOnClickListener {view->
            main_activity.supportFragmentManager.popBackStack()
        }


        return view
    }


}
