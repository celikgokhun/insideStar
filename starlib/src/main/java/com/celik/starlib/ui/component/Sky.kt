package com.celik.starlib.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.celik.starlib.data.model.Star

@Composable
fun Sky(
    stars: List<Star>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // Number of columns in the grid
        contentPadding = PaddingValues(2.dp), // Padding around the grid
        content = {
            items(stars) { star ->
                StarView(star = star)
            }
        }
    )
}