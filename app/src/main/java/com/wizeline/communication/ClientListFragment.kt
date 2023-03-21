package com.wizeline.communication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wizeline.communication.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ClientListFragment : Fragment() {

    private var columnCount = 1

    //TODO: 2b -> create interface property

    // TODO: 3f -> create sharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO: 1b -> Read argument and assign to columnCount
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // TODO: 2c -> set interface from activity or create a set method
    }

    override fun onDetach() {
        super.onDetach()
        // TODO: 2d -> don't forget to delete reference to listener to avoid Memory leaks
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
                adapter = ClientListRecyclerViewAdapter(PlaceholderContent.ITEMS) { client ->
                    Log.d("ClientListFragment", "$client")
                    // TODO: 2f -> notify to activity about the client selected

                    // TODO: 3g -> update selected client
                }
            }
        }
        return view
    }

    companion object {

        private const val ARG_COLUMN_COUNT = "column-count"

        // TODO: 1a -> Create method to received number of columns
    }
}
