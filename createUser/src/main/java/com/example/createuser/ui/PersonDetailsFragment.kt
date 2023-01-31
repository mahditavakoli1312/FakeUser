package com.example.createuser.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.createuser.databinding.FragmentPersonDetailsBinding
import com.example.createuser.di.PersonDetailsInjector
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


class PersonDetailsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val personDetailsViewModel by
    viewModels<PersonDetailsViewModel> { viewModelFactory }

    private lateinit var binding: FragmentPersonDetailsBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as PersonDetailsInjector)
            .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonDetailsBinding.inflate(
            inflater
        )
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = personDetailsViewModel
        lifecycleScope.launch {
            personDetailsViewModel.userDetails.collect {
                Log.d("mahdi", "fragment $it")
            }
        }

        binding.btnRefreshPersonDetails.setOnClickListener {
            personDetailsViewModel.fetchUser()
        }
    }
}