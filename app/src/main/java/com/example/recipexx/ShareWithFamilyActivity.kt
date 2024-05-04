package com.example.recipexx

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShareWithFamilyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_with_family)

        // Set up RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewFamilyMembers)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Example family members with email and phone number
        val familyMembers = listOf(
            FamilyMember("John Doe", 35, "Father", "john.doe@example.com", "+1234567890"),
            FamilyMember("Jane Doe", 32, "Mother", "jane.doe@example.com", "+1987654321"),
            FamilyMember("Sarah Doe", 10, "Daughter", "sarah.doe@example.com", "+1122334455")
            // Add more family members as needed
        )

        // Set up RecyclerView adapter
        val adapter = ShareWithFamilyAdapter(this, familyMembers)
        recyclerView.adapter = adapter
    }

    // Button click handler to go back to the main menu
    fun backToMainMenu(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
