package com.team26.techmarketplace.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.team26.techmarketplace.core.designsystem.Dimens
import com.team26.techmarketplace.core.designsystem.GreenDark
import com.team26.techmarketplace.core.designsystem.OffWhite

@Composable
fun PrimaryButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = OffWhite,
            contentColor = GreenDark
        ),
        modifier = modifier.height(Dimens.ButtonHeight)
    ) {
        Text(text, fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
    }
}