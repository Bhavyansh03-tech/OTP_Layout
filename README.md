# OTP Layout UI

This repository contains a simple OTP (One-Time Password) layout implemented using Jetpack Compose in Kotlin. The project focuses solely on the UI aspect of the OTP layout and does not include any logic for handling or validating the OTP. It is designed as a template for integrating an OTP input screen into an Android application.

## Features

- Basic OTP layout design
- Uses Jetpack Compose for UI implementation
- Written in Kotlin

## Screenshots

<div style="display: flex; justify-content: center; align-items: center;">
    <img src="https://github.com/Bhavyansh03-tech/OTP_Layout/assets/96388594/6c08f050-153e-42b7-9c23-f58a4d07fe8d" alt="First Flow Row" style="width: 200px; height: auto; margin-right: 10px;">
    <img src="https://github.com/Bhavyansh03-tech/OTP_Layout/assets/96388594/1ca24462-5c93-46d1-9d6a-91307b354d95" alt="Second Flow Row" style="width: 200px; height: auto;">
</div>

## Installation

To use this project, clone the repository and open it in Android Studio.

```bash
  https://github.com/Bhavyansh03-tech/OTP_Layout.git
```

## Main Components

This is the main activity that sets up the OTP layout using Jetpack Compose.
```bash

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

```

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are greatly appreciated.

1.> Fork the Project.\
2.> Create your Feature Branch `git checkout -b feature/AmazingFeature`.\
3.> Commit your Changes `git commit -m 'Add some AmazingFeature'`.\
4.> Push to the Branch `git push origin feature/AmazingFeature`.\
5.> Open a Pull Request

## Acknowledgements

- Inspiration from various Android development tutorials and documentation.
## Contact

For questions or feedback, please contact [@Bhavyansh03-tech](https://github.com/Bhavyansh03-tech).
