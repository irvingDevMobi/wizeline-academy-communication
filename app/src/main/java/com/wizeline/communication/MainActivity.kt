package com.wizeline.communication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// TODO: 2e -> implements interface to communicate with list fragment
class MainActivity : AppCompatActivity() {

    // TODO: 3d -> crate shared viewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (null == savedInstanceState) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.layoutContainer,
                    // TODO: 1c -> send number of columns
                    ClientListFragment()
                )
                .commit()
        }

        // TODO 3e -> observe liveData of SharedViewModel
    }

    private fun showDetail(client: Client) {
        supportFragmentManager.beginTransaction()
            .add(R.id.layoutContainer, ClientDetailFragment.newInstance(client))
            .addToBackStack(null)
            .commit()
    }
}
