package com.wizeline.communication.placeholder

import com.wizeline.communication.Client
import com.wizeline.communication.CreditRating
import java.util.ArrayList
import java.util.HashMap
import kotlin.random.Random

/**
 * Helper class for providing sample content for user interfaces
 *
 */
object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<Client> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    private val ITEM_MAP: MutableMap<String, Client> = HashMap()

    private const val COUNT = 25

    init {
        // Add some sample items.
        for (i in 1..COUNT) {
            addItem(createPlaceholderItem(i))
        }
    }

    private fun addItem(item: Client) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createPlaceholderItem(position: Int): Client {
        return Client(position.toString(), "Client $position", generateRate())
    }

    private fun generateRate(): CreditRating {
        val ratings = CreditRating.values()
        return ratings[Random.nextInt(3)]
    }

}
