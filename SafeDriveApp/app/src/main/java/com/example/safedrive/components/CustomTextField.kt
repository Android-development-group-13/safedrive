package com.example.safedrive.components
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    placeholder: String = label,
    singleLine: Boolean = true,
    textStyle: TextStyle = TextStyle(fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface),
    cursorColor: Color = MaterialTheme.colorScheme.primary,
    borderColor: Color = Color.Gray,
    labelStyle: TextStyle = TextStyle(fontSize = 12.sp, color = Color.Gray),
    placeholderStyle: TextStyle = TextStyle(fontSize = 12.sp, color = Color.Gray),
    roundedCornersSize: Int = 4,
    borderStrokeWidth: Float = 1f
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (label.isNotEmpty()) {
            Text(text = label, style = labelStyle, modifier = Modifier.padding(start = 4.dp, bottom = 4.dp))
        }

        Box(modifier = Modifier.clip(RoundedCornerShape(roundedCornersSize.dp))) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = singleLine,
                textStyle = textStyle,
                cursorBrush = SolidColor(cursorColor),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .border(BorderStroke(borderStrokeWidth.dp, borderColor))
                            .padding(horizontal = 4.dp, vertical = 8.dp) // Adjust padding here
                    ) {
                        if (value.isEmpty()) {
                            Text(placeholder, style = placeholderStyle)
                        }
                        innerTextField()
                    }
                }
            )
        }
    }
}
