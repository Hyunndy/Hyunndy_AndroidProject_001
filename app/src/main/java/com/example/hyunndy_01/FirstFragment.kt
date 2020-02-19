package com.example.hyunndy_01


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    // 3. Fragmnet에서는 view에 배치되어있는걸 그대로 가져올 수 없기 때문에 얻어온 view 객체에서 구성요소의 객체를 생성해야한다.
    var button: Button? = null
    var edit1: EditText? = null
    var edit2: EditText? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // 3. Fragment가 불리면 자동으로 호출되는 CreateView함수에서 view를 생성해서 vieww를 통해 Fragment Layout에 있는 구성요소들을 가져온다!
        var view = inflater!!.inflate(R.layout.fragment_first, container, false)
        button = view.findViewById<Button>(R.id.button)
        edit1 = view.findViewById<EditText>(R.id.editText)
        edit2 = view.findViewById<EditText>(R.id.editText2)




        // 4. Fragment에선 Activity를 그냥 가져올 수 있음. 버튼을 클릭하면 result fragmnet로 이동하게!
        button?.setOnClickListener {view->

            // 5. 프래그먼트1의 EditText의 내용을 메인액티비티의 객체에 저장해둔다. 프래그먼트2에서 사용할 수 있도록!
            var main_activity = activity as MainActivity // MainActivity로 형변환

            main_activity.value1 = edit1?.text.toString()
            main_activity.value2 = edit2?.text.toString()

            main_activity.setFragment("result")
        }


        return view
    }

}
