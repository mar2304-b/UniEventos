package com.example.unieventos2.ui.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.unieventos2.R
import com.example.unieventos2.models.Event

@Composable
fun UpcomingEvents(
    onNavigateToEventDetail: (Int) -> Unit,
    getEventList: () -> List<Event>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.width(30.dp))
        Text(
            text = stringResource(id = R.string.welcome),
            color = Color.Black,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        var searchQuery1 by remember { mutableStateOf("") }
        TextField(
            value = searchQuery1,
            onValueChange = { searchQuery1 = it },
            placeholder = { Text(text = stringResource(id = R.string.searchEventByName)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = stringResource(id = R.string.search))
            }
        )

        var searchQuery2 by remember { mutableStateOf("") }
        TextField(
            value = searchQuery2,
            onValueChange = { searchQuery2 = it },
            placeholder = { Text(text = stringResource(id = R.string.searchEventByType)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = stringResource(id = R.string.search))
            }
        )

        var searchQuery3 by remember { mutableStateOf("") }
        TextField(
            value = searchQuery3,
            onValueChange = { searchQuery3 = it },
            placeholder = { Text(text = stringResource(id = R.string.searchEventByCity)) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = stringResource(id = R.string.search))
            }
        )

        Spacer(modifier = Modifier.width(50.dp))
        Text(
            text = stringResource(id = R.string.upcomingEvents),
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn {
            items(getEventList()){
                EventCard(
                    event = it,
                    onClick = {onNavigateToEventDetail(it.id)}
                )
            }
        }
    }
}
