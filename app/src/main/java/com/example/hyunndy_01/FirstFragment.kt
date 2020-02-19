package com.example.hyunndy_01


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : ListFragment() {

    // 1. 리스트뷰를 구성하기위해 필요한 객체들.
    var textView: TextView? = null
    var list = arrayOf("항목1", "항목2", "항목3")


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view = inflater.inflate(R.layout.fragment_first, container, false)
        textView = view.findViewById<TextView>(R.id.textView3)

        // 2. 어댑터 생성
        var adapter = activity?.let { ArrayAdapter<String>(it, android.R.layout.simple_list_item_1, list) }
        listAdapter = adapter

        return view
    }

    // 3. 리스너 생성
    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        var str = list[position]
        textView?.text = str
    }
}
