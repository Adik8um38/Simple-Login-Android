package io.simplelogin.android.module.about

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import io.simplelogin.android.databinding.FragmentAboutBinding
import io.simplelogin.android.module.home.HomeActivity
import io.simplelogin.android.utils.baseclass.BaseFragment
import io.simplelogin.android.utils.extension.getVersionName
import io.simplelogin.android.utils.extension.startSendEmailIntent

class AboutFragment : BaseFragment(), HomeActivity.OnBackPressed {
    private lateinit var binding: FragmentAboutBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(inflater)
        binding.toolbar.setNavigationOnClickListener { showLeftMenu() }

        binding.appVersionTextView.text = "SimpleLogin v${context?.getVersionName()}"
        binding.howTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToHowItWorksFragment()
            )
        }

        binding.contactTextView.setOnClickListener {
            activity?.startSendEmailIntent("hi@simplelogin.io")
        }

        val base_url = "https://simplelogin.io"
        binding.faqTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToFaqFragment()
            )
        }
        binding.teamTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToWebViewFragment("$base_url/about")
            )
        }

        binding.pricingTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToWebViewFragment("$base_url/pricing")
            )
        }

        binding.blogTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToWebViewFragment("$base_url/blog")
            )
        }

        binding.termsTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToWebViewFragment("$base_url/terms")
            )
        }

        binding.privacyTextView.setOnClickListener {
            findNavController().navigate(
                AboutFragmentDirections.actionAboutFragmentToWebViewFragment("$base_url/privacy")
            )
        }

        return binding.root
    }

    // HomeActivity.OnBackPressed
    override fun onBackPressed() = showLeftMenu()
}