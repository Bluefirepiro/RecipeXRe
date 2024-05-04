package com.example.recipexx

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.recipexx.R.id.btnAddRecipe
import com.example.recipexx.R.id.btnRecipeList
import com.example.recipexx.R.id.btnShare
import com.example.recipexx.R.layout

class HomeActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_home)

        // Button click listeners
        findViewById<Button>(btnRecipeList).setOnClickListener {
            startActivity(Intent(this, RecipeListActivity::class.java))
        }

        findViewById<Button>(btnShare).setOnClickListener {
            startActivity(Intent(this, ShareWithFamilyActivity::class.java))
            // Implement share functionality here
        }

        findViewById<Button>(btnAddRecipe).setOnClickListener {
            startActivity(Intent(this, AddRecipeActivity::class.java))
        }
    }
}





