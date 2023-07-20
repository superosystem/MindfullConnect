package dev.gusriil.mindfullconnect.android.ui.main.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dev.gusriil.mindfullconnect.android.R
import dev.gusriil.mindfullconnect.android.databinding.DialogAddPictureChooserBinding

class AddPictureChooserDialog : BottomSheetDialogFragment() {

    companion object {
        val TAG: String = AddPictureChooserDialog::class.java.simpleName

        fun show(
            fm: FragmentManager, listener: PictureChooserListener
        ) {
            AddPictureChooserDialog().apply {
                this.listener = listener
            }.show(fm, TAG)
        }
    }

    interface PictureChooserListener {
        fun onUploadPhoto()
    }

    private lateinit var binding: DialogAddPictureChooserBinding
    private lateinit var listener: PictureChooserListener

    override fun getTheme(): Int {
        return R.style.TransparentBottomSheetDialogTheme
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DialogAddPictureChooserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            tvUploadPhoto.setText(R.string.upload_photo)

            btnUploadPhoto.setOnClickListener {
                listener.onUploadPhoto()
                dismiss()
            }

            btnCancel.setOnClickListener {
                dismiss()
            }
        }
    }
}
