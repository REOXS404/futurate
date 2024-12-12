package com.example.futurate.UI.Walktrought

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.futurate.R

class WalkthroughFragment : Fragment() {
    private var imageResId: Int = 0
    private var title: String? = null
    private var description: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_walkthrough, container, false)
        arguments?.let {
            imageResId = it.getInt(ARG_IMAGE)
            title = it.getString(ARG_TITLE)
            description = it.getString(ARG_DESC)
        }

        view.findViewById<ImageView>(R.id.imageWalkthrough).setImageResource(imageResId)
        view.findViewById<TextView>(R.id.titleWalkthrough).text = title
        view.findViewById<TextView>(R.id.descWalkthrough).text = description

        return view
    }

    companion object {
        private const val ARG_IMAGE = "image"
        private const val ARG_TITLE = "title"
        private const val ARG_DESC = "desc"

        fun newInstance(imageResId: Int, title: String, description: String) =
            WalkthroughFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_IMAGE, imageResId)
                    putString(ARG_TITLE, title)
                    putString(ARG_DESC, description)
                }
            }
    }
}
