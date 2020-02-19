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



        return view
    }
}
