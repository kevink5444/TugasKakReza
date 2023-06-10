package com.kevin.tugaskakreza

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate layout untuk fragment Home
        return inflater.inflate(R.layout.activity_home_fragment, container, false)
    }

    // Di dalam HomeFragment
    fun updateRecyclerViewVisibility() {
        val recyclerView: RecyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerView.isClickable = false
        recyclerView.isFocusable = false
        if (isVisible) {
            recyclerView.visibility = View.VISIBLE
        } else {
            recyclerView.visibility = View.GONE
        }
    }
}





