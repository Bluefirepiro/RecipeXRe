package com.example.recipexx

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecipeListActivity : AppCompatActivity() {

    private lateinit var recipeListView: RecyclerView
    private lateinit var adapter: RecipeAdapter
    private var recipeList = mutableListOf(
        Recipe(
            "Pasta Carbonara",
            listOf("Spaghetti", "Eggs", "Bacon", "Parmesan Cheese", "Black Pepper"),
            "1. Cook pasta until al dente. \n2. Fry bacon until crispy. \n3. Whisk eggs with grated cheese. \n4. Combine pasta, bacon, and egg mixture. \n5. Season with black pepper."
        ),
        Recipe(
            "Chicken Stir-Fry",
            listOf("Chicken Breast", "Bell Peppers", "Onions", "Soy Sauce", "Garlic", "Ginger"),
            "1. Slice chicken and vegetables. \n2. Stir-fry chicken until browned. \n3. Add vegetables and sauté until tender. \n4. Mix in soy sauce, garlic, and ginger. \n5. Serve hot."
        ),
        Recipe(
            "Chocolate Chip Cookies",
            listOf("Flour", "Butter", "Sugar", "Chocolate Chips", "Egg", "Vanilla Extract"),
            "1. Cream butter and sugar. \n2. Beat in egg and vanilla. \n3. Mix in flour and chocolate chips. \n4. Drop dough onto baking sheets. \n5. Bake at 350°F for 10-12 minutes."
        )
    )

    private lateinit var addRecipeLauncher: ActivityResultLauncher<Intent>

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        recipeListView = findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        recipeListView.layoutManager = layoutManager

        adapter = RecipeAdapter(this, recipeList)
        recipeListView.adapter = adapter

        // Initialize the ActivityResultLauncher
        addRecipeLauncher = registerForActivityResult(StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data: Intent? = result.data
                val newRecipe = data?.getParcelableExtra("NEW_RECIPE", Recipe::class.java)
                newRecipe?.let {
                    Log.d("RecipeListActivity", "New recipe received: $newRecipe")
                    recipeList.add(it)
                    adapter.notifyDataSetChanged()
                }
            } else {
                Log.e("RecipeListActivity", "Add recipe canceled or failed")
            }
        }
    }

    // Method to handle button click event to go back to main menu
    fun backToMainMenu(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    // Method to start AddRecipeActivity to add a new recipe using ActivityResultLauncher
    fun addRecipe(view: View) {
        val intent = Intent(this, AddRecipeActivity::class.java)
        addRecipeLauncher.launch(intent)
    }

    companion object {
        const val ADD_RECIPE_REQUEST_CODE = 100
    }
}
