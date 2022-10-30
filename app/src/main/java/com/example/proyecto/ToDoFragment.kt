package com.example.proyecto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class ToDoFragment : Fragment() {
    private lateinit var listRecyclerView: RecyclerView
    private lateinit var myAdapter: RecyclerView.Adapter<MyTaskListAdapter.MyViewHolder>
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
        /*val btnDtail1:Button=fragmento.findViewById(R.id.btn_detail_1)
        val btnDtail2:Button=fragmento.findViewById(R.id.btn_detail_2)
        val btnDtail3:Button=fragmento.findViewById(R.id.btn_detail_3)
        val btnDtail4:Button=fragmento.findViewById(R.id.btn_detail_4)
        val btnDtail5:Button=fragmento.findViewById(R.id.btn_detail_5)
        val btnDtail6:Button=fragmento.findViewById(R.id.btn_detail_6)
        btnDtail1.setOnClickListener(View.OnClickListener {
            val datos= Bundle()
            datos.putString("Tarea","llevar Elementos de Aseo a la mascota")
            datos.putString("hora","8:00A.M.")
            datos.putString("lugar","Norte de Bogota")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,DetailFragment::class.java,datos,"detail1")
                ?.addToBackStack( "")
                ?.commit()
        })
        btnDtail2.setOnClickListener(View.OnClickListener {
            val datos= Bundle()
            datos.putString("Tarea","llevar las vitaminas Vitaminas a la mascota")
            datos.putString("hora","9:00A.M.")
            datos.putString("lugar","Norte de Bogota Colina Campestre")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,DetailFragment::class.java,datos,"detail1")
                ?.addToBackStack( "")
                ?.commit()
        })
        btnDtail3.setOnClickListener(View.OnClickListener {
            val datos= Bundle()
            datos.putString("Tarea","llevar comida a la mascota")
            datos.putString("hora","10:00A.M.")
            datos.putString("lugar","Norte de Bogota barrio Colina Campestre")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,DetailFragment::class.java,datos,"detail1")
                ?.addToBackStack( "")
                ?.commit()
        })
        btnDtail4.setOnClickListener(View.OnClickListener {
            val datos= Bundle()
            datos.putString("Tarea","llevar los accesorios a la mascota")
            datos.putString("hora","11:00A.M.")
            datos.putString("lugar","Norte de Bogota barrio Colina Campestre")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,DetailFragment::class.java,datos,"detail1")
                ?.addToBackStack( "")
                ?.commit()
        })
        btnDtail5.setOnClickListener(View.OnClickListener {
            val datos= Bundle()
            datos.putString("Tarea","Asistir con un veterinario para la mascota")
            datos.putString("hora","12:00P.M.")
            datos.putString("lugar","Norte de Bogota barrio Colina Campestre")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,DetailFragment::class.java,datos,"detail1")
                ?.addToBackStack( "")
                ?.commit()
        })
        btnDtail6.setOnClickListener(View.OnClickListener {
            val datos= Bundle()
            datos.putString("Tarea"," Contactarse con asesor sobre la mascota")
            datos.putString("hora","1:00P.M.")
            datos.putString("lugar","Norte de Bogota barrio Colina Campestre")
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.fcv,DetailFragment::class.java,datos,"detail1")
                ?.addToBackStack( "")
                ?.commit()
        })
*/
        return fragmento
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var myTaskTitles: ArrayList<String> = ArrayList()
        var myTaskTimes: ArrayList<String> = ArrayList()
        var myTaskPlaces: ArrayList<String> = ArrayList()
        myTaskTitles.add("elementos de aseo")
        myTaskTitles.add("vitaminas")
        myTaskTitles.add("comida")
        myTaskTitles.add("accesorios para tu peludito")
        myTaskTitles.add("contactar un veterinario")
        myTaskTitles.add("contactar con un asesor")
        myTaskTimes.add("8:00AM")
        myTaskTimes.add("9:00AM")
        myTaskTimes.add("10:00AM")
        myTaskTimes.add("11:00AM")
        myTaskTimes.add("12:00PM")
        myTaskTimes.add("1:00PM")
        myTaskPlaces.add("Bogota Colina Campestre")
        myTaskPlaces.add("Bogota Colina Campestre")
        myTaskPlaces.add("Bogota Colina Campestre")
        myTaskPlaces.add("Bogota Colina Campestre")
        myTaskPlaces.add("Bogota Colina Campestre")
        myTaskPlaces.add("Bogota Colina Campestre")
        var info: Bundle= Bundle()
        info.putStringArrayList("titles",myTaskTitles)
        info.putStringArrayList("times",myTaskTimes)
        info.putStringArrayList("places",myTaskPlaces)
        listRecyclerView = requireView().findViewById(R.id.recyclerToDoList)
        myAdapter = MyTaskListAdapter(activity as AppCompatActivity,info)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter = myAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }
}
