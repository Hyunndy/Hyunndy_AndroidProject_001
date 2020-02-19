package com.example.hyunndy_01


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment() {

    // 1. Fragment 배치 시 자동으로 호출되는 메서드.
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Fragmnet할 레이아웃을 반환한다.
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

}
