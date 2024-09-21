import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCart() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Carrito de compra",
            color = Color.Black,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Row {
                Text(text = "Código de la orden: ")
                Text(text = "333")
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Información general del evento seleccionado",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = "Localidad seleccionada: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "Gramilla VIP",
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = "Fecha del evento: ")
                Text(text = "20/12/2024")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = "Dirección: ")
                Text(text = "Armenia(Q) Cra 4 # 23 N 12")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = "Cantidad de boletas:")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "1",
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = com.example.unieventos2.R.drawable.localidades),
                contentDescription = "Concierto",
                modifier = Modifier.size(600.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "Ingrese el cupón: ")
                Spacer(modifier = Modifier.width(20.dp))
                TextField(
                    value = "123",
                    singleLine = true,
                    onValueChange = {},
                    modifier = Modifier.width(190.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Confirmar ediciones")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Generar pago")
            }
        }
    }
}


