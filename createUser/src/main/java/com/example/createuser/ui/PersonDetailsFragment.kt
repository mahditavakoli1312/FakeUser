package com.example.createuser.ui

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.core.ui.NetworkState
import com.example.core.ui.utils.ClipboardUtils
import com.example.core.ui.utils.VibrationUtils
import com.example.core.ui.utils.collectOnFragment
import com.example.createuser.R
import com.example.createuser.databinding.FragmentPersonDetailsBinding
import com.example.createuser.di.PersonDetailsInjector
import javax.inject.Inject


class PersonDetailsFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val personDetailsViewModel by
    viewModels<PersonDetailsViewModel> { viewModelFactory }
    private lateinit var binding: FragmentPersonDetailsBinding
    private val VIBRATION_TIME = 100L

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

        val progress = ProgressDialog(requireContext())
        personDetailsViewModel.stateLoadState.collectOnFragment(this) {
            if (it == NetworkState.LOADING) {
                binding.clPersonDetailsPersonDetails.visibility = View.INVISIBLE
                progress.setTitle(requireContext().resources.getText(R.string.label_loading))
                progress.setMessage(requireContext().resources.getText(R.string.label_loading))
                progress.setCancelable(false)
                progress.show()
            } else {
                binding.clPersonDetailsPersonDetails.visibility = View.VISIBLE
                progress.dismiss()
            }
        }

        setBindings()
        setCopyReaction()
        setupCollection()
    }

    private fun setBindings() {
        binding.apply {
            btnRefreshPersonDetails.setOnClickListener {
                personDetailsViewModel.fetchUser()
            }
            btnCopyGeneratedAddressPersonDetails.setOnClickListener {
                copyAddressToClipboard(
                    personDetailsViewModel.generateAddress(),
                    requireContext()
                )
            }
        }
    }

    private fun setupCollection() {
        personDetailsViewModel.loadState.collectOnFragment(this) { networkState ->
            when (networkState) {
                NetworkState.SUCCESS -> {}
                NetworkState.INITIAL_STATE -> {}
                NetworkState.APP_ERROR -> Toast.makeText(
                    requireContext(),
                    requireContext().resources.getText(R.string.label_network_error),
                    Toast.LENGTH_SHORT
                ).show()
                NetworkState.SERVER_ERROR ->
                    Toast.makeText(
                        requireContext(),
                        requireContext().resources.getText(R.string.label_server_error),
                        Toast.LENGTH_SHORT
                    ).show()
                NetworkState.NETWORK_ERROR -> Toast.makeText(
                    requireContext(),
                    requireContext().resources.getText(R.string.label_network_error),
                    Toast.LENGTH_SHORT
                ).show()
                NetworkState.LOADING -> {}
            }
        }

        // need to collect (don't touch it child )
        personDetailsViewModel.loading.collectOnFragment(this) {}
    }

    private fun setCopyReaction() {
        binding.apply {
            tvGenderPersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvGenderPersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            tvNamePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvNamePersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            tvCountryNamePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvCountryNamePersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            tvCityNamePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvCityNamePersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            tvStateNamePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvStateNamePersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            tvPostCodeValuePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvPostCodeValuePersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            tvLatitudeValuePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvLatitudeValuePersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            tvLongitudeValuePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvLongitudeValuePersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            tvEmailValuePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvEmailValuePersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            tvAgeValuePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvAgeValuePersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            tvPhoneValuePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvPhoneValuePersonDetails.text.toString(),
                    context = requireContext()
                )
            }

            ivPersonImagePersonDetails.setOnClickListener {
                personDetailsViewModel.userDetails.value.largePicture?.let { imageUrl ->
                    copyImageToClipboard(
                        imageUrl,
                        context = requireContext()
                    )
                }
            }

            tvStreetNamePersonDetails.setOnClickListener {
                copyTextToClipboard(
                    tvStreetNamePersonDetails.text.toString(),
                    context = requireContext()
                )
            }
        }
    }

    private fun copyTextToClipboard(textToCopy: String, context: Context) {
        if (textToCopy.isNotBlank()) {
            vibrateAndDo {
                ClipboardUtils.copyTextToClipboard(textToCopy = textToCopy, context = context)
                Toast.makeText(
                    context,
                    context.resources.getText(R.string.label_copied),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun copyImageToClipboard(textToCopy: String, context: Context) {
        if (textToCopy.isNotBlank()) {
            vibrateAndDo {
                ClipboardUtils.copyTextToClipboard(textToCopy = textToCopy, context = context)
                Toast.makeText(
                    context,
                    context.resources.getText(R.string.label_image_copied),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun copyAddressToClipboard(textToCopy: String, context: Context) {
        if (textToCopy.isNotBlank()) {
            vibrateAndDo {
                ClipboardUtils.copyTextToClipboard(textToCopy = textToCopy, context = context)
                Toast.makeText(
                    context,
                    context.resources.getText(R.string.label_generated_address_copied),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun vibrateAndDo(function: () -> Unit) {
        VibrationUtils.vibrate(
            vibrationTime = VIBRATION_TIME,
            context = requireContext()
        )
        function.invoke()
    }
}