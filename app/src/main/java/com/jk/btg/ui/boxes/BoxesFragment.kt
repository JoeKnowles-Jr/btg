package com.jk.btg.ui.boxes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jk.btg.data.model.products.Box
import com.jk.btg.data.model.products.BoxAdapter
import com.jk.btg.data.model.products.BoxAdapter.BoxClickListener
import com.jk.btg.databinding.FragmentBoxesBinding

class BoxesFragment : Fragment(), BoxClickListener {

    private var _binding: FragmentBoxesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: BoxesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel =
            ViewModelProvider(this)[BoxesViewModel::class.java]

        _binding = FragmentBoxesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val boxAdapter = BoxAdapter()
        boxAdapter.listenWith(this)
        binding.rvBoxes.adapter = boxAdapter
        viewModel.boxList.observe(viewLifecycleOwner) {
            boxAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onBoxClick(box: Box) {

    }

    override fun onBoxLongClick(box: Box) {

    }
}