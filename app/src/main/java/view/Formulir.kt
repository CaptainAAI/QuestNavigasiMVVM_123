package com.example.questnavigasimvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questnavigasimvvm.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun FormIsi(
    jenisJK: List<String> = listOf("Laki-laki", "Perempuan"),
    onSubmitbtnClick : () -> Unit
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.home), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(paddingValues = isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Nama Lengkap
            OutlinedTextField(
                value = "",
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(250.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = {}
            )

            // Divider
            HorizontalDivider(
                modifier = Modifier
                    .padding(4.dp)
                    .width(250.dp),
                thickness = DividerDefaults.Thickness,
                color = Color.Red
            )

            // Radio Button Jenis Kelamin
            jenisJK.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = false,
                        onClick = { /* handle click */ }
                    )
                    Text(text = item)
                }
            }

            // Divider lagi
            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // Alamat
            OutlinedTextField(
                value = "",
                singleLine = true,
                modifier = Modifier.width(250.dp),
                label = { Text(text = "Alamat") },
                onValueChange = {}
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Tombol Submit
            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = 1f)
                    .padding(all = 25.dp),
                onClick = onSubmitbtnClick
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}
