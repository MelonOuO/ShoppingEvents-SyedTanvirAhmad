package com.example.shoppingevents.ui.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.example.shoppingevents.ui.theme.default.defaultThemeSpacings

@Composable
fun defaultItemPadding(): PaddingValues = PaddingValues(
    horizontal = defaultThemeSpacings.default,
)
@Composable
fun mediumItemPadding(): PaddingValues = PaddingValues(
    horizontal = defaultThemeSpacings.double
)

