package com.example.otp_layout

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OtpTextField(context: Context) {
    var otpText by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = otpText,
        onValueChange = {
            if (it.length <= 4) {
                otpText = it
            }
        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            // Otp Layout :->
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                repeat(4) { index ->
                    val number = when {
                        index >= otpText.length -> ""
                        else -> otpText[index].toString()
                    }

                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = number,
                            style = MaterialTheme.typography.titleLarge
                        )

                        Box(
                            modifier = Modifier
                                .width(20.dp)
                                .height(2.dp)
                                .background(Color.Black)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Button :->
            Button(
                colors = ButtonDefaults.buttonColors(
                    Color.Black
                ),
                onClick = {
                    Toast.makeText(context, "Verified", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(
                    text = "Verify"
                )

            }

        }
    }
}