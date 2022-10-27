package com.example.proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ToDoFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.fragment_to_do,container,false)
        val btnDtail1:Button=fragmento.findViewById(R.id.btn_detail_1)
        val btnDtail2:Button=fragmento.findViewById(R.id.btn_detail_2)
        val btnDtail3:Button=fragmento.findViewById(R.id.btn_detail_3)
        val btnDtail4:Button=fragmento.findViewById(R.id.btn_detail_4)
        val btnDtail5:Button=fragmento.findViewById(R.id.btn_detail_5)
        val btnDtail6:Button=fragmento.findViewById(R.id.btn_detail_6)
        btnDtail1.setOnClickListener(View.OnClickListener {
            val datos= Bundle()
            datos.putString("Tarea","Elementos de Aseo")
            datos.putString("hora","8:00A.M.")
            datos.putString("lugar","Norte de Bogota")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,DetailFragment::class.java,datos,"detail1")
                ?.addToBackStack( "")
                ?.commit()

        })
        return fragmento
    }
}