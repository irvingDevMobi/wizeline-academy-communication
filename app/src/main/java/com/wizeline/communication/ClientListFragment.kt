package com.wizeline.communication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wizeline.communication.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ClientListFragment : Fragment() {

    private var columnCount = 1

    var callback: OnClientListListener? = null
    var clientListRecyclerViewAdapter: ClientListRecyclerViewAdapter? = null

    private val sharedViewModel: SharedClientViewModel
    by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT, 1)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnClientListListener) {
            callback = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        callback = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.client_list, container, false)
        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                clientListRecyclerViewAdapter = ClientListRecyclerViewAdapter(PlaceholderContent.ITEMS) { client ->
                    Log.d("ClientListFragment", "$client")
                    //callback?.onItemClick(client)

                    sharedViewModel.updateUiState(client)
                }
                adapter = clientListRecyclerViewAdapter
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.uiState.observe(viewLifecycleOwner) {
            clientListRecyclerViewAdapter?.updateClient(it)
        }
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

        fun newInstance(numOfColumns: Int = 1): ClientListFragment {
            return ClientListFragment().apply {
                val bundle = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, numOfColumns)
                }
                arguments = bundle
            }
        }
    }
}
