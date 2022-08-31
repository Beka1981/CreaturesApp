package com.benten.creaturesapp.views.allCreatures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.benten.creaturesapp.R
import com.benten.creaturesapp.databinding.FragmentAllCreaturesBinding
import com.benten.creaturesapp.model.Creature
import com.benten.creaturesapp.model.CreatureAttributes
import com.benten.creaturesapp.views.addCreature.AddCreatureFragment
import com.benten.creaturesapp.views.allCreatures.adapters.AllCreaturesAdapter

class AllCreaturesFragment : Fragment() {
    private var _binding: FragmentAllCreaturesBinding? = null
    private val binding get() = _binding!!
    private lateinit var creaturesAdapter: AllCreaturesAdapter

    private val viewModel by viewModels<AllCreaturesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllCreaturesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        creaturesAdapter = AllCreaturesAdapter()
        binding.rvCreatures.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvCreatures.adapter = creaturesAdapter

        viewModel.getAllCreaturesLiveData().observe(viewLifecycleOwner) {
            creaturesAdapter.updateAll(it)
        }
        viewModel.getAddClickedLiveData().observe(viewLifecycleOwner) {
            if (it){
                goToAddCreature()
            }
        }

        binding.fabAddButton.setOnClickListener {
           //viewModel.onAddCreatureClicked()
            goToAddCreature()
        }
    }

    private fun goToAddCreature() {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.flContent, AddCreatureFragment())
            addToBackStack(AddCreatureFragment::class.java.name)
            commit()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}