package com.wizeline.communication

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnClientListListener {

    private val sharedViewModel: SharedClientViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (null == savedInstanceState) {
            if (null == findViewById(R.id.lateralContainer)) {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.layoutContainer,
                        ClientListFragment.newInstance(2)
                    )
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.lateralContainer,
                        ClientListFragment.newInstance()
                    )
                    .commit()
                supportFragmentManager.beginTransaction()
                    .add(
                        R.id.layoutContainer,
                        ClientDetailFragment.newInstance()
                    )
                    .commit()
            }
        }

        sharedViewModel.uiState.observe(this) { client ->
            showDetail(client)
        }
    }

    private fun showDetail(client: Client) {
        supportFragmentManager.beginTransaction()
            .add(R.id.layoutContainer, ClientDetailFragment.newInstance(client))
            .addToBackStack(null)
            .commit()
    }

    override fun onItemClick(client: Client) {
        showDetail(client)
    }
}
