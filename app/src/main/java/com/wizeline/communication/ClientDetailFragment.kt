package com.wizeline.communication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText

private const val ARG_CLIENT_ID = "clientId"
private const val ARG_CLIENT_NAME = "clientName"
private const val ARG_CLIENT_RATING = "clientRating"

/**
 * A simple [Fragment] subclass.
 * Use the [ClientDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ClientDetailFragment : Fragment() {
    private var clientId: String = ""
    private var clientName: String = ""
    private var clientRatingString: String = ""

    private var idEditText: TextInputEditText? = null
    private var nameEditText: TextInputEditText? = null
    private var ratingEditText: TextInputEditText? = null

    // TODO: 4-> Challenge use sharedViewModel to get selected Client

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            clientId = it.getString(ARG_CLIENT_ID, "")
            clientName = it.getString(ARG_CLIENT_NAME, "")
            clientRatingString = it.getString(ARG_CLIENT_RATING, "")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_client_detail, container, false)
        idEditText = view.findViewById(R.id.id_edit_text)
        nameEditText = view.findViewById(R.id.name_edit_text)
        ratingEditText = view.findViewById(R.id.rating_edit_text)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        idEditText?.setText(clientId)
        nameEditText?.setText(clientName)
        ratingEditText?.setText(clientRatingString)
    }

    companion object {

        fun newInstance(
            clientId: String = "",
            clientName: String = "",
            clientRating: String = ""
        ) = ClientDetailFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_CLIENT_ID, clientId)
                putString(ARG_CLIENT_NAME, clientName)
                putString(ARG_CLIENT_RATING, clientRating)
            }
        }

        fun newInstance(
            client: Client
        ): ClientDetailFragment = newInstance(
            clientId = client.id,
            clientName = client.name,
            clientRating = client.creditRating.toString()
        )
    }
}
