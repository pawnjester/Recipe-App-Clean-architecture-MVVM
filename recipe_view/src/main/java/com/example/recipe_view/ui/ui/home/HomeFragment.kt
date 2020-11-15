package com.example.recipe_view.ui.ui.home

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipe_view.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeView()
    }

    private fun initializeView() {
//        search_view.findViewById<EditText>(androidx.appcompat.R.id.search_src_text).apply {
//            isFocusableInTouchMode = false
//            setOnClickListener {
//                val action = HomeFragmentDirections.actionHomeFragmentToRecipeListFragment(null)
//                findNavController().navigate(action)
//            }
//        }
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}