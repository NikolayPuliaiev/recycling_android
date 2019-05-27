package com.nikolaypuliaiev.recycling.ui.map.sortaccept

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nikolaypuliaiev.recycling.R
import com.nikolaypuliaiev.recycling.databinding.FragmentQrCodeSortBinding
import com.nikolaypuliaiev.recycling.utils.BaseClasses.BaseFragment
import net.glxn.qrgen.android.QRCode
import net.glxn.qrgen.core.image.ImageType

class QRCodeSortFragment : BaseFragment() {

    companion object {
        fun newInstance(): QRCodeSortFragment = QRCodeSortFragment()
    }

    private lateinit var binding: FragmentQrCodeSortBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_qr_code_sort, container, false)

        binding.fragment = this

        binding.qrCode.setImageBitmap(QRCode.from("Hello world")
            .to(ImageType.PNG)
            .withSize(250, 250)
            .bitmap())

        binding.backButton.setOnClickListener {
            closeCurrentFragment()
        }

        return binding.root
    }
}