package com.example.unieventos2.ui.components

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.unieventos2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionsMenu(
    value:String,
    onValueSelected: (String) ->Unit,
    expanded: Boolean,
    expandedChange: (Boolean) ->Unit,
    modifier: Modifier,
    values: List<String>,
    label: String
){


    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expandedChange(!expanded) },
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { },
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            label = { Text(label) },
            placeholder = { Text(label) },
            modifier = Modifier
                .menuAnchor()
                .then(modifier)
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expandedChange(false) }
        ) {
            values.forEach() { value ->
                DropdownMenuItem(
                    text = { Text(text = value) },
                    onClick = {
                        onValueSelected(value)
                        expandedChange(false)
                    }
                )
            }
        }
    }
}

