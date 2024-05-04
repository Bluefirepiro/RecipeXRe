package com.example.recipexx

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddRecipeActivity : AppCompatActivity() {
    private lateinit var editTextRecipeName: EditText
    private lateinit var editTextIngredients: EditText
    private lateinit var editTextInstructions: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recipe)

        // Initialize EditText fields
        editTextRecipeName = findViewById(R.id.editTextRecipeName)
        editTextIngredients = findViewById(R.id.editTextIngredients)
        editTextInstructions = findViewById(R.id.editTextInstructions)
    }

    // Method to handle button click event to go back to main menu
    fun backToMainMenu(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    // Method to handle button click event to add a new recipe
    fun addRecipe(view: View) {
        val recipeName = editTextRecipeName.text.toString()
        val ingredients = editTextIngredients.text.toString().split("\n")
        val instructions = editTextInstructions.text.toString()

        // Create a new Recipe object
        val recipe = Recipe(recipeName, ingredients, instructions)

        // Pass the new recipe back to RecipeListActivity
        val resultIntent = Intent()
        resultIntent.putExtra("NEW_RECIPE", recipe)
        setResult(RESULT_OK, resultIntent)
        finish()
    }
}
