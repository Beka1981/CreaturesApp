package com.benten.creaturesapp.views.avatars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.benten.creaturesapp.databinding.FragmentChooseAvatarBinding
import com.benten.creaturesapp.views.addCreature.AvatarChooser
import com.benten.creaturesapp.views.avatars.adapters.AvatarChoserAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AvatarChoserBottomSheet : BottomSheetDialogFragment() {
    private var _binding: FragmentChooseAvatarBinding? = null
    private val binding get() = _binding!!
    private lateinit var avatarsAdapter: AvatarChoserAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseAvatarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        avatarsAdapter = AvatarChoserAdapter()
        binding.rvAvatars.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvAvatars.adapter = avatarsAdapter
        avatarsAdapter.updateAll(AvatarStore.AVATARS)
        avatarsAdapter.setOnAvatarChosenListener {
            if (requireParentFragment() is AvatarChooser) {
                (requireParentFragment() as AvatarChooser).chooseAvatar(it)
                dismissAllowingStateLoss()
            }

        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        const val AVATAR_BOTTTOM_SHEET_KEY = "AVATAR_BOTTTOM_SHEET_KEY"
        fun newInstance(): AvatarChoserBottomSheet {
            return AvatarChoserBottomSheet()
        }
    }
}